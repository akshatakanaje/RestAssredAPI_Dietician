package httpRequest;

import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public abstract class BaseRequest {

    protected String username;
    protected String password;
    protected String baseUrl;
    protected String serviceUrl;
    protected String contentTypeHeader;
    protected String acceptHeader;
    protected String requestBody;
    protected Object pathparam;
    protected String method;
    protected String token;

    public abstract RequestSpecification buildRequest();

    static boolean init = false;
    static PrintStream log;

    public static PrintStream getLogPrintStream() {
        if (!init) {
            try {
                log = new PrintStream(new FileOutputStream("RestAssuredDietitianLogs.txt", false), true); // false to overwrite
            } catch (FileNotFoundException e) {
                System.err.println("LogPrintStream File not found!!");
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize log file", e); // Stop execution if log file can't be created
            }
            init = true;
        }
        return log;
    }


    //Getters and setters for fields
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getContentTypeHeader() {
        return contentTypeHeader;
    }

    public void setContentTypeHeader(String contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
    }

    public String getAcceptHeader() {
        return acceptHeader;
    }

    public void setAcceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
    }

    public Object getPathparam() {
        return pathparam;
    }

    public void setPathparam(Object pathparam) {
        this.pathparam = pathparam;
    }
}
