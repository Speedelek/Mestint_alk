
public class Operator {

    public String op;
    public int index;

    public Operator(String op, int index){
        this.op = op;
        this.index = index;
    }

    public boolean alkalmazhato(Allapot allapot, String op, int index){
        switch (op){
            case "fel":
                return is_valid_up(allapot, index);
            case "le":
                return is_valid_down(allapot, index);
            case "jobb":
                return is_valid_right(allapot, index);
            case "bal":
                return is_valid_left(allapot, index);
            default:
                System.out.println("rossz operator nev");
                return false;
        }
    }

    private static int isPuck(int currentElement){
        if(currentElement == 1 || currentElement == 2) return 1;
        else return 0;
    }

    private static boolean is_valid_up(Allapot allapot,int i){
        int[][] table = allapot.table;
        int counter = 0;

        for(int j = 0; j < 6; j++){
            counter = counter + isPuck(table[j][i]);
        }
        if(counter == 4 && table[0][i] == 0) return true;
        return false;
    }

    private static boolean is_valid_down(Allapot allapot,int i){
        int[][] table = allapot.table;
        int counter = 0;

        for(int j = 0; j < 6; j++){
            counter = counter + isPuck(table[j][i]);
        }
        if(counter == 4 && table[5][i] == 0) return true;
        return false;
    }

    private static boolean is_valid_right(Allapot allapot,int j){
        int[][] table = allapot.table;
        int counter = 0;

        for(int i = 0; i < 6; i++){
            counter = counter + isPuck(table[j][i]);
        }
        if(counter == 4 && table[j][5] == 0) return true;
        return false;
    }

    private static boolean is_valid_left(Allapot allapot,int j){
        int[][] table = allapot.table;
        int counter = 0;

        for(int i = 0; i < 6; i++){
            counter = counter + isPuck(table[j][i]);
        }
        if(counter == 4 && table[j][0] == 0) return true;
        return false;
    }

    //ALKALMAZAS

    public Allapot alkalmaz(Allapot allapot, String op, int index){
        switch (op){
            case "fel":
                return operator_up(allapot, index);
            case "le":
                return operator_down(allapot, index);
            case "jobb":
                return operator_right(allapot, index);
            case "bal":
                return operator_left(allapot, index);
            default:
                System.out.println("rossz operator nev");
                return null;
        }
    }

    private Allapot operator_up(Allapot allapot, int i){
        int[][] table = allapot.table;
        Allapot uj = new Allapot();

        int[][] tmp_table = table.clone();

        for(int j = 0; j <= 4; j++){
            tmp_table[j][i] = table[j+1][i];
        }
		tmp_table[5][i] = 0;

        uj.table = tmp_table;
        return uj;
    }

    private Allapot operator_down(Allapot allapot, int i){
        int[][] table = allapot.table;
        Allapot uj = new Allapot();

        int[][] tmp_table = table.clone();

        for(int j = 5; j > 0; j--){
            tmp_table[j][i] = table[j-1][i];
        }
		tmp_table[0][i] = 0;

        uj.table = tmp_table;
        return uj;
    }

    private Allapot operator_right(Allapot allapot, int j){
        int[][] table = allapot.table;
        Allapot uj = new Allapot();

        int[][] tmp_table = table.clone();

        for(int i = 5; i > 0; i--){
            tmp_table[j][i] = table[j][i-1];
        }
		tmp_table[j][0] = 0;

        uj.table = tmp_table;
        return uj;
    }

    private Allapot operator_left(Allapot allapot, int j){
        int[][] table = allapot.table;
        Allapot uj = new Allapot();

        int[][] tmp_table = table.clone();

        for(int i = 0; i < 5; i++){
            tmp_table[j][i] = table[j][i+1];
        }
		tmp_table[j][5] = 0;

        uj.table = tmp_table;
        return uj;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "op='" + op + '\'' +
                ", index=" + index +
                '}';
    }
}
