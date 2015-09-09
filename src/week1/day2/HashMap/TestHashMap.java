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
        map.put(new EqualsHashCode(-2), "-2");
        map.put(new EqualsHashCode(-1), "minus one");
        map.put(new EqualsHashCode(1), "one");
        map.put(new EqualsHashCode(2), "two");
        map.put(new EqualsHashCode(3), "three");
        map.put(new EqualsHashCode(4), "four");
        map.print();






      /*  MyHashMap<Integer, String> map = new MyHashMap<>(5);

        map.put(1, "6");
        map.put(12, "16");
        map.remove(12);
        System.out.println(map.get(1));
        System.out.println(map.get(12));
        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("15"));
        System.out.println("-1 = " + new EqualsHashCode(-1).hashCode());
        System.out.println("0 = " +new EqualsHashCode(0).hashCode());
        System.out.println("1 = " +new EqualsHashCode(1).hashCode());
        System.out.println("2 = " +new EqualsHashCode(2).hashCode());
*/


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
        public String toString() {
            return String.valueOf(key);
        }
    }
}
