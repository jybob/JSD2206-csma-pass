package cn.tedu.jsd2206.csmall.passport.ex.handler;


import cn.tedu.jsd2206.csmall.passport.ex.ServiceException;
import cn.tedu.jsd2206.csmall.passport.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        System.out.println("创建全局异常处理器对象：GlobalExceptionHandler");
    }

    @ExceptionHandler
    public JsonResult handleServiceException(ServiceException e) {
        log.debug("捕获到ServiceException：{}", e.getMessage());
        return JsonResult.fail(e.getServiceCode(), e.getMessage());
    }

    @ExceptionHandler
    public String handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.debug("捕获到HttpRequestMethodNotSupportedException：{}", e.getMessage());
        return "非法访问";
    }

    @ExceptionHandler
    public String handleThrowable(Throwable e) {
        log.debug("捕获到Throwable：{}", e.getMessage());
        e.printStackTrace(); // 强烈建议
        return "服务器运行过程中出现未知错误，请联系系统管理员！";
    }

}
