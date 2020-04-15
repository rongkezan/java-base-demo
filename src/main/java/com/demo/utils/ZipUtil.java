package com.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 压缩工具类
 */
@Slf4j
public class ZipUtil {
    public static void toZip(List<File> srcFiles, OutputStream out) throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            for (File srcFile : srcFiles) {
                byte[] buf = new byte[2048];
                String fileName = srcFile.getName();
                if (StringUtils.isBlank(fileName)) {
                    continue;
                }
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1) {
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
                in.close();
            }
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            log.error("压缩文件出错", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 解压zip文件
     *
     * @param zipFile
     * @param descDir
     * @return
     * @throws IOException
     */
    public static List<String> unZip(File zipFile, String descDir) throws IOException {
        ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));	//解决中文文件夹乱码

        String name = zip.getName().substring(zip.getName().lastIndexOf(java.io.File.separator) + 1, zip.getName().lastIndexOf('.'));
        File pathFile = new File(descDir + name);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        List<String> fullPaths = new ArrayList<String>();
        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            System.out.println("zipEntryName==" + zipEntryName);
            //处理含有文件夹的情况
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {
                zipEntryName = zipEntryName.replace('/', '\\'); //防止影响后续文件路径的创建
            }
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + name + java.io.File.separator + zipEntryName);
            if (!FileUtil.checkPathIsFile(outPath)) {
                continue;
            }
            // 判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf(java.io.File.separator)));
            if (!file.exists()) {
                file.mkdirs();
            }
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压  
            if (new File(outPath).isDirectory()) {
                continue;
            }
            fullPaths.add(outPath);
            FileOutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        zip.close();
        log.info("******************解压zip完毕********************");
        return fullPaths;
    }
}
