package com.padilha.algorithms.java;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Queue;

/*
 A satellite image of the Pacific Ocean consists of green and blue pixels, representing land and water.
    The Pacific ocean is large, and mostly blue; but contains islands, which are green. Islands themselves may contain blue pixels, which are lakes.

    A frontend presents the image to a user, who can click on it. When the user clicks on a green pixel, a popup will appear that displays the number of lakes in that island. \
    This UI code already exists: the problem of this question is to write the backend function that will return the value to display.

    As an example, consider an image (20 pixels wide by 10 tall) that is mostly blue; but contains 3 green rectangles:

    On the left of the image there is a horizontal line of three green pixels, from coordinates (2, 2) to (4, 2). This is an island with no lakes
    In the middle is a 3x3 square of green pixels (coordinates (5, 4) to (7, 6)) where the center pixel (6, 5) is water. This is an island with 1 lake
    On the right is a green rectangle (coordinates (11, 3) to (16, 5)) where three internal pixels are water: (12, 4), (14, 4), and (15, 4).
    This forms an island with two lakes.

|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|
        |.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|
        |.|.|x|x|x|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|
            |.|.|.|.|.|.|.|.|.|.|.|x|x|x|x|x|x|.|.|.|
            |.|.|.|.|.|x|x|x|.|.|.|x|.|x|.|.|x|.|.|.|
            |.|.|.|.|.|x|.|x|.|.|.|x|x|x|x|x|x|.|.|.|
            |.|.|.|.|.|x|x|x|.|.|.|.|.|.|.|.|.|.|.|.|
            |.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|
    Assuming a function, count_lakes(image, coord) → integer:

    count_lakes(image, (2,2)) → 0
    count_lakes(image, (6,6)) → 1
    count_lakes(image, (12,5)) → 2


            1 -> Look around the user click. Depth first search
 2 -> Look for lakes
 3 - return number os lakes for the iland.

            |.|.|.|.|.|.|.|.|.|.|4|5|6|.|.|.|.|.|.|.|
            0 |.|.|.|.|.|.|x|x|.|.|.|.|.|.|.|.|.|.|.|.|
            1 |x|x|.|.|.|x|.|.|x|.|x|.|.|.|.|.|.|.|.|.|
            2 |.|.|x|x|x|.|.|.|x|x|.|X|.|.|.|.|.|.|.|.|
            3 |.|.|.|x|.|.|.|.|X|.|.|x|x|x|x|x|x|.|.|.|
            |.|.|.|.|.|x|x|.|.|.|.|x|.|x|.|.|x|.|.|.|
            |.|.|.|.|.|x|.|x|.|.|x|x|x|x|x|x|x|.|.|.|
            |.|.|.|.|.|x|x|x|.|x|.|.|.|.|.|.|.|.|.|.|
            |.|.|.|.|.|.|.|.|x|.|.|.|.|.|.|.|.|.|.|.|


            -> visitedArray {up, down, left, right, lu,}

   [20, 10]

           [4,0] = 0
           [4,1] = 0
           [4,2] = x
   [4,3] = 0

           [5,0] = 0
           [5,1] = x
   [5,2] = 0
           [5,3] = 0

           [6,0] = 0
           [6,1] = 0
           [6,2] = x
   [6,3] = 0
 */
public class IslandGoogle {
    /*
    Pair<Integer,Integer> -> Position
    Integer -> Total lakes

    Map<Pair<Integer,Integer>,Integer>

    public void findLake() {

        nlakes = new HashMap();

        Point (x, y)

        boolean[][] image = {{false, false, false, false, false, false},
                {false, true, true, true, false, false},
                {false, true, false, true, false, false},
                {false, true, true, true, false, false},
                {false, false, false, false, false, false}};

        public int[][] depthFS(int[][] initial, int start, int end) {

        }

        public int findLake(boolean[][] image, Point point) {


            int length = image[0].length;
            int high = image[0,0].length;

            int[][] initial[][] = new int[point.x, point.y];
            int[][] visited[][] = new int[0,0];

            int start = initial[0];

            while () {
                depthFS()
            }

        }

     */

    private static void DFSMarkingIsland(char[][] grid, Queue<int[]> frontier, boolean[][] visited) {

    }

    public int findLake(boolean[][] image, Point point){
     int count = 0;

     int n = image.length;
     if (n == 0) return 0;
     int m = image[0].length;

    for (int i = point.x; i < n; i++){
        for (int j = point.y; j < m; j++)
        {
            
        }
    }

     return count;
    }

    public static void main(String[] args) {
        BigDecimal testBig = new BigDecimal(19);
        System.out.println(testBig.toString());
    }

}
