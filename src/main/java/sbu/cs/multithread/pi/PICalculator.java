package sbu.cs.multithread.pi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PICalculator
{
    private ExecutorService executorService = Executors.newFixedThreadPool(16);

    public String calculate(int floatingPoint)
    {
        boolean isNegative = false;
        for (int i = 1; i < 1000000; i++)
        {
            executorService.submit(new Calculator(i,isNegative));
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
        return Pi.getPi().toString();
    }
}
