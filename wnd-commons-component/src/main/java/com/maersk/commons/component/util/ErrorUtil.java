package com.maersk.commons.component.util;

import com.maersk.commons.component.dto.BaseErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Util for building standard error outputs.
 */
@Component
public class ErrorUtil {

    private final MessageUtil messageUtil;

    public ErrorUtil(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }

    /**
     * build 400 error list
     * @param key
     * @return List
     */
    public List<BaseErrorDto> build400ErrorList(String key) {
        return this.buildErrorList(HttpStatus.BAD_REQUEST.value(), key);
    }

    /**
     * build 400 error list
     * @param key
     * @param detail
     * @return List
     */
    public List<BaseErrorDto> build400ErrorList(String key, String detail) {
        return this.buildErrorList(HttpStatus.BAD_REQUEST.value(), key, detail);
    }

    /**
     * build 408 error list
     * @param key
     * @return List
     */
    public List<BaseErrorDto> build408ErrorList(String key) {
        return this.buildErrorList(HttpStatus.REQUEST_TIMEOUT.value(), key);
    }

    /**
     * build 408 error list
     * @param key
     * @param detail
     * @return List
     */
    public List<BaseErrorDto> build408ErrorList(String key, String detail) {
        return this.buildErrorList(HttpStatus.REQUEST_TIMEOUT.value(), key, detail);
    }

    /**
     * build 409 error list
     * @param key
     * @return List
     */
    public List<BaseErrorDto> build409ErrorList(String key) {
        return this.buildErrorList(HttpStatus.CONFLICT.value(), key);
    }

    /**
     * build 409 error list
     * @param key
     * @param detail
     * @return List
     */
    public List<BaseErrorDto> build409ErrorList(String key, String detail) {
        return this.buildErrorList(HttpStatus.CONFLICT.value(), key, detail);
    }

    /**
     * build 500 error list
     * @param key
     * @return List
     */
    public List<BaseErrorDto> build500ErrorList(String key) {
        return this.buildErrorList(HttpStatus.INTERNAL_SERVER_ERROR.value(), key);
    }

    /**
     * build 500 error list
     * @param key
     * @param detail
     * @return List
     */
    public List<BaseErrorDto> build500ErrorList(String key, String detail) {
        return this.buildErrorList(HttpStatus.INTERNAL_SERVER_ERROR.value(), key, detail);
    }

    /**
     * build error list
     * @param status
     * @param key
     * @return List
     */
    public List<BaseErrorDto> buildErrorList(int status, String key) {
        List<BaseErrorDto> list = new ArrayList();
        list.add(this.buildError(status, key));
        return list;
    }

    /**
     * build error list
     * @param status
     * @param key
     * @param detail
     * @return List
     */
    public List<BaseErrorDto> buildErrorList(int status, String key, String detail) {
        List<BaseErrorDto> list = new ArrayList();
        list.add(this.buildError(status, key, detail));
        return list;
    }

    /**
     * build error
     * @param status
     * @param key
     * @return BaseErrorDto
     */
    public BaseErrorDto buildError(int status, String key) {
        BaseErrorDto error =
            BaseErrorDto
                .builder()
                .status(String.valueOf(status))
                .code(messageUtil.getCode(key))
                .title(messageUtil.getTitle(key))
                .detail(messageUtil.getDetail(key))
                .build();
        return error;
    }

    /**
     * build error
     * @param status
     * @param key
     * @param detail
     * @return BaseErrorDto
     */
    public BaseErrorDto buildError(int status, String key, String detail) {
        BaseErrorDto error =
            BaseErrorDto
                .builder()
                .status(String.valueOf(status))
                .code(messageUtil.getCode(key))
                .title(messageUtil.getTitle(key))
                .detail(detail)
                .build();
        return error;
    }

    /**
     * build error
     * @param status
     * @param key
     * @param objs
     * @return BaseErrorDto
     */
    public BaseErrorDto buildError(int status, String key, Object[] objs) {
        BaseErrorDto error =
            BaseErrorDto
                .builder()
                .status(String.valueOf(status))
                .code(messageUtil.getCode(key))
                .title(messageUtil.getTitle(key))
                .detail(messageUtil.getDetail(key, objs))
                .build();
        return error;
    }
}
