interface Printable{
    void print(String s);
}

public class TerminalLambda {

    public static void main(String[] args) {

        Printable printer = s->System.out.println(s);
        printer.print("Hello Java!");
    }
}