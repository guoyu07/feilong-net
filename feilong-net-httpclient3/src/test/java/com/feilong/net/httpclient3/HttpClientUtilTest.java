/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.net.httpclient3;

import static com.feilong.core.CharsetType.UTF8;
import static com.feilong.core.util.MapUtil.newHashMap;
import static com.feilong.net.HttpMethodType.GET;
import static com.feilong.net.HttpMethodType.POST;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.coreextension.awt.DesktopUtil;
import com.feilong.coreextension.entity.BackWarnEntity;
import com.feilong.io.IOWriteUtil;
import com.feilong.json.jsonlib.JsonUtil;
import com.feilong.net.UncheckedHttpException;

/**
 * The Class HttpClientUtilTest.
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 */
public class HttpClientUtilTest{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtilTest.class);

    /**
     * 获得 http method with execute1.
     *
     * @throws UncheckedHttpException
     *             the http client exception
     */
    @Test
    public void getHttpMethodWithExecute1(){
        String uri = "http://127.0.0.1:6666/template.txt?sign=123456";
        uri = "http://sitemanager.underarmour.tw/brand-uastory.css";

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.setUri(uri);
        httpClientConfig.setHttpMethodType(GET);

        String responseBodyAsString = HttpClientUtil.getResponseBodyAsString(httpClientConfig);
        LOGGER.debug("responseBodyAsString:{}", responseBodyAsString);
    }

    @Test
    public void getHttpMethodWithExecute122(){
        String uri = "http://localhost:8222/json1";

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.setUri(uri);
        httpClientConfig.setHttpMethodType(GET);

        String responseBodyAsString = HttpClientUtil.getResponseBodyAsString(httpClientConfig);
        LOGGER.debug("responseBodyAsString:{}", responseBodyAsString);

        BackWarnEntity bean = JsonUtil.toBean(responseBodyAsString, BackWarnEntity.class);
        LOGGER.debug("BackWarnEntity:{}", bean);
    }

    /**
     * Gets the http method with execute.
     * 
     * @throws UncheckedHttpException
     *             the http client util exception
     */
    @Test
    public void getHttpMethodWithExecute(){
        String uri = "http://www.google.com.hk/search?client=aff-cs-360se&forid=1&ie=utf-8&oe=UTF-8&q=enumeration";
        uri = "http://www.d9cn.org/d9cnbook/50/50537/10967924.html";
        uri = "http://www.kenwen.com/egbk/31/31186/4395342.txt";
        uri = "http://pandavip.www.net.cn/cgi-bin/Check.cgi?queryType=0&domain=feihe&big5=n&sign=2&url=www.net.cn&com=yes&cn=no&mobi=no&net=no&comcn=no&image.x=19&image.y=10";
        // HttpMethodParams params = new HttpMethodParams();
        // params.setParameter(HttpMethodParams.USER_AGENT, "");
        // httpMethod.setParams(params);

        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.setUri(uri);
        httpClientConfig.setHttpMethodType(GET);

        String responseBodyAsString = HttpClientUtil.getResponseBodyAsString(httpClientConfig);

        LOGGER.debug("responseBodyAsString:{}", responseBodyAsString);
        LOGGER.debug("print httpMethod.getResponseHeaders()=======================");
    }

    /**
     * Gets the fL logistics track.
     *
     * @throws UncheckedHttpException
     *             the http client util exception
     */
    @Test
    public void getFLLogisticsTrack(){
        String uri = "http://firstlogistics.co.id/ws/demo/post/";

        Map<String, String> params = newHashMap();

        params.put("APPID", "EBDEMO01");
        params.put("ACCOUNT", "1300000430");
        params.put("FUNCTION", "track");
        params.put("REF", "MPE100503");

        uri = "http://117.102.249.96/ws/mpe/";

        uri = "http://117.102.249.96/ws/ecom/";
        params = newHashMap();
        params.put("APPID", "MP4PP01");
        params.put("ACCOUNT", "1300000430");
        params.put("FUNCTION", "track");
        params.put("REF", "81131531");

        // method = POST
        // Account = 1300000430
        // AppID = MP4PP01
        // Function = track
        //
        // And you can use this AWB to test, it's a real AWB 81129754

        // MPE100503 - SHIPPED
        // MPE100501 - PICKED UP
        // MPE100500 - FAILED
        // MPE100498 - DELIVERED

        HttpClientConfig httpClientConfig = new HttpClientConfig(uri, params, POST);
        String responseBodyAsString = HttpClientUtil.getResponseBodyAsString(httpClientConfig);
        LOGGER.debug(responseBodyAsString);
    }

    /**
     * Check tcash transaction.
     *
     * @throws UncheckedHttpException
     *             the http client exception
     */
    @Test
    public void checkTcashTransaction(){
        //		String uri = "http://202.3.208.89:11080/tcash-api/api/check/customer/transaction?refNum=290914112053368&userKey=testing&passKey=1234&signKey=1234";
        String uri = "http://202.3.208.89:11080/tcash-api/api/check/customer/transaction";
        Map<String, String> params = newHashMap();

        params.put("terminalId", "8021");
        params.put("refNum", "290914112053368");
        params.put("userKey", "testing");
        params.put("passKey", "1234");
        params.put("signKey", "1234");

        HttpClientConfig httpClientConfig = new HttpClientConfig(uri, params, GET);
        String responseBodyAsString = HttpClientUtil.getResponseBodyAsString(httpClientConfig);
        LOGGER.debug(responseBodyAsString);
    }

    /**
     * Test fund.
     *
     * @throws UncheckedHttpException
     *             the http client exception
     */
    @Test
    public void testFund(){
        String uri = "http://www.howbuy.com/fund/ajax/board/index.htm?glrm=&keyword=&radio=2&orderField=jjjz&orderType=asc&cat=All&level=";
        Map<String, String> params = newHashMap();

        HttpClientConfig httpClientConfig = new HttpClientConfig(uri, params, POST);

        String responseBodyAsString = HttpClientUtil.getResponseBodyAsString(httpClientConfig);
        String replace = responseBodyAsString.replace("<textarea style=\"display:none\">", "").replace("</textarea>", "")
                        .replace("</tbody>", "").replace("</table>", "").replace("onclick=\"move(this);\"", "")
                        .replace("href=\"/fund/", "href=\"http://www.howbuy.com/fund/")
                        .replaceAll("<input  type=\"checkbox\"  value=\"\\d{6}\"/>", "")//
                        .replaceAll("<td width=\"4%\"></td>", "")//
                        .replaceAll("<td width=\"5%\">\\d+</td>", "")//
        ;
        //^(\\d{3,4}-)?\\d{6,8}$
        StringBuilder sb = new StringBuilder();
        sb.append(replace).append("</tbody>").append("</table>");

        String filePath = "d:/1.html";
        IOWriteUtil.writeStringToFile(filePath, sb.toString(), UTF8);
        DesktopUtil.open(filePath);
    }

    /**
     * Testenclosing_type.
     */
    @Test
    public void testenclosing_type(){
        String aString = "22222<input  type=\"checkbox\"  value=\"161015\"/>3333";
        LOGGER.debug(aString.replaceAll("<input  type=\"checkbox\"  value=\"\\d{6}\"/>", ""));
        //assertEquals(expected, actual);
    }
}
