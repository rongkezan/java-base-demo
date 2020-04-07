package com.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Jackson转换测试
 *
 * @author <a href="rongkz@zjport.gov.cn">KeithRong</a>
 * @date 2020/4/2 10:59
 */
@Slf4j
public class TestJackson {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testConvert() {
        String jsonString = readFile();
        Map<String, Object> map = null;
        try {
            map = JacksonUtils.jsonToMap(jsonString);
            Map<String, List<Map<String, String>>> payload = (Map<String, List<Map<String, String>>>) map.get("payload");
            List<Map<String, String>> list = payload.get("aimgs");
            for (Map<String, String> map2 : list) {
                System.out.println(map2.get("gdsSeqno"));
            }
        } catch (Exception e) {
            log.error("json解析异常", e);
        }
    }

    @Test
    public void testDeepConvert() throws Exception {
        String jsonString = readFile();
        Map<String, Object> map = JacksonUtils.jsonToMapDeeply(jsonString);
        Map<String, List<Map<String, String>>> payload = (Map<String, List<Map<String, String>>>) map.get("payload");
        List<Map<String, String>> list = payload.get("aimgs");
        for (Map<String, String> map2 : list) {
            System.out.println(map2.get("gdsSeqno"));
        }
    }

    private String readFile(){
        StringBuilder sb = new StringBuilder();
        File srcFile = new File("src/test/java/com/demo/json/json.txt");
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(srcFile);
            br = new BufferedReader(fr);
            String data;
            while ((data = br.readLine()) != null){
                sb.append(data + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 把json解析成map，如果map内部的value存在jsonString，继续解析
     *
     * @param json
     * @param mapper
     * @return
     * @throws Exception
     */
    private static Map<String, Object> json2MapRecursion(String json, ObjectMapper mapper) throws Exception {
        if (json == null) {
            return null;
        }

        Map<String, Object> map = mapper.readValue(json, Map.class);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object obj = entry.getValue();
            if (obj != null && obj instanceof String) {
                String str = ((String) obj);

                if (str.startsWith("[")) {
                    List<?> list = json2ListRecursion(str, mapper);
                    map.put(entry.getKey(), list);
                } else if (str.startsWith("{")) {
                    Map<String, Object> mapRecursion = json2MapRecursion(str, mapper);
                    map.put(entry.getKey(), mapRecursion);
                }
            }
        }

        return map;
    }

    /**
     * 把json解析成list，如果list内部的元素存在jsonString，继续解析
     *
     * @param json
     * @param mapper 解析工具
     * @return
     * @throws Exception
     */
    private static List<Object> json2ListRecursion(String json, ObjectMapper mapper) throws Exception {
        if (json == null) {
            return null;
        }

        List<Object> list = mapper.readValue(json, List.class);

        for (Object obj : list) {
            if (obj != null && obj instanceof String) {
                String str = (String) obj;
                if (str.startsWith("[")) {
                    obj = json2ListRecursion(str, mapper);
                } else if (obj.toString().startsWith("{")) {
                    obj = json2MapRecursion(str, mapper);
                }
            }
        }

        return list;
    }
}
