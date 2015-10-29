package homework7;

/**
 * Created by Razer on 26.10.15.
 */
public class test {
    public static void main(String[] args) {
        int array[] = {1, 3, 0, 12, 4, 5, 7, 2, 5, 9, 15};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                System.out.println(array[i]);
            } else if (array[i] % 3 == 0 & array[i] % 5 == 0) {
                System.out.println("artcode");
            } else if (array[i] % 3 == 0) {
                System.out.println("art");
            } else if (array[i] % 5 == 0) {
                System.out.println("code");
            } else {
                System.out.println(array[i]);
            }

        }
    }
}
