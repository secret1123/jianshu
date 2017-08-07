package jianshu.xin.controller;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AnLu on
 * 2017/8/7 16:19.
 * jianshu
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    private final UserService userService;

    private final StrongPasswordEncryptor encryptor;

    @Autowired
    public UserController(UserService userService, StrongPasswordEncryptor encryptor) {
        this.userService = userService;
        this.encryptor = encryptor;
    }
}
