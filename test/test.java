import org.junit.Test;
import sample.Controller;

import static org.junit.Assert.assertEquals;
import static sample.smth.*;

import sample.Solver;
public class test {

    @Test
    public void test1(){
        array[0][0] = 13;
        array[0][1] = 7;
        array[0][2] = 5;
        array[0][3] = 1;
        array[1][0] = 11;
        array[1][1] = 8;
        array[1][2] = 4;
        array[1][3] = 10;
        array[2][0] = 3;
        array[2][1] = 2;
        array[2][2] = 15;
        array[2][3] = 9;
        array[3][0] = 6;
        array[3][1] = 14;
        array[3][2] = 12;
        array[3][3] = 0;

        Solver h = new Solver();
        assertEquals( h.helper() ,"LURULLDLUURRRDLLDLDRULUURRDLLURRDLDRRDLLLURRDR" );
    }

}
