package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import generics.ApiUtils;
import generics.jsonUtil;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DietitianActions {

    private static final Logger logger = LoggerFactory.getLogger(DietitianActions.class);


    public static BaseRequest validLogin(BaseRequest login) {
        login = RequestFactory.setAuthentication(login, "post", EnvConstants.userLoginId, EnvConstants.password,
                EnvConstants.qaEnvironmentBaseURI);
        login = RequestFactory.createRequest(login, EnvConstants.jsonContentType, EnvConstants.loginRequestBody,
                EnvConstants.endPoint_Login, 0);
        return login;
    }

    //Get All Dietitian
    public static BaseRequest setDetailsToGetAllDietitian(BaseRequest getDietitian) {
        RequestFactory.setAuthentication(getDietitian, "get", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(getDietitian, EnvConstants.jsonContentType, "",
                EnvConstants.endPoint_GetAllDietitian, 0);
    }

    public static BaseRequest setDetailsToGetAllDietitianWithoutAuth(BaseRequest getDietitian) {
        getDietitian = RequestFactory.setAuthentication(getDietitian, "get", "",
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(getDietitian, EnvConstants.jsonContentType, "",
                EnvConstants.endPoint_GetAllDietitian, 0);
    }

    public static BaseRequest setDetailsToGetAllDietitianWithInvalidEndpoint(BaseRequest getDietitian) {
        getDietitian = RequestFactory.setAuthentication(getDietitian, "get", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(getDietitian,
                EnvConstants.jsonContentType, "", "invalid", 0);

    }

    public static BaseRequest setDetailsToGetAllDietitianWithInvalidMethod(BaseRequest getDietitian) {
        getDietitian = RequestFactory.setAuthentication(getDietitian, "get", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(getDietitian, EnvConstants.jsonContentType, "",
                EnvConstants.endPoint_GetAllDietitian, 0);
    }

    //Get Dietitian by Id
    public static BaseRequest setDetailsToGetDietitianById(BaseRequest getDietitian) {
        getDietitian = RequestFactory.setAuthentication(getDietitian, "get", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(getDietitian, EnvConstants.jsonContentType, "",
                EnvConstants.endPoint_GetDietitianById, 0);
    }

    public static BaseRequest setDetailsToGetDietitianByIdWithoutAuth(BaseRequest getDietitian) {
        getDietitian = RequestFactory.setAuthentication(getDietitian, "get", "",
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(getDietitian, EnvConstants.jsonContentType, "",
                EnvConstants.endPoint_GetDietitianById, 0);
    }

    public static BaseRequest setDetailsToGetDietitianByInvalidId(BaseRequest getDietitian) {
        getDietitian = RequestFactory.setAuthentication(getDietitian, "get", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(getDietitian,
                EnvConstants.jsonContentType, "", "dietician/99989", 0);
    }


    public static BaseRequest setDetailsToGetDietitianByInvalidEndpoint(BaseRequest getDietitian) {
        getDietitian= RequestFactory.setAuthentication(getDietitian, "get", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(getDietitian,
                EnvConstants.jsonContentType, "", "invalid", 0);
    }


    //Delete Dietitian by Id
    public static BaseRequest setDetailsToDeleteDietitianById(BaseRequest deleteDietitian) {
        deleteDietitian = RequestFactory.setAuthentication(deleteDietitian, "delete", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(deleteDietitian, EnvConstants.jsonContentType, "",
                EnvConstants.endPoint_DeleteDietitianById, 0);
    }

    public static BaseRequest setDetailsToDeleteDietitianByIdWithoutAuth(BaseRequest deleteDietitian) {
        deleteDietitian = RequestFactory.setAuthentication(deleteDietitian, "delete", "",
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(deleteDietitian, EnvConstants.jsonContentType, "",
                EnvConstants.endPoint_DeleteDietitianById, 0);
    }

    public static BaseRequest setDetailsToDeleteDietitianByIdWithInvalidEndpoint(BaseRequest deleteDietitian) {
        deleteDietitian = RequestFactory.setAuthentication(deleteDietitian, "delete", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(deleteDietitian, EnvConstants.jsonContentType, "",
                "invalid", 0);
    }

    public static BaseRequest setDetailsToDeleteDietitianByIdWithInvalidMethod(BaseRequest deleteDietitian) {
        deleteDietitian = RequestFactory.setAuthentication(deleteDietitian, "delete", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(deleteDietitian, EnvConstants.jsonContentType, "",
                EnvConstants.endPoint_DeleteDietitianById, 0);
    }

    public static BaseRequest setDetailsToDeleteDietitianByInvalidId(BaseRequest deleteDietitian) {
        deleteDietitian = RequestFactory.setAuthentication(deleteDietitian, "delete", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        return RequestFactory.createRequest(deleteDietitian, EnvConstants.jsonContentType, "",
               "dietician/99989" , 0);
    }

    public static BaseRequest setDetailsToAddDietitian(BaseRequest addDietitian) {
        addDietitian = RequestFactory.setAuthentication(addDietitian, "post", EnvVariables.token,
                EnvConstants.qaEnvironmentBaseURI);
        String classDetails = jsonUtil.run_all_test_scenarios_from_json_data("ValidDietitianWithAllValidFieldsPresentInRequestBody");
        return RequestFactory.createRequest(addDietitian, EnvConstants.jsonContentType, classDetails,
                EnvConstants.endPoint_CreateDietitian, 0);
    }

    public static void setDietitianId(Response response) {
        String DietitianIdValue = ApiUtils.extractFromResponse(response, "dietitianId");
        if (DietitianIdValue!= null) {
            int dietitianId = Integer.parseInt(DietitianIdValue);
            logger.info("Setting batchID in Env Variables: " + dietitianId);
            EnvVariables.dietitianId = dietitianId;
        } else {
            logger.info("batchId is null in response!");
        }
    }

}
