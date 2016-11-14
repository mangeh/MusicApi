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

    private JSONObject json;

    private ApiUtilities apiUtilities;

    @Before
    public void setUp() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonExample);
        json = (JSONObject) obj;
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
        String name = apiUtilities.findJsonValue(json,"firstName");

        Assert.assertEquals("John",name);
    }

    @Test
    public void findJsonValueAllMatches() throws Exception {

    }

}