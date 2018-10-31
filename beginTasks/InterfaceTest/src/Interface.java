import java.util.Arrays;

public class Interface {

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33, 66, 89};
        AsciiCharSequence answer = new AsciiCharSequence(example);  // создание нового объекта AsciiCharSequence
        System.out.println(answer);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(7));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 8));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
        byte[] rty = {11};
        System.out.println(rty[0]);
    }

    private static class AsciiCharSequence implements java.lang.CharSequence { // импорт интерфейса, который уже задан. У интерфейса все методы должны быть определены (теперь)
        byte[] example1;
        AsciiCharSequence (byte[] qwe) { // создание конструктора (принимает массив байт), (конструктор в отличии от метода ничего не возвращает
                example1 = qwe.clone();
        }

        public String toString() { // переопределяем все методы
            //String y = "";
            //String p = Arrays.toString(example);

            char[] k= new char[example1.length];
            for (int i=0; i<example1.length; i++) {
                k[i] = (char) example1[i];     // явное приведение типа byte к char, уже на этом этапе массив из Hello
            }
            String y = String.valueOf(k);
            return y;

        }
        public int length() {
            return example1.length;
        }
        public char charAt(int a) {
            return (char)example1[a];  // возвращает пришедшее значение, например 1
        }
        public CharSequence subSequence(int var1, int var2) {


            byte[] k = new byte[var2-var1];
            for (int i = var1; i < var2; i++) {
                k[i-var1] = example1[i];     // явное приведение типа byte к char, уже на этом этапе массив из Hello
            }
            //String y = String.valueOf(k);
            //y.substring(var1, var2);AsciiCharSequence

            AsciiCharSequence qwerty = new AsciiCharSequence(k); // почему то обращается к toString. Видимо из-за CharSequence

            return qwerty;
            //return y.substring(var1, var2);
        }

    }

}
