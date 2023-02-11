package love.thread;

public class SafeCycleAndSelectThread extends Thread{
    private final int id;

    public SafeCycleAndSelectThread(Integer id){
        this.id = id;
    }

    @Override
    public void run() {

        Thread selectThread = new SelectThread(id);
        selectThread.start();
        Thread cycleThread = new CycleThread(id);
        cycleThread.start();

    }
}
