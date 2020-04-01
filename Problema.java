
import java.util.ArrayList;
import java.util.List;

public class Problema {

    public Allapot kezdo() {
        return new Allapot();
    }

    static List<Operator> OPERATOROK = new ArrayList<Operator>();
    static{
        for(int i = 0; i < 6; i++){
            OPERATOROK.add( new Operator("fel",i));
        }
        for(int i = 0; i < 6; i++){
            OPERATOROK.add( new Operator("le",i));
        }
        for(int j = 0; j < 6; j++){
            OPERATOROK.add( new Operator("jobb",j));
        }
        for(int j = 0; j < 6; j++){
            OPERATOROK.add( new Operator("bal",j));
        }
    }

    public List<Operator> operatorok() {
        return OPERATOROK;
    }

}
