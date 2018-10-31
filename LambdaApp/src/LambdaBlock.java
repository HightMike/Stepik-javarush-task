public class LambdaBlock {
    public static void main(String[] args) {
        Operationable operation = (int x, int y)-> {

            if(y==0)
                return 0;
            else
                return x/y;
        };

        System.out.println(operation.calculate(20, 10)); //2
        System.out.println(operation.calculate(20, 0)); //0
    }
}

// интерфейс уже определен
// В блочных лямбда-выражениях можно использовать внутренние вложенные блоки, циклы, конструкции if, switch, создавать переменные и т.д.
// Если блочное лямбда-выражение должно возвращать значение, то явным образом применяется оператор return: