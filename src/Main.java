import java.util.Scanner;
import java.math.BigInteger;

/*
Напишите функцию, которая вычисляет результат двух заданных целых чисел без использования операции умножения.
Постарайтесь сделать это как можно быстрее (O(log(n) или лучше.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int n1 = sc.nextInt();
        System.out.println("Введите второе число: ");
        int n2 = sc.nextInt();

        int r0 = mulByLoop(n1, n2);
        int r1 = mulByWhile(n1, n2);
        int r2 = mulByRecursion(n1, n2);
        int r3 = mulByBits(n1, n2);
        int r4 = mulByDoWhile(n1, n2);
        int r5 = mulByBigInteger(BigInteger.valueOf(n1), BigInteger.valueOf(n2));
        int r6 = mulByHalving(n1, n2);
        int r7 = mulByLogs(n1, n2);

        System.out.println("Итог: " + r0);
        System.out.println("Итог0: " + r1);
        System.out.println("Итог1: " + r2);
        System.out.println("Итог2: " + r3);
        System.out.println("Итог3: " + r4);
        System.out.println("Итог4: " + r5);
        System.out.println("Итог5: " + r6);
        System.out.println("Итог6: " + r7);

        boolean same = r0 == r1 && r1 == r2 && r2 == r3
                && r3 == r4 && r4 == r5 && r5 == r6 && r6 == r7;
        System.out.println("Все результаты совпадают: " + same);
    }

    public static int mulByLoop(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int acc = 0;
        for (int i = 1; i <= b; i++) {
            acc += a;
        }
        return acc;
    }

    public static int mulByWhile(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int acc = 0;
        int i = 0;
        while (i < b) {
            acc += a;
            i++;
        }
        return acc;
    }

    public static int mulByRecursion(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (b < 0) {
            return mulByRecursion(a, -b);
        }
        return a + mulByRecursion(a, b - 1);
    }

    public static int mulByBits(int a, int b) {
        int acc = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                acc += a;
            }
            a <<= 1;
            b >>= 1;
        }
        return acc;
    }

    public static int mulByDoWhile(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int acc = 0;
        int i = 0;
        do {
            acc += a;
            i++;
        } while (i < b);
        return acc;
    }

    public static int mulByBigInteger(BigInteger a, BigInteger b) {
        return a.multiply(b).intValue();
    }

    public static int mulByHalving(int a, int b) {
        int acc = 0;
        while (b > 0) {
            if (b % 2 == 1) {
                acc += a;
            }
            a += a;
            b /= 2;
        }
        return acc;
    }

    public static int mulByLogs(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;
        double x = Math.abs((double) a);
        double y = Math.abs((double) b);
        double logSum = Math.log10(x) + Math.log10(y);
        double result = Math.pow(10, logSum);
        if (sign < 0) {
            result = -result;
        }
        return (int) Math.round(result);
    }
}
