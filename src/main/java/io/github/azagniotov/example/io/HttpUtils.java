package io.github.azagniotov.example.io;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;

import java.io.IOException;
import java.net.ProxySelector;
import java.util.concurrent.TimeUnit;

public final class HttpUtils {

    private static final HttpRequestFactory WEB_CLIENT;

    static {
        /**
         * @see ApacheHttpTransport#newDefaultHttpClient()
         */
        final HttpClient apacheHttpClient = HttpClientBuilder.create()
                .useSystemProperties()
                //.setSSLSocketFactory(SSLConnectionSocketFactory.getSocketFactory())
                .setSSLHostnameVerifier((hostname, session) -> true)
                .setMaxConnTotal(200)
                .setMaxConnPerRoute(20)
                .setConnectionTimeToLive(-1, TimeUnit.MILLISECONDS)
                .setRoutePlanner(new SystemDefaultRoutePlanner(ProxySelector.getDefault()))
                .disableRedirectHandling()

                // In ProxyConfigWithStubsTest.shouldReturnProxiedRequestResponse_WhenStubsWereNotMatched():
                //
                // I had to set this header to avoid "Not in GZIP format java.util.zip.ZipException: Not in GZIP format" error:
                // The 'null' overrides the default value "gzip", also I had to .disableContentCompression() on WEB_CLIENT
                .disableContentCompression()
                .disableAutomaticRetries()
                .build();

        WEB_CLIENT = new ApacheHttpTransport(apacheHttpClient, false).createRequestFactory(request -> {
            request.setThrowExceptionOnExecuteError(false);
            request.setConnectTimeout(45000);
            request.setReadTimeout(850);
        });
    }

    private HttpUtils() {

    }

    public static HttpRequest constructHttpRequest(final String method, final String targetUrl) throws IOException {
        return WEB_CLIENT.buildRequest(method, new GenericUrl(targetUrl), null);
    }
}