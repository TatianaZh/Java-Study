import java.util.HashMap;
import java.util.Map;


public class CountMapImpl<E> implements CountMap<E> {


    private Map<E,Integer> map;
    private Map<E,Integer> source;

    public CountMapImpl() {
        this.map = new HashMap<>();
    }


    @Override
    // добавляет элемент в этот контейнер.
    public void add(E e) {
        if (map.containsKey(e)) {
            int value = map.get(e);
            ++value;
            map.put(e, value);
        } else {
            map.put(e, 1);
        }

    }

    @Override
    //Возвращает количество добавлений данного элемента
    public int getCount(E e) {
        if (map.get(e)!= null)
            return map.get(e);
        return 0;
    }

    @Override
    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    public int remove(E e) {
        int kol = map.get(e);
        map.remove(e);
        return kol;
    }

    @Override
    //количество разных элементов
    public int size() {
        return map.size();
    }

    @Override
    //Добавить все элементы из source в текущий контейнер,
    //при совпадении ключей, суммировать значения
    public void addAll(CountMap source) {
        this.source = source.toMap();
        for (Map.Entry<E, Integer> entry : this.source.entrySet()) {
            if (map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    //Вернуть java.util.Map.
    // ключ - добавленный элемент, значение - количество его добавлений
    public Map toMap() {
        return map;
    }

    @Override
    //Тот же самый контракт как и toMap(), только всю информацию записать
    // в destination
    public void toMap(Map destination) {
        destination.putAll(map);

    }
}
