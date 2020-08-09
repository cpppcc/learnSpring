package com.example.demo.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.ExceptionsAndError.Exception.EntityNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(value = EntityNotExistsException.class)
    @ResponseBody
    public String EntityNotExistsExceptionHandler(EntityNotExistsException ex , HttpServletRequest re){
        return "<html><body>" +
                "<h1>Error page</h1>" +
                "<p2>Failed URL : " +
                re.getRequestURI()+
                "</p2></br>"+
                "<p3>Exception message : " +
                ex.getMessage()+
                " </p3> </br>"+
                "<p1>Exception : </br>" +
                Arrays.toString(ex.getStackTrace()) +
                "</p1>"
                +"</body></html>";

    }

}
