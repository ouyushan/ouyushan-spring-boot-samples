package org.ouyushan.springboot.error.exception.handler;

/**
 * @Description:
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2020/5/7 14:44
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理
 */
@ControllerAdvice
public class ErrorExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorExceptionHandler.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "ouyushan");
    }

    /**
     * 统一异常处理
     *
     * @param exception
     *
     * @return
     */

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    // 入参只能是异常类
    public ModelAndView processException(RuntimeException exception) {
        logger.info("自定义异常处理-RuntimeException");
        ModelAndView m = new ModelAndView();
        logger.info("--------------------" + exception.getMessage());
        m.addObject("author", "ouyushan");
        m.addObject("exception", "runtimeException");
        m.setViewName("error/500");
        return m;
    }

    /**
     * 统一异常处理
     *
     * @param exception
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    // 入参只能是异常类
    public ModelAndView processException(Exception exception) {
        logger.info("自定义异常处理-Exception");
        ModelAndView m = new ModelAndView();
        logger.info("--------------------" + exception.getMessage());
        m.addObject("author", "ouyushan");
        m.addObject("exception", "exception");
        m.setViewName("error/500");
        return m;
    }

}
