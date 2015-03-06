package callYelpApiSerach;

import getRestaurantsData.jsonParse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SearchRestaurFromYelp
{	
	public Hashtable<String,String>[] GetRestaurantsBasedOnZip(String Foodname, String Address)
	{
		ObjectMapper mapper = new ObjectMapper();
		jsonParse objJsonParse= new jsonParse();
		
		List <String>JsonSet = new ArrayList<String>();
		try {
			JsonSet=objJsonParse.getCleanYelpData(Foodname,Address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Hashtable<String,String>[] arr = new Hashtable[50];
		for (int i=0;i<JsonSet.size();i++)
		{
		    arr[i] = new Hashtable<String,String>();
			JsonNode rootNode=null;
			try {
				rootNode = mapper.readTree(JsonSet.get(i));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			arr[i].put("distance",String.valueOf(rootNode.path("distance").getDoubleValue()));
			JsonNode coordinateNode = rootNode.findValue("coordinate");
			arr[i].put("latitude",coordinateNode.findValue("latitude").toString());
			arr[i].put("longitude",coordinateNode.findValue("longitude").toString());
			arr[i].put("review_count",String.valueOf(rootNode.path("review_count").getIntValue()));
			arr[i].put("name",String.valueOf(rootNode.path("name").getTextValue()));
			arr[i].put("rating",String.valueOf(rootNode.path("rating").getDoubleValue()));
			JsonNode nameNode = rootNode.path("categories");
			Iterator<JsonNode> ite1 = nameNode.getElements();

			while (ite1.hasNext()){
				JsonNode temp = (JsonNode) ite1.next().iterator().next();
				arr[i].put("categories",temp.getTextValue());
			}

			arr[i].put("url",String.valueOf(rootNode.path("url").getTextValue()));
			JsonNode addressNode = rootNode.findValue("address");
			Iterator<JsonNode> iteAdd = addressNode.getElements();

			while (iteAdd.hasNext()) {
				JsonNode tempAdd = iteAdd.next();
				//System.out.println(tempAdd.getTextValue());
				arr[i].put("address",tempAdd.getTextValue());
			}

			JsonNode locationNode = rootNode.findValue("location");
			arr[i].put("city",locationNode.findValue("city").toString());
			arr[i].put("postal_code",rootNode.findValue("postal_code").toString());
			arr[i].put("country_code",rootNode.findValue("country_code").toString());
			arr[i].put("phone",String.valueOf(rootNode.path("display_phone").getTextValue()));
			String snippet_text=String.valueOf(rootNode.path("snippet_text").getTextValue()).trim().replace("\n", "");
			arr[i].put("snippet_text",snippet_text);
			arr[i].put("image_url",String.valueOf(rootNode.path("image_url").getTextValue()));
			arr[i].put("is_closed",String.valueOf(rootNode.path("is_closed").getBooleanValue()));
//			System.out.println(arr[i]);
		}
		return arr;
	}// end function
	
	
	public static void main (String args[]) throws IOException{
		Hashtable<String, String>[] result= null;
		int i;
		SearchRestaurFromYelp obj= new SearchRestaurFromYelp();
		result=obj.GetRestaurantsBasedOnZip("Indian", "1 washingtone sqaure san jose");
		for (i=0;i<20;i++){
			System.out.println(result[i]+"\n");
		}
	}
}
