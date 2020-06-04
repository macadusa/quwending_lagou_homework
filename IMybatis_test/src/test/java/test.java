import com.User;
import com.config.Resources;
import com.mapper.IUserMapper;
import com.session.DefultSqlSessionFactoryBuilder;
import com.session.SqlSession;
import com.session.SqlSessionFactory;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class test {
    @Test
    public  void  test() throws PropertyVetoException, DocumentException, IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {
        InputStream inputStreamFromXmlByPath = Resources.getInputStreamFromXmlByPath("mybatis-config.xml");
        SqlSessionFactory build = new DefultSqlSessionFactoryBuilder().build(inputStreamFromXmlByPath);
        SqlSession sqlSession = build.openSqlSession();
        User user =new User();
        user.setId(1);
        user.setUsername("张三");
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<Object> one = mapper.findOne(user);
        for (Object o : one) {
            System.out.println("----------"+o.toString());
        }
    }
    @Test
    public  void  testinsert() throws PropertyVetoException, DocumentException, IllegalAccessException, IntrospectionException, InstantiationException, NoSuchFieldException, SQLException, InvocationTargetException, ClassNotFoundException {
        InputStream inputStreamFromXmlByPath = Resources.getInputStreamFromXmlByPath("mybatis-config.xml");
        SqlSessionFactory build = new DefultSqlSessionFactoryBuilder().build(inputStreamFromXmlByPath);
        SqlSession sqlSession = build.openSqlSession();
        User user =new User();
        user.setId(1);
        user.setUsername("张三update");
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
//        mapper.deleteOne(user);
//        mapper.createOne(user);
        mapper.updateOne(user);
    }
}
