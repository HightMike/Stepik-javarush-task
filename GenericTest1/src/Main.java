public class Main {
    public static void main(String[] args) { // psvm + tab
        //StringTuple st = new StringTuple("left", "right");
        final Tuple<Integer> it2 = new Tuple<Integer>(2, 4); // можно без стринг справа
        final Tuple<String> st3 = new Tuple<String>("asd", "asdfas"); // можно без стринг справа

        System.out.println(it2.getLeft());  //sout + tab
        System.out.println(st3.getRight());

        // T может хранить только ссылочный тип
        Tuple<SuperClass> tuple = new Tuple<>(new SuperClass(), new SuperClass());// тип тут SuperClass
        System.out.println(tuple.getLeft());
    }

    private static class SuperClass {
        @Override
        public String toString() {
            return "super";
        }
    }
    enum Cat {
        Leopard, Puma, Lion, Tiger, Manul
    }


}


