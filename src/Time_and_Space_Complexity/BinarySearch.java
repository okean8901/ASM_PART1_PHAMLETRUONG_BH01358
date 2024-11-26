package Time_and_Space_Complexity;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Tính chỉ số giữa
            if (arr[mid] == target) {
                return mid; // Trả về chỉ số nếu tìm thấy
            }
            if (arr[mid] < target) {
                left = mid + 1; // Tìm ở nửa bên phải
            } else {
                right = mid - 1; // Tìm ở nửa bên trái
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40}; // Mảng đã được sắp xếp
        int target = 10;
        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Phần tử " + target + " được tìm thấy tại chỉ số: " + result);
        } else {
            System.out.println("Phần tử " + target + " không được tìm thấy.");
        }
    }
}
