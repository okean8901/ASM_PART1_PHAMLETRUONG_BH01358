package Sort;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int size = 10;
        int[] array1 = generateRandomArray(size);
        int[] array2 = array1.clone();

        long startTime = System.nanoTime();
        QuickSort.quickSort(array1, 0, array1.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        BubbleSort.bubbleSort(array2);
        endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " ns");
    }
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }
}
