package apiConfig;

public class EnvConstants {

    static final String restLogProperties = "src/test/resources/log4j2.properties";

    public static final String qaEnvironmentbaseURI = "https://dieticianstaging-f334e4b782aa.herokuapp.com/dietician/";

    public static final String endPoint_Login = "login";

    public static final String userLoginId = "Tim@gmail.com";
    public static final String password = "test";

    public static final String jsonContentType = "application/json";

    public static final String invalidpathParamZero = "0";
    public static final String invalidpathParamNegativeID = "-1";
    public static final String invalidpathParamOverflowinteger = "120000000000000000000000000000000000000000000000";

    public static final String loginRequestBody = "{ \"userLoginEmailId\" : \"Tim@gmail.com\",\n"
            + "  \"password\" : \"test\"}";

    public static final int http_OK = 200;
    public static final int http_Created = 201;
    public static final int http_BadRequest = 400;
    public static final int http_UnAuthorized = 401;
    public static final int http_NotFound = 404;
    public static final int http_MethodNotAllowed = 405;
}
