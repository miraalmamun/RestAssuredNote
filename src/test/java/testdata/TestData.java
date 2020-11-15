package testdata;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestData {

	public static void main(String[] args) throws Exception {

		String path = System.getProperty("user.dir") + "\\JSONFiles\\testdata.json";
		FileReader reader = new FileReader(path);
        JSONParser connect = new JSONParser();
        JSONObject obj = (JSONObject) connect.parse(reader);
		System.out.println(obj);
		JSONArray ja = (JSONArray)obj.get("testdata");
		
		int totalFirstJSONArrayObject = ja.size();
		
		
		for(int i = 0; i < totalFirstJSONArrayObject; i++)
		{
			
			JSONObject obj2 = (JSONObject)ja.get(i);
			
			JSONArray jsonAr = (JSONArray)obj2.get("data");
			String testName = (String)obj2.get("testName");
			System.out.println(testName);
			
			for(int j = 0; j<jsonAr.size(); j++)
			{
				JSONObject obj3 = (JSONObject) jsonAr.get(j);
				System.out.println(obj3);
				@SuppressWarnings("unchecked")
				Set<String> s = obj3.keySet();
				
				Iterator<String> it = s.iterator();
				while(it.hasNext())
				{
					String key = it.next();
					String value = (String)obj3.get(key);
					System.out.println(key+" ****** "+value);
				}
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		/*
		 * String path2 = System.getProperty("user.dir") + "\\JSONFiles\\Course.json";
		 * 
		 * byte[] b = Files.readAllBytes(Paths.get(path2)); String s = new String(b);
		 * 
		 * JsonPath json = new JsonPath(s); System.out.println(json);
		 * 
		 */

	}

}
