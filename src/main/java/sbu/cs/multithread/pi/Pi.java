package sbu.cs.multithread.pi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Pi
{
    private static BigDecimal pi = new BigDecimal(0,new MathContext(1000,RoundingMode.HALF_DOWN));

    synchronized public static void addToPi(BigDecimal singleFraction)
    {
        pi = pi.add(singleFraction);
    }

    public static BigDecimal getPi()
    {
        return pi;
    }
}
