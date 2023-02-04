package love.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import love.DateTimeFormat;
import love.JsonFormat;

import java.io.Serializable;
import java.util.Date;
@Data
@TableName(value = "`table`")
public class Table implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id ;
    @TableField(value = "`username`")
    private String username;
    @TableField(value = "`password`")
    private String password;
    @TableField(value = "`date`")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    @TableField(value = "`num`")
    private Integer num;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", num=" + num +
                '}';
    }
}
