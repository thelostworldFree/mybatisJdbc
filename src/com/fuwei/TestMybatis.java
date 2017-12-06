package com.fuwei;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fuwei.mybatis.User;
 
public class TestMybatis {
 /*//查询
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
         
        List<User> cs=session.selectList("queryUser");
        for (User c : cs) {
            System.out.println(c.getSid()+"  "+c.getUsername()+"  "+
    				c.getClasses()+"  "+c.getBirthday()+""+c.getCity()+"  "+
    				c.getQq()+"  "+c.getWords()+"  "+c.getPhone());
        }
         
    }*/

    /*//插入数据
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("my的数据");
        user.setClasses("javaJDbc");
        user.setBirthday("1826-0-3");
        user.setCity("洛杉矶");
        user.setQq(15232584);
        user.setWords("mybatis我来了");
        user.setPhone(1625148);
        session.insert("insertUser",user);
        listAll(session);

        session.commit();
        session.close();

    }
*/
   /*//删除数据
   public static void main(String[] args) throws IOException {
       String resource = "mybatis-config.xml";
       InputStream inputStream = Resources.getResourceAsStream(resource);
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       SqlSession session = sqlSessionFactory.openSession();

       User user = new User();
       user.setSid(19);
       session.delete("deleteUser",user);

       listAll(session);

       session.commit();
       session.close();

   }*/

   //查询一个sid的数据
   public static void main(String[] args) throws IOException {
       String resource = "mybatis-config.xml";
       InputStream inputStream = Resources.getResourceAsStream(resource);
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       SqlSession session = sqlSessionFactory.openSession();

       User user= session.selectOne("getUser",2);

       System.out.println(user.getSid()+"  "+user.getUsername()+"  "+
               user.getClasses()+"  "+user.getBirthday()+""+user.getCity()+"  "+
               user.getQq()+"  "+user.getWords()+"  "+user.getPhone());

//      listAll(session);

       session.commit();
       session.close();

   }
/*//修改
public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = sqlSessionFactory.openSession();

    User user= session.selectOne("getUser",20);
    user.setUsername("修改的名字");
    session.update("updateUser",user);

    listAll(session);

    session.commit();
    session.close();

}*/

    //全部查询数据
    private static void listAll(SqlSession session) {
        List<User> cs = session.selectList("queryUser");
        for (User user : cs) {
            System.out.println(user.getSid()+"  "+user.getUsername()+"  "+
                    user.getClasses()+"  "+user.getBirthday()+""+user.getCity()+"  "+
                    user.getQq()+"  "+user.getWords()+"  "+user.getPhone());
        }
    }
}