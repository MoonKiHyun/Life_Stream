package com.moon.lifestream.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse<T> {

    private String status;
    private int httpStatus;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(int httpStatus, T data) {

        return ApiResponse.<T>builder()
                .status("success")
                .httpStatus(httpStatus)
                .data(data)
                .build();
    }

    public static ApiResponse<Void> success(int httpStatus, String message) {

        return ApiResponse.<Void>builder()
                .status("success")
                .httpStatus(httpStatus)
                .message(message)
                .build();
    }

    public static ApiResponse<Void> fail(int httpStatus, String message) {

        return ApiResponse.<Void>builder()
                .status("fail")
                .httpStatus(httpStatus)
                .message(message)
                .build();
    }

    public static ApiResponse<Void> error(int httpStatus, String message) {

        return ApiResponse.<Void>builder()
                .status("error")
                .httpStatus(httpStatus)
                .message(message)
                .build();
    }
}
