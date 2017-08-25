package jianshu.xin.service.impl;

import jianshu.xin.dao.GenericDao;
import jianshu.xin.model.User;
import jianshu.xin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by AnLu on
 * 2017/8/13 13:07.
 * jianshu
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User,Integer> implements UserService {

    @Override
    @Autowired
    @Qualifier("userDaoImpl")
    public void setGenericDao(GenericDao<User,Integer> genericDao){
        super.genericDao = genericDao;
    }

    @Override
    public int signUp(User user) {
        user = (User) genericDao.create("signUp",user);
        return user.getId();
    }

    @Override
    public User queryUserByNick(String nick) {
        return genericDao.queryOne("queryUserByNick",nick);
    }

    @Override
    public User queryUserByMobile(String mobile) {
        return genericDao.queryOne("queryUserByMobile",mobile);
    }

    @Override
    public void signInUpdate(User user) {
        genericDao.modify("signInUpdate",user);
    }
}
