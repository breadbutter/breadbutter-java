package io.breadbutter;

import net.servicestack.client.WebServiceException;

/**
 * Class to encapsulate LogonLabs exceptions
 */
public class BreadButterException extends Exception {

    private int httpStatusCode;
    private String errorCode;

    BreadButterException(WebServiceException ex) {
        super(ex.getErrorMessage(), ex);
        httpStatusCode = ex.getStatusCode();
        errorCode = ex.getErrorCode();
    }

    /**
     * Gets the httpStatusCode value
     * @return the int status code
     */
    public int getHttpStatusCode()
    {
        return httpStatusCode;
    }

    /**
     * Gets the errorCode value
     * @return the String error code
     */
    public String getErrorCode()
    {
        return errorCode;
    }
}
