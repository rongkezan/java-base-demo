package com.demo.basic;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @Description 根据数据库表生成实体类字段
 * @Author <a href="rongkz@zjport.gov.cn">KeithRong</a>
 * @Date 2020/3/6 14:35
 * @Version 1.0
 * @Note 获取表字段sql举例
 * <p>
 * select column_name,column_comment,data_type
 * from information_schema.columns
 * where table_name='dub_invt_head_form' and table_schema='dubdev'
 * </p>
 */
public class TableToEntity {
    private static StringBuilder str = new StringBuilder();

    private static StringBuilder newStr = new StringBuilder();

    public static void main(String[] args) {
        String temp1 = "";
        String temp2 = "";

        String result = readFile().toString();
        String[] strArr = result.split("\r\n");

        for (String s : strArr) {
            String[] arr = s.split("\t");
            temp1 = "/** " + arr[1] + " */\n";
            String[] items = arr[0].split("_");
            for (int i = 0; i < items.length; i++){
                String res = items[i];
                if (i != 0){
                    res = items[i].substring(0, 1).toUpperCase() + items[i].substring(1);
                }
                temp2 += res;
            }
            temp2 = "private String " + temp2 + ";\n";
            newStr.append(temp1).append(temp2);
            temp2 = "";
        }
        System.out.println(newStr);
    }

    private static StringBuilder readFile(){
        File file = new File("E:\\1.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] cbuf = new char[1024];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                for (int i = 0; i < len; i++) {
                    str.append(cbuf[i]);
                }
            }
            fr.read(cbuf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
