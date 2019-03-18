package starvation;



public class Worker {

    public synchronized void work(){


        while (true){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
