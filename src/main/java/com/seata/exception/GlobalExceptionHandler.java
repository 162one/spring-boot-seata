package com.seata.exception;

import com.seata.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public AjaxResult bizExceptionHandler(HttpServletRequest request, BizException e) {
        log.error(request.getRequestURI() + " 发生业务异常！原因是：{}", e.getErrorMsg());
        return AjaxResult.fail(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public AjaxResult exceptionHandler(HttpServletRequest request, NullPointerException e) {

        log.error(request.getRequestURI() + " 发生空指针异常！原因是:", e);
        return AjaxResult.fail(ExceptionEnum.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AjaxResult exceptionHandler(HttpServletRequest request, Exception e) {
        log.error(request.getRequestURI() + " 未知异常！原因是:", e);
        return AjaxResult.fail(ExceptionEnum.INTERNAL_SERVER_ERROR);
    }
}