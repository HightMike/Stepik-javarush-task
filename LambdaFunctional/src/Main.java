import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> condition = n -> (n % 2) == 0;
        Function<Integer, String> ifTrue = n -> "Number is even";
        Function<Integer, String> ifFalse = n -> "Number is odd";

        Function<Integer, String> isEven = ternaryOperator(condition, ifTrue, ifFalse);

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(isEven.apply(sc.nextInt()));
        }
        catch (Exception e) {
        }

    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        Function <T,U> func= (T arg) -> {
            if (condition.test(arg)) {
                return ifTrue.apply(arg);
            }
            else {
                return ifFalse.apply(arg);
            }
        };
        return func;
        // все это можно сделать в одну строчку
        // return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);


    }

}

