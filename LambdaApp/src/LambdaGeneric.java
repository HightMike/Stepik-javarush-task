public class LambdaGeneric {

    public static void main(String[] args) {

        Oper<Integer> operation1 = (x, y)-> x + y;
        Oper<String> operation2 = (x, y) -> x + y;

        System.out.println(operation1.calculate(20, 10)); //30
        System.out.println(operation2.calculate("20", "10")); //2010
    }
}
interface Oper<T>{
    T calculate(T x, T y);
}

//Функциональный интерфейс может быть обобщенным, однако в лямбда-выражении использование обобщений не допускается.
// В этом случае нам надо типизировать объект интерфейса определенным типом, который потом будет применяться в лямбда-выражении