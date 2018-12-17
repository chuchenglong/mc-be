package com.mc.service;

import com.mc.mapper.ServerInfoMapper;
import com.mc.model.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private ServerInfoMapper serverInfoMapper;

    public ServerInfo getServerByUserIdAndUri(int userId, String uri) {
        return serverInfoMapper.selectServerByUserIdAndUri(userId, uri);
    }
}
