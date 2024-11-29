package Time_and_Space_Complexity;

import java.util.Arrays;
import java.util.Random;

public class AnalysisAlgorithmDemo {
    // Thuật toán QuickSort với chiến lược phân vùng được cải thiện
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Sử dụng phương pháp chọn pivot là trung vị của ba phần tử để cải thiện hiệu năng trung bình
            int pivotIndex = medianOfThreePivot(arr, low, high);
            pivotIndex = partition(arr, low, high, pivotIndex);

            // Sắp xếp đệ quy các phần con
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Phương thức chọn pivot là trung vị của ba phần tử
    private static int medianOfThreePivot(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        // Sắp xếp low, mid, high để tìm trung vị
        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);

        return mid;
    }

    // Phương thức phân vùng được tối ưu hóa
    private static int partition(int[] arr, int low, int high, int pivotIndex) {
        // Di chuyển pivot về cuối mảng
        swap(arr, pivotIndex, high);
        int pivot = arr[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Đặt pivot vào vị trí cuối cùng
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Thuật toán MergeSort với hiệu quả bộ nhớ được cải thiện
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Phương thức merge được tối ưu hóa
    private static void merge(int[] arr, int left, int mid, int right) {
        // Tạo mảng tạm thời với kích thước chính xác
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        // Merge với logic so sánh đơn giản
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }

        // Sao chép các phần tử còn lại
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // Thuật toán BubbleSort được tối ưu với điều kiện dừng sớm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            // Nếu không có phép hoán đổi nào, mảng đã được sắp xếp
            if (!swapped) break;
        }
    }

    // Phương thức tiện ích để hoán đổi các phần tử
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Phương thức so sánh hiệu năng các thuật toán sắp xếp
    public static void compareSortingAlgorithms(int size) {
        // Tạo các mảng giống hệt nhau để so sánh công bằng
        int[] bubbleArray = new Random().ints(size, 0, 10_000_000).toArray();
        int[] quickArray = Arrays.copyOf(bubbleArray, bubbleArray.length);
        int[] mergeArray = Arrays.copyOf(bubbleArray, bubbleArray.length);

        // Đo và in thời gian sắp xếp
        long startTime, endTime;

        startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        endTime = System.nanoTime();
        System.out.printf("Thời gian Bubble Sort: %d ns%n", endTime - startTime);

        startTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.nanoTime();
        System.out.printf("Thời gian Quick Sort:  %d ns%n", endTime - startTime);

        startTime = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        endTime = System.nanoTime();
        System.out.printf("Thời gian Merge Sort:  %d ns%n", endTime - startTime);
    }

    public static void main(String[] args) {
        // Chạy so sánh hiệu năng
        compareSortingAlgorithms(1000);
    }
}