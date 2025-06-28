package com.e_commerce.inventory.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryProductError {
    private String message;
    private String code;
    private String description;
    private HttpStatus status;
    private Timestamp timestamp;
    private String path;
    private String method;
    private String requestUrl;


}
