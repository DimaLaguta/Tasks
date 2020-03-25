package chapter6.ex3ex4;

import java.util.ArrayList;

public class Table<K, V> {
    ArrayList<Entry<K, V>> arrayList = new ArrayList<>();

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public V getValueByKey(K key) {
        for (Entry<K, V> i : arrayList) {
            if (i.getKey().equals(key)) {
                return (V) i.getValue();
            }
        }
        return null;
    }

    public void setValueByKey(K key, V value) {
        boolean isFind = false;
        for (Entry<K, V> i : arrayList) {
            if (i.getKey().equals(key)) {
                i.setValue(value);
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            arrayList.add(new Entry<>(key, value));
        }
    }

    public void deleteKey(K key) {
        arrayList.removeIf(x -> x.getKey() == key);
    }
}
