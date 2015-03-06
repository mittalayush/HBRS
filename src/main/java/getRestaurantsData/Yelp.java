package getRestaurantsData;
import geoCode.ConvAddress;
import geoCode.GoogleResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import geoLocation.Result;

import java.io.FileWriter;
import java.util.Properties;

public class Yelp {

  OAuthService service;
  Token accessToken;

  public Yelp(String consumerKey, String consumerSecret, String token, String tokenSecret) {
    this.service = new ServiceBuilder().provider(YelpApi2.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }
  public Yelp() {
	  }


  public String search(String term, double latitude, double longitude) {
    OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
    request.addQuerystringParameter("term", term);
    request.addQuerystringParameter("ll", latitude + "," + longitude);
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    return response.getBody();
  }

  
  public void SearchRestaur(String FoodItem, String Address) {
	  
	Properties prop = new Properties();
	InputStream input = null;
    try {
    	// load the tokens from config file
    	
    	String path = this.getClass().getClassLoader().getResource("").getPath() + "getRestaurantsData/";
    	path = path.substring(1);
    	
    	
    	input = new FileInputStream(path+"config.properties");
    	//System.out.println(input);
		prop.load(input);
    	String lat=null;
    	String lng=null;
    	ConvAddress ConAddress= new ConvAddress();
		GoogleResponse res = ConAddress.convertToLatLong(Address);
		  if(res.getStatus().equals("OK"))
		{
		   for(Result result : res.getResults())
		{   
			   lat=result.getGeometry().getLocation().getLat();
			   lng=result.getGeometry().getLocation().getLng();
			   break;
		}
		}
		  else
		{
		   System.out.println(res.getStatus());
		}
		Yelp yelp = new Yelp(prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret"));
		if (lat!=null && lng!=null){
	    String response = yelp.search(FoodItem, Double.parseDouble(lat), Double.parseDouble(lng));
	    //System.out.println(path);
	    File file = new File(path+"result.json");
	      // creates the file
	    file.createNewFile();
	    FileWriter writer = new FileWriter(file);
	    writer.write(response);
	    writer.flush();
	    writer.close();
	    //System.out.println(response);
		}
		else
		{
		//System.out.println("Please enter again, Invalid adress");
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
}
