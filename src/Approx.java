import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by micosa on 22.03.17.
 */

public class Approx {
    static public void main (String[] args) {


        List<Data> data = new ArrayList<>();

        data.add(new Data (1, 2));
        data.add(new Data (6, 9));
        data.add(new Data (10, 5));
        data.add(new Data (13, -11.2));
        //data.add(new Data (50, -11.2));
        data.add(new Data (100, 20));

        FunctionFormula f = new FunctionFormula(new double[] {0,0,0,0,0,0}, data);
        //f.generateSons(1, 50);
        //List<FunctionFormula> BS = f.getBestSons();
        //for (FunctionFormula b : BS) {
        FunctionFormula b = f.correctOneself(9, 40);
            System.out.println(b.dist);
            for (int i=5; i>0; i--) {
                System.out.print(b.values[i]+"*x^"+i+" + ");
            }
            System.out.println(b.values[0]);
        //}






    }
}
