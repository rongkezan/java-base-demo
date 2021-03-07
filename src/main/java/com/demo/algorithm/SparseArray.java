package com.demo.algorithm;

/**
 * 稀疏数组
 * 将 11*11 的二维数组转化成稀疏数组
 * 0:无子 1:黑子 2:蓝子
 */
public class SparseArray {

    public static void main(String[] args) {
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        for (int[] row : chessArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        int sum = 0;
        for (int[] row : chessArr) {
            for (int item : row) {
                if (item != 0) sum++;
            }
        }
        // 创建稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (chessArr[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println("--- 得到的稀疏数组 ---");
        for (int[] row : sparseArray) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 将稀疏数组还原为二维数组
        System.out.println("--- 恢复后的二维数组 ---");
        int newChessArr[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++){
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            int val = sparseArray[i][2];
            newChessArr[row][col] = val;
        }

        for (int[] row : newChessArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
