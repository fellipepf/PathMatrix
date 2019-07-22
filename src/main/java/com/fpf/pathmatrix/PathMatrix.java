/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpf.pathmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felli
 */
public class PathMatrix {

    private Matrix matrix;
    private List<Position> path;
    
    private static int N = 5;
    private int iterations = 0;

    public PathMatrix(int arrayMatrix[][]){
       this.matrix = new Matrix(arrayMatrix);
       this.path = new ArrayList<>();
        
    }

    public int getIterarions(){
        return iterations;
    }
    private static boolean isValidPosition(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }

        return true;
    }
    
    private List<Position> createPath(int x, int y, boolean visited[][]) {
        
        Position position = new Position(x, y);
        
        iterations++;
        
        if (x == N - 1 && y == N - 1) {
            path.add(position);
            return path;
        }

        visited[x][y] = true;

        if (isValidPosition(x, y) && this.matrix.getValue(position) == 0) {
            path.add(position);

            
            if (x + 1 < N && !visited[x + 1][y]) {
                createPath(x + 1, y, visited);
            }

            // go up (x, y) --> (x - 1, y)
            if (x - 1 >= 0 && !visited[x - 1][y]) {
                createPath( x - 1, y, visited);
            }

            // go right (x, y) --> (x, y + 1)
            if (Direction.RIGHT.neighbor(position).getColum() < N && !visited[x][y + 1] ) {
                createPath(x, y + 1, visited);
            }

            // go left (x, y) --> (x, y - 1)
            if (y - 1 >= 0 && !visited[x][y - 1]) {
                createPath(x, y - 1, visited);
            }
        }

        visited[x][y] = false;
        

        return path;
    }

    public static void main(String args[]) {
        int matrix[][] = {
            {0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0},
            {1, 0, 0, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0}
        };

        PathMatrix findPath = new PathMatrix(matrix);

        boolean[][] visited = new boolean[N][N];

        findPath.createPath( 0, 0, visited);

        System.out.println("path " + findPath.path);
        System.out.println("iterations "+findPath.getIterarions());
    }

}
