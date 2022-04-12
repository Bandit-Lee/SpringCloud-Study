package com.bandit.springCloud.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Bandit
 * @createTime 2022/4/12 9:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class Payment implements Serializable {

    private static final long serialVersionUID = 353147002947006310L;
    private long id;
    private String serial;

}
