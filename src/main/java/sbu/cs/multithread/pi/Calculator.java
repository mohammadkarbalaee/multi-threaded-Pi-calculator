package sbu.cs.multithread.pi;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator implements Runnable
{
    private int index;
    private boolean isNegative;
    private BigDecimal angle;

    public Calculator(int index, boolean isNegative, BigDecimal angle)
    {
        this.index = index;
        this.isNegative = isNegative;
        this.angle = angle;
    }

    @Override
    public void run()
    {
        BigDecimal fraction = numerator().divide(denominator(),new MathContext(1000,RoundingMode.HALF_DOWN));
        if (isNegative)
        {
            Pi.addToPi(fraction.negate());
        }
        else
        {
            Pi.addToPi(fraction);
        }
    }

    private BigDecimal denominator()
    {
        int counter = index;
        BigDecimal result = new BigDecimal(1);
        while (counter > 0)
        {
            result = result.multiply(BigDecimal.valueOf(counter));
            counter--;
        }
        return result;
    }

    private BigDecimal numerator()
    {
        BigDecimal result = new BigDecimal(1);
        for (int i = 0; i < index; i++)
        {
            result = result.multiply(angle);
        }
        return result;
    }
}