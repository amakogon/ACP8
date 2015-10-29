package homework7;

import java.util.Arrays;

/**
 * Created by Razer on 26.10.15.
 */
public class test2 {
    public static void main(String[] args) {
        int array[] = {109, 2, 34, 234, 21, 12, 1};
        System.out.println(Arrays.toString(sort(array)));
    }

    private static int[] sort(int array[]) {

        int i, j, first, temp;
        for ( i = array.length - 1; i > 0; i -- ) {
            first = 0;
            for(j = 1; j <= i; j ++)
            {
                if( array[ j ] < array[ first ] )
                    first = j;
            }
            temp = array[ first ];
            array[ first ] = array[ i ];
            array[ i ] = temp;
        }
        return array;
    }
}
