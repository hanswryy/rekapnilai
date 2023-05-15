//package com.k4.rekapnilai.exceptionhandler;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(BadRequestException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String handleBadRequestException(BadRequestException ex) {
//        // Lakukan tindakan yang sesuai untuk menangani kesalahan Bad Request
//        // Misalnya, log kesalahan, memberikan pesan kesalahan, atau mengarahkan kembali ke halaman input
//        return "Home"; // Kembali ke halaman input
//    }
//
//    // Rest of your code
//}
