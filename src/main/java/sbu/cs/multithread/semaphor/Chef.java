package sbu.cs.multithread.semaphor;

import java.util.concurrent.Semaphore;

public class Chef extends Thread
{
    private Semaphore semaphore;

    public Chef(String name,Semaphore semaphore)
    {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                semaphore.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            Source.getSource();
            System.out.println("by " + getName());
            try
            {
                sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            semaphore.release();
        }
    }
}
