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
    private ExecutorService executorService = Executors.newFixedThreadPool(16);

    public String calculate(int floatingPoint)
    {
        for (int i = 0; i <= 10000; i++)
        {
            executorService.submit(new Calculator(i));
        }
        executorService.shutdown();
        try
        {
            executorService.awaitTermination(10000,TimeUnit.MILLISECONDS);
            executorService.shutdownNow();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return Pi.getPi().multiply(BigDecimal.valueOf(2)).toString().substring(0,floatingPoint+2);
    }
}
