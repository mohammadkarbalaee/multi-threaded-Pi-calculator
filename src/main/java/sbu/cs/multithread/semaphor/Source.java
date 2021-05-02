package sbu.cs.multithread.semaphor;

public class Source
{

    public static void getSource()
    {
        System.out.println("source is taken");
        try
        {
            Thread.sleep(10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
