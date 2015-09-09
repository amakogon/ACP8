package week1.day2.HashMap;

/**
 *_|\_/|,,_____,~~`
 *_(.".)~~     )`~}} Created by Juff on 08.09.2015.
 *__\o/\ /---~\\ ~}}
 *___ _//    _// ~}
 */
public class TestHashMap {
    public static void main(String[] args) {
        MyHashMap<EqualsHashCode, String> map = new MyHashMap<>(5);
        map.put(new EqualsHashCode(-3), "minus three");
        map.put(new EqualsHashCode(-2), "minus two");
        map.put(new EqualsHashCode(-1), "minus one");
        map.put(new EqualsHashCode(0), "zero");
        map.put(new EqualsHashCode(1), "one");
        EqualsHashCode e = new EqualsHashCode(2);
        map.put(e, "two");
        map.put(e, "double");
        map.put(e, "II");
        map.put(new EqualsHashCode(3), "three");
        map.put(new EqualsHashCode(4), "four");
        map.print();
        map.remove(e);
        System.out.println("-----------------------------------");
        map.print();





    }

    public static class EqualsHashCode{
        int key;

        public EqualsHashCode(int key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return this.key>=0?103:0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EqualsHashCode that = (EqualsHashCode) o;

            return key == that.key;

        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }
}
