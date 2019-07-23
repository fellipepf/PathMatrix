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
    private List<Position> visited;

    private static int N = 5;
    private int iterations = 0;

    public PathMatrix(int arrayMatrix[][]) {
        this.matrix = new Matrix(arrayMatrix);
        this.path = new ArrayList<>();
        this.visited = new ArrayList<>();

    }

    public int getIterarions() {
        return iterations;
    }

    private static boolean isValidPosition(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }

        return true;
    }

    private boolean avaliaVizinho(Direction direction, Position position) {
        Position vizinho = direction.neighbor(position);

        direction.setN(N);

        if (direction.isValid(position) && !visited.contains(vizinho)) {
            return true;
        }

        return false;
    }

    private List<Position> createPath(int x, int y) {

        Position position = new Position(x, y);

        iterations++;

        if (x == N - 1 && y == N - 1) {
            path.add(position);
            return path;
        }

        this.visited.add(position);

        if (isValidPosition(x, y) && this.matrix.getValue(position) == 0) {
            path.add(position);

            if (avaliaVizinho(Direction.DOWN, position)) {
                createPath(Direction.DOWN.neighbor(position).getRow(), Direction.DOWN.neighbor(position).getColum());
            }

            if (avaliaVizinho(Direction.UP, position)) {
                createPath(Direction.UP.neighbor(position).getRow(), Direction.UP.neighbor(position).getColum());
            }

            if (avaliaVizinho(Direction.RIGHT, position)) {
                createPath(Direction.RIGHT.neighbor(position).getRow(), Direction.RIGHT.neighbor(position).getColum());
            }

            if (avaliaVizinho(Direction.LEFT, position)) {
                createPath(Direction.LEFT.neighbor(position).getRow(), Direction.LEFT.neighbor(position).getColum());
            }
        }

        this.visited.remove(position);

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

        findPath.createPath(0, 0);

        System.out.println("path " + findPath.path);
        System.out.println("iterations " + findPath.getIterarions());
    }

}
