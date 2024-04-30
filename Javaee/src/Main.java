import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<INT>a = new ArrayList<>();
        ArrayList<INT>b=new ArrayList<>();

        INT as1 = new INT(2);
        a.add(as1);

        for(INT it:a){
            System.out.println(it.getTmp());
        }

        for(INT it:a){
            System.out.println(it.getTmp());
        }

        System.out.println("");

        for(INT it:a){
            b.add(it);
        }

        for(int i=0;i<b.size();i++){
            b.get(i).setTmp(3);
        }

        System.out.println("修改后");
        for(INT it:a){
            System.out.println(it.getTmp());
        }
    }
}