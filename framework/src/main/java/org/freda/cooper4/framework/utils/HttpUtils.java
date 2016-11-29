package org.freda.cooper4.framework.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.freda.cooper4.framework.datastructure.Dto;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP工具类
 *
 * Created by rally on 2016/11/15.
 */
public class HttpUtils
{
    private static final Log log = LogFactory.getLog(HttpUtils.class);

    private static Map<String,String> headersMap = new HashMap<>();

    private static final String[][] HEADER_KEY_VALUE = {
            {"Accept",       "application/json"},
            {"Content-Type", "application/json; charset=UTF-8"}};

    static
    {
        headersMap.put(HEADER_KEY_VALUE[0][0],HEADER_KEY_VALUE[0][1]);
    }

    /**
     * GET 请求
     *
     * @param url
     * @param params
     * @return
     * @throws UnirestException
     */
    public static HttpResponse<JsonNode> get(String url, Dto params) throws UnirestException
    {
        log.info("Http请求开始==>url:" + url + " method:<GET> \n params:" + params);

        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get(url).headers(setJsonContentHeader(false)).queryString(params).asJson();

        log.info("Http请求==>status:" + jsonNodeHttpResponse.getStatus() + "||" + jsonNodeHttpResponse.getStatusText());

        log.debug("result:\n" + jsonNodeHttpResponse.getBody());

        return jsonNodeHttpResponse;
    }

    /**
     * POST 请求
     *
     * @param url
     * @param params
     * @param isJsonHeader
     * @return
     */
    public static HttpResponse<JsonNode> post(String url, Dto params, boolean isJsonHeader) throws UnirestException
    {
        log.info("Http请求开始==>url:" + url + " method:<POST> \n params:" + params + "参数类型:" + (isJsonHeader ? "json":"field"));

        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.post(url).headers(setJsonContentHeader(isJsonHeader)).body(params.toJson()).asJson();

        log.info("Http请求==>status:" + jsonNodeHttpResponse.getStatus() + "||" + jsonNodeHttpResponse.getStatusText());

        log.debug("result:\n" + jsonNodeHttpResponse.getBody());

        return jsonNodeHttpResponse;
    }

    /**
     * PUT 请求
     *
     * @param url
     * @param params
     * @param isJsonHeader
     * @return
     */
    public static HttpResponse<JsonNode> put(String url, Dto params, boolean isJsonHeader) throws UnirestException
    {
        log.info("Http请求开始==>url:" + url + " method:<PUT> \n params:" + params + "参数类型:" + (isJsonHeader ? "json":"field"));

        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.put(url).headers(setJsonContentHeader(isJsonHeader)).body(params.toJson()).asJson();

        log.info("Http请求==>status:" + jsonNodeHttpResponse.getStatus() + "||" + jsonNodeHttpResponse.getStatusText());

        log.debug("result:\n" + jsonNodeHttpResponse.getBody());

        return jsonNodeHttpResponse;
    }

    /**
     * DELETE 请求
     *
     * @param url
     * @param params
     * @param isJsonHeader
     * @return
     */
    public static HttpResponse<JsonNode> delete(String url, Dto params, boolean isJsonHeader) throws UnirestException
    {
        log.info("Http请求开始==>url:" + url + " method:<DELETE> \n params:" + params + "参数类型:" + (isJsonHeader ? "json":"field"));

        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.delete(url).headers(setJsonContentHeader(isJsonHeader)).body(params.toJson()).asJson();

        log.info("Http请求==>status:" + jsonNodeHttpResponse.getStatus() + "||" + jsonNodeHttpResponse.getStatusText());

        log.debug("result:\n" + jsonNodeHttpResponse.getBody());

        return jsonNodeHttpResponse;
    }

    /**
     * 设置参数为JSON格式
     *
     * @return headerMap
     */
    private static Map<String ,String > setJsonContentHeader(boolean isAdd)
    {
        if (isAdd)
            headersMap.put(HEADER_KEY_VALUE[1][0], HEADER_KEY_VALUE[1][1]);
        else
            headersMap.remove(HEADER_KEY_VALUE[1][0]);

        return headersMap;
    }
}
