package jianshu.xin.dao.impl;

import jianshu.xin.dao.UserDao;
import jianshu.xin.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by AnLu on
 * 2017/7/7 14:38.
 * jianshu
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User,Integer> implements UserDao{
}
