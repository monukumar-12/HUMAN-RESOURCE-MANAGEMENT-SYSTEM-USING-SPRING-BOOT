package com.module2.layersMVC.advices;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class ApiResponse<T> {
    private LocalDateTime timeStatus;
    private T data;
    private  ApiError error;

    public ApiResponse(){
        this.timeStatus= LocalDateTime.now();

    }
    public ApiResponse(T data
    ){
        this();
        this.data=data;

    }

    public ApiResponse(ApiError error){
        this();
        this.error=error;


    }
}
