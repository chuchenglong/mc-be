package com.mc.service;

import com.mc.constant.TipsConstant;
import com.mc.properties.FileProperties;
import com.mc.system.McBusinessException;
import com.mc.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileService extends BaseService {

    @Autowired
    private FileProperties fileProperties;

    public void checkUserImage(MultipartFile file) throws McBusinessException {
        // 判断文件是否为空
        if(file.isEmpty())
            throw new McBusinessException(TipsConstant.FILE_INVALID);

        String originalFilename = file.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String checkSuffix = fileProperties.getSupportSuffix();
        if (StringUtils.isNotEmpty(checkSuffix)) {
            if (checkSuffix.indexOf(fileSuffix) == -1) {
                throw new McBusinessException(TipsConstant.UNSUPPORT_FILE);
            }
        }

        long size = file.getSize();
        int maxSize = fileProperties.getMaxSize();
        if (maxSize > 0) {
            if (size > maxSize * 1024 * 1024)
                throw new McBusinessException(TipsConstant.FILE_OVERSIZED_3M);
        }
    }

    public String getFullFilename() {
        String uploadPath = fileProperties.getUploadPath();
        // 全路径文件名 = 上传路径 + userId + 时间戳 + 后缀
        String timestamp = String.valueOf(new Date().getTime());
        return uploadPath + getLocalUserId() + timestamp + ".jpg";
    }

    public void singleUploadFile(MultipartFile file, String fullFilename) throws McBusinessException {
        File dest = new File(fullFilename);
        try {
            // 判断文件父目录是否存在, 不存在生成相应目录
            if(!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            // 保存文件
            file.transferTo(dest);
        } catch (IOException e) {
            throw new McBusinessException(TipsConstant.FAIL_UPLOAD);
        }
    }

    public String getDownloadUrl(String fullFilename) {
        return fullFilename.replace(fileProperties.getUploadPath(), fileProperties.getDownloadPath());
    }
}
