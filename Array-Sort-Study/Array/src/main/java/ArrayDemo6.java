import jdk.internal.util.xml.impl.Input;
import sun.security.util.Length;

import java.util.Scanner;
/*      1
        1	1
        1	2	1
        1	3	3	1
        1	4	6	4	1
        1	5	10	10	5	1*/
public class ArrayDemo6 {
    public static void main(String[] args){
        System.out.println("请输入你要打印的行数：");
        Scanner input=new Scanner(System.in);
        int n= input.nextInt();
        int array[][]=new int[n][n];
        for (int i = 0; i < array.length; i++) {
            array[i][i]=1;
            array[i][0]=1;
        }

        for (int i = 2; i < array.length; i++) {
            for (int j = 1; j < i; j++) {
                array[i][j]=array[i-1][j]+array[i-1][j-1];
            }
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
        //

    }
}
