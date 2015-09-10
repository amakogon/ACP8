package week1.day2.HashMap;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on 08.09.2015.
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {

    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Bucket<K, V>[] buckets;
    private int size;
    private float loadFactor;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        buckets = ((Bucket<K, V>[]) new Bucket[capacity]);
        this.loadFactor = loadFactor;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }


    @Override
    public V get(Object key) {
        Objects.requireNonNull(key);
        if (isEmpty()) {
            return null;
        }
        Bucket<K, V> bucket = getBucket(key);
        return bucket == null ? null : bucket.value;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        int hash = key.hashCode();
        int index = hash % buckets.length;

        if (buckets[index] == null) {
            buckets[index] = new Bucket<>(hash, key, value, null);
            size++;

        } else if (!buckets[index].hasNext()) {
            if (buckets[index].hash == hash && buckets[index].key.equals(key)) {
                buckets[index].setValue(value);
                return value;
            } else {
                buckets[index].next = new Bucket<>(hash, key, value, null);
                size++;
            }

        } else if (buckets[index].hasNext()) {
            Bucket<K, V> currentBucket = buckets[index];
            while (currentBucket.next != null) {
                if (currentBucket.hash == hash && currentBucket.key.equals(key)) {
                    currentBucket.setValue(value);
                    return value;
                }
                currentBucket = currentBucket.next;
            }
            if (currentBucket.lastBucket().hash == hash && currentBucket.lastBucket().key.equals(key)) {
                currentBucket.lastBucket().setValue(value);
            } else {
                currentBucket.lastBucket().next = new Bucket<>(hash, key, value, null);
                size++;
            }

        }

        return value;
    }

    @Override
    //TODO: rewrte this
    public V remove(Object key) {
        Objects.requireNonNull(key);
        if (!containsKey(key)) return null;
        int index = key.hashCode() % buckets.length;
        if (buckets[index] == null) {
            return null;
        }else {
            if(buckets)
        }
        return null;
    }

    public void print() {
        for (Bucket<K, V> bucket : buckets) {
            if (bucket == null) {
                System.out.print("blanc");
            } else if (!bucket.hasNext()) {
                System.out.println("\t|----" + bucket.getKey() + " " + bucket.getValue() + "|");
            } else if (bucket.hasNext()) {
                System.out.print("\t|----" + bucket.getKey() + " " + bucket.getValue() + "|");
                Bucket<K, V> currentBucket = bucket;
                while (currentBucket.next != null) {

                    currentBucket = currentBucket.next;
                    System.out.print("\t|----" + currentBucket.getKey() + " " + currentBucket.getValue() + "|");
                }
            }
            System.out.println();
        }
    }

    /*//TODO: rewrte this
    private void addBucket(K key, V value, int hash, int index) {
//    TODO: check loadFactor
        Bucket<K, V> bucket = Bucket.newBucket(hash, key, value, buckets[index]);
        buckets[index] = bucket;
        size++;
    }*/
    private Bucket<K, V> getBucket(Object key) {
        if (size == 0) {
            return null;
        }
        int hash = key == null ? 0 : key.hashCode();
        int index = hash % buckets.length;

        if (buckets[index] == null) {
            return null;
        } else if (buckets[index].hasNext()) {
            Bucket<K, V> currentBucket = buckets[index];
            while (currentBucket.hasNext()) {
                if (currentBucket.key.equals(key)) {
                    return currentBucket;
                }
                currentBucket = currentBucket.nextBucket();
            }
            if (currentBucket.lastBucket().key.equals(key)) {
                return currentBucket.lastBucket();
            }
        }

        return null;
    }


    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends K> keySet = m.keySet();
        Object[] keys = keySet.toArray();
        for (Object o : keys) {
            put((K) o, (V) get(o));
        }
    }

    @Override
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> set = new HashSet<>();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                if (buckets[i].hasNext()) {
                    Bucket<K, V> currentBucket = buckets[i];
                    while (currentBucket.hasNext()) {
                        set.add(currentBucket.key);
                        currentBucket = currentBucket.nextBucket();
                    }
                    set.add(currentBucket.lastBucket().key);
                } else {
                    set.add(buckets[i].key);
                }
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                if (buckets[i].hasNext()) {
                    Bucket<K, V> currentBucket = buckets[i];
                    while (currentBucket.hasNext()) {
                        values.add(currentBucket.value);
                        currentBucket = currentBucket.nextBucket();
                    }
                    values.add(currentBucket.lastBucket().value);
                } else {
                    values.add(buckets[i].value);
                }
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<K> hs = keySet();
        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (K key : hs) {
            entrySet.add(getBucket(key));
        }
        return entrySet;
    }


    private static class Bucket<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        int hash;
        Bucket<K, V> next;

        private Bucket(int hash, K key, V value, Bucket<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }

        static <K, V> Bucket<K, V> newBucket(int hash, K key, V value, Bucket<K, V> next) {
            return new Bucket<>(hash, key, value, next);
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public Bucket<K, V> nextBucket() {
            return this.next;
        }

        public Bucket<K, V> lastBucket() {
            Bucket<K, V> bucket = this;
            while (bucket.hasNext()) {
                bucket = bucket.next;
            }
            return bucket;
        }

    }
}