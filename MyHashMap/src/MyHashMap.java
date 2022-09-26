
public class MyHashMap<K, V> {

    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    static class Entry<K, V> {
        public K key;
        public V value;
        public Entry<K, V> next;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public Entry[] hashTable;

    MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    static int tableSizeFor(int n) {
        n = n - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        //We are only doing upto 16 because, we can skip the first double,For Eg. if first
        // are 16 1's, we and skip them and dop for another remaining 16.
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K k, V v) {
        int hashCode = k.hashCode() % hashTable.length;

        Entry node = hashTable[hashCode];
        if (node == null) {
            Entry entry = new Entry(k, v);
            hashTable[hashCode] = entry;
        } else {
            Entry temp = node;
            while (temp.next != null) {
                if (temp.key == k) { //If key is found update the value!
                    temp.value = v;
                    return;
                }
                temp = temp.next;
            }

            Entry entry = new Entry(k, v);
            temp.next = entry;
        }
    }

    public V get(K k) {
        int hashCode = k.hashCode() % hashTable.length;

        Entry temp = hashTable[hashCode];
        while (temp != null) {
            if (temp.key == k)
                return (V) temp.value;
            temp = temp.next;
        }

        return null;
    }

}