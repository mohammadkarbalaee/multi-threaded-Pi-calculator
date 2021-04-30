package sbu.cs.multithread.pi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator implements Runnable
{
    private int index;
    private boolean isNegative;
    private final BigDecimal FOUR = new BigDecimal(4,new MathContext(1,RoundingMode.HALF_DOWN));

    public Calculator(int index,boolean isNegative)
    {
        this.index = index;
        this.isNegative = isNegative;
    }

    @Override
    public void run()
    {
        BigDecimal bigDecimal = new BigDecimal(oddSeries(index));
        bigDecimal = FOUR.divide(bigDecimal,new MathContext(1000,RoundingMode.HALF_DOWN));
        if (isNegative)
        {
            Pi.addToPi(bigDecimal.negate());
        }
        else
        {
            Pi.addToPi(bigDecimal);
        }
    }

    private int oddSeries(int index)
    {
        return 2 * index - 1;
    }
}