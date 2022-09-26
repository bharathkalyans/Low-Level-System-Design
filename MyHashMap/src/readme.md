# Implementation of Hash Map! #

* Use generics so that any type of object can be used!
* The initial (1 << 4) and maximum capacity(1 << 30).must be declared as final and static.
* Default value will start from 16 **i.e** 1 << 4.

```java
    private static final int INITIAL_SIZE = 1<<4;
    private static final int MAXIMUM_CAPACITY = 1<<30;
```

* Create an Entry Class(Node) to hold Key, Value and Next pointer.

```java
    static class Entry<K, V> {
      public K key;
      public V value;
      public Entry<K, V> next;
  
      Entry(K k, V v) {
          this.key = k;
          this.value = v;
      }
    }
```

* Initialise the hashTable.
  * The tableSizeFor() method is used to make the number in terms of power of 2.
  * Every hashTable will be of size in terms of power of 2. 

```java
    private final Entry[]hashTable;
```
```java
//  CONSTRUCTORS
    MyHashMap(){
        hashTable=new Entry[INITIAL_SIZE];
    }

    MyHashMap(int capacity){
        int tableSize=tableSizeFor(capacity);
        hashTable=new Entry[tableSize];
    }
    
    static int tableSizeFor(int n){
        n=n-1;
        n|=n>>>1;
        n|=n>>>2;
        n|=n>>>4;
        n|=n>>>8;
        n|=n>>>16;
        //We are only doing upto 16 because, we can skip the first double,For Eg. if first
        // are 16 1's, we and skip them and dop for another remaining 16.
        return(n< 0)?1:(n>=MAXIMUM_CAPACITY)?MAXIMUM_CAPACITY:n+1;
    }
```

* There are mainly two functions in any Hash Map.
  * put(K k, V v)
  * get(V v)

```java
    public void put(K k, V v) {
        int hashCode = k.hashCode() % hashTable.length;

        Entry node = hashTable[hashCode];
        if (node == null) {
            Entry<K, V> entry = new Entry<>(k, v);
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

            temp.next = new Entry<>(k, v);
        }
    }
```
```java
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
```
* An extra method to find if key is present in the map or not.
```java
    public boolean containsKey(K k) {
        int hashCode = k.hashCode() % hashTable.length;

        Entry temp = hashTable[hashCode];
        while (temp != null) {
            if (temp.key == k)
                return true;
            temp = temp.next;
        }

        return false;
    }
```
***

[REFERENCE](https://www.youtube.com/playlist?list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW)