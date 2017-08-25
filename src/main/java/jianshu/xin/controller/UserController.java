package jianshu.xin.controller;

import com.google.code.kaptcha.Constants;
import jianshu.xin.model.Notebook;
import jianshu.xin.model.User;
import jianshu.xin.service.NotebookService;
import jianshu.xin.service.UserService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AnLu on
 * 2017/8/7 16:19.
 * jianshu
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    private final UserService userService;

    private final NotebookService notebookService;

    private final StrongPasswordEncryptor encryptor;

    @Autowired
    public UserController(UserService userService, NotebookService notebookService, StrongPasswordEncryptor encryptor) {
        this.userService = userService;
        this.notebookService = notebookService;
        this.encryptor = encryptor;
    }

    @RequestMapping("signUp")
    private String signUp(User user){
        if (isSignUpInvalid(user)) return "sign_up.jsp";

        String password = encryptor.encryptPassword(user.getPassword());
        String lastIp = request.getRemoteAddr();
        user.setPassword(password);
        user.setLastIp(lastIp);

        int userId = userService.signUp(user);
        notebookService.init(userId);

        return "redirect:/sign_in.jsp";
    }

    private boolean isSignUpInvalid(User user) {
        if (user.getNick().length() == 0) {
            request.setAttribute("message", "请输入昵称");
            return true;
        }

        if (user.getMobile().length() == 0) {
            request.setAttribute("message", "请输入手机号");
            return true;
        }

        if (user.getPassword().length() < 6) {
            request.setAttribute("message", "密码不能少于6个字符");
            return true;
        }

        if (isNickExisted(user.getNick())) {
            request.setAttribute("message", "昵称 已经被使用");
            return true;
        }

        if (isMobileExisted(user.getMobile())) {
            request.setAttribute("message", "手机号 已经被使用");
            return true;
        }
        return false;
    }

    private User checkSignIn(User user){
        String plainPassword = user.getPassword();
        user = userService.queryUserByMobile(user.getMobile());

        if (user != null) {
            String encryptedPassword = user.getPassword();
            if (encryptor.checkPassword(plainPassword, encryptedPassword)) {
                String lastIp = request.getRemoteAddr();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String lastTime = format.format(new Date());
                user.setLastIp(lastIp);
                user.setLastTime(lastTime);
                userService.signInUpdate(user);
                return user;
            }
        }
        return null;
    }

    /**
     * 处理Android客户端请求
     */
    @ResponseBody
    @RequestMapping("signInApi")
    private Map<String,Object> signInApi(User user){
        user = checkSignIn(user);
        Map<String,Object> map = new HashMap<>();
        if (user != null) {
            map.put("canSignIn", true);
            map.put("user", user);
        } else {
            map.put("canSignIn", false);
            map.put("user", null);
        }
        return map;
}

@RequestMapping("signIn")
    private String signIn(User user,String kaptchaReceived){
    user = checkSignIn(user);
    if (user != null) {
        request.getSession().setAttribute("user", user);
        return "redirect:/default.jsp";
    }
    request.setAttribute("message", "登录失败，手机号/邮箱或密码错误");
    return "/sign_in.jsp";
}

@RequestMapping("signOut")
    private void signOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/");
    }

    private boolean isNickExisted(String nick) {
        try {
            return isExisted("nick", nick);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * for signUp
     */
    private boolean isMobileExisted(String mobile) {
        try {
            return isExisted("mobile", mobile);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * for AJAX
     */
    @ResponseBody
    @RequestMapping("isNickOrMobileExisted")
    private Map<String,Boolean> isNickOrMobileExisted(String field,String value) throws ServletException,IOException{
        boolean isExisted = isExisted(field, value);
        Map<String, Boolean> map = new HashMap<>();
        map.put("isExisted", isExisted);
        return map;
    }

    private boolean isExisted(String field,String value) throws ServletException,IOException{
        boolean isNickExisted = false;
        boolean isMobileExisted = false;

        if (field.equals("nick")) {
            User user = userService.queryUserByNick(value);
            isNickExisted = (user != null);
        } else {
            User user = userService.queryUserByMobile(value);
            isMobileExisted = (user != null);
        }
        return isNickExisted || isMobileExisted;
    }

    @ResponseBody
    @RequestMapping("checkValidCode")
    private Map<String,Boolean> checkValidCode(String kaptchaReceived){
        String kaptchaExpected = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        Map<String,Boolean> map = new HashMap<>();

        if (kaptchaExpected.equalsIgnoreCase(kaptchaReceived)){
            map.put("isValid",true);
        }else {
            map.put("isValid",false);
        }
        return map;
    }

    @RequestMapping("write")
    private String write(){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "redirect:/sign_in.jsp";
        }
        int userId = ((User)session.getAttribute("user")).getId();
        List<Notebook> notebooks = userService.queryOne("signInQueryById",userId).getNotebooks();
        session.setAttribute("notebooks",notebooks);
        return "redirect:/write.jsp";
    }
}

