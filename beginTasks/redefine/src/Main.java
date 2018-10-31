public class Main {
    public static void main(String[] args) {
        System.out.println(redefine.sqrt(134.0));
        try {
            System.out.println(redefine.sqrt(-4.0));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static class redefine {
        //double i;
        public static double sqrt (double i) {
            if (i<0) {
                throw new IllegalArgumentException( "Expected non-negative number, got " + i); // бросаем исключаение если i меньше 0, IllegalArgumentException конкрентный тип исключения для аргументов
            }
            else {
                return Math.pow(i, 0.5);
            }
        }
    }
}

