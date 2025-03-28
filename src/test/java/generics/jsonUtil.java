package generics;

import apiConfig.EnvConstants;
import apiConfig.EnvVariables;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class jsonUtil {

    private static String ReqBody;

    public static JSONArray getTestData(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            int dietitianId = EnvVariables.dietitianId;

            if (content.contains("{{dietitianId}}")) {
                content = content.replace("{{dietitianId}}", String.valueOf(dietitianId));
            }
            JSONObject jsonObject = new JSONObject(content);
            return jsonObject.getJSONArray("data");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String run_all_test_scenarios_from_json_data(String reqBodyFieldName) {
        JSONArray testDataArray = getTestData(EnvConstants.TestDatajsonPath);
        JSONObject reqBody = null ;
        for (int i = 0; i < testDataArray.length(); i++) {
            JSONObject testData = testDataArray.getJSONObject(i);

            if (testData.has(reqBodyFieldName)) {
                reqBody = testData.getJSONObject(reqBodyFieldName);
            } else {
                continue;
            }
        }
        return ReqBody =  reqBody.toString();
    }
}
