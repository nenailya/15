package sample;

public class smth {
    public static int[][] array;

    public static void fooForEachCell(int x, int y) {

        if(x+1<4 && array[x+1][y] == 0)  {array[x+1][y] = array[x][y]; array[x][y] = 0;} else
        if(y+1<4 && array[x][y+1] == 0)  {array[x][y+1] = array[x][y]; array[x][y] = 0;} else
        if(x-1>-1 && array[x-1][y] == 0) {array[x-1][y] = array[x][y]; array[x][y] = 0;} else
        if(y-1>-1 && array[x][y-1] == 0) {array[x][y-1] = array[x][y]; array[x][y] = 0;}


    }

    static {
        clean();
    }

    public static void clean() {
        array = new int[4][4];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[0][3] = 4;
        array[1][0] = 5;
        array[1][1] = 6;
        array[1][2] = 7;
        array[1][3] = 8;
        array[2][0] = 9;
        array[2][1] = 10;
        array[2][2] = 11;
        array[2][3] = 12;
        array[3][0] = 13;
        array[3][1] = 14;
        array[3][2] = 15;
        array[3][3] = 0;

    }

}