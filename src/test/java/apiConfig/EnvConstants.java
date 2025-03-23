package apiConfig;

public class EnvConstants {

    public static final String qaEnvironmentBaseURI = "https://dieticianstaging-f334e4b782aa.herokuapp.com/dietician/";
    public static final String jsonContentType = "application/json";


    // Login constants
    public static final String endPoint_Login = "login";
    public static final String userLoginId = "Tim@gmail.com";
    public static final String password = "test";
    public static final String loginRequestBody = "{ \"userLoginEmailId\" : \"Tim@gmail.com\",\n"
            + "  \"password\" : \"test\"}";


    // Wrong Login constants
    public static final String userLoginWrongId = "sdetwrong@gmail.com";
    public static final String wrongPassword = "test001";
    public static final String endPoint_invalidLogin = "invalidlogin";
    public static final String loginRequestBodyWrong = "{ \"userLoginEmailId\" : \"Tim.numpy@gmail.com\",\n"
            + "  \"password\" : \"numpy@2025\"}";


    //invalidPathParameters
    public static final String invalidPathParamZero = "0";
    public static final String invalidPathParamNegativeID = "-1";
    public static final String invalidPathParamOverFlowInteger = "120000000000000000000000000000000000000000000000";


    public static final int http_OK = 200;
    public static final int http_Created = 201;
    public static final int http_BadRequest = 400;
    public static final int http_UnAuthorized = 401;
    public static final int http_NotFound = 404;
    public static final int http_MethodNotAllowed = 405;


    //Dietitian constants
    public static final String endPoint_GetAllDietitian = "dietician";
    public static final String endPoint_CreateDietitian = "dietician";

    public static final String endPoint_GetDietitianById = "dietician/" + EnvVariables.dietitianId;
    public static final String endPoint_UpdateDietitianById = "dietician/" + EnvVariables.dietitianId;
    public static final String endPoint_DeleteDietitianById = "dietician/" + EnvVariables.dietitianId;

}
