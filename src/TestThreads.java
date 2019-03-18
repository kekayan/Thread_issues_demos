import deadLock.Business;
import liveLock.Criminal;
import liveLock.Police;
import starvation.Worker;

public class TestThreads {


    public static void main(String[] args) {

//        Deadlock:  All threads are blocked, the program hangs forever.
        Business business=new Business();
        for (int i=0;i<10;i++){
            new Thread(business::foo,"foo").start();
            new Thread(business::bar,"bar").start();
        }


//         Livelock: No threads blocked but they run into infinite loops. The program is still running but unable to make further progress.
        /**
         Criminal criminal=new Criminal();
         Police police=new Police();
        new Thread(()->{
            criminal.releaseHostage(police);
        },"Criminal Thread").start();

        new Thread(()->{
            police.giveMoney(criminal);
        },"Police Thread").start();

         **/


//        Starvation: Only one thread is running, and other threads are waiting forever.
        /**
        Worker worker=new Worker();

        for (int i=0;i<10;i++){
            new Thread(()->{
                worker.work();
            },String.valueOf(i)).start();
        }
         **/



    }
}
