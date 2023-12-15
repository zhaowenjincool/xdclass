package org.example.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.example.utils.JsonData;
import org.example.utils.JwtUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        String token = request.getHeader("token");
        if(token==null){
            token = request.getParameter("token");
        }
        if(StringUtils.isNotBlank(token)){
            Claims claims = JwtUtils.checkToken(token);
            if(claims==null){
                writeResponse(response,JsonData.buildError("登录过期"));
                return false;
            }else{
                request.setAttribute("userId",claims.get("userId"));
                request.setAttribute("username",claims.get("username"));
                return true;
            }
        }else{
            writeResponse(response,JsonData.buildError("登录过期"));
            return false;
        }
    }

    private void writeResponse(HttpServletResponse response,JsonData jsonData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(jsonData));
        writer.close();
        response.flushBuffer();
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
