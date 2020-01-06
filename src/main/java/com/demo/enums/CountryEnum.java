package com.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    OUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");

    private Integer retCode;
    private String retMessage;

    public static CountryEnum forEachCountryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element : myArray) {
            if(index == element.getRetCode()){
                return element;
            }
        }
        return null;
    }
}
