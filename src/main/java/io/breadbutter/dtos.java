package io.breadbutter;
/* Options:
Date: 2019-10-08 14:31:01
Version: 5.60
Tip: To override a DTO option, remove "//" prefix before updating
BaseUrl: https://local-idpx.logon-dev.com

//Package:
//GlobalNamespace: dtos
//AddPropertyAccessors: True
//SettersReturnThis: True
//AddServiceStackTypes: True
//AddResponseStatus: False
//AddDescriptionAsComments: True
//AddImplicitVersion:
//IncludeTypes:
//ExcludeTypes:
//TreatTypesAsStrings:
//DefaultImports: java.math.*,java.util.*,net.servicestack.client.*
*/

/* Options:
Date: 2020-05-14 18:21:09
Version: 5.70
Tip: To override a DTO option, remove "//" prefix before updating
BaseUrl: https://api.logon-dev-stable.com

//Package:
//GlobalNamespace: dtos
//AddPropertyAccessors: True
//SettersReturnThis: True
//AddServiceStackTypes: True
//AddResponseStatus: False
//AddDescriptionAsComments: True
//AddImplicitVersion:
//IncludeTypes:
//ExcludeTypes:
//TreatTypesAsStrings:
//DefaultImports: java.math.*,java.util.*,net.servicestack.client.*
*/

import java.math.*;
import java.util.*;
import net.servicestack.client.*;

public class dtos
{


    @Route(Path="/ping", Verbs="GET")
    @DataContract
    public static class Ping implements IReturn<PingResponse>, IAppId
    {
        @DataMember
        public String app_id = null;

        public String getAppId() { return app_id; }
        public Ping setAppId(String value) { this.app_id = value; return this; }
        private static Object responseType = PingResponse.class;
        public Object getResponseType() { return responseType; }
    }

    public static class PingResponse implements IBaseResponse
    {
        @DataMember
        public String version = null;

        public IErrorResponse error = null;

        public String getVersion() { return version; }
        public PingResponse setVersion(String value) { this.version = value; return this; }
        public IErrorResponse getError() { return error; }
        public PingResponse setError(IErrorResponse value) { this.error = value; return this; }
    }

    @Route(Path="/apps/{app_id}/authentications/{authentication_token}", Verbs="GET")
    @DataContract
    public static class GetAuthentication implements IReturn<GetAuthenticationResponse>, IAppId
    {
        @DataMember(IsRequired=true)
        public String app_id = null;

        @DataMember(IsRequired=true)
        public String authentication_token = null;

        public String getAppId() { return app_id; }
        public GetAuthentication setAppId(String value) { this.app_id = value; return this; }
        public String getAuthenticationToken() { return authentication_token; }
        public GetAuthentication setAuthenticationToken(String value) { this.authentication_token = value; return this; }
        private static Object responseType = GetAuthenticationResponse.class;
        public Object getResponseType() { return responseType; }
    }

    public static class GetAuthenticationResponse implements IBaseResponse
    {
        @DataMember
        public String app_id = null;

        @DataMember
        public ClientDetails client_details = null;

        @DataMember
        public Boolean auth_success = null;

        @DataMember
        public String auth_error = null;

        @DataMember
        public AuthenticationData auth_data = null;

        @DataMember
        public GetAuthenticationProvider provider = null;

        @DataMember
        public AuthOptions options = null;

        @DataMember
        public String user_id = null;

        @DataMember
        public IErrorResponse error = null;

        public String getAppId() { return app_id; }
        public GetAuthenticationResponse setAppId(String value) { this.app_id = value; return this; }
        public ClientDetails getClientDetails() { return client_details; }
        public GetAuthenticationResponse setClientDetails(ClientDetails value) { this.client_details = value; return this; }
        public Boolean isAuthSuccess() { return auth_success; }
        public GetAuthenticationResponse setAuthSuccess(Boolean value) { this.auth_success = value; return this; }
        public String getAuthError() { return auth_error; }
        public GetAuthenticationResponse setAuthError(String value) { this.auth_error = value; return this; }
        public AuthenticationData getAuthData() { return auth_data; }
        public GetAuthenticationResponse setAuthData(AuthenticationData value) { this.auth_data = value; return this; }
        public GetAuthenticationProvider getProvider() { return provider; }
        public GetAuthenticationResponse setProvider(GetAuthenticationProvider value) { this.provider = value; return this; }
        public AuthOptions getOptions() { return options; }
        public GetAuthenticationResponse setOptions(AuthOptions value) { this.options = value; return this; }
        public String getUserId() { return user_id; }
        public GetAuthenticationResponse setUserId(String value) { this.user_id = value; return this; }
        public IErrorResponse getError() { return error; }
        public GetAuthenticationResponse setError(IErrorResponse value) { this.error = value; return this; }
    }

    public static class UpdateAppUserResponse implements IBaseResponse
    {
        @DataMember
        public IErrorResponse error = null;

        public IErrorResponse getError() { return error; }
        public UpdateAppUserResponse setError(IErrorResponse value) { this.error = value; return this; }
    }

    public static interface IAppId
    {
        public String app_id = null;
    }

    public static interface IDeviceId
    {
        public String device_id = null;
    }

    public static interface IErrorResponse
    {
        public String code = null;
        public String message = null;
        public ArrayList<IValidationExceptionResponse> validation_errors = null;
    }

    public static interface IBaseResponse
    {
        public IErrorResponse error = null;
    }

    public static class ClientDetails
    {
        @DataMember
        public String ip_address = null;

        @DataMember
        public String continent_code = null;

        @DataMember
        public String continent = null;

        @DataMember
        public String country_code = null;

        @DataMember
        public String country = null;

        @DataMember
        public String state_prov_code = null;

        @DataMember
        public String state_prov = null;

        @DataMember
        public String city = null;

        @DataMember
        public String latitude = null;

        @DataMember
        public String longitude = null;

        @DataMember
        public String operating_system = null;

        @DataMember
        public String browser = null;

        @DataMember
        public String device = null;

        public String getIpAddress() { return ip_address; }
        public ClientDetails setIpAddress(String value) { this.ip_address = value; return this; }
        public String getContinentCode() { return continent_code; }
        public ClientDetails setContinentCode(String value) { this.continent_code = value; return this; }
        public String getContinent() { return continent; }
        public ClientDetails setContinent(String value) { this.continent = value; return this; }
        public String getCountryCode() { return country_code; }
        public ClientDetails setCountryCode(String value) { this.country_code = value; return this; }
        public String getCountry() { return country; }
        public ClientDetails setCountry(String value) { this.country = value; return this; }
        public String getStateProvCode() { return state_prov_code; }
        public ClientDetails setStateProvCode(String value) { this.state_prov_code = value; return this; }
        public String getStateProv() { return state_prov; }
        public ClientDetails setStateProv(String value) { this.state_prov = value; return this; }
        public String getCity() { return city; }
        public ClientDetails setCity(String value) { this.city = value; return this; }
        public String getLatitude() { return latitude; }
        public ClientDetails setLatitude(String value) { this.latitude = value; return this; }
        public String getLongitude() { return longitude; }
        public ClientDetails setLongitude(String value) { this.longitude = value; return this; }
        public String getOperatingSystem() { return operating_system; }
        public ClientDetails setOperatingSystem(String value) { this.operating_system = value; return this; }
        public String getBrowser() { return browser; }
        public ClientDetails setBrowser(String value) { this.browser = value; return this; }
        public String getDevice() { return device; }
        public ClientDetails setDevice(String value) { this.device = value; return this; }
    }

    public static class AuthenticationData
    {
        @DataMember
        public String email_address = null;

        @DataMember
        public String first_name = null;

        @DataMember
        public String last_name = null;

        @DataMember
        public String profile_image_url = null;

        @DataMember
        public String uid = null;

        @DataMember
        public HashMap<String,String> data = null;

        @DataMember
        public AuthorizationDataTokens oauth_tokens = null;

        public String getEmailAddress() { return email_address; }
        public AuthenticationData setEmailAddress(String value) { this.email_address = value; return this; }
        public String getFirstName() { return first_name; }
        public AuthenticationData setFirstName(String value) { this.first_name = value; return this; }
        public String getLastName() { return last_name; }
        public AuthenticationData setLastName(String value) { this.last_name = value; return this; }
        public String getProfileImageUrl() { return profile_image_url; }
        public AuthenticationData setProfileImageUrl(String value) { this.profile_image_url = value; return this; }
        public String getUid() { return uid; }
        public AuthenticationData setUid(String value) { this.uid = value; return this; }
        public HashMap<String,String> getData() { return data; }
        public AuthenticationData setData(HashMap<String,String> value) { this.data = value; return this; }
        public AuthorizationDataTokens getOauthTokens() { return oauth_tokens; }
        public AuthenticationData setOauthTokens(AuthorizationDataTokens value) { this.oauth_tokens = value; return this; }
    }

    public static class GetAuthenticationProvider
    {
        @DataMember
        public String idp = null;

        @DataMember
        public String id = null;

        @DataMember
        public String protocol = null;

        @DataMember
        public String name = null;

        @DataMember
        public String type = null;

        public String getIdp() { return idp; }
        public GetAuthenticationProvider setIdp(String value) { this.idp = value; return this; }
        public String getId() { return id; }
        public GetAuthenticationProvider setId(String value) { this.id = value; return this; }
        public String getProtocol() { return protocol; }
        public GetAuthenticationProvider setProtocol(String value) { this.protocol = value; return this; }
        public String getName() { return name; }
        public GetAuthenticationProvider setName(String value) { this.name = value; return this; }
        public String getType() { return type; }
        public GetAuthenticationProvider setType(String value) { this.type = value; return this; }
    }

    public static class AuthOptions
    {
        @DataMember
        public String client_data = null;

        @DataMember
        public String callback_url = null;

        @DataMember
        public String destination_url = null;

        @DataMember
        public String force_reauthentication = null;

        public String getClientData() { return client_data; }
        public AuthOptions setClientData(String value) { this.client_data = value; return this; }
        public String getCallbackUrl() { return callback_url; }
        public AuthOptions setCallbackUrl(String value) { this.callback_url = value; return this; }
        public String getDestinationUrl() { return destination_url; }
        public AuthOptions setDestinationUrl(String value) { this.destination_url = value; return this; }
        public String getForceReauthentication() { return force_reauthentication; }
        public AuthOptions setForceReauthentication(String value) { this.force_reauthentication = value; return this; }
    }




    public static interface IValidationExceptionResponse
    {
        public String property = null;
        public String code = null;
        public String message = null;
    }

    public static class AuthorizationDataTokens
    {
        @DataMember
        public String access_token = null;

        @DataMember
        public Long access_token_expires_in = null;

        @DataMember
        public String refresh_token = null;

        @DataMember
        public Long refresh_token_expires_in = null;

        @DataMember
        public Boolean can_refresh_token = null;

        @DataMember
        public Boolean can_revoke_token = null;

        public String getAccessToken() { return access_token; }
        public AuthorizationDataTokens setAccessToken(String value) { this.access_token = value; return this; }
        public Long getAccessTokenExpiresIn() { return access_token_expires_in; }
        public AuthorizationDataTokens setAccessTokenExpiresIn(Long value) { this.access_token_expires_in = value; return this; }
        public String getRefreshToken() { return refresh_token; }
        public AuthorizationDataTokens setRefreshToken(String value) { this.refresh_token = value; return this; }
        public Long getRefreshTokenExpiresIn() { return refresh_token_expires_in; }
        public AuthorizationDataTokens setRefreshTokenExpiresIn(Long value) { this.refresh_token_expires_in = value; return this; }
        public Boolean isCanRefreshToken() { return can_refresh_token; }
        public AuthorizationDataTokens setCanRefreshToken(Boolean value) { this.can_refresh_token = value; return this; }
        public Boolean isCanRevokeToken() { return can_revoke_token; }
        public AuthorizationDataTokens setCanRevokeToken(Boolean value) { this.can_revoke_token = value; return this; }
    }



    public static class ParsedIpAddressDataModel
    {
        public String continent = null;
        public String continent_code = null;
        public String country = null;
        public String country_code = null;
        public String state_prov = null;
        public String state_prov_code = null;
        public String city = null;
        public String longitude = null;
        public String latitude = null;

        public String getContinent() { return continent; }
        public ParsedIpAddressDataModel setContinent(String value) { this.continent = value; return this; }
        public String getContinentCode() { return continent_code; }
        public ParsedIpAddressDataModel setContinentCode(String value) { this.continent_code = value; return this; }
        public String getCountry() { return country; }
        public ParsedIpAddressDataModel setCountry(String value) { this.country = value; return this; }
        public String getCountryCode() { return country_code; }
        public ParsedIpAddressDataModel setCountryCode(String value) { this.country_code = value; return this; }
        public String getStateProv() { return state_prov; }
        public ParsedIpAddressDataModel setStateProv(String value) { this.state_prov = value; return this; }
        public String getStateProvCode() { return state_prov_code; }
        public ParsedIpAddressDataModel setStateProvCode(String value) { this.state_prov_code = value; return this; }
        public String getCity() { return city; }
        public ParsedIpAddressDataModel setCity(String value) { this.city = value; return this; }
        public String getLongitude() { return longitude; }
        public ParsedIpAddressDataModel setLongitude(String value) { this.longitude = value; return this; }
        public String getLatitude() { return latitude; }
        public ParsedIpAddressDataModel setLatitude(String value) { this.latitude = value; return this; }
    }

    public static class ParsedUserAgentDataModel
    {
        public String operating_system = null;
        public String device = null;
        public String browser = null;
        public Boolean is_bot = null;

        public String getOperatingSystem() { return operating_system; }
        public ParsedUserAgentDataModel setOperatingSystem(String value) { this.operating_system = value; return this; }
        public String getDevice() { return device; }
        public ParsedUserAgentDataModel setDevice(String value) { this.device = value; return this; }
        public String getBrowser() { return browser; }
        public ParsedUserAgentDataModel setBrowser(String value) { this.browser = value; return this; }
        public Boolean getIsBot() { return is_bot; }
        public ParsedUserAgentDataModel setIsBot(Boolean value) { this.is_bot = value; return this; }
    }



}