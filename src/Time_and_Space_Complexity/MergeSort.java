package Time_and_Space_Complexity;

public class MergeSort {
    // Phương thức sắp xếp MergeSort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2; // Tìm điểm giữa
            mergeSort(arr, l, m); // Sắp xếp nửa đầu
            mergeSort(arr, m + 1, r); // Sắp xếp nửa sau
            merge(arr, l, m, r); // Gộp hai nửa đã sắp xếp
        }
    }

    // Phương thức gộp
    private static void merge(int[] arr, int l, int m, int r) {
        // Kích thước của hai mảng con cần gộp
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1]; // Mảng bên trái
        int[] R = new int[n2]; // Mảng bên phải

        // Sao chép dữ liệu vào các mảng tạm
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // Gộp các mảng tạm
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của L[] nếu có
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Phương thức main để kiểm tra
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1); // Gọi phương thức sắp xếp
        System.out.println("Mảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " "); // In ra mảng đã sắp xếp
        }
    }
}