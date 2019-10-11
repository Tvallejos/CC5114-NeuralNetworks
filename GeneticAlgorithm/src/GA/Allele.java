package GA;

import java.util.ArrayList;
import java.util.Random;

public class Allele {
    private ArrayList<String> values;

    public Allele(ArrayList<String> values) {
        this.values = values;
    }

    public String get(int i) {
        return values.get(i);
    }

    public String getRandom(int seed) {
        Random r = new Random(seed);
        int low = 0;
        int high = values.size();
        int result = r.nextInt(high - low) + low;
        return get(result);
    }

    public int getSize() {
        return values.size();
    }

    //private ArrayList<String> getValues() {
    //    return values;
    //}

    @Override
    public boolean equals(Object o) {
        if (o instanceof Allele) {
            if (values.size() == ((Allele) o).values.size()) {
                boolean accumulated = true;
                for (int i = 0; i < values.size(); i++) {
                    accumulated = accumulated && values.get(i).equals(((Allele) o).values.get(i));

                }
                return accumulated;
            }
        }
        return false;
    }
}
