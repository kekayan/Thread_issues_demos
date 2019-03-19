import raceCondition_ctricalSections.Counter;

public class TestThreads {


    public static void main(String[] args) {

//      For Critical & race Conditions ( critical happen by print stream)
//      https://stackoverflow.com/questions/9459657/is-multi-thread-output-from-system-out-println-interleaved
        
        Counter counter = new Counter();
        for (int i = 1; i <= 1; i++) {
            new Thread(() -> {
                counter.add(1);
            }).start();
            new Thread(() -> {
                counter.add(1);
            }).start();
            new Thread(() -> {
                counter.add(1);
            }).start();
            new Thread(() -> {
                counter.add(1);
            }).start();
        }
        System.out.println(counter.getCount());


//       Hidden Deadlock:  All threads are blocked, the program hangs forever. No logs in dump
        /**
         Task task = new Task();
         for (int i = 0; i < 5; i++) {
         new Thread(() -> {
         task.executeTask1();
         }, "pattern 1").start();

         new Thread(() -> {
         task.executeTask2();
         }, "pattern 2").start();
         }
         **/



//        Deadlock:  All threads are blocked, the program hangs forever.
        /**
         Business business=new Business();
         for (int i=0;i<10;i++){
         new Thread(business::foo,"foo").start();
         new Thread(business::bar,"bar").start();
         }
         **/

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
