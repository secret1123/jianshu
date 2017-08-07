package jianshu.xin.dao.impl;

import jianshu.xin.dao.UserDao;
import jianshu.xin.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by AnLu on
 * 2017/7/7 14:38.
 * jianshu
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void signUp(User user) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            sqlSession.insert("user.signUp",user);
        }
    }

    @Override
    public User queryUserByNick(String nick) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(false)){
            return sqlSession.selectOne("user.queryUserByNick",nick);
        }
    }

    @Override
    public User queryUserByMobile(String mobile) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(false)){
            return sqlSession.selectOne("user.queryUserByMobile",mobile);
        }
    }

    @Override
    public void signInUpdate(User user) {
        try(SqlSession sqlSession = MybatisUtil.getSqlSession(true)){
            sqlSession.update("user.signInUpdate",user);
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDao = (UserDaoImpl) context.getBean("userAction");

        User user = new User("jerry","13512345678","111111");
        userDao.signUp(user);
    }
}
