package Hashmap_Hashfunction;

import java.util.LinkedList;

class CustomHashMap {

    private static class Entry {
        int key, value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] buckets;
    private int capacity = 10;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = getBucketIndex(key);
        LinkedList<Entry> list = buckets[index];

        for (Entry e : list) {
            if (e.key == key) {
                e.value = value;
                return;
            }
        }
        list.add(new Entry(key, value));
    }

    public Integer get(int key) {
        int index = getBucketIndex(key);
        LinkedList<Entry> list = buckets[index];

        for (Entry e : list) {
            if (e.key == key) {
                return e.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        LinkedList<Entry> list = buckets[index];
        list.removeIf(e -> e.key == key);
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(11, 110);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(11));

        map.remove(2);
        System.out.println(map.get(2));
    }
}

