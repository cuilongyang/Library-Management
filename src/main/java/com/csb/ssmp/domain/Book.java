package com.csb.ssmp.domain;

import lombok.Data;

/**
 * @author cuilongyang
 * @version 1.0
 * @date 2022/04/16
 * Lombok
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
