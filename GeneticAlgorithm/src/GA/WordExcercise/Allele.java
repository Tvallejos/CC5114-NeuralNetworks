package GA.WordExcercise;

import java.util.ArrayList;
import java.util.Random;

public class Allele {
    private ArrayList<String> values;
    public Allele(ArrayList<String> values){
        this.values = values;
    }

    public String get(int i){
        return values.get(i);
    }

    public String getRandom(int seed){
        Random r = new Random(seed);
        int low = 0;
        int high = values.size();
        int result = r.nextInt(high-low) + low;
        return get(result);
    }

    public int getSize(){
        return values.size();
    }
}
