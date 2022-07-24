package cn.edu.syu.interceptor;

import cn.edu.syu.po.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI();
        if (url.contains("login")||url.contains("login.jsp")||url.contains("addUser.jsp")||url.contains("addUser")) {
            return true;
        }
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("USER");
        if (user!=null){
            return true;
        }
        request.setAttribute("loginDefeatTips","您还没有登录，请先登录！");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return false;
    }
}
