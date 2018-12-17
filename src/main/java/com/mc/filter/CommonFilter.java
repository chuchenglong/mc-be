package com.mc.filter;

import com.mc.constant.CommConstant;
import com.mc.constant.ThreadLocalConstant;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChenglongChu
 * @description 通用过滤器
 * @create 2018/5/28 16:53
 */
@Component
public class CommonFilter implements Filter {
    /**
     * @description 初始化
     * @param filterConfig 过滤器参数
     * @throws ServletException
     * @author ChenglongChu
     * @create 2018/5/28 16:53
    **/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * @description 过滤器执行过程
     * @param servletRequest servlet请求参数
     * @param servletResponse servlet返回参数
     * @param filterChain 过滤器链
     * @throws IOException
     * @throws ServletException
     * @author ChenglongChu
     * @create 2018/5/28 16:53
    **/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        // 解决response跨域问题
        // 允许哪些Origin发起跨域请求
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        // 是否允许浏览器携带用户身份信息（cookie）
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 多少秒内，不需要再发送预检验请求，可以缓存该结果
        response.setHeader("Access-Control-Max-Age", "3600");
        //表明它允许跨域请求包含xxx头
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        // 允许请求的方法
        response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
        // 设置字符编码
        response.setContentType("text/html;charset=UTF-8");
        // ajax dynamic init
        response.setHeader("Cache-Control", "no-cache");
        // 若果是OPTIONS请求，直接返回成功，对OPTIONS检查请求直接返回成功
        if (CommConstant.METHOD_OPTIONS.equals(request.getMethod())) {
            response.setStatus( 200 );
            return;
        }
        // 将request和response放入ThreadLocal中以便后续使用
        ThreadLocalConstant.setLocalRequest(request);
        ThreadLocalConstant.setLocalResponse(response);
        // 转发请求
        filterChain.doFilter(request, response);
    }

    /**
     * @description 销毁
     * @author ChenglongChu
     * @create 2018/5/28 16:53
    **/
    @Override
    public void destroy() {
    }
}
