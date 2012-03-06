package cn.net.iccard.util;

public class NotifyBean {
	
	
	String mchtTxURL = "";
	String sendMsg = "";
	String txType = "";
	String signature = "";
	public String getMchtTxURL() {
		return mchtTxURL;
	}
	public void setMchtTxURL(String mchtTxURL) {
		this.mchtTxURL = mchtTxURL;
	}
	public String getSendMsg() {
		return sendMsg;
	}
	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}
	public String getTxType() {
		return txType;
	}
	public void setTxType(String txType) {
		this.txType = txType;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	
}
