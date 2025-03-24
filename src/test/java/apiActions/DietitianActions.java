package apiActions;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;

public class DietitianActions {

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

}
