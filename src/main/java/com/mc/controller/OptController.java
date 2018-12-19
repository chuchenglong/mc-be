package com.mc.controller;

import com.mc.service.OptService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import com.mc.vo.OptVo;
import com.mc.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opt")
public class OptController {
    @Autowired
    private OptService optService;

    @RequestMapping(value = "/getOptList", method = RequestMethod.POST)
    public McResult getOptList(@RequestBody OptVo optVo) throws McBusinessException {
        PageVo pageVo = optService.getOptList(optVo);
        // 返回成功结果信息
        return McResult.newSuccess(pageVo);
    }
}
