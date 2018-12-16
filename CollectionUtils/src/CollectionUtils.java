import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Параметризовать методы, используя правило PECS, и реализовать их.
//producer(предоставляет) - extend, consumer(получает) -super
public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static<T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
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
        for (T e : c1) {
            if (c2.contains(e)) return true;
        }
        return false;
    }

    public static <T extends Comparable <? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> returnList = new ArrayList<>();
        for (T o: list) {
            if((o.compareTo(min) >= 0 ) && (o.compareTo(max) <= 0))
                returnList.add(o);
        }
        return returnList;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> returnList = new ArrayList<>();
        for (T o: list) {
            if(comparator.compare(o,min) >= 0 && comparator.compare(o,max) <= 0) returnList.add(o);
        }
        return returnList;
    }
}

