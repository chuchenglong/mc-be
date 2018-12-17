package com.mc.system;

import com.mc.constant.TipsConstant;

public class McBusinessException extends Exception {
    private static final long serialVersionUID = -3387516993124229948L;

    public McBusinessException(Object Obj) {
        super(Obj.toString());
    }

    public McBusinessException(TipsConstant e, String... args) {
        String message = e.getMessage();
        for (String arg : args) {
            message = message.replaceFirst("\\?", arg);
        }
        e.setMessage(message);
        new Throwable(message);
    }

    public McBusinessException(TipsConstant e, Object... args) {
        String message = e.getMessage();
        for (Object arg : args) {
            message = message.replaceFirst("\\?", String.valueOf(arg));
        }
        e.setMessage(message);
        new Throwable(message);
    }

}
