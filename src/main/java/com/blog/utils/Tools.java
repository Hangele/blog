package com.blog.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.ws.rs.core.UriBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URI;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 常用工具类
 */
public class Tools {
  private static Logger logger = LoggerFactory.getLogger(Tools.class);
    /**
     * 获取当前时间14位字符串+4位随机数 18位
     * 
     * @return String e.g."201312142102582374"
     */
    public static String getCurrentTimeRandom() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date()) + getRandom(4);
    }

    /**
     * <b>时间戳  自1970年1月1日 0点0分0秒以来的 秒 数<b><br/>
     * 
     * @return 
     */
    public static String getTimeStamp() {
        return Long.toString(System.currentTimeMillis() / 1000) + "";
    }
    
    /**
     * <b>当前时间搓加随机数 18位<b><br/>
     * 
     * @return 138702705717598172
     */
    public static String getTimeToRubRandom() {
        return System.currentTimeMillis() + getRandom(5);
    }


    /**
     * <b>根据参数生成随机数<b><br/>
     * 
     * @param digit 位数
     * @return String
     */
    public static String getRandom(int digit) {
        if (digit > 0) {
            StringBuffer sb = new StringBuffer();
            String str = "0123456789";
            Random r = new Random();
            for (int i = 0; i < digit; i++) {
                int num = r.nextInt(str.length());
                sb.append(str.charAt(num));
                str = str.replace((str.charAt(num) + ""), "");
            }
            return sb.toString();
        } else {
            return "";
        }
    }
    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    public static String toDuration_unit(Integer duration_unit ){
        String result="";//借款期限:0年1月2日
        switch (duration_unit){
            case 0:
                 result="年";
                break;
            case 1:
                result="月";
                break;
            case 2:
                result="日";
                break;
        }
        return result;
    }

    /**
     * 去除富文本内容的html标签
     * @param content
     * @return
     */
    public static String delHtml(String content) {
        // <p>段落替换为换行
        content = content.replaceAll("<p .*?>", "");

        content = content.replaceAll("<br\\s*/?>", "");
          // 去掉其它的<>之间的东西
        content = content.replaceAll("\\<.*?>", "");

        content=content.replaceAll("&nbsp;","");
        //去掉空格及空白字符
        content=content.replaceAll("\\s*", "");
        return content;
    }

    /**
     * 隐藏字符串部分信息
     * @param prefixLength 前多少位不隐藏
     * @param suffixLength 后多少位不隐藏
     * @param xxName 隐藏部分用什么替换
     * @return
     */
    public static String getReplaceStr(String str,int prefixLength,int suffixLength,String xxName){
        String suffix=str.substring(str.length()-suffixLength);
        String prefix=str.substring(0,prefixLength);
        StringBuffer xx=new StringBuffer("");
        for(int i=0;i<=str.length()-prefixLength-suffixLength;i++){
            xx.append(xxName);
        }
        return prefix+xx+suffix;
    }
    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    public static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                'b', 'c', 'd', 'e', 'f' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
    /**
     * 生成一个UUID
     *
     * @return String 生成的UUID
     */
    public static String randomUUID() {
        String s = UUID.randomUUID().toString();
        s = s.replace("-", ""); // 去掉uuid中的“-”
        return s.toUpperCase();
    }

    /**
     * 复制source中字段的值到target中(空值不进行复制)
     *
     * @param source
     * @param target
     * @param ignoreProperties 需要过滤的不进行赋值的字段,比如target中非公开的set方法,需要进行过滤,否则抛异常。
     */
    @SuppressWarnings("rawtypes")
    public static void copyProperties(Object source, Object target, List ignoreProperties) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        List ignorePropertyList;
        Field[] fields = source.getClass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                if (ignoreProperties == null || ignoreProperties.size() == 0) {
                    ignorePropertyList = new ArrayList();
                } else {
                    ignorePropertyList = ignoreProperties;
                }
                boolean needCopy = true;
                Iterator iterator = ignorePropertyList.iterator();
                while (iterator.hasNext()) {
                    String fieldName = (String) iterator.next();
                    if (fieldName != null && fieldName.equals(field.getName())) {
                        needCopy = false;
                    }
                }
                String setMethodName = "";
                String getMethodName = "";

                try {
                    if (needCopy) {
                        getMethodName = "get" + Tools.initialToUpperOrLower(field.getName());
                        Method method = source.getClass().getDeclaredMethod(getMethodName);
                        Object value = method.invoke(source);
                        if (value != null) {
                            if ((value instanceof String && "".equals(value))) {
                                continue;
                            }
                            setMethodName = "set" + Tools.initialToUpperOrLower(field.getName());
                            Method setMethod;
                            setMethod = target.getClass().getMethod(setMethodName, field.getType());
                            setMethod.setAccessible(true);
                            setMethod.invoke(target, value);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
//                    throw new BadRequestException(400, "copyProperties调用异常,setMethodName:" + setMethodName + ",getMethodName:" + getMethodName);
                }

            }
        }
    }

    public static float getfloatTwoDecimals(float num){
    	 DecimalFormat df = new DecimalFormat("#.00");
    	 return Float.parseFloat(df.format(num));
    }
    public static float getfloatSixDecimals(float num){
   	 DecimalFormat df = new DecimalFormat("#.000000");
   	 return Float.parseFloat(df.format(num));
    }

    public static URI generateUrl(UriBuilder ub, String path, Map<String,String> queryParam){
        ub.path(path);
        if(queryParam!=null) {
            Iterator<String> itr = queryParam.keySet().iterator();
            while (itr.hasNext()) {
                String key = itr.next();
                ub.queryParam(key, queryParam.get(key));
            }
        }
        return ub.build();
    }

    /**
     * 首字母 如果为小写变大写,如果为小写变大写
     * @param str
     * @return
     */
    public static String initialToUpperOrLower(String str){
        if(str!=null&&!"".equals(str)){
            char[] chars = new char[1];
            chars[0]=str.charAt(0);
            String temp = new String(chars);
            if(chars[0]>='A'&&chars[0]<='Z'){
                return str.replaceFirst(temp,temp.toLowerCase());
            }
            return str.replaceFirst(temp,temp.toUpperCase());
        }
        return str;
    }
    public static boolean isTwoDecimals(BigDecimal amount){
        return Pattern.matches("^\\d*.\\d{2}$",amount.toString());
    }
    public static boolean isLessOrEqualMillion(BigDecimal amount){
        return amount.compareTo(new BigDecimal("100000000.00"))<=0;
    }
    public static String amountUnitConverison(BigDecimal amount){
        return amount.movePointRight(2).toString();
    }
    
    public static String str = "abcdefghijklmnopqrstuvwxyz";	
    /**
     * 随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length){
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			int num = r.nextInt(len);
			sb.append(str.charAt(num));
		}
		return sb.toString();
	}
    
    /**
     * 将a=aa&b=bb类字符串转换成map
     * 2017-2-21上午10:25:16
     * @param str
     * @return
     */
    public static Map<String,String> parseStrTOMap(String str){
    	Map<String,String> map = new HashMap<String,String>();
		String[] dataArr = str.split("&");
		for(String data:dataArr){
			String[] aaArr = data.split("=");
			if(aaArr == null || aaArr.length<2){
				continue;
			}
			map.put(aaArr[0], aaArr[1]);
		}
		logger.info(JSON.toJSONString(map));
		return map;
    }
    
    /**
     * 将a=aa/b=bb类字符串转换成map
     * 2017-2-21上午10:25:16
     * @param str
     * @return
     */
    public static Map<String,Object> parseStrTOMapBak(String str){
        Map<String,Object> map = new HashMap<String,Object>();
        String[] dataArr = str.split("/");
        for(String data:dataArr){
            String[] aaArr = data.split("=");
            if(aaArr == null || aaArr.length<2){
                continue;
            }
            map.put(aaArr[0], aaArr[1]);
        }
        logger.info(JSON.toJSONString(map));
        return map;
    }
    
    /**
     * 
     * 2017-3-24下午3:41:19
     * @param is  流转换为String 
     * @return
     * @throws IOException
     */
    public static String inputStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }
    
    /**
     * 数据按特定类别分组分组
     * keyword：分组类别
     * datas: 待分组数据
     * 2017-8-19上午10:19:41
     * @return
     */
    public static List<Map<String, Object>> dataGroup(List<Map<String, Object>> datas,String keyword){
    	//按指定类别分组
		if(datas != null && !datas.isEmpty()){
			//分组后最终的显示数据
			List<Map<String, Object>> groupedData = new ArrayList<Map<String, Object>>();
			//分组数据(含键值)
			Map<String, Object> resMap = new HashMap<String, Object>();
			//特定分组下所有数据
			List<Map<String, Object>> keywordList = new ArrayList<Map<String, Object>>();
			Map<String, Object> data = datas.get(0);
			keywordList.add(data);
			String keywordGroup = (String) data.get(keyword);
			if(datas.size()==1){
				resMap.put("keyword", keywordGroup);
				resMap.put("datas", keywordList);
				groupedData.add(resMap);
			}
			for(int index=1;index<datas.size();index++){
				data = datas.get(index);
				if(keywordGroup.equals((String) data.get(keyword))){
					keywordList.add(data);
				}else {
					//扫描到不同类别，重新开始
					resMap.put("keyword", keywordGroup);
					resMap.put("datas", keywordList);
					groupedData.add(resMap);
					keywordGroup = (String) data.get(keyword);
					keywordList = new ArrayList<Map<String, Object>>() ;
					resMap = new HashMap<String, Object>();
					keywordList.add(data);
				}
				//最后一个
				if(index == datas.size()-1){
					resMap.put("keyword", keywordGroup);
					resMap.put("datas", keywordList);
					groupedData.add(resMap);
				}
			}
			datas = groupedData;
		}
		return datas;
    }
    
    /**
    * dayForWeek
    * @date 2017年10月25日 上午9:47:50
    * 判断传入时间是星期几
    * @param date
    * @return int
    * @throws Exception 
     */
    public  static  int  dayForWeek(Date date) throws  Exception {  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int dayForWeek = 0 ;  
        if (c.get(Calendar.DAY_OF_WEEK) == 1 ){  
            dayForWeek = 7 ;  
        }else {  
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1 ;  
        }  
        return  dayForWeek;  
    }
    
    /** 
    * shieldCellphone
    * 2017年11月30日 上午8:57:20
    * 屏蔽电话中间四位
    * @param string
    * @return String
     */
    public static String shieldCellphone(String string){
        return string.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
    }
    
    /**
    * replaceMsg
    * 2018年3月28日 上午10:15:38
    * 替换消息中的字段
    * @param keys 被替换字段名
    * @param map 被替换字段值
    * @param msg 被替换消息
    * @return String
     */
    public static String replaceMsg(List<String> keys,Map<String, Object> map,String msg){
        if(keys != null && keys.size()>0 
                && map != null && msg != null ){
            for (String string : keys) {
                String key = map.get(string) == null?"暂无":map.get(string).toString();
                msg = msg.replace(string, key);
            }
        }
        return msg;
    }
    
    /**
    * 替换文字中的字段
    * @param keys 被替换字段名
    * @param sign 用户签的字段
    * @param map 被替换字段值
    * @param msg 被替换消息
    * @return String
     */
    public static String replaceContent(List<String> keys,List<String> sign,Map<String, Object> map,String msg){
        if(keys != null && keys.size()>0 && map != null && msg != null){
            for (String string : keys) {
                String key = "";
                if(sign != null && sign.contains(string)){
                	key = "<span class=\"fill-info input-item bottom5 "+string+"\"><input class=\"no-center top5\" type=\"text\" ref=\""+string+"\" v-model=\"form."+string+"\"></span>";
                } else {
                	key = map.get(string) == null ? " " : map.get(string).toString();
                }
                
                msg = msg.replace(string, key);
            }
        }
        return msg;
    }
    
    
    public static void main(String[] args){
    }
    
}
