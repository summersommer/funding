package com.zzk.atcrowdfunding.exception;

/**
 * 保存Admin账号重复异常
 * @Author Administrator
 * @Date 2020/5/10
 */
public class LoginAcctAlreadyUseForUpdateException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public LoginAcctAlreadyUseForUpdateException() {
    }

    public LoginAcctAlreadyUseForUpdateException(String message) {
        super(message);
    }

    public LoginAcctAlreadyUseForUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyUseForUpdateException(Throwable cause) {
        super(cause);
    }

    public LoginAcctAlreadyUseForUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
