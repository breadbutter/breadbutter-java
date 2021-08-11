# BreadButter Java

The official BreadButter Java Client library.

## Download

Maven
```xml
<dependency>
    <groupId>io.breadbutter</groupId>
    <artifactId>breadbutter-java</artifactId>
    <version>3.1.0</version>
</dependency>
```

## BreadButter API


- Prior to coding, some configuration is required at https://app.breadbutter.io/app/#/app-settings.

- For the full Developer Documentation please visit: https://app.breadbutter.io/api/

---
### Instantiating a new client

- Your `APP_ID` can be found in [App Settings](https://app.breadbutter.io/app/#/app-settings)
- `APP_SECRETS` are configured [here](https://app.breadbutter.io/app/#/app-secrets)
- The `BREADBUTTER_API_ENDPOINT` should be set to `https://api.breadbutter.io`

Create a new instance of `BreadButterClient`.  

```java
import io.breadbutter.BreadButterClient;

BreadButterClient client = new BreadButterClient("{APP_ID}", "{APP_SECRET}", "{BREADBUTTER_API_ENDPOINT}");
```
---
### Authentication QuickStart

The StartAuthentication function in the JS library begins the BreadButter managed SSO process.

>Further documentation on starting the login process via our JavaScript client can be found at our GitHub page [here](https://github.com/breadbutter/breadbutter-java)

The following example demonstrates what to do once the `Callback Url` has been used by our system to redirect the user back to your page:

```java
import io.breadbutter.BreadButterClient;
import io.breadbutter.dtos.GetAuthenticationResponse;
import io.breadbutter.dtos.AuthenticationData;
import io.breadbutter.BreadButterException;

String callbackUrl = "{CallbackUrl}?authentication_token={AUTH_TOKEN}";

String queryToken = client.parseAuthenticationToken(callbackUrl);

try {

    GetAuthenticationResponse response = client.getAuthentication(queryToken);
    
    if(response.isAuthSuccess()) {
        //authentication and validation succeeded. proceed with post-auth workflows for your system
        AuthenticationData authData = response.getAuthData();
        String emailAddress = authData.getEmailAddress();
        String firstName = authData.getFirstName();
        String lastName = authData.getLastName();
    }
} catch(BreadButterException ex) {
    System.out.println(ex.getMessage());
}
```

#### ParseAuthenticationToken
This method parses out the value of the token query parameter returned with your callback url.
```java
import io.breadbutter.BreadButterClient;

String callbackUrl = "https://example.com?authentication_token=60219621548a2f1c23e51bdc";
String token = client.parseAuthenticationToken(callbackUrl);
System.out.println(token);

//output
//60219621548a2f1c23e51bdc
```
