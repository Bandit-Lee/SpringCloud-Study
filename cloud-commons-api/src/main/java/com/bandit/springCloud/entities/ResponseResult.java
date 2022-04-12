package com.bandit.springCloud.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Bandit
 * @createTime 2022/4/12 9:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 237760404085615437L;

    private Integer code;
    private String message;
    private T data;

    public ResponseResult(Integer code, String message) {
        this(code, message, null);
    }
}
