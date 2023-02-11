package love._016imcn;

import love.thread.*;
import love.untils.SqlSessionFactors;

public class APP {
    public static volatile Integer id;
    public static void main(String[] args) {
        SqlSessionFactors.init();
        Thread addThread = new AddThread();
        try {
            addThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addThread.start();
        while (id == null) {
            Thread.onSpinWait();
        }
        System.out.println("\n\n\n" +id+ "\n\n\n\n\n\n");

        Thread selectThread = new SelectThread(id);
        selectThread.start();
        Thread cycleThread = new CycleThread(id);
        cycleThread.start();
        try {
            cycleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread deleteThread = new DeleteThread(id);
        deleteThread.start();
    }
}
