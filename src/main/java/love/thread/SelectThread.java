package love.thread;

import love.Mapper;
import love.model.Table;
import love.untils.GetMapper;

public class SelectThread extends Thread {
    private final Integer id;

    public SelectThread(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("查询线程启动……");
        Mapper mapper = GetMapper.get();
        while (true){
            Table table = mapper.selectById(id);
            if (table == null){
                System.out.println("未找到");
                return;
            }else {
                System.out.println(table);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
