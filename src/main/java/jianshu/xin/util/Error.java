package jianshu.xin.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AnLu on
 * 6/27/17 15:22
 */
public class Error {
    public static void showError(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("message", "ERROR.");
        try {
            request.getRequestDispatcher("default.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
