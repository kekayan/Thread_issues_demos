package raceCondition_ctricalSections;

public class Counter {
    protected long count = 0;

    public long getCount() {
        return count;
    }

    public void add(long value) {

        this.count = this.count + value;
        for (int i = 0; i < 10000000; i++) {
            System.out.println(i);
        }
    }


}
