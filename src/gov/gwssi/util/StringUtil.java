/**
 * 
 *开发单位：长城软件与系统有限公司
 *版权所属：长城软件与系统有限公司
 *创建日期：  2016-8-15      
 *
 */
package gov.gwssi.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * ****************************************************************************
 * 字符串操作工具类
 *
 * @author(作者)：xuyongyun	
 * @author(复审人)：	xu 2016-5-10
 * @version(版本)1.0
 * @since 1.0
 ******************************************************************************
 */

public class StringUtil {
	
	private static char[] CH_HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
        		'9', 'A', 'B', 'C', 'D', 'E', 'F'};

	/**
	 * 判断是不是空白字符串
	 * @param src 待处理字符串
	 * @return 空白时返回true，非空白时返回false
	 * @since           1.0
	 */
	public static boolean isBlank(String src){
		if(src==null||src.length()==0||src.trim().length()==0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 处理字符串两端空白
	 * @param src 待处理字符串
	 * @param defaultValue 字符串空白时默认返回值
	 * @return src空白时返回defaultValue，非空白时进行左右的空白处理
	 * @since           1.0
	 */
	public static String trim(String src,String defaultValue){
		if(isBlank(src)){
			return defaultValue;
		}else{
			return src.trim();
		}
	}
	
	/**
	 * 处理空String对象
	 * @param object 待处理对象
	 * @param defaultValue 字符串空白时默认返回值
	 * @return src空白时返回defaultValue，非空白时进行左右的空白处理
	 * @since           1.0
	 */
	public static String trimObject(Object object,String defaultValue){
		if(object==null){
			return defaultValue;
		}else{
			return trim(String.valueOf(object),defaultValue);
		}
		
	}
	
	/**
	 * 处理字符串中间的回车换行及两端的空白
	 *	
	 * @param src
	 * @return
	 * @since           1.0
	 */
	public static String trimEnter(String src){
		if(!isBlank(src)){
			src = trim(src,"");
			src = src.replaceAll("\r", "");
			src = src.replaceAll("\n", "");
		}
		return src;
	}
	
	/**
     * 将字节数组转为十六进制字符串
     *
     * @param bytes
     * @return 返回16进制字符串
     */
    public static String byteArrayToHex(byte[] bytes) {
        // 一个字节占8位，一个十六进制字符占4位；十六进制字符数组的长度为字节数组长度的两倍
        char[] chars = new char[bytes.length * 2];
        int index = 0;
        for (byte b : bytes) {
            // 取字节的高4位
            chars[index++] = CH_HEX[b >>> 4 & 0xf];
            // 取字节的低4位
            chars[index++] = CH_HEX[b & 0xf];
        }
        return new String(chars);
    }
    
    public static byte[] hexToBytes(String src) {  
    	int m = 0, n = 0;  
    	int l = src.length() / 2; 
    	byte[] ret = new byte[l];  
    	for (int i = 0; i < l; i++) {  
    		m = i * 2 + 1;  
    	    n = m + 1;  
    	    ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));  
    	}  
    	return ret;  
    }
    
    private static byte uniteBytes(String src0, String src1) {
    	byte b0 = Byte.decode("0x" + src0).byteValue();
    	b0 = (byte) (b0 << 4);  
    	byte b1 = Byte.decode("0x" + src1).byteValue();  
    	byte ret = (byte) (b0 | b1);  
    	return ret;  
   }
    
    public static String doubleToString(double num) {
		DecimalFormat df = new DecimalFormat("#.00");
		String nums = df.format(num);

		if (nums.lastIndexOf(".") < nums.length() - 3)
			nums = nums.substring(0, nums.lastIndexOf("." + 3));
		if (nums.lastIndexOf(".") == 0)
			nums = "0" + nums;
		return nums;
	}
    
    public static String getUUID() {  
        UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  
        // 去掉"-"符号  
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 22);  
        String time = DateUtil.format(new Date(), DateUtil.DATE_CHAR_17);
        return time + temp;  
    }
    
    public static void main(String args[]) throws ParseException{
		System.out.println(doubleToString(111.0251));
		System.out.println(getUUID());
	}


}
