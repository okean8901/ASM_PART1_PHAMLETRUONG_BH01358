package Student_management_app_scenario;

import java.util.Comparator;
import java.util.Random;

public class StudentSpaceComplexityDemo {
    // Memory Tracking Utility
    static class MemoryTracker {
        private long initialMemory;
        private long peakMemoryUsage;

        // Start memory tracking
        public void startTracking() {
            System.gc();
            initialMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            peakMemoryUsage = initialMemory;
        }

        // Stop tracking and return peak memory usage
        public long stopTracking() {
            System.gc();
            long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long memoryUsed = finalMemory - initialMemory;
            return Math.max(memoryUsed, peakMemoryUsage - initialMemory);
        }
    }

    // Bubble Sort for Students with In-Place Sorting (O(1) extra space)
    public static void bubbleSort(Student[] arr, Comparator<Student> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    // In-place swap
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Quick Sort for Students (O(log n) recursive space)
    public static void quickSort(Student[] arr, int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, comparator);

            // Recursive calls with O(log n) stack space
            quickSort(arr, low, pivotIndex - 1, comparator);
            quickSort(arr, pivotIndex + 1, high, comparator);
        }
    }

    // Partition method for Quick Sort
    private static int partition(Student[] arr, int low, int high, Comparator<Student> comparator) {
        Student pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                // In-place swap
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Merge Sort for Students (O(n) extra space)
    public static void mergeSort(Student[] arr, int left, int right, Comparator<Student> comparator) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursive calls
            mergeSort(arr, left, mid, comparator);
            mergeSort(arr, mid + 1, right, comparator);

            // Merge with O(n) auxiliary space
            merge(arr, left, mid, right, comparator);
        }
    }

    // Merge method for Merge Sort
    private static void merge(Student[] arr, int left, int mid, int right, Comparator<Student> comparator) {
        // Create auxiliary arrays - O(n) space
        Student[] leftArr = new Student[mid - left + 1];
        Student[] rightArr = new Student[right - mid];

        // Copy data
        System.arraycopy(arr, left, leftArr, 0, leftArr.length);
        System.arraycopy(arr, mid + 1, rightArr, 0, rightArr.length);

        // Merge two arrays
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            arr[k++] = (comparator.compare(leftArr[i], rightArr[j]) <= 0) ? leftArr[i++] : rightArr[j++];
        }

        // Copy remaining elements
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    // Compare Space Complexity of Sorting Algorithms
    public static void compareSpaceComplexity(StudentStack studentStack) {
        // Convert stack to array for fair comparison
        Student[] students = studentStack.toArray();

        // Create copies for different sorting algorithms
        Student[] bubbleArray = new Student[students.length];
        Student[] quickArray = new Student[students.length];
        Student[] mergeArray = new Student[students.length];
        System.arraycopy(students, 0, bubbleArray, 0, students.length);
        System.arraycopy(students, 0, quickArray, 0, students.length);
        System.arraycopy(students, 0, mergeArray, 0, students.length);

        // Comparator for sorting by ID
        Comparator<Student> idComparator = Comparator.comparingInt(Student::getId);

        // Memory Tracker
        MemoryTracker memoryTracker = new MemoryTracker();

        // Measure and print memory usage for Bubble Sort
        memoryTracker.startTracking();
        bubbleSort(bubbleArray, idComparator);
        long bubbleMemory = memoryTracker.stopTracking();
        System.out.printf("Memory Used by Bubble Sort: %d bytes%n", bubbleMemory);

        // Measure and print memory usage for Quick Sort
        memoryTracker.startTracking();
        quickSort(quickArray, 0, quickArray.length - 1, idComparator);
        long quickMemory = memoryTracker.stopTracking();
        System.out.printf("Memory Used by Quick Sort:  %d bytes%n", quickMemory);

        // Measure and print memory usage for Merge Sort
        memoryTracker.startTracking();
        mergeSort(mergeArray, 0, mergeArray.length - 1, idComparator);
        long mergeMemory = memoryTracker.stopTracking();
        System.out.printf("Memory Used by Merge Sort:  %d bytes%n", mergeMemory);

        // Rebuild the stack with sorted array (using Merge Sort results)
        studentStack.rebuildFromArray(mergeArray);
    }

    public static void main(String[] args) {
        // Create a student stack and add sample students
        StudentStack studentStack = new StudentStack();

        // Add students with randomized IDs to demonstrate sorting
        studentStack.push(new Student(3, "Trường", 20));
        studentStack.push(new Student(1, "Hiển", 22));
        studentStack.push(new Student(4, "Tiến", 19));
        studentStack.push(new Student(2, "Nguyên", 21));
        studentStack.push(new Student(5, "Đạt", 23));
        studentStack.push(new Student(6, "Huy", 18));

        // Compare space complexity of sorting algorithms
        compareSpaceComplexity(studentStack);

        // Display sorted students
        System.out.println("\nSorted Students:");
        studentStack.displayStudents();
    }
}