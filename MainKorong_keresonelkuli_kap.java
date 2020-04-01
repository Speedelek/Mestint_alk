
import java.util.Scanner;

public class MainKorong_keresonelkuli_kap {

    //kezdo
    private static int[][] table = {
            {3,0,0,0,0,3},
            {0,1,1,1,2,0},
            {0,1,1,2,1,0},
            {0,1,2,1,1,0},
            {0,2,1,1,1,0},
            {3,0,0,0,0,3}
    };

    private static boolean is_goal(int[][] table){
        if(table[2][2] == 2 && table[2][3] == 2 && table[3][2] == 2 && table[3][3] == 2) return true;
        return false;
    }

    private static int isPuck(int currentElement){
        if(currentElement == 1 || currentElement == 2) return 1;
        else return 0;
    }

    private static boolean is_valid_up(int[][] table,int i){
        int counter = 0;

        for(int j = 0; j < 6; j++){
            counter = counter + isPuck(table[j][i]);
        }
        if(counter == 4 && table[0][i] == 0) return true;
        return false;
    }

    private static boolean is_valid_down(int[][] table,int i){
        int counter = 0;

        for(int j = 0; j < 6; j++){
            counter = counter + isPuck(table[j][i]);
        }
        if(counter == 4 && table[5][i] == 0) return true;
        return false;
    }

    private static boolean is_valid_right(int[][] table,int j){
        int counter = 0;

        for(int i = 0; i < 6; i++){
            counter = counter + isPuck(table[j][i]);
        }
        if(counter == 4 && table[j][5] == 0) return true;
        return false;
    }

    private static boolean is_valid_left(int[][] table,int j){
        int counter = 0;

        for(int i = 0; i < 6; i++){
            counter = counter + isPuck(table[j][i]);
        }
        if(counter == 4 && table[j][0] == 0) return true;
        return false;
    }


    private static int[][] operator_up(int[][] table, int i){

        if(!is_valid_up(table,i)){
            System.out.println("Wrong operation");
            return null;
        }

        int[][] tmp_table = table.clone();

        for(int j = 0; j <= 4; j++){
            tmp_table[j][i] = table[j+1][i];
        }
		tmp_table[5][i] = 0;

        return tmp_table;
    }

    private static int[][] operator_down(int[][] table, int i){

        if(!is_valid_down(table,i)){
            System.out.println("Wrong operation");
            return null;
        }

        int[][] tmp_table = table.clone();

        for(int j = 5; j > 0; j--){
            tmp_table[j][i] = table[j-1][i];
        }
		tmp_table[0][i] = 0;

        return tmp_table;
    }

    private static int[][] operator_right(int[][] table, int j){

        if(!is_valid_right(table,j)){
            System.out.println("Wrong operation");
            return null;
        }

        int[][] tmp_table = table.clone();

        for(int i = 5; i > 0; i--){
            tmp_table[j][i] = table[j][i-1];
        }
		tmp_table[j][0] = 0;

        return tmp_table;
    }

    private static int[][] operator_left(int[][] table, int j){

        if(!is_valid_left(table,j)){
            System.out.println("Wrong operation");
            return null;
        }

        int[][] tmp_table = table.clone();

        for(int i = 0; i < 5; i++){
            tmp_table[j][i] = table[j][i+1];
        }
		tmp_table[j][5] = 0;

        return tmp_table;
    }

    private static void write(int[][] table){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] choose_operator(String op, int index, int[][] table){
        switch (op){
            case "fel":
                return operator_up(table, index);
            case "le":
                return operator_down(table, index);
            case "jobb":
                return operator_right(table, index);
            case "bal":
                return operator_left(table, index);
            default:
                System.out.println("rossz operator nev");
                return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("fel + oszlop, le + oszlop, jobb + sor, bal + sor");
        write(table);

        Scanner scannerOp = new Scanner(System.in);
        Scanner scannerIndex = new Scanner(System.in);
        System.out.print("Enter n: ");

        String op;
        int index;

        while(!is_goal(table)){
            System.out.print("Enter op: ");
            op = scannerOp.nextLine();
            System.out.println();
            System.out.print("Enter index(1-6): ");
            index = scannerIndex.nextInt();

            choose_operator(op, index-1, table);

            write(table);
            System.out.println();
        }
        scannerOp.close();
        scannerIndex.close();
    }
}
