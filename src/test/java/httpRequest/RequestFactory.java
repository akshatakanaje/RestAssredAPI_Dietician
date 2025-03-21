package httpRequest;

public class RequestFactory {

    // Method to set username password in authentication details
    public static BaseRequest setAuthentication(BaseRequest request, String methodType, String authUsername,
                                                String authPswd, String baseUrl) {

        String requestType = methodType.toUpperCase();

        if (requestType.equals("GET")) {
            request = new GetRequest();

        } else if(requestType.equals("POST")) {
            request = new PostRequest();
        } else if(requestType.equals("DELETE")) {
            request = new DeleteRequest();
        } else if(requestType.equals("PUT")) {
            request = new UpdateRequest();
        }
        if (request == null) {
            throw new IllegalArgumentException("Request must not be null.");
        }

        // Set authentication details on the provided request
        request.setUsername(authUsername);
        request.setPassword(authPswd);
        request.setBaseUrl(baseUrl);

        return request;
    }

    // Method to set authentication token in request details
    public static BaseRequest setAuthentication(BaseRequest request, String methodType, String token, String baseUrl) {

        String requestType = methodType.toUpperCase();

        if (requestType.equals("GET")) {
            request = new GetRequest();

        } else if(requestType.equals("POST")) {
            request = new PostRequest();
        } else if(requestType.equals("DELETE")) {
            request = new DeleteRequest();
        } else if(requestType.equals("PUT")) {
            request = new UpdateRequest();
        }
        if (request == null) {
            throw new IllegalArgumentException("Request must not be null.");
        }

        // Set authentication details on the provided request
        request.setBaseUrl(baseUrl);
        request.setToken(token);
        return request;
    }

    public static BaseRequest createRequest(BaseRequest request, String acceptHeader, String requestBody,String serviceUrl,
                                            Object pathParam) {
        if (request != null) {

            request.setServiceUrl(serviceUrl);
            request.setContentTypeHeader(acceptHeader);
            request.setAcceptHeader(acceptHeader);
            request.setRequestBody(requestBody);
            request.setPathparam(pathParam);

        }
        return  request;
    }

    public static BaseRequest createRequest(String methodType, String authUsername, String authPswd,
                                            String baseUrl,String acceptHeader, String serviceUrl,String requestBody,Integer pathParam){

        BaseRequest request = null;

        String requestType = methodType.toUpperCase();
        if (requestType.equals("GET")) {
            request = new GetRequest();
        }else if(requestType.equals("POST")) {
            request = new PostRequest();
        } else if(requestType.equals("DELETE")) {
            request = new DeleteRequest();
        } else if(requestType.equals("PUT")) {
            request = new UpdateRequest();
        }

        if (request != null) {
            request.setUsername(authUsername);
            request.setPassword(authPswd);
            request.setBaseUrl(baseUrl);
            request.setServiceUrl(serviceUrl);
            request.setContentTypeHeader(acceptHeader);
            request.setAcceptHeader(acceptHeader);
            request.setRequestBody(requestBody);
            //request.setRequestParams(requestParams);

        }
        return  request;
    }
}
