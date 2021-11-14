package chapter9;

import chapter7.LinkedPositionalList;
import chapter7.Position;
import chapter7.PositionalList;

import java.util.Comparator;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    public UnsortedPriorityQueue() {
        super();
    }

    public UnsortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    private Position<Entry<K, V>> findMin() {
        Position<Entry<K, V>> small = list.first();
        for (Position<Entry<K, V>> walk : list.positions()) {
            if (compare(walk.getElement(), small.getElement()) < 0) small = walk;
        }
        return small;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        list.addLast(newest);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        return null;
    }

    @Override
    public Entry<K, V> removeMin() {
        return null;
    }
}
