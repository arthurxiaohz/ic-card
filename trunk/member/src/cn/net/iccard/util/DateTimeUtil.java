package cn.net.iccard.util;





import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * DateTime process utilities.
 */
public class DateTimeUtil {
	
	//private static Log logger = LogFactory.getLog(DateTimeUtil.class);
	
	/** 格式转换类型: yyyyMMdd ==> yyyy/MM/dd */
	public final static int FORMAT_TRANS_D8_D10_S   = 1;
	/** 格式转换类型: yyyyMMdd ==> yyyy-MM-dd */
	public final static int FORMAT_TRANS_D8_D10_ML  = 2;
	/** 格式转换类型: yyyy?MM?dd ==> yyyyMMdd */
	public final static int FORMAT_TRANS_D10_D8     = 3;
	
	/** 格式转换类型: yyyyMMddhhmmss ==> yyyyMMdd */
	public final static int FORMAT_TRANS_DT14_D8     = 4;
	/** 格式转换类型: yyyyMMddHHmmss ==> yyyy/MM/dd */
	public final static int FORMAT_TRANS_DT14_D10_S  = 5;
	/** 格式转换类型: yyyyMMddHHmmss ==> yyyy-MM-dd */
	public final static int FORMAT_TRANS_DT14_D10_ML = 6;
	
	/** 格式转换类型: yyyyMMddHHmmss ==> yyyy/MM/dd HH:mm:ss */
	public final static int FORMAT_TRANS_DT14_DT19_S    = 7;
	/** 格式转换类型: yyyyMMddHHmmss ==> yyyy-MM-dd HH:mm:ss */
	public final static int FORMAT_TRANS_DT14_DT19_ML   = 8;
	/** 格式转换类型: yyyyMMddHHmmss ==> yyyyMMdd HH:mm:ss */
	public final static int FORMAT_TRANS_DT14_DT17      = 9;
	/** 格式转换类型: yyyyMMdd HH:mm:ss ==> yyyyMMddHHmmss */
	public final static int FORMAT_TRANS_DT17_DT14      = 10;
	/** 格式转换类型: yyyy?MM?dd HH:mm:ss ==> yyyyMMddHHmmss */
	public final static int FORMAT_TRANS_DT19_DT14      = 11;
	
	/** 格式转换类型: yyyy-MM-dd ==> yyyyMMddHHmmss */
	public final static int FORMAT_TRANS_D10_DT14_ML = 12;
	
	/**
	 * 取得当前日期时间。
	 * 
	 * @return 当前日期时间，格式：yyyyMMddHHmmss
	 */
	public static String getCurrDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		return df.format(cal.getTime());
	}
	
	/**
	 * 取得当前日期时间精确到毫秒。
	 * 
	 * @return 当前日期时间，格式：yyyyMMddHHmmssSSS
	 */
	public static String getNicetyCurrDateTime() {
   
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}
	
	/**
	 * 取得今日日期。
	 * 
	 * @return 今日日期，格式：yyyyMMdd
	 */
	public static String getToday() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		return df.format(cal.getTime());
	}

	/**
	 * 取得昨日日期。
	 * 
	 * @return 昨日日期，格式：yyyyMMdd
	 */
	public static String getYesterday() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.add(Calendar.DATE, -1);
		return df.format(cal.getTime());
	}
	
	/**
	 * 取得前日日期。
	 * 
	 * @return 前日日期，格式：yyyyMMdd
	 */
	public static String getBeforeYesterday() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.add(Calendar.DATE, -2);
		return df.format(cal.getTime());
	}
	/**
	 * 取得明日日期。
	 * 
	 * @return 明日日期，格式：yyyyMMdd
	 */
	public static String getTomorrow() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.add(Calendar.DATE, 1);
		return df.format(cal.getTime());
	}
	/**
	 * 获取指定日期的前一天
	 * @return 日期，格式：yyyyMMdd
	 */
	public static String getYesterdayByTime(String strDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");  
        Calendar   c  = Calendar.getInstance();   
        c.set(Integer.parseInt(strDate.substring(0,4)),   
                    Integer.parseInt(strDate.substring(4,6))-1,   
                    Integer.parseInt(strDate.substring(6,8)));   
        c.add(Calendar.DATE, -1);
		return df.format(c.getTime());
	}
	/**
	 * 获取指定日期的前两天
	 * @return 日期，格式：yyyyMMdd
	 */
	public static String getBeforeYesterdayByTime(String strDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");  
        Calendar   c  = Calendar.getInstance();   
        c.set(Integer.parseInt(strDate.substring(0,4)),   
                    Integer.parseInt(strDate.substring(4,6))-1,   
                    Integer.parseInt(strDate.substring(6,8)));   
        c.add(Calendar.DATE, -2);
		return df.format(c.getTime());
	}
	/**
	 * 获取指定日期的后一天
	 * @return 日期，格式：yyyyMMdd
	 */
	public static String getTomorrowByTime(String strDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");  
        Calendar   c  = Calendar.getInstance();   
        c.set(Integer.parseInt(strDate.substring(0,4)),   
                    Integer.parseInt(strDate.substring(4,6))-1,   
                    Integer.parseInt(strDate.substring(6,8)));   
        c.add(Calendar.DATE, 1);
		return df.format(c.getTime());
	}
	
	/**
	 * 获取指定日期的后两天
	 * @return 日期，格式：yyyyMMdd
	 */
	public static String getAftTomorrowByTime(String strDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");  
        Calendar   c  = Calendar.getInstance();   
        c.set(Integer.parseInt(strDate.substring(0,4)),   
                    Integer.parseInt(strDate.substring(4,6))-1,   
                    Integer.parseInt(strDate.substring(6,8)));   
        c.add(Calendar.DATE, 2);
		return df.format(c.getTime());
	}
	
	/**
	 * 获取指定日期及后N天日期列表(包括制定日期当天)
	 * @return 日期，格式：yyyyMMdd
	 */
	public static String[] getDayListBylength(String startDate, int count) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");  
        Calendar   c  = Calendar.getInstance();   
        String[] dayList = new String[count + 1];
        for (int i = 0; i <= count; i++) {
        	c.set(Integer.parseInt(startDate.substring(0,4)),   
                    Integer.parseInt(startDate.substring(4,6))-1,   
                    Integer.parseInt(startDate.substring(6,8)));   
        	c.add(Calendar.DATE, i);
        	dayList[i] = df.format(c.getTime());
        }
        return dayList;
	}
	
	/**
	 * 日期/时间格式转换
	 * @param orgStr 原始日期时间字符串
	 * @param formatTransformType 转换方式
	 * @return 转换后的字符串
	 */
	public static String format(String orgStr, int formatTransformType){
		if (null == orgStr){
			return null;
		}
		
		String result = null;
		StringBuffer temp = new StringBuffer();
		
		switch (formatTransformType) {
			case FORMAT_TRANS_D8_D10_S :{//yyyyMMdd ==> yyyy/MM/dd
				if(orgStr.length() != 8){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,4)).append("/").append(orgStr.substring(4,6)).append("/").append(orgStr.substring(6,8));
				result = temp.toString();
				break;
			}
			case FORMAT_TRANS_D8_D10_ML :{//yyyyMMdd ==> yyyy-MM-dd
				if(orgStr.length() != 8){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,4)).append("-").append(orgStr.substring(4,6)).append("-").append(orgStr.substring(6,8));
				result = temp.toString();
				break;
			}
			case FORMAT_TRANS_D10_D8 :{//yyyy?MM?dd ==> yyyyMMdd
				if(orgStr.length() != 10){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,4)).append(orgStr.substring(5,7)).append(orgStr.substring(8,10));
				result = temp.toString();
				break;
			}
			case FORMAT_TRANS_DT14_D8 :{//yyyyMMddhhmmss ==> yyyyMMdd
				if(orgStr.length() != 14){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,8));
				result = temp.toString();
				break;
			}
			case FORMAT_TRANS_DT14_D10_S :{//yyyyMMddHHmmss ==> yyyy/MM/dd
				result = format(format(orgStr, FORMAT_TRANS_DT14_D8), FORMAT_TRANS_D8_D10_S);
				break;
			}
			case FORMAT_TRANS_DT14_D10_ML :{//yyyyMMddHHmmss ==> yyyy-MM-dd
				result = format(format(orgStr, FORMAT_TRANS_DT14_D8), FORMAT_TRANS_D8_D10_ML);
				break;
			}
			case FORMAT_TRANS_DT14_DT19_S :{//yyyyMMddHHmmss ==> yyyy/MM/dd HH:mm:ss
				if(orgStr.length() != 14){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,4))
                    .append("/")
                    .append(orgStr.substring(4,6))
                    .append("/")
				    .append(orgStr.substring(6,8))
				    .append(" ")
				    .append(orgStr.substring(8,10))
				    .append(":")
				    .append(orgStr.substring(10,12))
				    .append(":")
					.append(orgStr.substring(12,14));
				result = temp.toString();
				break;
			}
			case FORMAT_TRANS_DT14_DT19_ML :{//yyyyMMddHHmmss ==> yyyy-MM-dd HH:mm:ss
				if(orgStr.length() != 14){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,4))
                    .append("-")
                    .append(orgStr.substring(4,6))
                    .append("-")
				    .append(orgStr.substring(6,8))
				    .append(" ")
				    .append(orgStr.substring(8,10))
				    .append(":")
				    .append(orgStr.substring(10,12))
				    .append(":")
					.append(orgStr.substring(12,14));
				result = temp.toString();
				break;
			}
			case FORMAT_TRANS_DT14_DT17 :{//yyyyMMddHHmmss ==> yyyyMMdd HH:mm:ss
				temp.append(format(orgStr, DateTimeUtil.FORMAT_TRANS_DT14_D8))
				    .append(" ")
				    .append(orgStr.substring(8,10))
				    .append(":")
				    .append(orgStr.substring(10,12))
				    .append(":")
					.append(orgStr.substring(12,14));
				result = temp.toString();
				break;
			}
			case FORMAT_TRANS_DT17_DT14 :{//yyyyMMdd HH:mm:ss ==> yyyyMMddHHmmss
				if(orgStr.length() != 17){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,8))
					.append(orgStr.substring(9,11))
					.append(orgStr.substring(12,14))
					.append(orgStr.substring(15,17));
				result = temp.toString();
				break;//yyyy?MM?dd HH:mm:ss ==> yyyyMMddHHmmss
			}
			case FORMAT_TRANS_DT19_DT14 :{//yyyy?MM?dd HH:mm:ss ==> yyyyMMddHHmmss
				if(orgStr.length() != 19){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,4))
					.append(orgStr.substring(5,7))
					.append(orgStr.substring(8,10))
					.append(orgStr.substring(11,13))
					.append(orgStr.substring(14,16))
					.append(orgStr.substring(17,19));
				result = temp.toString();
				break;
			}
			case FORMAT_TRANS_D10_DT14_ML :{//yyyy-MM-dd ==> yyyyMMddHHmmss 
				if(orgStr.length() != 10){
					throw new RuntimeException("Invalid date/time string format to be format.");
				}
				temp.append(orgStr.substring(0,4))
				    .append(orgStr.substring(5,7))
				    .append(orgStr.substring(8,10))
				    .append("000000");
				result = temp.toString();
				break;
			}
			default :
				throw new RuntimeException("Invalid data/time format type.");
		}
		
		return result;
	}
	
	/**
     * 根据转化给定格式的字符串为Date类型
     *
     * @param strDate 给定格式的字符串
     * @param aMask 格式,如:yyyyMMdd,yyyy-MM-dd HH:mm:ss
     * @return Date类型数据
     */
    public static Date string2Date(String strDate, String aMask) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
        	System.out.println("ParseException: " + pe);
        	return null;
        }

        return (date);
    } 
    
    /**
     * 转化Date类型数据为指定格式的字符串
     *
     * @param aDate Date类型数据
     * @param aMask 格式,如:yyyyMMdd,yyyy-MM-dd HH:mm:ss    
     * @return 指定格式的字符串
     */
    public static String date2String(Date aDate, String aMask) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            System.out.println("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }
    
    /**
     * 根据指定格式获取当前时间
     * @param aMask 格式,如:yyyyMMdd,yyyy-MM-dd HH:mm:ss
     * @return 字符串类型的当前时间
     */
    public static String getCurrDateTime(String aMask) {
    	Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    	return date2String(cal.getTime(), aMask);
    }
    /**
     * 对14位字符串格式的时间，进行转换为指定格式的时间
     * @param str 格式,如：yyyymmddhhmmss
     * @return 时间格式为：YYYY-MM-DD
     */
    public static String getCharForteenToDate(String sDate){
    	String str="";
    	if(sDate==null){
    		System.out.println("aDate is null!");
    	}else{
    		 String sform=format(sDate, FORMAT_TRANS_DT14_DT19_ML);
    		 String[] yMonthDay=StringUtil.split(sform, " ");
    		 str=yMonthDay[0];
    	}	 
		 return str;
	}
    
    /**
     *ex. 20011112 ==> 2001-11-12
     * ex. 20011112151617 ==> 2001-11-12T15:16:17+08:00
     * @param myDateTime
     * @return
     */
	  public  static String formateStringtoDateTime(String myDateTime){
	      String rtnDateTime = "";
	      if(myDateTime.length() == 8 || myDateTime.length() == 14) {
	          rtnDateTime = myDateTime.substring(0, 4) + "-" + myDateTime.substring(4, 6)
	              + "-" + myDateTime.substring(6, 8);
	          if(myDateTime.length() == 14) {
	              rtnDateTime = rtnDateTime + " ";
	              myDateTime = myDateTime.substring(8);
	          }
	      }
	      if(myDateTime.length() == 6) {
	          rtnDateTime = rtnDateTime + myDateTime.substring(0, 2) + ":" +
	              myDateTime.substring(2, 4) + ":" + myDateTime.substring(4, 6);
	      }
	      return rtnDateTime;
	  }
	  
	  /**
	     * 解析日期字符串返回当月最后一天
	     * @param date 日期字符串  "20100701"
	     * 
	     * @return 解析后返回当月的最后一天字符串20100731
	     */
	    public static String parseDate(String date) {
	        try {
	        	DateFormat  df = new SimpleDateFormat("yyyyMMdd");    
	   		  	Calendar  calendar=Calendar.getInstance();        
	            SimpleDateFormat formatter;
	            if (null == "yyyyMMdd")
	                throw new IllegalArgumentException("The wrong date format");
	            formatter = new SimpleDateFormat("yyyyMMdd");
	            ParsePosition pos = new ParsePosition(0); 
	            calendar.setTime(formatter.parse(date, pos));
	   		  	Calendar cpcalendar=(Calendar)calendar.clone();    
	   		  	cpcalendar.set(Calendar.DAY_OF_MONTH,1);    
	   		  	cpcalendar.add(Calendar.MONTH,1);    
	   		  	cpcalendar.add(Calendar.DATE,-1);
	   		  	return df.format(new Date(cpcalendar.getTimeInMillis()));
	        } catch (Exception e) {
	            throw new IllegalArgumentException("The wrong date:" + date + " " + e);
	        }
	    }
	    
	    /**
		 * 通过日期区间得到每天日期组成的list
		 * 
		 * @param startDate
		 * @param endDate
		 * @return list
		 * @throws Exception
		 */
		public static List getDateList(String startDate, String endDate) {
			try {
				List l = new ArrayList();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String tempDate = startDate;
				Calendar c = Calendar.getInstance();

				for (c.setTime(sdf.parse(startDate));; c.set(Calendar.DAY_OF_YEAR,
						c.get(Calendar.DAY_OF_YEAR) + 1)) {
					tempDate = sdf.format(c.getTime());
					l.add(tempDate);
					if (tempDate.equals(endDate))
						break;
				}
				return l;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		public static String getDateTimeNow(String aFormat)
		{
			Date tCurrentTime =new Date();
			SimpleDateFormat tFormater =  new SimpleDateFormat(aFormat);
			String tDateString = tFormater.format(tCurrentTime);
			
			return tDateString;
		}
		
		/**
		 * 
		 * @param datestr  日期
		 * @param day	   正数为之后天数，负数为之前天数
		 * @return
		 */
		public static String getBeforeAfterDate(String datestr, int day) {   
		      SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");   
		      java.sql.Date olddate = null;   
		      try {   
		          df.setLenient(false);   
		          olddate = new java.sql.Date(df.parse(datestr).getTime());   
		      } catch (ParseException e) {   
		          throw new RuntimeException("日期转换错误");   
		      }   
		      Calendar cal = new GregorianCalendar();   
		      cal.setTime(olddate);   

		      int Year = cal.get(Calendar.YEAR);   
		      int Month = cal.get(Calendar.MONTH);   
		      int Day = cal.get(Calendar.DAY_OF_MONTH);   

		      int NewDay = Day + day;   

		      cal.set(Calendar.YEAR, Year);   
		      cal.set(Calendar.MONTH, Month);   
		      cal.set(Calendar.DAY_OF_MONTH, NewDay);   
		      return new SimpleDateFormat("yyyyMMdd").format(new Date(cal.getTimeInMillis()));
		     // return new Date(cal.getTimeInMillis());   
		  } 
		
		public static void main(String args[]){
				//System.out.println((DateTimeUtil.format("20010303444444", FORMAT_TRANS_DT14_DT19_S)).substring(0, 10));
			System.out.println(getBeforeAfterDate("20120228",2).toString());
		}
}
