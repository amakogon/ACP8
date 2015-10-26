package week8;

/**
 * Created by Home on 26.10.2015.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] mas = {3,6,44,3,22,8,9,0,15};
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) {
                System.out.println("----");
            }
            else if (mas[i] % 3 == 0 && mas[i] % 5 == 0) {
                System.out.println("art code");
            }
            else if (mas[i] % 3 == 0){
                System.out.println("art");
            }
            else if (mas[i] %5 == 0) {
                System.out.println("code");
            }
            else {
                System.out.println("----");
            }
        }
    }
}
