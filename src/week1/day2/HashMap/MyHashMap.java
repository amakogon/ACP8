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
            buckets[index] = createLastBucket(key, value, hash);
            size++;

        } else if (!buckets[index].hasNext()) {
            if (buckets[index].hash == hash && buckets[index].key.equals(key)) {
                buckets[index].setValue(value);
                return value;
            } else {
                buckets[index].next = createLastBucket(key, value, hash);
                size++;
            }
        } else if (buckets[index].hasNext()) {
            Bucket<K, V> currentBucket = buckets[index];

            for (Bucket<K, V> bucket = buckets[index]; bucket.next != null; bucket = bucket.next) {
                if (bucket.hash == hash && bucket.key.equals(key)) {
                    bucket.setValue(value);
                    return value;
                }
            }
            if (buckets[index].lastBucket().hash == hash && currentBucket.lastBucket().key.equals(key)) {
                buckets[index].lastBucket().setValue(value);
                return value;
            } else {
                buckets[index].lastBucket().next = createLastBucket(key, value, hash);
                size++;
            }
        }
        return value;
    }

    private Bucket<K, V> createLastBucket(K key, V value, int hash) {
        return new Bucket<>(hash, key, value, null);
    }


    @Override
    public V remove(Object key) {
        Objects.requireNonNull(key);
        if (!containsKey(key)) return null;
        int index = key.hashCode() % buckets.length;
        if (buckets[index] == null) {
            return null;
        } else {
            if (buckets[index].next != null) {
                for (Bucket<K, V> bucket = buckets[index]; bucket.hasNext(); bucket = bucket.nextBucket()) {
                    if (bucket.key.equals(key)) {
                        if (bucket.next == null) {
                            bucket = null;
                            size--;
                        } else {
                            buckets[index] = bucket.next;
                        }
                    }
                    if (bucket.next.key.equals(key)) {
                        Bucket<K, V> nextNextBucket = bucket.nextBucket().nextBucket();
                        if (nextNextBucket == null) {
                            bucket.next = null;
                            size--;
                            return null;

                        } else {
                            bucket.next = null;
                            size--;
                            bucket.next = nextNextBucket;
                            return null;
                        }
                    }
                }

            } else {
                if (buckets[index].key.equals(key)) {
                    buckets[index] = null;
                    size--;
                    return null;
                }
            }
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
                for (Bucket<K, V> currentBucket = bucket; currentBucket.hasNext(); currentBucket = currentBucket.next) {
                    System.out.print("\t|----" + currentBucket.getKey() + " " + currentBucket.getValue() + "|");
                }
            }
            System.out.println();
        }
    }

    private Bucket<K, V> getBucket(Object key) {
        if (size == 0) {
            return null;
        }
        int hash = key == null ? 0 : key.hashCode();
        int index = hash % buckets.length;

        if (buckets[index] == null) {
            return null;
        } else if (buckets[index].hasNext()) {
            for (Bucket<K, V> bucket = buckets[index]; bucket.hasNext(); bucket = bucket.nextBucket()) {
                if (bucket.key.equals(key)) {
                    return bucket;
                }
            }
            if (buckets[index].lastBucket().key.equals(key)) {
                return buckets[index].lastBucket();
            }
        }
        return null;
    }


    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            put(key, value);
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
                    for (Bucket<K, V> bucket = buckets[i]; bucket.hasNext(); bucket = bucket.nextBucket()) {
                        set.add(bucket.key);
                    }
                    set.add(buckets[i].lastBucket().key);
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
                    for (Bucket<K, V> currentBucket = buckets[i]; currentBucket.hasNext(); currentBucket = currentBucket.nextBucket()) {

                        values.add(currentBucket.value);
                    }
                    values.add(buckets[i].lastBucket().value);
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

        public K setKey(K key) {
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