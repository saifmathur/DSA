public class Recursion {

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public int sumOfDigits(int n) {
        if (n == 0) return 0;
        return Math.abs(n % 10) + sumOfDigits(n / 10);
    }


}
