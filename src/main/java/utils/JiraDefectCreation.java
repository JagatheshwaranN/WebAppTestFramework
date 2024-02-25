package utils;

import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;


import static io.restassured.RestAssured.given;

public class JiraDefectCreation {

    public static void main(String[] args) {
        String defectId = JiraDefectCreation.createDefectThruAPI("File Attachment Not Working", "File attachment option is not working and keep loading.",
                "Bug", "AutomationDefect", "QDPM-1", "UAT", FileReader.getDataFromPropFile("jiraId"));
        System.out.println(defectId);
    }

    public static String createDefectThruAPI(String summary, String description, String issueType, String label, String parent, String environment, String assignee){

        JSONObject defectPayload;

        try (FileInputStream fileReader = new FileInputStream("src/main/resources/jiraFiles/defectCreationPayload.json")){
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            defectPayload = new JSONObject(jsonTokener);

            JSONObject root = defectPayload.getJSONObject("fields");
            root.put("summary", summary);

            JSONArray descriptionArrObj = root.getJSONObject("description").getJSONArray("content");
            JSONObject contentTextNode = descriptionArrObj.getJSONObject(0).getJSONArray("content").getJSONObject(0);
            contentTextNode.put("text", description);

            JSONObject issueTypeObj = root.getJSONObject("issuetype");
            issueTypeObj.put("name", issueType);

            JSONArray labelArrObj = root.getJSONArray("labels");
            labelArrObj.clear();
            labelArrObj.put(label);

            JSONObject parentObj = root.getJSONObject("parent");
            parentObj.put("key", parent);

            JSONArray environmentArrObj = root.getJSONObject("environment").getJSONArray("content");
            JSONObject environmentTextNode = environmentArrObj.getJSONObject(0).getJSONArray("content").getJSONObject(0);
            environmentTextNode.put("text", environment);

            JSONObject assigneeObj = root.getJSONObject("assignee");
            assigneeObj.put("id", assignee);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        byte[] basicAuth = Base64.getEncoder().encode((FileReader.getDataFromPropFile("jiraUserName")+":"+FileReader.getDataFromPropFile("jiraAccessToken")).getBytes());
        String basicAuthString = new String(basicAuth);

        return given()
                .header("Authorization", "Basic "+basicAuthString)
                .contentType(ContentType.JSON)
                .body(defectPayload.toString())
                .log()
                .body()
        .when()
                .post(FileReader.getDataFromPropFile("jiraDefectEndpoint"))
        .then()
                .statusCode(201)
                .log()
                .body()
                .extract()
                .path("id");
    }

}
