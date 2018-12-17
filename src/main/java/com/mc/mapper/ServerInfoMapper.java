package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.ServerInfo;
import org.apache.ibatis.annotations.Param;

public interface ServerInfoMapper extends QkMapperConfig<ServerInfo> {
    ServerInfo selectServerByUserIdAndUri(@Param("userId") int userId, @Param("uri") String uri);

    int selectNormalServerInfoCountByServerUrl(String serverUrl);

    int selectServerInfoCountByServerUrl(String serverUrl);

    void updateServerInfoById(ServerInfo serverInfo);

    void updateServerStatusById(@Param("id") int id, @Param("serverStatus") String serverStatus);
}