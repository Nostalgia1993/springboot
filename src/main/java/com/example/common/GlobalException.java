package com.example.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e){
        log.error("=============全局异常捕捉",e);
        if(e instanceof  CustomException){
            System.out.println("该异常为自定义异常~");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",e);
        mv.addObject("message","=======我是标记======");
        mv.addObject("url",request.getRequestURL());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public Result jsonErrorHandler(HttpServletRequest request,CustomException e){
        request.setAttribute("base",request.getContextPath());
        return Result.fail(e.getMessage(),"error data");
    }


}
