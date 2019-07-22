
import com.fpf.pathmatrix.Direction;
import com.fpf.pathmatrix.Position;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felli
 */
public class DirectionTest {
    public static void main(String args[]){
        Position p = new Position(0, 0);
        
        System.out.println(Direction.LEFT.neighbor(p));
        System.out.println(Direction.RIGHT.neighbor(p));
        System.out.println(Direction.UP.neighbor(p));
        System.out.println(p);
    }
}
