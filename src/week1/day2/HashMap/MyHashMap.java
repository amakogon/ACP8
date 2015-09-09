package week1.day2.HashMap;

/**
 * _|\_/|,,_____,~~`
 * _(.".)~~     )`~}} Created by Juff on 08.09.2015.
 * __\o/\ /---~\\ ~}}
 * ___ _//    _// ~}
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
        Objects.requireNonNull(key);
        if (isEmpty()) {
            return false;
        }
        int hash = key.hashCode();
        int index = hash % buckets.length;
        if (buckets[index] != null) {
            return buckets[index].key.equals(key);
        } else {
            return false;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        Objects.requireNonNull(value);
        if (size() == 0) return false;

        for (Bucket<K, V> bucket : buckets) {
            if (bucket == null) continue;
            if (bucket.value.equals(value)) return true;
            else if (bucket.hasNext()) {
                Bucket<K, V> currentBucket = bucket;
                while (currentBucket.hasNext()) {
                    if (currentBucket.value.equals(value)) {
                        return true;
                    }
                    currentBucket = currentBucket.nextBucket();
                }
            }
        }
        return false;
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

        for (Bucket<K, V> bucket = buckets[index]; bucket != null; bucket = bucket.next) {
            if (bucket.hash == hash && bucket.key.equals(key)) {
                bucket.value = value;
                return value;
            }
        }

        addBucket(key, value, hash, index);
        return value;
    }

    private void addBucket(K key, V value, int hash, int index) {
//    TODO: check loadFactor
        Bucket<K, V> bucket = Bucket.newBucket(hash, key, value, buckets[index]);
        buckets[index] = bucket;
        size++;
    }

    private Bucket<K, V> getBucket(Object key) {
        if (size == 0) {
            return null;
        }
        int hash = key == null ? 0 : key.hashCode();
        int index = hash % buckets.length;
        for (Bucket<K, V> bucket = buckets[index]; bucket != null; bucket = bucket.next) {
            if (hash == bucket.hash && Objects.equals(key, bucket.getKey())) {
                return bucket;
            }
        }
        return null;
    }

    @Override
    //Todo: test this with equals hashcode test class
    public V remove(Object key) {
        Objects.requireNonNull(key);
        if (containsKey(key)) {
            int index = key.hashCode() % buckets.length;
            if (buckets[index].key.equals(key)) {
                if (buckets[index].hasNext()) {
                    Bucket<K, V> lastBucket = buckets[index].lastBucket();
                    buckets[index] = buckets[index].lastBucket();
                    lastBucket = null;
                } else {
                    buckets[index] = null;
                }
            } else if (buckets[index].hasNext()) {
                Bucket<K, V> currentBucket = buckets[index];

                while (currentBucket.hasNext()) {
                    if (currentBucket.key.equals(key)) {
                        Bucket<K, V> lastBucket = currentBucket.lastBucket();
                        currentBucket = currentBucket.lastBucket();
                        lastBucket = null;
                    }
                    currentBucket = currentBucket.nextBucket();
                }
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
        return Collections.emptySet();
    }

    @Override
    public Collection<V> values() {
        return Collections.emptyList();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Collections.emptySet();
    }

    public void print() {
        for (Bucket<K, V> bucket : buckets) {
            if (bucket == null) {
                System.out.println("blanc");
            } else if (!bucket.hasNext()) {
                System.out.println(bucket.getKey() + " " + bucket.getValue());
            } else {
                Bucket<K, V> currentBucket = bucket;
                while (currentBucket.hasNext()) {
                    System.out.println("\t" + currentBucket.getKey() + " " + currentBucket.getValue());
                    currentBucket = currentBucket.nextBucket();
                }
            }

        }
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