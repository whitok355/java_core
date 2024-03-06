package ja;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Generator {
    private static Random rand = new Random();

    private static double getRandomDouble(int max, int min){
        MathContext context = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(rand.nextDouble(max,min), context);
        return result.doubleValue();
    }
    private static int getRandomInt(int max, int min){
        return rand.nextInt(max, min);
    }
    public static People generateWorkers(int id){
        int rand = getRandomInt(0, 2);
        if(rand == 1){
            return new Freelancer(
                    id,
                    getRandomDouble(0, 23),
                    getRandomDouble(100, 500) //ставка за час
            );
        } else{
            return new Worker(
                    id,
                    getRandomDouble(0, 23 ),
                    getRandomDouble(500, 5000) //ставка за день
            );
        }
    }
}