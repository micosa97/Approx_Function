import java.util.*;

/**
 * Created by micosa on 22.03.17.
 */
public class FunctionFormula {
    public double [] values;
    private List<Data> data;
    private List<FunctionFormula> sons;
    public Double dist;

    public Double getDist (){
        return dist;
    }

    public FunctionFormula (double [] values, List<Data> data ) {
        this.values=values;
        this.data=data;
        calcDistance();
    }
    private double calcDistance () {
        dist= new Double(0);
        for (Data d : data) {
            double aVal=0;
            for (int i = 0; i<6; i++) {
                aVal += values[i]*Math.pow(d.x, i);
            }
            dist = dist + Math.abs(aVal - d.y);
        }

    return dist;
    }
    public void generateSons (int steps, double range)
    {
        Random random = new Random();
        sons = new ArrayList<>();
        for (int i=0; i<400; i++){
            double [] values = this.values.clone();
            values[5] +=(random.nextDouble()-0.5)*range/80;
            values[4] +=(random.nextDouble()-0.5)*range/40;
            values[3] +=(random.nextDouble()-0.5)*range/8;
            values[2] +=(random.nextDouble()-0.5)*range/4;
            values[1] +=(random.nextDouble()-0.5)*range/2;
            values[0] +=(random.nextDouble()-0.5)*range;
            sons.add(new FunctionFormula(values, data));


        }
        sons.sort((o1, o2) -> o1.dist.compareTo(o2.dist));
        sons=sons.subList(0,2);





    }

    public FunctionFormula correctOneself (int step, double range) {
        generateSons(step, range);
        if (step==0) return this;
        for (FunctionFormula s: sons) {
            s.correctOneself(step-1, range/1.5);
        }
        sons.sort((o1, o2) -> o1.dist.compareTo(o2.dist));

        return (this.dist<sons.get(0).dist) ? this.correctOneself(step-1, range/7) : sons.get(0);
    }

    public List<FunctionFormula> getBestSons (){
        //sons.sort((o1, o2) -> o1.dist.compareTo(o2.dist));
      //  sons.sort(Comparator.comparingDouble(FunctionFormula::getDist));
        return sons;

    }
}
