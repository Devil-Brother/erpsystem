package com.myc.erpsystem.config.exception;

public class CustomSystemException extends RuntimeException {

   private String errMessage;

   public CustomSystemException() {
      super();
   }

   public CustomSystemException(String errMessage) {
      super(errMessage);
      this.errMessage = errMessage;
   }

   public String getErrMessage() {
      return errMessage;
   }

   public static void cast(CommonError commonError){
       throw new CustomSystemException(commonError.getErrMessage());
   }
   public static void cast(String errMessage){
       throw new CustomSystemException(errMessage);
   }

}