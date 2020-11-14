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
        var m = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = m;
                m++;
            }
        }
        array[3][3] = 0;
    }

}