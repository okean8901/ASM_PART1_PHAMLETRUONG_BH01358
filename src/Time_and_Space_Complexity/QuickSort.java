package Time_and_Space_Complexity;

public class QuickSort {
    // Phương thức sắp xếp QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Phân vùng mảng
            quickSort(arr, low, pi - 1);  // Sắp xếp phần tử trước phân vùng
            quickSort(arr, pi + 1, high); // Sắp xếp phần tử sau phân vùng
        }
    }

    // Phương thức phân vùng
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Chọn phần tử cuối làm pivot
        int i = (low - 1); // Chỉ số của phần tử nhỏ hơn
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Hoán đổi arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Hoán đổi arr[i + 1] và arr[high] (hoặc pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; // Trả về chỉ số của pivot
    }

    // Phương thức main để kiểm tra
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        quickSort(arr, 0, arr.length - 1); // Gọi phương thức sắp xếp
        System.out.println("Mảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " "); // In ra mảng đã sắp xếp
        }
    }
}