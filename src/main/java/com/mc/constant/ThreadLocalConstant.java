package com.mc.constant;

import com.mc.vo.LocalUserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadLocalConstant {
    public static ThreadLocal<HttpServletRequest> localRequest = new ThreadLocal<HttpServletRequest>();
    public static ThreadLocal<HttpServletResponse> localResponse = new ThreadLocal<HttpServletResponse>();
    public static ThreadLocal<LocalUserVo> localUser = new ThreadLocal<LocalUserVo>();

    public static void setLocalRequest(HttpServletRequest request) {
        localRequest.set(request);
    }

    public static HttpServletRequest getLocalRequest() {
        return localRequest.get();
    }

    public static void setLocalResponse(HttpServletResponse response) {
        localResponse.set(response);
    }

    public static HttpServletResponse getLocalResponse() {
        return localResponse.get();
    }

    public static void setLocalUser(LocalUserVo luVO) {
        localUser.set(luVO);
    }

    public static LocalUserVo getLocalUser() {
        return localUser.get();
    }

    public static void clean() {
        localRequest.set(null);
        localResponse.set(null);
    }
}
