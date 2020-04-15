package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 文件工具类
 */
public class FileUtil {

    /**
     * 判断文件是否正在被使用
     */
    public static boolean isUsing(String fullPath) {
        boolean result = true;
        try {
            File file = new File(fullPath);
            if (!file.renameTo(file)) {
                result = true;
            } else {
                result = false;//不是正在被使用
            }
        } catch (Exception e) {
            result = true;
        }
        return result;
    }

    /**
     * 过滤文件种类
     * 去除非法的路径
     *
     * @param path
     * @return
     */
    static public boolean checkPathIsFile(String path) {
        if (StringUtils.isBlank(path)) {
            return false;
        }
        String[] allowTypes = new String[]{"wpd", "docx", "doc", "xls", "xlsx", "ppt", "pptx", "pdf", "rar", "zip", "bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd",
                "cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf", "blob", "txt"};
        String suffix = path.substring(path.lastIndexOf(".") + 1, path.length());
        if (StringUtils.isBlank(suffix)) {
            return false;
        }
        suffix = suffix.toLowerCase();//转小写
        System.out.println("su==" + suffix);
        for (int i = 0; i < allowTypes.length; i++) {
            if (suffix.equals(allowTypes[i])) {
                return true;
            }
        }
        System.out.println("path==" + path + " 不是文件");
        return false;
    }

    /**
     * 检查文件类型是否合法
     *
     * @param suffix
     * @return
     */
    static public boolean checkFileSuffix(String suffix) {
        if (StringUtils.isBlank(suffix)) {
            return false;
        }
        String suffix11 = suffix.toLowerCase();
        String[] allowTypes = new String[]{"wpd", "docx", "doc", "xls", "xlsx", "ppt", "pptx", "pdf", "rar", "zip", "bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd",
                "cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf", "blob", "txt"};
        for (int i = 0; i < allowTypes.length; i++) {
            if (suffix11.equals(allowTypes[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 文件转成字节数组
     *
     * @param filePath
     * @return
     */
    static public byte[] changeFileToByteArray(String filePath) {
        byte[] bytesArray = null;
        ByteArrayOutputStream baos = null;
        FileInputStream inputStream = null;
        try {
            File fileTemp = new File(filePath);
            if (!fileTemp.exists()) {
                return bytesArray;
            }
            baos = new ByteArrayOutputStream();
            int len = 0;
            inputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[3];

            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            bytesArray = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return bytesArray;
    }

    /**
     * 读取文本文件内容成字符串
     *
     * @param filePath 文件所在路径
     * @return 文本内容
     * @throws IOException 异常
     * @author cn.outofmemory
     * @date 2013-1-7
     */
    static public String readFile(String filePath, String charset) throws IOException {
        StringBuffer sb = new StringBuffer();
        readToBuffer(sb, filePath, charset);

        //  String result=new String(sb.toString().getBytes(),"utf-8");
        return sb.toString();
    }

    static private void readToBuffer(StringBuffer buffer, String filePath, String charset) throws IOException {
        InputStream is = new FileInputStream(filePath);

        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, charset));
        // BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行

        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            // buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }


    /**
     * 判断系统类型
     * 1 表示win
     * 0表示linux
     *
     * @return
     */

    public static String getOsType() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return "1"; //win系统
        } else {
            return "0"; //Linux系统
        }

    }


    /**
     * 写String至磁盘文件
     */
    public static void string2File(String content, String fullFileName, String encoding) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(fullFileName);
            os.write(content.getBytes(encoding));
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 写String至磁盘文件
     */
    public static String file2String(File file, String encoding) {
        InputStream is = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer("");
        try {
            is = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(is, encoding));
            String str = "";
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    /**
     * 根据文件路径返回文件大小（单位：M）
     *
     * @param f
     * @return
     */
    public static Double getFileSize(File f) {
        if (f.exists() && f.isFile()) {
            double size = f.length();
            return getDoubleByScale((double) (size / 1024.0 / 1024.0), 3);
        }
        return 0D;
    }


    /**
     * Double类型截长,四舍五入
     *
     * @param d
     * @param scale
     * @return
     */
    public static Double getDoubleByScale(Double d, int scale) {
        if (d == null) {
            return 0D;
        }
        BigDecimal b = new BigDecimal(d);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 遍历查询文件
     */
    public static File[] getFiles(String srcPath, final String regex) {
        File file = new File(srcPath);
        if (file.exists() && file.isDirectory()) {

            return file.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    return name.matches(regex);
                }
            });
        }
        return null;
    }

    /**
     * 移动文件
     */
    public static void renameTo(String src, String dest, String fileName) {
        mkDirs(dest);
        File srcFile = new File(src + File.separator + fileName);
        File destFile = new File(dest + File.separator + fileName);
        if (srcFile.exists()) {
            if (!srcFile.renameTo(destFile)) {
                destFile.delete();
                srcFile.renameTo(destFile);
            }
        }
    }

    /**
     * 移动文件
     */
    public static void renameTo(File src, File dest) {
        if (src.exists()) {
            if (!src.renameTo(dest)) {
                dest.delete();
                src.renameTo(dest);
            }
        }
    }

    /**
     * 删除文件
     *
     * @param pathfilename
     */
    public static void delFile(String pathfilename) {
        File file = new File(pathfilename);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 创建文件路径
     *
     * @param dest
     */
    public static void mkDirs(String dest) {
        File destFile = new File(dest);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
    }

    /**
     * 创建文件路径
     *
     * @param fromFile
     * @param toFile
     */
    public static void copyFile(String fromFile, String toFile) {
        File src = new File(fromFile);
        File dest = new File(toFile);
        FileUtil.copyFile(src, dest);
    }

    /**
     * 创建文件路径
     */
    public static void copyFile(File fromFile, File toFile) {
        FileUtil.copyFile(fromFile, toFile);
    }

    /**
     * 删除目录（文件夹）以及目录下的文件
     *
     * @param path 被删除目录的文件路径
     */
    public static void deleteDirectory(String path) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!path.endsWith(File.separator)) {
            path = path + File.separator;
        }
        File dirFile = new File(path);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (dirFile.exists() && dirFile.isDirectory()) {
            //删除文件夹下的所有文件(包括子目录)
            File[] files = dirFile.listFiles();
            if (files == null) {
                return;
            }
            for (int i = 0; i < files.length; i++) {
                //删除子文件
                if (files[i].isFile()) {
                    delFile(files[i].getAbsolutePath());
                }
            }
            dirFile.delete();
        }

    }

    /**
     * bos转为file
     *
     * @param bos
     * @param fileName
     * @param path
     * @return
     * @throws IOException
     */
    public static File bosToFile(ByteArrayOutputStream bos, String fileName, String path) throws IOException {
        String downloadFileName = fileName + ".pdf";
        isPathExist(path);
        //保存文件
        File file = new File(path + downloadFileName);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());
        byte[] byt = new byte[byteArrayInputStream.available()];
        byteArrayInputStream.read(byt);
        OutputStream output = new FileOutputStream(file);
        BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
        bufferedOutput.write(byt);

        byteArrayInputStream.close();
        bufferedOutput.close();
        output.close();
        return file;
    }

    public static void isPathExist(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * bos转为file
     *
     * @param bos
     * @param fileName
     * @param path
     * @return
     * @throws IOException
     */
    public static File bosToSrcFile(ByteArrayOutputStream bos, String fileName,
                                    String path) throws IOException {
        String downloadFileName = fileName;
        isPathExist(path);
        // 保存文件
        File file = new File(path + downloadFileName);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                bos.toByteArray());
        byte[] byt = new byte[byteArrayInputStream.available()];
        byteArrayInputStream.read(byt);
        OutputStream output = new FileOutputStream(file);
        BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
        bufferedOutput.write(byt);

        byteArrayInputStream.close();
        bufferedOutput.close();
        output.close();
        return file;
    }

    /**
     * @param filePath
     * @return
     */
    public static byte[] httpFileToByteArray(String filePath) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream inputStream = null;
        try {
            URL url = new URL(filePath);
            // 打开到url的连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            int len = 0;
            byte[] buffer = new byte[1024];

            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            byte[] byteArray = baos.toByteArray();
            return byteArray;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void main(String[] args) {
    	
     /*String fullPath = 	composePath("/wuwuw/");
     
     System.out.println("fullPath==="+fullPath);
     System.out.println("fullPath==="+fullPath);*/
    }
}
