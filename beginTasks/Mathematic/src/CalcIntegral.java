import java.util.function.DoubleUnaryOperator;

public class CalcIntegral {

//метод левых прямоугольников

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }
    public static double integrate(DoubleUnaryOperator f, double a, double b) {

        double result =0;
        double step = 1e-7; // задавать так, а не через делить

        for (double x=a; x<b; x+=step ) {
            result = result + f.applyAsDouble(x)*step; // идем по сетке
        }
        //ваш код
        return (result);
    }
}