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
public enum Direction {
    //left (x, y) --> (x, y - 1)
    LEFT {
        @Override
        public Position neighbor(Position position) {
            return new Position(position.getRow(), position.getColum() - 1);
        }

        @Override
        public boolean isValid(Position position) {
            return neighbor(position).getColum() >= 0;
        }

    },
    //right (x, y) --> (x, y + 1)
    RIGHT {
        @Override
        public Position neighbor(Position position) {
            return new Position(position.getRow(), position.getColum() + 1);
        }

        @Override
        public boolean isValid(Position position) {
            return neighbor(position).getColum() < height;
        }

    },
    //up (x, y) --> (x - 1, y)
    UP {
        @Override
        public Position neighbor(Position position) {
            return new Position(position.getRow() - 1, position.getColum());
        }

        @Override
        public boolean isValid(Position position) {
            return neighbor(position).getRow() >= 0;
        }

    },
    //down (x, y) --> (x + 1, y)
    DOWN {
        @Override
        public Position neighbor(Position position) {
            return new Position(position.getRow() + 1, position.getColum());
        }

        @Override
        public boolean isValid(Position position) {
            return neighbor(position).getRow() < width;
        }

    };

    public abstract Position neighbor(Position position);

    public abstract boolean isValid(Position position);

    private static int width;
    private static int height;

    public void setWidth(int width) {
        Direction.width = width;
    }
    
    public void setHeight(int height){
        Direction.height = height;
    }

}
