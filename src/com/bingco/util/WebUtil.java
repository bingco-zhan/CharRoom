package com.bingco.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Web请求响应数据工具类
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-15 20:49
 * Package com.bingco.util
 * -----------------------------------------------------
 */
public class WebUtil {

    /**
     * 返回数据
     *
     * @param code
     * @param msg
     * @param data
     */
    public static Map<String, Object> sendMsg(int code, String msg, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    /**
     * DOM解析xml字符
     * @param xml
     * @return
     */
    public static Map<String, String> parseXml(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document root = builder.parse(new InputSource(new StringReader(xml)));
            NodeList nodes = root.getChildNodes();
            Element item = (Element) nodes.item(0);
            nodes = item.getChildNodes();
            HashMap<String, String> result = new HashMap<>();
            for (int x = 0; x < nodes.getLength(); x++) {
                if (nodes.item(x).hasChildNodes()) {
                    Node node = nodes.item(x);
                    String key = node.getNodeName().trim(),
                            value = node.getFirstChild().getNodeValue().trim();
                    result.put(key, value);
                }
            }
            return result;
        }

        catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
