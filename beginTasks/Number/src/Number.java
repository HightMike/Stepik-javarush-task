public class Number {
    public static void main(String[] args) {
        M x = new M();
        M y = x;
        y.i = 1;
        M x = new M();
        System.out.println(x.i);
    }

    public static class M {
        int i =0;

    }

}
