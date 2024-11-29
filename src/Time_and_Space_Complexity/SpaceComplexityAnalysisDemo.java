package Time_and_Space_Complexity;

import java.util.Arrays;
import java.util.Random;

public class SpaceComplexityAnalysisDemo {
    // Lớp để theo dõi việc sử dụng bộ nhớ
    static class MemoryTracker {
        private long initialMemory;
        private long peakMemoryUsage;

        // Bắt đầu theo dõi bộ nhớ
        public void startTracking() {
            System.gc();
            initialMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            peakMemoryUsage = initialMemory;
        }

        // Cập nhật và trả về mức sử dụng bộ nhớ đỉnh điểm
        public long stopTracking() {
            System.gc();
            long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long memoryUsed = finalMemory - initialMemory;
            return Math.max(memoryUsed, peakMemoryUsage - initialMemory);
        }
    }

    // Thuật toán Bubble Sort (Không gian O(1))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi tại chỗ
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có phép hoán đổi nào, mảng đã được sắp xếp
            if (!swapped) break;
        }
    }

    // Thuật toán Quick Sort (Không gian O(log n) do đệ quy)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Đệ quy với không gian ngăn xếp O(log n)
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Phương thức phân vùng cho Quick Sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Hoán đổi tại chỗ
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Đặt pivot vào vị trí đúng
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Thuật toán Merge Sort (Không gian O(n))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Đệ quy
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Gộp với không gian phụ O(n)
            merge(arr, left, mid, right);
        }
    }

    // Phương thức gộp cho Merge Sort
    private static void merge(int[] arr, int left, int mid, int right) {
        // Tạo mảng phụ - không gian O(n)
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        // Sao chép dữ liệu
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightArr.length; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Gộp hai mảng
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }

        // Sao chép các phần tử còn lại
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // Phương thức so sánh độ phức tạp không gian
    public static void compareSpaceComplexity(int size) {
        // Tạo các mảng giống hệt nhau để so sánh công bằng
        int[] bubbleArray = new Random().ints(size, 0, 10_000_000).toArray();
        int[] quickArray = Arrays.copyOf(bubbleArray, bubbleArray.length);
        int[] mergeArray = Arrays.copyOf(bubbleArray, bubbleArray.length);

        // Máy theo dõi bộ nhớ
        MemoryTracker memoryTracker = new MemoryTracker();

        // Đo và in bộ nhớ sử dụng Bubble Sort
        memoryTracker.startTracking();
        bubbleSort(bubbleArray);
        long bubbleMemory = memoryTracker.stopTracking();
        System.out.printf("Bộ nhớ sử dụng Bubble Sort: %d bytes%n", bubbleMemory);

        // Đo và in bộ nhớ sử dụng Quick Sort
        memoryTracker.startTracking();
        quickSort(quickArray, 0, quickArray.length - 1);
        long quickMemory = memoryTracker.stopTracking();
        System.out.printf("Bộ nhớ sử dụng Quick Sort:  %d bytes%n", quickMemory);

        // Đo và in bộ nhớ sử dụng Merge Sort
        memoryTracker.startTracking();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        long mergeMemory = memoryTracker.stopTracking();
        System.out.printf("Bộ nhớ sử dụng Merge Sort:  %d bytes%n", mergeMemory);
    }

    public static void main(String[] args) {
        // Thực hiện so sánh độ phức tạp không gian
        int size = 100;

        // So sánh độ phức tạp không gian
        compareSpaceComplexity(size);
    }
}