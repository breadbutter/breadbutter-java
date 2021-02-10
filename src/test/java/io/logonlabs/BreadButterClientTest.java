package io.logonlabs;

import io.breadbutter.BreadButterClient;
import io.breadbutter.dtos;
import org.junit.*;


public class BreadButterClientTest {

    private static final String GATEWAY_URL = "";
    private static final String APP_ID = "";
    private static final String APP_SECRET = "";
    private static final String VALIDATE_TOKEN = ""; //this has to be hardcoded since redirect can't be performed

    @Test
    public void pingTest() throws Exception {
        BreadButterClient client = new BreadButterClient(APP_ID, APP_SECRET, GATEWAY_URL);
    }


    @Test
    public void getAuthenticationTest() throws Exception {
        BreadButterClient client = new BreadButterClient(APP_ID, APP_SECRET, GATEWAY_URL);

        dtos.GetAuthenticationResponse response = client.getAuthentication(VALIDATE_TOKEN);

        if(!response.isAuthSuccess()){

            throw new Exception("Authentication failed with error: " + response.getAuthError());

        } else {
            //authentication and validation succeeded
            dtos.AuthenticationData authData = response.getAuthData();
            String emailAddress = authData.getEmailAddress();
            String firstName = authData.getFirstName();
            String lastName = authData.getLastName();
        }
    }

    @Test
    public void parseTokenFromUrlTest() throws Exception {
        BreadButterClient client = new BreadButterClient(APP_ID, APP_SECRET, GATEWAY_URL);
        String tokenValue = "therealtokenvalue";
        String url = "https://www.logonlabs.com/callbacktest?faketoken=123toke&authentication_token="+tokenValue;
        String token = client.parseAuthenticationToken(url);
        if(!token.equalsIgnoreCase(tokenValue)){
            throw new Exception("Could not parse token correctly");
        }

        System.out.println(String.format("Token parsed as %s", token));
    }

}
