package love.thread;

import love.Mapper;
import love.model.Table;
import love.untils.GetMapper;

public class DeleteThread extends Thread{
    private Integer id;
    public DeleteThread(Integer id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("删除线程启动……");
        Mapper mapper = GetMapper.get();
        Table table = mapper.selectById(id);
        mapper.deleteById(id);
        System.out.println("删除成功："+table);
    }
}
