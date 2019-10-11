package GA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlleleTest {
    private Allele alleleValues;


    @BeforeEach
    void Setup() {
        //constructor test
        String rgb = "red green blue";
        ArrayList<String> strArr = new ArrayList<String>(Arrays.asList(rgb.split(" ")));
        alleleValues = new Allele(strArr);
    }

    @Test
    void abcConstructor(){
        String s = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        ArrayList<String> abc = new ArrayList<String>(Arrays.asList(s.split(" ")));
        alleleValues = new Allele(abc);
        String[] abcArray = s.split(" ");
        for (int i = 0; i < abcArray.length ; i++) {
            assertEquals(abcArray[i],alleleValues.get(i));
        }
    }

    @Test
    void getRandomTest(){
        Random r = new Random(0);
        // 5 first random values
        //0
        //2
        //0
        //2
        //1
        // from random seed 0 + other random
        // code
        // for (int i = 0; i <5 ; i++) {
        //int seed = new Random(r.nextInt()).nextInt(alleleValues.getSize());
        //    System.out.println(seed);
        //}

        assertEquals("red",alleleValues.getRandom(r.nextInt()));
        assertEquals("blue",alleleValues.getRandom(r.nextInt()));
        assertEquals("red",alleleValues.getRandom(r.nextInt()));
        assertEquals("blue",alleleValues.getRandom(r.nextInt()));
        assertEquals("green",alleleValues.getRandom(r.nextInt()));
    }

    @Test
    void getSizeTest(){
        assertEquals(3,alleleValues.getSize());
    }
}
