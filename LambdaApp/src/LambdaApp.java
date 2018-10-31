public class LambdaApp {

    public static void main(String[] args) {

        Operationable operation; //Определение ссылки на функциональный интерфейс:
        operation = (x,y)->x+y; // левая часть содержит список параметров выражения
                                // правая собственно представляет тело лямбда-выражения, где выполняются все действия.
        int result = operation.calculate(10, 20);
        System.out.println(result); //30
    }
}   //функциональный интерфейс должен содержать только один единственный метод без реализации
interface Operationable{ //В роли функционального интерфейса выступает интерфейс Operationable, в котором определен один метод без реализации - метод calculate.
    int calculate(int x, int y);
}

// если бы метод не принимал никаких параметров, то пишут 	()-> 30 + 20;
//()-> 30 + 20;


 //данный пример можно переписать в следующем виде
//class LambdaApp2 {

//    public static void main(String[] args) {
//
//        Operationable op = new Operationable(){
//
//            public int calculate(int x, int y){
//
//                return x + y;
//            }
//        };
//        int z = op.calculate(20, 10);
//        System.out.println(z); // 30
//    }
//}
