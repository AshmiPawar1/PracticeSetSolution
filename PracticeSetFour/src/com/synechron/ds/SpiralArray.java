package com.synechron.ds;

public class SpiralArray {

	static void spiralPrint(int endRow, int endColumn, int a[][]) 
    { 
        int i, startRow = 0, startColumn = 0; 
        /*  startRow - starting row index 
        endRow - ending row index 
        startColumn - starting column index 
        endColumn - ending column index 
        i - iterator 
        */
  
        while (startRow < endRow && startColumn < endColumn) { 
            // Print the first row from the remaining rows 
            for (i = startColumn; i < endColumn; ++i) { 
                System.out.print(a[startRow][i] + " "); 
            } 
            startRow++; 
  
            // Print the last column from the remaining columns 
            for (i = startRow; i < endRow; ++i) { 
                System.out.print(a[i][endColumn - 1] + " "); 
            } 
            endColumn--; 
  
            // Print the last row from the remaining rows */ 
            if (startRow < endRow) { 
                for (i = endColumn - 1; i >= startColumn; --i) { 
                    System.out.print(a[endRow - 1][i] + " "); 
                } 
                endRow--; 
            } 
  
            // Print the first column from the remaining columns */ 
            if (startColumn < endColumn) { 
                for (i = endRow - 1; i >= startRow; --i) { 
                    System.out.print(a[i][startColumn] + " "); 
                } 
                startColumn++; 
            } 
        } 
    } 
  
   
    public static void main(String[] args) 
    { 
        int R = 4; 
        int C = 6; 
        int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 },
                      { 19, 20, 21, 22, 23, 24 }}; 
        spiralPrint(R, C, a); 
    } 


}
