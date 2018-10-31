public class Main {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod1();
    }

    private static void anotherMethod1() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod2();
    }


    private static void anotherMethod2() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String message = "";
        if (stackTraceElements.length>3) { // stack - стек вызовов

            StackTraceElement element1 = stackTraceElements[3]; // конечный потребитель
            //StackTraceElement element2 = stackTraceElements[0]; // пакет
            //String className2 = element2.getClassName();
            String className = element1.getClassName();
            String methodName = element1.getMethodName();
            message = className + "#" + methodName;

        }
        else {
            return null;
        }
        return message;
    }
}
