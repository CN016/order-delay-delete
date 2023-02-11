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
        String username = getRandomStr(new Random().nextInt(250));
        String password = getRandomStr(new Random().nextInt(250));
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
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

    /**
     * 从[48,127)内取值转ascii码字符，变成随机的字符串
     * @param len 字符串长度
     * @return 随机字符串
     */
    public String getRandomStr(int len){
        Random random=new Random();
        StringBuilder str=new StringBuilder();
        char c='1';
        for (int i = 0; i < len; i++) {
            int x=random.nextInt(127-48)+48;
            c=(char) x;
            str.append(c);
        }
        return str.toString();
    }
}
