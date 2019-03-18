package liveLock;

public class Police {
    private  boolean moneySent=false;

    public void giveMoney(Criminal criminal){
        while (!criminal.isHostageReleased()){
            System.out.println("Police: waiting criminal to release hostage");


        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Police: sent money");

        this.moneySent=true;
    }

    public boolean isMoneySent() {
        return this.moneySent;
    }
}
