package com.mc.controller;

import com.mc.constant.CommConstant;
import com.mc.service.FileService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

@RestController
@RequestMapping("/file")
public class FileController {
    private final Logger logger = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/uploadSingleUserImage", method = RequestMethod.POST)
    public McResult uploadSingleUserImage(HttpServletRequest request) throws McBusinessException {
        MultipartFile file = ((MultipartHttpServletRequest)request).getFile("file");
        // 检查文件
        fileService.checkUserImage(file);
        // 获取待生成文件全路径文件名
        String fullFilename = fileService.getFullFilename();
        // 生成文件
        fileService.singleUploadFile(file, fullFilename);
        // 获取下载地址
        String downloadUrl = fileService.getDownloadUrl(fullFilename);
        // 返回结果
        return McResult.newSuccess(downloadUrl);
    }

    /**
     * @description 指定路径文件下载
     * 测试下载方法, 使用需调整内容
     * @param request 请求入参
     * @author ChenglongChu
     * @create 2018/5/31 16:42
     **/
    @RequestMapping(value="singleDownload",method= RequestMethod.POST)
    @Deprecated
    public ResponseEntity<byte[]> singleDownload(HttpServletRequest request) throws IOException {
        String path = request.getParameter("path");
        // 生成文件
        File file = new File(path);
        // head
        HttpHeaders headers = new HttpHeaders();
        // 文件的属性, 文件命名
        headers.setContentDispositionFormData("attachment", "new.zip");
        // 内容是字节流
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 开始下载
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public McResult upload(HttpServletRequest request) throws McBusinessException {
        MultipartFile file = ((MultipartHttpServletRequest)request).getFile("file");
        if (file.getSize() == 0)
            return McResult.newFailed("不能上传空文件！", "-1");
        String text = null;
        String fileName = file.getOriginalFilename();
        String temp = fileName.toLowerCase();
        try {
            if (temp.endsWith(CommConstant.DOCX)) {
                text = readDocx(file.getInputStream());
            } else if (temp.endsWith(CommConstant.DOC)) {
                text = readDoc(file.getInputStream());
            } else {
                return McResult.newFailed("文件格式不正确！", "-1");
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return McResult.newFailed("文件上传失败！", "-1");
        }
        // 返回结果
        return McResult.newSuccess(text);
    }

    private String readDoc(InputStream stream) {
        try {
            HWPFDocument doc = new HWPFDocument(stream);
            Range range = doc.getRange();
            return range.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String readDocx(InputStream stream) {
        try (OPCPackage opcPackage = OPCPackage.open(stream)) {
            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
            return extractor.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
