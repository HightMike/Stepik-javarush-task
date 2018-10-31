public class Tuple<T> {

    private final T left;

    private final T right; // final должен передаваться в конструктор иначе будет подчеркивать


    public Tuple(final T left,final T right) { // alt + Enter для создания конструктора автоматом
        this.left = left;
        this.right = right;
    }

    public T getLeft() { // code - generate - getter для добавления геттера
        return left;
    }

    public T getRight() { // без конкретного типа. Этот тип указывается в момент создания инстанса( на клиентской стороне)
        return right;
    }
}
