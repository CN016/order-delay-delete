package love._016imcn;

import love.thread.AddThread;
import love.thread.CycleThread;
import love.thread.DeleteThread;
import love.thread.SelectThread;

public class APP {
    public static Integer id;
    public static void main(String[] args) {
        Thread addThread = new AddThread();
        addThread.start();
        try {
            addThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
