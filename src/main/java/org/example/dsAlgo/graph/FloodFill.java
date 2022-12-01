package org.example.dsAlgo.graph;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class FloodFill {

    /*
     * We only need to change all the adjacent same pixels recursively of the
     * starting pixel to the given color
     * sr = 1, sc = 1, color = 2
     * [[1,1,1]
     * [1,1,0]
     * [1,0,1]]
     * |
     * v
     * [[2,2,2]
     * [2,2,0],
     * [2,0,1]]
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        int row = image.length;
        if (row == 0) {
            return image;
        }
        int col = image[0].length;
        if (col == 0) {
            return image;
        }

        Queue<Pair<Integer, Integer>> nextPixel = new LinkedList<>();
        nextPixel.add(new Pair<>(sr, sc));

        while (!nextPixel.isEmpty()) {
            int i = nextPixel.element().getKey();
            int j = nextPixel.element().getValue();
            nextPixel.remove();

            if (image[i][j] == startColor) {
                image[i][j] = color;
            }
            // above element
            if (i - 1 >= 0 && image[i - 1][j] == startColor && image[i - 1][j] != color) {
                nextPixel.add(new Pair<Integer, Integer>(i - 1, j));
                image[i - 1][j] = color;
            }
            // left element
            if (j - 1 >= 0 && image[i][j - 1] == startColor && image[i][j - 1] != color) {
                nextPixel.add(new Pair<Integer, Integer>(i, j - 1));
                image[i][j - 1] = color;
            }
            // below element
            if (i + 1 < row && image[i + 1][j] == startColor && image[i + 1][j] != color) {
                nextPixel.add(new Pair<Integer, Integer>(i + 1, j));
                image[i + 1][j] = color;
            }
            // right element
            if (j + 1 < col && image[i][j + 1] == startColor && image[i][j + 1] != color) {
                nextPixel.add(new Pair<Integer, Integer>(i, j + 1));
                image[i][j + 1] = color;
            }
        }
        return image;
    }
}
