package sbu.cs.multithread.pi;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PICalculator
{
    private ExecutorService executorService = Executors.newFixedThreadPool(8);
    private final BigDecimal angle = new BigDecimal(String.valueOf(BigDecimalMath.pi(new MathContext(1010, RoundingMode.HALF_DOWN)))).divide(BigDecimal.valueOf(1000000),new MathContext(1010,RoundingMode.HALF_DOWN));

    public String calculate(int floatingPoint)
    {
        boolean isNegative = false;
        for (int i = 1; i < 100; i++)
        {
            executorService.submit(new Calculator(i,isNegative,angle));
            isNegative = !isNegative;
        }
        executorService.shutdown();
        try
        {
            executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return Pi.getPi().multiply(BigDecimal.valueOf(1000000)).toString();
    }
}
