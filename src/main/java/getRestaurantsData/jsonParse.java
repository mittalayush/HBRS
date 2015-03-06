package getRestaurantsData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import callYelpApiSerach.SearchRestaurFromYelp;

import java.util.*;

public class jsonParse {
	
	@SuppressWarnings("deprecation")
	public List getCleanYelpData(String FoodItem, String Address) throws IOException{	
	List <String>RestaurSet = new ArrayList();
	ObjectMapper mapper = new ObjectMapper();
	try {

		Yelp objYelpSrach = new Yelp();
		objYelpSrach.SearchRestaur(FoodItem,Address);
    	String path = this.getClass().getClassLoader().getResource("").getPath() + "getRestaurantsData/";
    	path = path.substring(1);
    	//System.out.println("---------"+path);
		BufferedReader fileReader = new BufferedReader(new FileReader(path+"result.json"));
		JsonNode rootNode = mapper.readTree(fileReader);
		JsonNode businessesNode = rootNode.path("businesses");
		String copyNode="";
		Iterator<JsonNode> businessesNodeElements = businessesNode.iterator();
        while (businessesNodeElements.hasNext()) {
            JsonNode restaurSet = businessesNodeElements.next();
            String tempNode="";
            tempNode+="{";
            tempNode+="\"distance\":"+(JsonNode)restaurSet.getFieldValue("distance");
            tempNode+=",\"review_count\":"+(JsonNode)restaurSet.getFieldValue("review_count");
            tempNode+=",\"categories\":"+(JsonNode)restaurSet.getFieldValue("categories");
            tempNode+=",\"name\":"+(JsonNode)restaurSet.getFieldValue("name");
            tempNode+=",\"rating\":"+(JsonNode)restaurSet.getFieldValue("rating");
            tempNode+=",\"url\":"+(JsonNode)restaurSet.getFieldValue("url");
            tempNode+=",\"location\":"+(JsonNode)restaurSet.getFieldValue("location");
            tempNode+=",\"menu_date_updated\":"+(JsonNode)restaurSet.getFieldValue("menu_date_updated");
            tempNode+=",\"phone\":"+(JsonNode)restaurSet.getFieldValue("phone");
            tempNode+=",\"snippet_text\":"+(JsonNode)restaurSet.getFieldValue("snippet_text");
            tempNode+=",\"image_url\":"+(JsonNode)restaurSet.getFieldValue("image_url");
            tempNode+=",\"display_phone\":"+(JsonNode)restaurSet.getFieldValue("display_phone");
            tempNode+=",\"review_count\":"+(JsonNode)restaurSet.getFieldValue("review_count");
            tempNode+=",\"is_closed\":"+(JsonNode)restaurSet.getFieldValue("is_closed");
            tempNode+="}";
            copyNode=tempNode;
            tempNode="";
            RestaurSet.add(copyNode);  
        }
        copyNode="";      
	} // end try block
	catch (JsonGenerationException e)	{e.printStackTrace();}
	catch (JsonMappingException e) 		{e.printStackTrace();}

	return RestaurSet;	
	}
	
	
	public static void main (String args[]) throws IOException{
		List result= null;
		jsonParse obj= new jsonParse();
		result=obj.getCleanYelpData("Mexician", "190 Ryland Street 95110");
		System.out.println(result);
		
		
	}
}