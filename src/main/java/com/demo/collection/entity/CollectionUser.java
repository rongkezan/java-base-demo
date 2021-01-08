package com.demo.collection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author keith
 */
@Data
@AllArgsConstructor
public class CollectionUser {
    private String name;
    private Integer age;
    private Double salary;
}
