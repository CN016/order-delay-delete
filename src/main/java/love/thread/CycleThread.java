package love.thread;

import love.Mapper;
import love.model.Table;
import love.untils.GetMapper;

import java.util.Date;

public class CycleThread extends Thread{
    private final Integer id ;

    public CycleThread(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("循环线程启动……");
        Mapper mapper = GetMapper.get();
        Table table = mapper.selectById(id);
        Date createDate = table.getDate();
        long createTime = createDate.getTime();
        System.out.println(createDate.getTime());
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        while (currentTime - createTime < 60L * 1000L){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentTime = System.currentTimeMillis();
        }
    }
}
