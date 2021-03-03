package com.zzk.atcrowdfunding.exception;

/**
 * 保存Admin账号重复异常
 * @Author Administrator
 * @Date 2020/5/10
 */
public class LoginAcctAlreadyUseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public LoginAcctAlreadyUseException() {
    }

    public LoginAcctAlreadyUseException(String message) {
        super(message);
    }

    public LoginAcctAlreadyUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyUseException(Throwable cause) {
        super(cause);
    }

    public LoginAcctAlreadyUseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
