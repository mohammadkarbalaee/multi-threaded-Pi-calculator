package sbu.cs.multithread.semaphor;


import java.util.concurrent.Semaphore;

public class SourceController
{

    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(2);

        Chef chef1 = new Chef("chef1",semaphore);
        Chef chef2 = new Chef("chef2",semaphore);
        Chef chef3 = new Chef("chef3",semaphore);
        Chef chef4 = new Chef("chef4",semaphore);
        Chef chef5 = new Chef("chef5",semaphore);
        chef1.setPriority(1);
        chef2.setPriority(1);
        chef3.setPriority(1);
        chef4.setPriority(1);
        chef5.setPriority(1);
        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();
        chef5.start();
    }
}
