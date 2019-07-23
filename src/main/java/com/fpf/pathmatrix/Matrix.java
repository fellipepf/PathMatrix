/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpf.pathmatrix;

/**
 *
 * @author felli
 */
public class Matrix {
    
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int getValue(int row, int colum){
        return matrix[row][colum];
    }
    
    public int getValue(Position position){
        return matrix[position.getRow()][position.getColum()];
    }
    
    public int getHeight(){
        return matrix[0].length;
    }
    
    public int getWidth(){
        return matrix.length;
    }
    
    public boolean isPositionValid(Position position){
         return !(position.getRow() < 0 || position.getColum() < 0 
                 || position.getRow() >= getWidth() || position.getColum() >= getHeight());
    }
    
    public Position getStartPosition(){
        return new Position(0, 0);
    }
    
    public Position getEndPosition(){
        return new Position(getWidth()-1, getHeight()-1);
    }
    
}
