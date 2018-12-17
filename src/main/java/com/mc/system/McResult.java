package com.mc.system;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

/**
 * @author ChenglongChu
 * @description 统一管理结果结构
 * @create 2018/5/28 16:54
 */
public class McResult<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private T data;

    public McResult() {
        super();
    }

    public McResult(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public McResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @description 组装成功结果结构
     * @param data 参数数据
     * @return ManagerResult 结果对象
     * @author ChenglongChu
     * @create 2018/5/28 16:54
     **/
    public static <T> McResult<T> newSuccess(T data) {
        if (null == data) {
            return new McResult("success", "", null);
        }
        if (data.getClass().getTypeName().equals("com.mc.system.McResult")) {
            return (McResult<T>)data;
        }
        return new McResult("success", "", data);
    }

    /**
     * @description 组装失败结构结构
     * @param message 信息数据
     * @param data 参数数据
     * @return ManagerResult 结果对象
     * @author ChenglongChu
     * @create 2018/5/28 16:54
     **/
    public static <T> McResult<T> newFailed(String message, T data) {
        return new McResult("ERROR00000", message, data);
    }

    /**
     * @description 组装失败结构结构
     * @param message 信息数据
     * @return ManagerResult 结果对象
     * @author ChenglongChu
     * @create 2018/5/28 16:54
     **/
    public static McResult newFailed(String message) {
        return new McResult("ERROR00000", message, null);
    }

    /**
     * @description 组装失败结构结构
     * @param message 信息数据
     * @return ManagerResult 结果对象
     * @author ChenglongChu
     * @create 2018/5/28 16:54
     **/
    public static McResult newFailed(String code, String message) {
        return new McResult(code, message, null);
    }

    /**
     * @description 查看结果是否为成功结果, 不参与序列化输出
     * @author ChenglongChu
     * @create 2018/5/28 16:54
     **/
    @JsonIgnore
    @JSONField(serialize = false)
    public boolean isSuccess() {
        return "success".equals(this.code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
