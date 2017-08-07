package jianshu.xin.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by AnLu on
 * 2017/8/7 14:54.
 * jianshu
 */
public class BaseController {
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    ServletContext application;

    @ModelAttribute
    private void set(HttpServletRequest request,HttpServletResponse response){
        this.request = request;
        this.response = response;
        session = request.getSession();
        application = request.getServletContext();
    }
}
