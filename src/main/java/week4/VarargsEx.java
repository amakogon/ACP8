package week4;

public class VarargsEx {
  public static void main(String[] args) {
    int result = min(3, 2, -1978, 534);
    int result1 = min(4);
    System.out.println(result);
    System.out.println(result1);
  }

  public static int min(int firstElem, int... args) {
/*    if (args.length == 0) {
      throw new IllegalArgumentException("you have to pass at least one element");
    }*/
    int min = firstElem;
    for (int i : args) {
      min = Math.min(min, i);
    }
    return min;
  }
}
