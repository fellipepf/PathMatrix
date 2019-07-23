
import com.fpf.pathmatrix.PathMatrix;
import com.fpf.pathmatrix.Position;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felli
 */
public class PathTest {
    
    List<Position> pathExpected = new ArrayList<>();
    
    
    @Test
    public void PathTest(){
        
        pathExpected.add(new Position(0, 0));
        pathExpected.add(new Position(0, 1));
        pathExpected.add(new Position(1, 1));
        pathExpected.add(new Position(2, 1));
        pathExpected.add(new Position(2, 2));
        pathExpected.add(new Position(3, 2));
        pathExpected.add(new Position(4, 2));
        pathExpected.add(new Position(4, 3));
        pathExpected.add(new Position(4, 4));
        
        int matrix[][] = {
            {0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0},
            {1, 0, 0, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0}
        };

        PathMatrix findPath = new PathMatrix(matrix);
        assertEquals(pathExpected, findPath.getPath());
    }
    
}
