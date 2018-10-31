import java.util.Objects;

public class Pair<T,K> {
    private final T first;
    private final K second;

    public Pair(final T first, final K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(getFirst(), pair.getFirst()) &&
                Objects.equals(getSecond(), pair.getSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }

    public K getSecond() {
        return second;
    }
    public static <T1, K> Pair <T1, K> of(T1 first, K second) {

        return new Pair<>(first, second);
    }


}
