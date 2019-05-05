/**
 * 
 *开发单位：长城软件与系统有限公司
 *版权所属：长城软件与系统有限公司
 *创建日期：  2012-8-23      
 *
 */
package gov.gwssi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * ****************************************************************************
 * the tool class of date.
 * 
 * @author(作者)：金志福 E-mail:jinzhifu@gwssi.com.cn
 * @author(复审人)： user 2012-8-23
 * @version(版本)1.0
 * @since 1.0
 ****************************************************************************** 
 */

public class DateUtil {

	/** 日期格式 */
	public static final String CKTS_RQGS = "yyyy-MM-dd";
	/** 时间格式 */
	public static final String CKTS_SJGS = "yyyy-MM-dd HH:mm:ss";
	/** 日期格式:年月 */
	public static final String CKTS_RQGS_YM = "yyyy-MM";
	/** 日期格式:年月 */
	public static final String CKTS_RQGS_YM1 = "yyyyMM";
	/** 中文显示日期格式 */
	public static final String CKTS_RQGS_ZW = "yyyy年MM月dd日";
	/** java时间格式 */
	public static final String CKTS_JAVASJGS = "yyyy-MM-dd HH:mm:ss";

	public static final String CKTS_ORACLESJGS = "yyyy-MM-dd HH-mm-ss";
	
	public static final String DATE_CHAR_8 = "yyyyMMdd";
	public static final String DATE_CHAR_14 = "yyyyMMddHHmmss";
	public static final String DATE_CHAR_17 = "yyyyMMddHHmmssSSS";

	/**
	 * 日期对象转为字符对象（有格式参数）
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            日期字符格式
	 * @return String 日期字符串
	 */
	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// 使用指定格式转换
		String dateStr = formatDateToString(date, sdf);
		return dateStr;
	}

	/**
	 * 日期对象转为字符对象
	 * 
	 * @param date
	 *            日期
	 * @param df
	 *            日期格式转换类
	 * @return String 日期字符串
	 */
	private static String formatDateToString(Date date, DateFormat df) {
		if (date == null)
			return "";
		else {
			String dateStr = df.format(date);
			return dateStr;
		}
	}


	/**
	 * 获得当前日期（有格式参数）
	 * 
	 * @param format
	 *            日期字符格式
	 * @return String 日期
	 * @throws BaseException
	 */
	public static String getCurrentDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(new Date());
		return dateStr;
	}

	/**
	 * 获得当前月
	 * 
	 * @return String 月
	 * @throws BaseException
	 */
	public static String getCurrentMonth() {
		Calendar c = Calendar.getInstance();
		return String.valueOf(c.get(Calendar.MONTH) + 1);
	}

	/**
	 * 获得上个月
	 * 
	 * @return String 月
	 * @throws BaseException
	 */
	public static String getLastMonth() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month - 1);
		Date strDateTo = calendar.getTime();
		return format(strDateTo, "yyyyMM");
	}
	
	public static int getDisTime(){
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    long diff = cal.getTimeInMillis() - System.currentTimeMillis();
	    int dis = (int) (diff/1000);
	    return dis;
	}
}
