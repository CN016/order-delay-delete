package love.thread;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import love.Mapper;
import love._016imcn.APP;
import love.model.Table;
import love.untils.GetMapper;
import love.untils.Scanner;

import java.util.Date;
import java.util.Random;

public class AddThread extends Thread{

    @Override
    public void run() {
        System.out.println("添加线程启动……");
        System.out.print("请输入用户名：");
        String username = Scanner.next();
        System.out.print("请输入密码：");
        String password = Scanner.next();
        Date date = new Date();
        Integer randomNum = new Random().nextInt();
        Table table = new Table();
        table.setDate(date);
        table.setNum(randomNum);
        table.setPassword(password);
        table.setUsername(username);
        Mapper mapper = GetMapper.get();
        mapper.insert(table);
        QueryWrapper<Table> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        Table one = mapper.selectOne(queryWrapper);
        APP.id = one.getId();
        System.out.println("添加成功！\n"+table);
        System.out.println("时间：" + date);
    }
}
