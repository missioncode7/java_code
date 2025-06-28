package com.e_commerce.inventory.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;

@ControllerAdvice
public class InventoryProductGlobalExceptionHandler {

    @ExceptionHandler(InventoryProductNotFoundException.class)
    public ResponseEntity<InventoryProductError> handleInventoryProductNotFoundException(InventoryProductNotFoundException ex, WebRequest request, HttpServletRequest httpServletRequest) {
        InventoryProductError inventoryProductError = new InventoryProductError();
        inventoryProductError.setMessage(ex.getMessage());
        inventoryProductError.setTimestamp(new Timestamp(System.currentTimeMillis()));
        inventoryProductError.setStatus(HttpStatus.BAD_GATEWAY);
        inventoryProductError.setPath(request.getDescription(false));
        inventoryProductError.setDescription(ex.getClass().getName());
        inventoryProductError.setRequestUrl(httpServletRequest.getRequestURL().toString());
        inventoryProductError.setMethod(httpServletRequest.getMethod().toString());
        inventoryProductError.setCode("404");
        return ResponseEntity.status(404).body(inventoryProductError);
    }

}