package com.demo.collection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author keith
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionUser {
    private String name;
    private Integer age;
    private Double salary;
}
