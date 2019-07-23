
import com.fpf.pathmatrix.Direction;
import com.fpf.pathmatrix.Position;
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
public class DirectionTest {

    Position p = new Position(0, 0);

    
    @Test
    public void DirectionTest(){
       
        Position expectedPosition = new Position(0, -1);
        assertEquals(expectedPosition, Direction.LEFT.neighbor(p));
        
        expectedPosition = new Position(0, 1);
        assertEquals(expectedPosition, Direction.RIGHT.neighbor(p));
        
        expectedPosition = new Position(-1,0 );
        assertEquals(expectedPosition, Direction.UP.neighbor(p));
        
        expectedPosition = new Position(1, 0);
        assertEquals(expectedPosition, Direction.DOWN.neighbor(p));
    }
    

}
