package com.practise.programs;

public class LCDProgram {
    public static void main(String[] args) {
        //String arg = "67";
        String arg = args[0];
        int numberOfChars = arg.length();
        int[][][] chars = new int[numberOfChars][3][3];
        int[][] one = {{0,0,0}, {0,0,1}, {0,0,1}};
        int[][] two = {{0,1,0}, {0,1,1}, {1,1,0}};
        int[][] three = {{0,1,0}, {0,1,1}, {0,1,1}};
        int[][] four = {{0,0,0}, {1,1,1}, {0,0,1}};
        int[][] five = {{0,1,0}, {1,1,0}, {0,1,1}};
        int[][] six = {{0,1,0}, {1,1,0}, {1,1,1}};
        int[][] seven = {{0,1,0}, {0,0,1}, {0,0,1}};
        int[][] eight = {{0,1,0}, {1,1,1}, {1,1,1}};
        int[][] nine = {{0,1,0}, {1,1,1}, {0,1,1}};
        int[][] zero = {{0,1,0}, {1,0,1}, {1,1,1}};
        int i, j, k;
         
        for(i=0; i<numberOfChars; i++){
            if(arg.charAt(i)=='1') chars[i] = one;
            else if(arg.charAt(i)=='2') chars[i] = two;
            else if(arg.charAt(i)=='3') chars[i] = three;
            else if(arg.charAt(i)=='4') chars[i] = four;
            else if(arg.charAt(i)=='5') chars[i] = five;
            else if(arg.charAt(i)=='6') chars[i] = six;
            else if(arg.charAt(i)=='7') chars[i] = seven;
            else if(arg.charAt(i)=='8') chars[i] = eight;
            else if(arg.charAt(i)=='9') chars[i] = nine;
            else if(arg.charAt(i)=='0') chars[i] = zero;
            else chars[i] = four;
        }
         
        for (j = 0; j < 3; j++) {
            for (i = 0; i < numberOfChars; i++) {
                for (k = 0; k < 3; k++) {
                    if (chars[i][j][k] == 1) {
                        if (k == 1) System.out.print("_");
                        else System.out.print("|");
                    }
                    else System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}