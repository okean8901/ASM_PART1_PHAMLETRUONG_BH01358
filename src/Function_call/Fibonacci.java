package Function_call;

public class Fibonacci {
    public static int fibonacci(int n)
    {
        if(n <= 1)
        {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int result = fibonacci(5);
        System.out.println(result);
    }
}