package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class MatchFile {

    private static final String JSON_DIR_PATH = "E:\\Zjport\\报文\\msg\\json\\";

    private static final String DATA_DIR_PATH = "E:\\Zjport\\报文\\msg\\data\\";

    private static final String MATCH_DIR_PATH = "E:\\Zjport\\报文\\msg\\match\\";

    private static final String SUB_PATH = "20200902联邦易豹编号\\";

    public static void main(String[] args) {
        File jsonDir = new File(JSON_DIR_PATH);
        File dataDir = new File(DATA_DIR_PATH + SUB_PATH);
        File[] jsonFileArr = jsonDir.listFiles();
        File[] dataFileArr = dataDir.listFiles();

        for (File jsonFile : jsonFileArr) {
            String keyWord = jsonFile.getName().split("_")[0];
            for (File dataFile : dataFileArr) {
                String filename = dataFile.getName();
                if (filename.contains(keyWord)){
                    if (filename.contains(".zip") || filename.contains(".rar") || filename.contains(".pdf"))
                        filename = filename.substring(0, filename.lastIndexOf("."));
                    File dir = new File(MATCH_DIR_PATH + SUB_PATH);
                    if (!dir.exists()) dir.mkdir();
                    File matchDir = new File(MATCH_DIR_PATH + SUB_PATH + filename);
                    if (!matchDir.exists()) matchDir.mkdir();
                    File dstFile = new File(matchDir + File.separator + jsonFile.getName());
                    File dstFile2 = new File(matchDir + File.separator + dataFile.getName());
                    try {
                        Files.copy(jsonFile.toPath(), dstFile.toPath());
                        if (dataFile.isDirectory()){
                            copyDir(dataFile.getAbsolutePath(), dstFile2.getAbsolutePath());
                        } else {
                            Files.copy(dataFile.toPath(), dstFile2.toPath());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void copyDir(String fromDir,String toDir){
        //创建目录的File对象
        File dirSouce = new File(fromDir);
        //判断源目录是不是一个目录
        if (!dirSouce.isDirectory()) {
            //如果不是目录那就不复制
            return;
        }
        //创建目标目录的File对象
        File destDir = new File(toDir);
        //如果目的目录不存在
        if(!destDir.exists()){
            //创建目的目录
            destDir.mkdir();
        }
        //获取源目录下的File对象列表
        File[]files = dirSouce.listFiles();
        for (File file : files) {
            //拼接新的fromDir(fromFile)和toDir(toFile)的路径
            String strFrom = fromDir + File.separator + file.getName();
            System.out.println(strFrom);
            String strTo = toDir + File.separator + file.getName();
            System.out.println(strTo);
            //判断File对象是目录还是文件
            //判断是否是目录
            if (file.isDirectory()) {
                //递归调用复制目录的方法
                copyDir(strFrom,strTo);
            }
            //判断是否是文件
            if (file.isFile()) {
                System.out.println("正在复制文件："+file.getName());
                //递归调用复制文件的方法
                copyFile(strFrom,strTo);
            }
        }
    }

    public static void copyFile(String fromFile,String toFile){
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            //字节输入流——读取文件
            in = new FileInputStream(fromFile);
            //字节输出流——写入文件
            out = new FileOutputStream(toFile);
            //把读取到的内容写入新文件
            //把字节数组设置大一些   1*1024*1024=1M
            byte[] bs = new byte[1*1024*1024];
            int count = 0;
            while((count = in.read(bs))!=-1){
                out.write(bs,0,count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                in.close();
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
