package love.untils;

import love.Mapper;
import org.apache.ibatis.session.SqlSession;

public class GetMapper {
    private static final SqlSession session ;
    private static final Mapper mapper ;
    static {
        session = SqlSessionFactors.getSqlSessionFactory().openSession(true);
        mapper  = session.getMapper(Mapper.class);
    }
    public static Mapper get(){
        return mapper;
    }
}
