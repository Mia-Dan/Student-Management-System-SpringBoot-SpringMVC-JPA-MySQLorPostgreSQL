package com.example.exception;

import com.example.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// The term "advice" in ControllerAdvice is a concept from Aspect-Oriented Programming (AOP).
// @ControllerAdvice: Specialization of @Component for classes // ref: src comment
//      that declare @ExceptionHandler, @InitBinder, or @ModelAttribute methods
//      to be shared across multiple @Controller classes.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Annotation for handling exceptions in specific handler classes and/or handler methods.
    @ExceptionHandler(Exception.class) // catch all exceptions
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}
