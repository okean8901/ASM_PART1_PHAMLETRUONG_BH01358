package Student_management_app_scenario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class StudentAlgorithmDemo {
    // Quick Sort for Students
    public static void quickSort(Student[] arr, int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int pivotIndex = medianOfThreePivot(arr, low, high, comparator);
            pivotIndex = partition(arr, low, high, pivotIndex, comparator);

            quickSort(arr, low, pivotIndex - 1, comparator);
            quickSort(arr, pivotIndex + 1, high, comparator);
        }
    }

    // Median of Three Pivot Selection for Students
    private static int medianOfThreePivot(Student[] arr, int low, int high, Comparator<Student> comparator) {
        int mid = low + (high - low) / 2;

        // Sort low, mid, high to find median
        if (comparator.compare(arr[low], arr[mid]) > 0) swap(arr, low, mid);
        if (comparator.compare(arr[low], arr[high]) > 0) swap(arr, low, high);
        if (comparator.compare(arr[mid], arr[high]) > 0) swap(arr, mid, high);

        return mid;
    }

    // Optimized Partition for Students
    private static int partition(Student[] arr, int low, int high, int pivotIndex, Comparator<Student> comparator) {
        swap(arr, pivotIndex, high);
        Student pivot = arr[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Merge Sort for Students
    public static void mergeSort(Student[] arr, int left, int right, Comparator<Student> comparator) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid, comparator);
            mergeSort(arr, mid + 1, right, comparator);

            merge(arr, left, mid, right, comparator);
        }
    }

    // Optimized Merge for Students
    private static void merge(Student[] arr, int left, int mid, int right, Comparator<Student> comparator) {
        Student[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        Student[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (comparator.compare(leftArr[i], rightArr[j]) <= 0) ? leftArr[i++] : rightArr[j++];
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // Bubble Sort for Students
    public static void bubbleSort(Student[] arr, Comparator<Student> comparator) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Utility method to swap elements
    private static void swap(Student[] arr, int i, int j) {
        Student temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Performance Comparison Method for Student Sorting
    public static void compareSortingAlgorithms(StudentStack studentStack) {
        // Convert stack to array for fair comparison
        Student[] students = studentStack.toArray();

        // Create copies for different sorting algorithms
        Student[] bubbleArray = Arrays.copyOf(students, students.length);
        Student[] quickArray = Arrays.copyOf(students, students.length);
        Student[] mergeArray = Arrays.copyOf(students, students.length);

        // Comparator for sorting by ID
        Comparator<Student> idComparator = Comparator.comparingInt(Student::getId);

        // Measure and print sorting times
        long startTime, endTime;

        startTime = System.nanoTime();
        bubbleSort(bubbleArray, idComparator);
        endTime = System.nanoTime();
        System.out.printf("Bubble Sort Time: %d ns%n", endTime - startTime);

        startTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1, idComparator);
        endTime = System.nanoTime();
        System.out.printf("Quick Sort Time:  %d ns%n", endTime - startTime);

        startTime = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1, idComparator);
        endTime = System.nanoTime();
        System.out.printf("Merge Sort Time:  %d ns%n", endTime - startTime);

        // Rebuild the stack with sorted array
        studentStack.rebuildFromArray(mergeArray);
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create a student stack and add some sample students
        StudentStack studentStack = new StudentStack();
        studentStack.push(new Student(3, "Trường", 20));
        studentStack.push(new Student(1, "Hiển", 22));
        studentStack.push(new Student(4, "Đạt", 19));
        studentStack.push(new Student(2, "Huy", 21));

        // Compare sorting algorithms
        compareSortingAlgorithms(studentStack);

        // Display sorted students
        System.out.println("\nSorted Students:");
        studentStack.displayStudents();
    }
}