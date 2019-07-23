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

        createPath(matrix.getStartPosition());
    }

    public int getIterarions() {
        return iterations;
    }

    private boolean isFinalPosition(Position position) {
        return matrix.getEndPosition().equals(position);
    }

    private boolean avaliaVizinho(Direction direction, Position position) {
        Position vizinho = direction.neighbor(position);

        direction.setN(N);

        return direction.isValid(position) && !visited.contains(vizinho) && matrix.getValue(vizinho) == 0;
    }

    private List<Position> createPath(Position actualPosition) {

        iterations++;

        if (isFinalPosition(actualPosition)) {
            path.add(actualPosition);
            return path;
        }

        this.visited.add(actualPosition);

        if (matrix.isPositionValid(actualPosition) && this.matrix.getValue(actualPosition) == 0) {
            path.add(actualPosition);

            if (avaliaVizinho(Direction.DOWN, actualPosition)) {
                Position neighbor = Direction.DOWN.neighbor(actualPosition);
                createPath(neighbor);
            }

            if (avaliaVizinho(Direction.UP, actualPosition)) {
                Position neighbor = Direction.UP.neighbor(actualPosition);
                createPath(neighbor);
            }

            if (avaliaVizinho(Direction.RIGHT, actualPosition)) {
                Position neighbor = Direction.RIGHT.neighbor(actualPosition);
                createPath(neighbor);
            }

            if (avaliaVizinho(Direction.LEFT, actualPosition)) {
                Position neighbor = Direction.LEFT.neighbor(actualPosition);
                createPath(neighbor);
            }
        }

        this.visited.remove(actualPosition);

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

        System.out.println("path " + findPath.path);
        System.out.println("iterations " + findPath.getIterarions());
    }

}
