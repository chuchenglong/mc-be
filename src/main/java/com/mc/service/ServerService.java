package com.mc.service;

import com.mc.constant.TipsConstant;
import com.mc.enumeration.ServerStatusEnum;
import com.mc.mapper.ServerInfoMapper;
import com.mc.model.ConfigInfo;
import com.mc.model.ServerInfo;
import com.mc.system.McBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {
    @Autowired
    private ServerInfoMapper serverInfoMapper;

    public List<ServerInfo> getServerInfoList() {
        return serverInfoMapper.selectAll();
    }

    public void checkServerInfoListIsUsed(ServerInfo serverInfo) throws McBusinessException {
        int count = serverInfoMapper.selectServerInfoCountByServerUrl(serverInfo.getServerUrl());
        if (count > 0)
            throw new McBusinessException(TipsConstant.SERVER_EXISTS);
    }

    public int addServerInfo(ServerInfo serverInfo) {
        serverInfo.setServerStatus(ServerStatusEnum.NORMAL.getKey());
        serverInfoMapper.insert(serverInfo);
        return serverInfo.getId();
    }

    public void checkServerInfo(int id) throws McBusinessException {
        ServerInfo serverInfo = serverInfoMapper.selectByPrimaryKey(id);
        if (null == serverInfo)
            throw new McBusinessException(TipsConstant.NULL_SERVER);
    }

    public void deleteServerInfoById(int id) {
        serverInfoMapper.deleteByPrimaryKey(id);
    }

    public void updateServerInfo(ServerInfo serverInfo) {
        serverInfoMapper.updateServerInfoById(serverInfo);
    }

    public ServerInfo getServerInfoDetail(int id) {
        return serverInfoMapper.selectByPrimaryKey(id);
    }

    public void updateServerStatusById(int id, String serverStatus) {
        serverInfoMapper.updateServerStatusById(id, serverStatus);
    }
}
