public class ArrayDemo6 {
    public static void main(String[] args){
        //二维数组类型  二维数组名 [] []=new 二维数组类型[二维数组长度][二维数组中每个一维数组的长度]
        //int array[][]=new int[4][2];
       /* int [][]array=new int[4][2];
        //int []array[]=new int [4][2];*/
        int [][]array={{1,23,324},{12,12,3123}};
        /*for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[array.length-1].length; j++) {
                System.out.print(array[i][j]+",");
            }
        }*/
        //System.out.println(array);
        System.out.println(array[array.length-1][array[array.length-1].length-1]);
      /*  System.out.println(array[0][0]);
        array[0]=new int[]{2,123,123234};
        System.out.println(array[0][0]);*/

    }
}
