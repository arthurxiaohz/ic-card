package cn.net.iccard.util;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpPostObj {

    private String iKey;

    private String iValue;

    public HttpPostObj(String aKey, String aValue) {
        this.iKey = aKey;
        try {
			this.iValue = URLEncoder.encode(aValue, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }

    public String getKey() {
        return iKey;
    }

    public void setKey(String aKey) {
        iKey = aKey;
    }

    public String getValue() {
        return iValue;
    }

    public void setValue(String aValue) {
        iValue = aValue;
    }
}
