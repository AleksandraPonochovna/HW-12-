package com.company;

import java.util.Objects;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class TasksApp {

    public static void main(String[] args) {
        //Task 1
        System.out.println("Task 1: ");
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply("Hello world!")); //12
        System.out.println(safeStringLength.apply("")); //0
        //Task 2
        System.out.println("Task 2: ");
        pseudoRandomStream(13).forEach(s -> System.out.print(s + " "));
        //Task 3
        System.out.println("\nTask 3: ");
        System.out.println(integrate(x -> 1, 0, 10)); //10.0
        System.out.println(integrate(x -> x + 2, 0, 10)); //70.0
        System.out.println(integrate(x -> Math.sin(x) / x, 1, 5)); //0.603848174577285
    }

    private static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return string -> condition.test(string) ? ifTrue.apply(string) : ifFalse.apply(string);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10 % 1000));
        return stream;
    }

    public static int mid(int number) {
        int digitNumber = 10;
        String stringNumbers = "";
        final int CONST = 10000;
        if (number < digitNumber) {
            System.out.println("Your number should be more than 10.");
        }
        if (number > CONST) {
            return number % CONST / 10;
        } else {
            while (number >= digitNumber && number < CONST) {
                stringNumbers += Integer.toString(number / digitNumber);
                number = 0;
                digitNumber *= 10;
            }
            return Integer.parseInt(stringNumbers);
        }
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int n = 1_000_000;
        double result = 0;
        double step = (b - a) / n;
        for (int i = 0; i < n; i++) {
            result += f.applyAsDouble(a + step * (i + 0.5));
        }
        return result * step;
        return result;
    }
}
