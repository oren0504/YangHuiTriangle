/**
 * This is a example of creating YangHui triangle.
 * The mechanism of this code is the YangHui triangle's own principle,
 * The calculating number equals the sum of the numbers above it.
 *
 * To make the triangle generated looks more beautiful,
 * we take each blank as a variable controlled.
 *
 * First Step is to print all the blanks in the front.
 * Second Step is to print the combination aof the calculated number and the blanks accompanied.
 * Third Step is just the line-breaking.
 *
 * Repeat the Steps above for several times until reaching the goal.
 *
 * Considering the number goes larger and larger under the addition,
 * the algorithm for calculating the length of blanks accompanied need to be improved by adding more judgment if the line is too large.
 * So we limit the number maximum in order to make the shape looking perfect.
 *
 *
 *Improve the algorithm part if you have larger canvas to draw the triangle.
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class YangHuiTri {

    public static void main(String[] args) {
        //test for 3 times
        Scanner s1= new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            //Input the lines of the triangle wanted.
            Triangle(s1.nextInt());
        }

    }

    public static void Triangle(int n){//input the line length.
        //set the front blanks
        SymbolPart f1 = new SymbolPart();
        f1.setSymbol("   ");
        //set the accompanied blanks
        SymbolPart m1 = new SymbolPart();
        m1.setSymbol(" ");
        m1.setL(1);

        //set the triangle array and start calculating...
        int[][] tri = new int[n][n];
        for (int i = 0; i < tri.length; i++) {
            for (int j = 0; j < tri.length; j++) {
                try{
                    //calculate for the whole array.
                    tri[i][j] = tri[i-1][j] + tri[i-1][j-1];
                    //force the last number for the triangle line as 1.
                    if (i == j){
                        tri[i][j] = 1;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    //deal with the several beginning numbers.
                    tri[i][j] = 1;
                }
            }
        }


        //Output the triangle line by line during calculating the accompanied blanks length.
        for (int i=0 ; i < n; i++) {
            //set the front blanks length for each line and print.
            f1.setL(n-i-1);
            System.out.print(f1.getPart());

            //Output the combination of number and blanks.
            for (int j = 0; j <= i; j++) {
                System.out.print(tri[i][j]);
                if (tri[i][j]<10){
                    m1.setL(4);
                }else if(tri[i][j]<100){
                    m1.setL(3);
                }else if(tri[i][j]<1000){
                    m1.setL(2);
                }else if(tri[i][j]<10000){
                    m1.setL(1);
                }else {//number get too large to make the shape looks perfect
                    System.out.println();
                    System.out.println("The Number calculating now is larger than 10000.");
                    System.exit(0);
                }
                System.out.print(m1.getPart());
            }
            //make a line breaking.
            System.out.println();
        }
    }

}
