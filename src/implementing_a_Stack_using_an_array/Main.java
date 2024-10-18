package implementing_a_Stack_using_an_array;

public class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Output: 30
        System.out.println("Element removed: " + stack.pop()); // Output: 30
        System.out.println("Stack size: " + stack.size()); // Output: 2
        System.out.println("Is the stack empty? " + stack.isEmpty()); // Output: false
    }
}
