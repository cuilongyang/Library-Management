package com.csb.ssmp.controller.utils;

import lombok.Data;

/**
 * @author cuilongyang
 * @version 1.0
 * @date 2022/04/16
 */
@Data
public class R {
    private Boolean flag;
    private Object data;

    private String message;

    public R(){}
    public R(Boolean flag){
        this.flag = flag;
    }
    public R(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(String message){
        this.flag = false;
        this.message = message;
    }

}
