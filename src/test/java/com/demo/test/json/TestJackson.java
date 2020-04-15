package com.demo.test.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
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

    @Test
    public void testObjToJson() throws Exception{
        DubDeclareBillDetailProviderVo dubDeclareBillDetailProviderVo = new DubDeclareBillDetailProviderVo();
        String s = JacksonUtils.objToJson(dubDeclareBillDetailProviderVo);
        System.out.println(s);
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
}
