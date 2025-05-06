import java.util.Scanner;

public class Shantanu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(addTwoNumbers(a, b));
    }

    public static int addTwoNumbers(int a, int b) {
        return a + b;
    }
}
