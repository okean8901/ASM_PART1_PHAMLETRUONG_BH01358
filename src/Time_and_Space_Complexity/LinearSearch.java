package Time_and_Space_Complexity;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Trả về chỉ số nếu tìm thấy
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        int target = 4;
        int result = linearSearch(arr, target);
        if (result != -1) {
            System.out.println("Phần tử " + target + " được tìm thấy tại chỉ số: " + result);
        } else {
            System.out.println("Phần tử " + target + " không được tìm thấy.");
        }
    }
}
