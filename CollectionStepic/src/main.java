import java.util.*;

public class main {
    public static void main(String[] args) {

        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> number = new HashSet<T>(set1); //построил множество из элементов коллекции
        Set<T> number1 = new HashSet<T>(set2);
        Set<T> number2 = new HashSet<T>(set1);
        Set<T> number3 = new HashSet<T>(set2);
        number.addAll(number1);
        number2.retainAll(number3);
        number.removeAll(number2);
        return number;
    }
}
