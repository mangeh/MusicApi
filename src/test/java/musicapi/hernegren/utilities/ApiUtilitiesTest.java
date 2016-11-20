package musicapi.hernegren.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Magnus on 2016-11-13.
 */
public class ApiUtilitiesTest {

    private String jsonExample = "{\"employees\":[\n" +
            "    {\"firstName\":\"John\", \"lastName\":\"Doe\"},\n" +
            "    {\"firstName\":\"Anna\", \"lastName\":\"Smith\"},\n" +
            "    {\"firstName\":\"Peter\", \"lastName\":\"Jones\"}\n" +
            "]}";

    private String json2 = "{\n" +
            "    \"store\": {\n" +
            "        \"book\": [\n" +
            "            {\n" +
            "                \"category\": \"reference\",\n" +
            "                \"author\": \"Nigel Rees\",\n" +
            "                \"title\": \"Sayings of the Century\",\n" +
            "                \"price\": 8.95\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"Evelyn Waugh\",\n" +
            "                \"title\": \"Sword of Honour\",\n" +
            "                \"price\": 12.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"Herman Melville\",\n" +
            "                \"title\": \"Moby Dick\",\n" +
            "                \"isbn\": \"0-553-21311-3\",\n" +
            "                \"price\": 8.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"category\": \"fiction\",\n" +
            "                \"author\": \"J. R. R. Tolkien\",\n" +
            "                \"title\": \"The Lord of the Rings\",\n" +
            "                \"isbn\": \"0-395-19395-8\",\n" +
            "                \"price\": 22.99\n" +
            "            }\n" +
            "        ],\n" +
            "        \"bicycle\": {\n" +
            "            \"color\": \"red\",\n" +
            "            \"price\": 19.95\n" +
            "        }\n" +
            "    },\n" +
            "    \"expensive\": 10\n" +
            "}";



    private JSONObject json;

    private ApiUtilities apiUtilities;

    @Before
    public void setUp() throws Exception {
        JSONParser parser = new JSONParser();
//        Object obj = parser.parse(jsonExample);
//        json = (JSONObject) obj;
        apiUtilities = new ApiUtilities();

    }

    @Test
    public void getWikiUrl() throws Exception {
        String url = apiUtilities.getWikiUrl("https://en.wikipedia.org/wiki/Wechsler_Adult_Intelligence_Scale");

        Assert.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&redirects=true&titles=Wechsler_Adult_Intelligence_Scale",url);
    }

    @Test
    public void getBadWikiUrl() throws Exception {
        String url = apiUtilities.getWikiUrl("https://en.wikipedia.org/wikiti/Wechsler_Adult_Intelligence_Scale");

        Assert.assertEquals("Not found",url);
    }


    @Test
    public void findJsonValue() throws Exception {
        String name = apiUtilities.findFirstJsonValue(json2,"author");

        Assert.assertEquals("Nigel Rees",name);
    }

    @Test
    public void findJsonValueAllMatches() throws Exception {

    }

}