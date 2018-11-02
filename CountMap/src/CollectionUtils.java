import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Параметризовать методы, используя правило PECS, и реализовать их.
//producer(предоставляет) - extend, consumer(получает) -super
public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static<T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? super T> source, int size) {
        return new ArrayList(source.subList(0, size));
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? super T>  c2) {

        for (T element : c1) {
            if (c2.contains(element)) return true;
        }
        return false;
    }

    public static<T> List<T> range(List<? extends T> list, Object min, Object max) {

    }

    public static<T> List<T> range(List<? extends T>list, Object min, Object max, Comparator<? super T> comparator) {
    }
}


