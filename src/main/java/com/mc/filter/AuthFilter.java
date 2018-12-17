package com.mc.filter;

import com.mc.constant.CommConstant;
import com.mc.constant.ThreadLocalConstant;
import com.mc.enumeration.WhiteTypeEnum;
import com.mc.mapper.ServerInfoMapper;
import com.mc.model.ServerInfo;
import com.mc.service.ConfigService;
import com.mc.service.RedisService;
import com.mc.service.RoleService;
import com.mc.service.WhiteService;
import com.mc.util.StringUtils;
import com.mc.vo.LocalUserVo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChenglongChu
 * @description 权限过滤器
 * @create 2018/11/28 16:53
 */
@Component
public class AuthFilter implements Filter {
    private WebApplicationContext wac;

    /**
     * @description 初始化
     * @param filterConfig 过滤器参数
     * @throws ServletException
     * @author ChenglongChu
     * @create 2018/11/28 16:53
     **/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        wac = (WebApplicationContext) filterConfig.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }

    /**
     * @description 过滤器执行过程
     * @param servletRequest servlet请求参数
     * @param servletResponse servlet返回参数
     * @param filterChain 过滤器链
     * @throws IOException
     * @throws ServletException
     * @author ChenglongChu
     * @create 2018/11/28 16:53
     **/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ThreadLocalConstant.getLocalRequest();
        HttpServletResponse response = ThreadLocalConstant.getLocalResponse();
        LocalUserVo localUserVo = new LocalUserVo();
        RedisService redisService = wac.getBean(RedisService.class);
        ConfigService configService = wac.getBean(ConfigService.class);
        WhiteService whiteService = wac.getBean(WhiteService.class);
        RoleService roleService = wac.getBean(RoleService.class);

        String tokenOnOff = configService.getValueByCode(CommConstant.TOKEN_ON_OFF);

        String uri = request.getRequestURI();
        String formatUri = StringUtils.formatUri(uri);

        // 服务可用性验证
        ServerInfoMapper serverInfoMapper = wac.getBean(ServerInfoMapper.class);
        int count = serverInfoMapper.selectNormalServerInfoCountByServerUrl(formatUri);
        if (count == 0) {
            response.setStatus(404);
            return;
        }

        String token = request.getHeader(CommConstant.HEADER_TOKEN);
        // token验证checkToken
        if (StringUtils.isNotEmpty(tokenOnOff) && CommConstant.ON.equals(tokenOnOff)) {
            // 在白名单里
            if (whiteService.checkWhiteListByType(formatUri, WhiteTypeEnum.TOKEN_URI.getKey())) {
                // 如果token不为空，则重置token超时时间
                if (StringUtils.isNotEmpty(token))
                    redisService.resetTokenTimeout(token);
            } else {
                // 不在白名单里且要验证token，获取redis的userId
                String uId = redisService.getValueByKey(token);
                // 初始化userId为不存在
                int userId = 0;
                // redis中userId存在，就赋值userId
                if (StringUtils.isNumber(uId))
                    userId = Integer.valueOf(uId);
                // userId不存在，给302且终止请求
                if (userId == 0) {
                    response.setStatus(302);
                    return;
                }
                // userId存在，则重置token超时时间
                redisService.resetTokenTimeout(token);

                // 进行服务验证checkService，服务验证需要userId，所以必须基于token验证通过
                String serviceOnOff = configService.getValueByCode(CommConstant.SERVICE_ON_OFF);
                if (StringUtils.isNotEmpty(serviceOnOff) && CommConstant.ON.equals(serviceOnOff)
                        && !whiteService.checkWhiteListByType(uId, WhiteTypeEnum.USER_SERVER.getKey())) {
                    // 数据结构可以支持一人多角色情况，程序目前仅实现一对一，一对多需要在redis里加入role缓存
                    ServerInfo serverInfo = roleService.getServerByUserIdAndUri(userId, formatUri);
                    // 如果没有匹配服务，则该用户无服务权限，给403且终止请求
                    if (null == serverInfo) {
                        response.setStatus(403);
                        return;
                    }
                }

                // 都验证通过后将用户信息放入当前线程的LocalUser中，若支持一对多，LocalUserVo里要有roleType
                localUserVo.setUserId(userId);
            }
        } else {
            // 关掉的token验证，如果存在userId，则重置和缓存入线程map
            String uId = redisService.getValueByKey(token);
            if (StringUtils.isNumber(uId)) {
                redisService.resetTokenTimeout(token);
                localUserVo.setUserId(Integer.valueOf(uId));
            }
        }
        ThreadLocalConstant.setLocalUser(localUserVo);
        // 转发请求
        filterChain.doFilter(request, response);
    }

    /**
     * @description 销毁
     * @author ChenglongChu
     * @create 2018/11/28 16:53
     **/
    @Override
    public void destroy() {
    }

}
