package org.freda.cooper4.framework.datastructure;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DTO
 *
 * Created by rally on 2016/11/15.
 */
public interface Dto extends Map
{
    /**
     * 以Integer类型返回键值
     *
     * @param pStr
     *            键名
     * @return Integer 键值
     */
    Integer getAsInteger(String pStr);

    /**
     * 以Long类型返回键值
     *
     * @param pStr
     *            键名
     * @return Long 键值
     */
    Long getAsLong(String pStr);

    /**
     * 以String类型返回键值
     *
     * @param pStr
     *            键名
     * @return String 键值
     */
    String getAsString(String pStr);

    /**
     * 取出属性值
     *
     * @param pStr
     *            属性Key
     * @return Integer
     */
    BigDecimal getAsBigDecimal(String pStr);

    /**
     * 取出属性值
     *
     * @param pStr
     *            :属性Key
     * @return Integer
     */
    Date getAsDate(String pStr);

    /**
     * 以List类型返回键值
     *
     * @param key
     *            键名
     * @return List 键值
     */
    List getAsList(String key);

    /**
     * 以Timestamp类型返回键值
     *
     * @param pStr
     *            键名
     * @return Timestamp 键值
     */
    Timestamp getAsTimestamp(String pStr);

    /**
     * 以Boolean类型返回键值
     *
     * @param key
     *            键名
     * @return Timestamp 键值
     */
    Boolean getAsBoolean(String key);

    /**
     * 给Dto压入第一个默认List对象<br>
     * 为了方便存取(省去根据Key来存取和类型转换的过程)
     *
     * @param pList
     *            压入Dto的List对象
     */
    void setDefaultAList(List pList);

    /**
     * 给Dto压入第二个默认List对象<br>
     * 为了方便存取(省去根据Key来存取和类型转换的过程)
     *
     * @param pList
     *            压入Dto的List对象
     */
    void setDefaultBList(List pList);

    /**
     * 获取第一个默认List对象<br>
     * 为了方便存取(省去根据Key来存取和类型转换的过程)
     *
     *            压入Dto的List对象
     */
    List getDefaultAList();

    /**
     * 获取第二个默认List对象<br>
     * 为了方便存取(省去根据Key来存取和类型转换的过程)
     *
     *            压入Dto的List对象
     */
    List getDefaultBList();

    /**
     * 给Dto压入一个默认的Json格式字符串
     *
     * @param jsonString
     */
    void setDefaultJson(String jsonString);

    /**
     * 获取默认的Json格式字符串
     *
     * @return
     */
    String getDefaultJson();
    /**
     * 将此Dto对象转换为Json格式字符串<br>
     *
     * @return string 返回Json格式字符串
     */
    String toJson();

    /**
     * 设置交易状态
     *
     * @param pSuccess
     */
    void setSuccess(Boolean pSuccess);

    /**
     * 获取交易状态
     *
     */
    Boolean getSuccess();

    /**
     * 设置交易提示信息
     *
     * @param pMsg
     */
    void setMsg(String pMsg);

    /**
     * 获取交易提示信息
     *
     */
    String getMsg();

    /**
     * 将对象转化为get请求的参数Str
     *
     * @return
     */
    String toParamsString();
}
