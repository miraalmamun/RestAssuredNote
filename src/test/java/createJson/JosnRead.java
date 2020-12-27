package createJson;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JosnRead {

	public static void main(String[] args) throws Exception {

		String jsonPath = System.getProperty("user.dir") + "\\test.json";

		File file = new File(jsonPath);
		FileReader fs1 = new FileReader(file);

		JSONParser parse = new JSONParser();
		JSONObject obj = (JSONObject) parse.parse(fs1);
        System.out.println(obj);
        System.out.println("============================");
		JSONArray json = (JSONArray) obj.get("testdata");
		System.out.println(json);
		
		
		
		
		for(int i = 0; i<json.size();i++)
		{
			JSONObject obj2 = (JSONObject)json.get(i);
			//System.out.println(obj2);
			
			String testName = (String)obj2.get("testName");
			System.out.println(testName);
			JSONArray json2 = (JSONArray) obj2.get("data");
			//System.out.println(json2);
			json2.get(0);
			
			for(int j = 0; j<json2.size(); j++)
			{
				//System.out.println(json2.get(j));
				JSONObject obj3 = (JSONObject)json2.get(j);
				@SuppressWarnings("unchecked")
				Set<String> keys = obj3.keySet();
				
				Iterator<String> itr = keys.iterator();
				while(itr.hasNext())
				{
					String key = itr.next();
					String value = (String)obj3.get(key);
					System.out.println(key+"  "+value);
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				//System.out.println(keys);
				
				
				
				
				
				
				
				
				//System.out.println(obj3.get("runmode"));
				//System.out.println(obj3.get("password"));
				//System.out.println(obj3.get("browser"));
				//System.out.println(obj3.get("username"));
				
				
				
				
				//String runmode = (String)obj3.get("runmode");
				//String password = (String)obj3.get("password");
				//String browser = (String)obj3.get("browser");
				//String username = (String)obj3.get("username");
				
				//System.out.println(runmode+" "+password+" "+browser+" "+username);
				
				//System.out.println("==========================================");
				
				
				
				
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		/*
		//System.out.println(json.toJSONString());
		
		//System.out.println(json.get(0));
		
		JSONObject firstObject = (JSONObject)json.get(0);
		//System.out.println(firstObject.toJSONString());
		//System.out.println(firstObject.get("data"));
		
		JSONArray firstArray = (JSONArray)firstObject.get("data");
		//System.out.println(firstArray.get(0));
		
		JSONObject innerObject = (JSONObject)firstArray.get(0);
		System.out.println(innerObject.toString());
		//System.out.println(innerObject.get("runmode"));
		
		String runmode = (String)innerObject.get("runmode");
		String password = (String)innerObject.get("password");
		String browser = (String)innerObject.get("browser");
		String username = (String)innerObject.get("username");
		System.out.println(runmode);
		System.out.println(password);
		System.out.println(browser);
		System.out.println(username);
		
		
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for(int i = 0;i<json.size();i++)
//		{
//			
//			JSONObject obj2 =(JSONObject)json.get(i);
//		
//			System.out.println(obj2.get("data"));
//			
//			JSONArray ar = (JSONArray)obj2.get("data");
//			
//		}
//		
//		
//		
		
		
		
		
		

	}

}
