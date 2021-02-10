package io.breadbutter;

import net.servicestack.client.*;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.util.ParameterParser;
import org.apache.commons.httpclient.util.URIUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import java.util.List;

/**
 * Implementation of the Bread & Butter API defined in https://app.breadbutter.io/api-gateway/#introduction.
 */
public class BreadButterClient {

    private final String appId;
    private final String secret;
    private final String apiUrl;
    private final JsonServiceClient client;

    /**
     * Create a new instance of the Client.  AppId, secret, and apiUrl can all be retrieved via https://app.breadbutter.io/app/#/app-settings
     * @param appId     the application's unique identifier
     * @param secret    the application's secret
     * @param apiUrl    the API endpoint
     */
    public BreadButterClient(String appId, String secret, String apiUrl) {

        if(appId == null) {
            throw new IllegalArgumentException("appId must have a value");
        }

        if(apiUrl == null) {
            throw new IllegalArgumentException("apiUrl must have a value");
        }

        if(!apiUrl.startsWith("https://") && !apiUrl.startsWith("http://")){
            apiUrl = "https://" + apiUrl;
        }

        if(!apiUrl.endsWith("/")) {
            apiUrl = apiUrl + "/";
        }

        this.appId = appId;
        this.secret = secret;
        this.apiUrl = apiUrl;
        this.client = new JsonServiceClient(apiUrl);
        this.client.RequestFilter = conn -> conn.addRequestProperty("x-app-secret", secret);
    }


    /**
     * Request to the API to check status of the server
     * @return string representation of the API version on success
     */
    public String ping() {

        dtos.Ping request = new dtos.Ping();
        request.setAppId(appId);

        dtos.PingResponse response = client.get(request);

        return response.getVersion();
    }



    /**
     * Request that continues the SSO process initiated by startAuthentication
     * @param authenticationToken the value returned in the callback url
     * @return      full validation details outlined here https://app.breadbutter.io/api-gateway/#getauthentication
     * @throws BreadButterException thrown in case of API error
     */
    public dtos.GetAuthenticationResponse getAuthentication(String authenticationToken) throws BreadButterException {

        throwIfNoSecret();

        try {
            dtos.GetAuthentication request = new dtos.GetAuthentication();
            request.setAppId(appId);
            request.setAuthenticationToken(authenticationToken);

            dtos.GetAuthenticationResponse response = client.get(request);
            return response;
        } catch(WebServiceException ex) {
            throw new BreadButterException(ex);
        }
    }

    public String parseAuthenticationToken(String url) throws MalformedURLException, URIException {
        if(url == null || url.isEmpty()){
            throw new IllegalArgumentException("url must have value");
        }

        URL parsedUrl = new URL(url);

        String decoded = URIUtil.decode(parsedUrl.getQuery());
        ParameterParser parser = new ParameterParser();
        List<NameValuePair> pairs = parser.parse(decoded, '&');

        for (NameValuePair pair : pairs) {
            String parameterName = pair.getName();
            if (parameterName.equalsIgnoreCase("authentication_token")) {
                return pair.getValue();
            }
        }

        throw new IllegalArgumentException(String.format("url %s is missing a token parameter in query string", url));
    }

    private void throwIfNoSecret()
    {
        if (secret == null || secret.isEmpty())
        {
            throw new IllegalArgumentException("Secret must have value");
        }
    }

}
