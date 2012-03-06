package cn.net.iccard.util;


import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 实现 X509TrustManager 接口，默认信任所有的服务器证书。
 */
public class SampleTrustManager implements X509TrustManager {
    /* (non-Javadoc)
     * @see javax.net.ssl.X509TrustManager#getAcceptedIssuers()
     */
    public X509Certificate[] getAcceptedIssuers() {
        //System.out.println("SampleTrustManager::getAcceptedIssuers()");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.net.ssl.X509TrustManager#checkClientTrusted(java.security.cert.X509Certificate[], java.lang.String)
     */
    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        //System.out.println("SampleTrustManager::checkClientTrusted()");
    }

    /* (non-Javadoc)
     * @see javax.net.ssl.X509TrustManager#checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String)
     */
    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        //System.out.println("SampleTrustManager::checkServerTrusted()");
        //System.out.println(arg0.length);
        //System.out.println(arg0[0].toString());
        //System.out.println(arg0[1].toString());
        //System.out.println(arg0[2].toString());
    }
}
