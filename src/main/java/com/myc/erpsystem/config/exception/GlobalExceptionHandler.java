package com.myc.erpsystem.config.exception;

import com.myc.erpsystem.model.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

   @ResponseBody
   @ExceptionHandler(CustomSystemException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public RespBean customException(CustomSystemException e) {
      log.error("【系统异常】{}",e.getErrMessage(),e);
//      return new RestErrorResponse(e.getErrMessage());
      return RespBean.error(e.getErrMessage());

   }
   @ResponseBody
   @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public RespBean customSqlException(CustomSystemException e) {
      log.error("【系统异常】{}",e.getErrMessage(),e);
//      return new RestErrorResponse(e.getErrMessage());
      return RespBean.error(e.getErrMessage());

   }

   @ResponseBody
   @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public RespBean exception(Exception e) {

      log.error("【系统异常】{}",e.getMessage(),e);
      return RespBean.error("系统异常");

   }
}