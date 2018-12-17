package com.mc.controller;

import com.mc.model.OptRecord;
import com.mc.service.OptService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import com.mc.vo.OptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opt")
public class OptController {
    @Autowired
    private OptService optService;

    @RequestMapping(value = "/getOptList", method = RequestMethod.POST)
    public McResult getOptList(@RequestBody OptVo optVo) throws McBusinessException {
        List<OptRecord> list = optService.getOptList(optVo);
        // 返回成功结果信息
        return McResult.newSuccess(list);
    }
}
