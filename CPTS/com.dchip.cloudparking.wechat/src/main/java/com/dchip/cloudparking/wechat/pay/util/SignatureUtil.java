package com.dchip.cloudparking.wechat.pay.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.dchip.cloudparking.wechat.pay.base.SystemConstant;

/**
 * 签名工具类
 * 待再次重构
 * @author phil
 * @date 2017年7月2日
 *
 */
public class SignatureUtil {

	private static Logger logger = LoggerFactory.getLogger(SignatureUtil.class);

	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		return new String(tempArr);
	}

	/**
	 * 通过Class获取签名
	 * @param o 待加密的对象 该处仅限于Class
	 * @param apiKey  公众号key
	 * @param encoding 编码
	 * @return
	 */
	public static String createSign(Object o, String apiKey, String encoding) {
		String result = notSignParams(o, apiKey);
		result = MD5Util.MD5Encode(result, encoding).toUpperCase();
		return result;
	}

	/**
	 * 通过Map<String, Object>中的所有元素参与签名
	 * 
	 * @param map 待参与签名的map集合
	 * @params apikey apikey中 如果为空则不参与签名，如果不为空则参与签名
	 * @return
	 */
	public static String createSign(Map<String, Object> map, String apiKey, String encoding) {
		String result = notSignParams(map, apiKey);
		result = MD5Util.MD5Encode(result, encoding).toUpperCase();
		logger.debug("sign result {}", result);
		return result;
	}

	/**
	 * 通过Map<String, Object>中的所有元素参与签名
	 * 
	 * @param map 待参与签名的map集合
	 * @params apikey apikey中 如果为空则不参与签名，如果不为空则参与签名
	 * @return
	 */
	public static String createSha1Sign(Map<String, Object> map, String apiKey, String encoding) {
		String result = notSignParams(map, apiKey);
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			if(StringUtils.isEmpty(encoding)) {
				encoding = SystemConstant.DEFAULT_CHARACTER_ENCODING;
			}
			byte[] digest = md.digest(result.getBytes(encoding));
			result = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 将字段集合方法转换
	 * (考虑加入annotation签名注解扫描)
	 * @param array
	 * @param object
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private static ArrayList<String> getFieldList(Field[] array, Object object)
			throws IllegalArgumentException, IllegalAccessException {
		ArrayList<String> list = new ArrayList<String>();
		for (Field f : array) {
			f.setAccessible(true);
			if (f.get(object) != null && f.get(object) != "" && !f.getName().equals("serialVersionUID")
					&& !f.getName().equals("sign")) {
				if (f.getName().equals("packageStr")) {
					list.add("package" + "=" + f.get(object) + "&");
				} else {
					list.add(f.getName() + "=" + f.get(object) + "&");
				}
			}
		}
		return list;
	}

	/**
	 * 返回未加密的字符串
	 * @param o 要参与签名的数据对象
	 * @param apiKey  API密匙
	 * @return 签名
	 * @throws IllegalAccessException
	 */
	private static String notSignParams(Object o, String apiKey) {
		ArrayList<String> list = new ArrayList<>();
		String result = "";
		try {
			Class<?> cls = o.getClass();
			Field[] fields = cls.getDeclaredFields();
			list = getFieldList(fields, o);
			Field[] superFields = cls.getSuperclass().getDeclaredFields(); // 获取父类的私有属性
			list.addAll(getFieldList(superFields, o));
			int size = list.size();
			String[] arrayToSort = list.toArray(new String[size]);
			Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER); // 严格按字母表顺序排序
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < size; i++) {
				sb.append(arrayToSort[i]);
			}
			result = sb.toString();
			if (StringUtils.isNotEmpty(apiKey)) {
				result += "key=" + apiKey;
			} else {
				result = result.substring(0, result.lastIndexOf("&"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 返回未加密的字符串
	 * @param params
	 * @param apiKey
	 * @return 待加密的字符串
	 */
	private static String notSignParams(Map<String, Object> params, String apiKey) {
		ArrayList<String> list = new ArrayList<>();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			if (entry.getValue() != "" && entry.getValue() != null) {
				list.add(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		if (StringUtils.isNotEmpty(apiKey)) {
			result += "key=" + apiKey;
		} else {
			result = result.substring(0, result.lastIndexOf("&"));
		}
		return result;
	}
	
	/**
	 * 从API返回的XML数据里面重新计算一次签名
	 * 
	 * @param responseStrin API返回的XML数据
	 * @param apiKey Key
	 * @return 新的签名
	 */
	private static String reCreateSign(Map<String, Object> map, String apiKey, String encoding) {
		// 清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
		map.put("sign", "");
		// 将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
		return createSign(map, apiKey, encoding);
	}

	/**
	 * 检验API返回的数据里面的签名是否合法,规则是:按参数名称a-z排序,遇到空值的参数不参加签名
	 * @param resultXml  API返回的XML数据字符串
	 * @param apiKey  Key
	 * @return API签名是否合法
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws DocumentException
	 */
	public static boolean checkIsSignValidFromWeiXin(String checktXml, String apiKey, String encoding) throws ParserConfigurationException, IOException, SAXException {
		TreeMap<String, Object> map = XmlUtil.parseXmlToTreeMap(checktXml,encoding);
		String signFromResultXml = (String) map.get("sign");
		if (StringUtils.isEmpty(signFromResultXml)) {
			logger.error("API返回的数据签名数据不存在");
			return false;
		}
		// 将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
		String signForAPIResponse = reCreateSign(map, apiKey, encoding);
		if(!Objects.equals(signFromResultXml, signForAPIResponse)) {
			// 签名验不过，表示这个API返回的数据有可能已经被篡改了
			logger.error("API返回的数据签名验证不通过");
			return false;
		}
		logger.debug("API返回的数据签名验证通过");
		return true;
	}
	
}