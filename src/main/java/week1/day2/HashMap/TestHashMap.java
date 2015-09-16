package week1.day2.HashMap;

/*
 *_|\_/|,,_____,~~`
 *_(.".)~~     )`~}} Created by Juff on 08.09.2015.
 *__\o/\ /---~\\ ~}}
 *___ _//    _// ~}
 */
public class TestHashMap {
    public static void main(String[] args) {

        MyHashMap<EqualsHashCode, String> map = new MyHashMap<>(5); //Create map
        //Map filling
        map.put(new EqualsHashCode(-3), "minus three");
        map.put(new EqualsHashCode(-2), "minus two");
        map.put(new EqualsHashCode(-1), "minus one");
        //Checking size
        System.out.println("Size = " + map.size());
        //Map printing
        map.print();
        System.out.println("\nResize:\n");
        map.put(new EqualsHashCode(0), "zero");
        map.put(new EqualsHashCode(1), "one");
        //Add elements with same keys to check map property
        EqualsHashCode e = new EqualsHashCode(2);
        map.put(e, "two");
        map.put(e, "double");
        map.put(e, "II");
        map.put(new EqualsHashCode(3), "three");
        map.put(new EqualsHashCode(4), "four");
        //Checking size
        System.out.println("Size = " + map.size());
        //Map printing
        map.print();
        //Checking remove element
        map.remove(new EqualsHashCode(2));
        //Checking size
        System.out.println("\nRemove element with key =  " + new EqualsHashCode(2).toString() + ":\n");
        System.out.println("Size = " + map.size());
        map.print();
        System.out.println();

        //A fox)
        System.out.println("|\\_/|,,_____,~~`");
        System.out.println("(.\".)~~     )`~}}");
        System.out.println(" \\o/\\ /---~\\\\ ~}}");
        System.out.println("   _//    _// ~}");
    }

    //Experimental class for checking buckets
    public static class EqualsHashCode {
        int key;

        public EqualsHashCode(int key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return this.key >= 0 ? 103 : 0;
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
