package apiActions;

import apiConfig.EnvConstants;
import httpRequest.BaseRequest;
import httpRequest.RequestFactory;

public class UserLoginActions {

    public static BaseRequest validLogin(BaseRequest login) {
        login = RequestFactory.setAuthentication(login, "post", EnvConstants.userLoginId, EnvConstants.password,
                EnvConstants.qaEnvironmentbaseURI);
        login = RequestFactory.createRequest(login, EnvConstants.jsonContentType, EnvConstants.loginRequestBody,
                EnvConstants.endPoint_Login, 0);
        return login;
    }

    public static BaseRequest invalidLogin(BaseRequest invalidlogin) {
        invalidlogin = RequestFactory.setAuthentication(invalidlogin, "post", EnvConstants.userLoginwrongId,
                EnvConstants.Wrongpassword, EnvConstants.qaEnvironmentbaseURI);
        invalidlogin = RequestFactory.createRequest(invalidlogin, EnvConstants.jsonContentType,
                EnvConstants.loginRequestBodyWrong, EnvConstants.endPoint_invalidLogin, 0);
        return invalidlogin;

    }
}
