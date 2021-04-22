package sbu.cs.multithread.semaphor;

public class SourceControllerPriority {

    public static void main(String[] args) {
        Chef chef1 = new Chef("chef1");
        Chef chef2 = new Chef("chef2");
        Chef chef3 = new Chef("chef3");
        Chef chef4 = new Chef("chef4");
        Chef chef5 = new Chef("chef5");
        chef1.setPriority(1);
        chef2.setPriority(2);
        chef3.setPriority(1);
        chef4.setPriority(3);
        chef5.setPriority(1);
        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();
        chef5.start();
    }
}
