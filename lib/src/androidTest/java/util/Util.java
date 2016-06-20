package util;

import com.atapiwrapper.library.BuildConfig;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class Util {


	/**
	 * For requests going through Charles
	 *
	 * @return OkHttpClient
	 */
	public static OkHttpClient getClient() {
		OkHttpClient.Builder okClient = new OkHttpClient.Builder();
		if (BuildConfig.DEBUG) okClient.sslSocketFactory(badSslSocketFactory());
		return okClient.build();
	}

	/**
	 * Returns an SSL socket factory that doesn't validate SSL certs. This should only be used for development.
	 */
	private static SSLSocketFactory badSslSocketFactory() {
		try {
			// Construct SSLSocketFactory that accepts any cert.
			SSLContext context = SSLContext.getInstance("TLS");
			TrustManager permissive = new X509TrustManager() {
				@Override public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

				@Override public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

				@Override public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			context.init(null, new TrustManager[] { permissive }, null);
			return context.getSocketFactory();
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

}
