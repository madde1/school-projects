import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class algoArraylist {

    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();
        int total = 0;
        int sum;

        for(int i = 0; i < 10000000; i++ ){
            int randInt = (int)(Math.random()* 100)+1;
            arrayList.add(randInt);
            total += randInt;

        }
        sum = total/10000000;

       System.out.println(arrayList);
        System.out.println(sum);
        System.out.println(arrayList.get(999999));
    }
}
