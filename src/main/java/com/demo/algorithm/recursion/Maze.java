package com.demo.algorithm.recursion;

/**
 * 使用递归解决迷宫问题: 求最短路径
 * 策略: 下 右 上 左
 * map[1][1]: 起点
 * map[6][6]: 终点
 */
public class Maze {

    private static final int NOT_WALKED = 0;

    private static final int WALL = 1;

    private static final int WALKED = 2;

    private static final int DEAD_WAY = 3;

    public static void main(String[] args) {
        int[][] map = initMaze();
        walk(map, 1, 1);
        printMap(map);
        System.out.println("-------------------------");
        printMap(map);
    }

    private static int[][] initMaze(){
        int[][] map = new int[8][8];

        for (int i = 0; i < 8; i++) {
            map[0][i] = WALL;
            map[7][i] = WALL;
            map[i][0] = WALL;
            map[i][7] = WALL;
        }

        map[3][1] = WALL;
        map[3][2] = WALL;
        map[2][2] = WALL;

        return map;
    }

    private static boolean walk(int[][] map, int i, int j){
        if (map[6][6] == WALKED){    // 表示已经到终点了
            return true;
        }
        if (map[i][j] == NOT_WALKED){   // 如果可以走
            map[i][j] = WALKED;         // 设置为走过
            if (walk(map, i + 1, j)){           // 下
                return true;
            } else if(walk(map, i, j + 1)){     // 右
                return true;
             } else if (walk(map, i - 1, j)){   // 上
                return true;
            } else if (walk(map, i, j - 1)){    // 左
                return true;
            } else {
                map[i][j] = DEAD_WAY;
                return false;
            }
        }
        return false;
    }

    private static void printMap(int[][] map){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
