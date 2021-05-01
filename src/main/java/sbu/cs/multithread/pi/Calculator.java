package sbu.cs.multithread.pi;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator implements Runnable
{
    private int index;
    private final BigDecimal TWO = new BigDecimal(2,new MathContext(10000,RoundingMode.HALF_DOWN));

    public Calculator(int index)
    {
        this.index = index;
    }

    @Override
    public void run()
    {
        BigDecimal power2 = BigDecimalMath.pow(TWO,index,new MathContext(10000,RoundingMode.HALF_DOWN));
        BigDecimal kFactorial = BigDecimalMath.factorial(index);
        kFactorial = kFactorial.pow(2);
        BigDecimal denominator = BigDecimalMath.factorial(oddSeries(index));
        BigDecimal numerator = power2.multiply(kFactorial);
        BigDecimal fraction = numerator.divide(denominator,new MathContext(10000,RoundingMode.HALF_DOWN));
        Pi.addToPi(fraction);
    }


    private int oddSeries(int index)
    {
        return 2 * index + 1;
    }

}