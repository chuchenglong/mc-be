package com.mc.controller;

import com.mc.model.ServerInfo;
import com.mc.service.ServerService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {
    @Autowired
    private ServerService serverService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public McResult getServerInfoList() throws McBusinessException {
        List<ServerInfo> list = serverService.getServerInfoList();
        // 返回成功结果信息
        return McResult.newSuccess(list);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public McResult addServerInfo(@RequestBody ServerInfo serverInfo) throws McBusinessException {
        serverService.checkServerInfoListIsUsed(serverInfo);
        int id = serverService.addServerInfo(serverInfo);
        // 返回成功结果信息
        return McResult.newSuccess(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public McResult deleteServerInfoById(@RequestBody ServerInfo serverInfo) throws McBusinessException {
        serverService.checkServerInfo(serverInfo.getId());
        serverService.deleteServerInfoById(serverInfo.getId());
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public McResult updateServerInfo(@RequestBody ServerInfo serverInfo) throws McBusinessException {
        serverService.checkServerInfo(serverInfo.getId());
        serverService.updateServerInfo(serverInfo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public McResult getServerInfoDetail(@RequestBody ServerInfo serverInfo) throws McBusinessException {
        ServerInfo si = serverService.getServerInfoDetail(serverInfo.getId());
        // 返回成功结果信息
        return McResult.newSuccess(si);
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public McResult updateConfigStatus(@RequestBody ServerInfo serverInfo) throws McBusinessException {
        serverService.checkServerInfo(serverInfo.getId());
        serverService.updateServerStatusById(serverInfo.getId(), serverInfo.getServerStatus());
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }
}
