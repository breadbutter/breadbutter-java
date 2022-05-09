## The official Java Client library for Bread & Butter
This library allows you to connect your application to the authentication process of Bread & Butter. A user will be redirected to your application when a user is authenticated. Once this authentication is retrieved by your application you can perform an action like creating a user in your system or creating a session for that users.

## Download

Maven
```xml
<dependency>
    <groupId>io.breadbutter</groupId>
    <artifactId>breadbutter-java</artifactId>
    <version>5.2.0</version>
</dependency>
```

## API
>For more information on the full **DIY Quick Start Guide** visit https://app.breadbutter.io/api/

Once the user's authentication is processed on by Bread & Butter, the user is redirected to a callback interface defined in your Bread & Butter app. The example below is a simple interface that accepts the request from Bread & Butter and processes the authentication.

> After the the interface is created you will need to update the Callback URL with the URL to this interface in your app settings here: https://app.breadbutter.io/app/#/app-settings

### Processing an authentication request

*Instantiating a new client*

- `APP_ID` can be found in https://app.breadbutter.io/app/#/app-settings
- `APP_SECRET` is configured at https://app.breadbutter.io/app/#/app-settings
- The `BREADBUTTER_API_ENDPOINT` should be set to `https://api.breadbutter.io`

Create a new instance of `BreadButterClient`.

```java
import io.breadbutter.BreadButterClient;

BreadButterClient client = new BreadButterClient("{APP_ID}", "{APP_SECRET}", "{BREADBUTTER_API_ENDPOINT}");
```

*Retrieve authentication from Bread & Butter server*

> You can find the detailed API response here: https://breadbutter.io/api/server-api/

```java
import io.breadbutter.BreadButterClient;
import io.breadbutter.dtos.GetAuthenticationResponse;
import io.breadbutter.dtos.AuthenticationData;
import io.breadbutter.dtos.AuthOptions;
import io.breadbutter.BreadButterException;


String authToken = request.getParameter("authentication_token"); 


GetAuthenticationResponse bbResponse = client.getAuthentication(authToken);

AuthenticationData authData = bbResponse.getAuthData();
String emailAddress = authData.getEmailAddress();
String firstName = authData.getFirstName();
String lastName = authData.getLastName();
String profileImage = authData.getProfileImageUrl();

AuthOptions authOptions = bbResponse.getOptions();
String destinationUrl = authOptions.getDestinationUrl();

```

*Redirect the user back to your website*

```java
response.sendRedirect(destinationUrl);
```
