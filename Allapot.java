
import java.util.Arrays;

public class Allapot {

    public int[][] table = new int[6][6];

    private int[][] celTable = {
            {3,0,0,0,0,3},
            {0,1,1,1,1,0},
            {0,1,2,2,1,0},
            {0,1,2,2,1,0},
            {0,1,1,1,1,0},
            {3,0,0,0,0,3}
    };

    public Allapot(){
        table[0][0] = 3;
        table[0][1] = 0;
        table[0][2] = 0;
        table[0][3] = 0;
        table[0][4] = 0;
        table[0][5] = 3;

        table[1][0] = 0;
        table[1][1] = 1;
        table[1][2] = 1;
        table[1][3] = 1;
        table[1][4] = 2;
        table[1][5] = 0;

        table[2][0] = 0;
        table[2][1] = 1;
        table[2][2] = 1;
        table[2][3] = 2;
        table[2][4] = 1;
        table[2][5] = 0;

        table[3][0] = 0;
        table[3][1] = 1;
        table[3][2] = 2;
        table[3][3] = 1;
        table[3][4] = 1;
        table[3][5] = 0;

        table[4][0] = 0;
        table[4][1] = 2;
        table[4][2] = 1;
        table[4][3] = 1;
        table[4][4] = 1;
        table[4][5] = 0;

        table[5][0] = 3;
        table[5][1] = 0;
        table[5][2] = 0;
        table[5][3] = 0;
        table[5][4] = 0;
        table[5][5] = 3;
    }

    public boolean cel(){
        return table == celTable;
    }

    @Override
    public String toString() {
        return "Allapot{" +
                "table=" + Arrays.toString(table) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allapot allapot = (Allapot) o;
        return Arrays.equals(table, allapot.table);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(table);
    }
}
