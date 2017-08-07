package jianshu.xin.service;

import jianshu.xin.model.User;

/**
 * Created by AnLu on
 * 2017/8/7 16:36.
 * jianshu
 */
public interface UserService extends GenericService<User,Integer>{

    void signUp(User user);

    User queryUserByNick(String nick);

    User queryUserByMobile(String mobile);

    void signInUpdate(User user);
}
