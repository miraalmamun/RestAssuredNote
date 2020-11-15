package testdata;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestData2 {

	public static void main(String[] args) throws Exception {
		
		
		String path = System.getProperty("user.dir")+"\\JSONFiles\\testdata.json";
		FileReader reader = new FileReader(path);
		JSONObject jsonObject = (JSONObject)new JSONParser().parse(reader);
		JSONArray jsonArray = (JSONArray)jsonObject.get("testdata");
		System.out.println(jsonArray);
		
		int iterat = 0;
		int iterat2 = 0;
		while(iterat <jsonArray.size())
		{
			JSONObject jsonObject2 = (JSONObject)jsonArray.get(iterat);
			String testName = (String)jsonObject2.get("testName");
			System.out.println(testName);
			System.out.println("===== "+jsonObject2);
			JSONArray jsonArray2 = (JSONArray)jsonObject2.get("data");
			while(iterat2 <jsonArray2.size())
			{
				JSONObject jsonObject3 = (JSONObject)jsonArray2.get(iterat2);
				System.out.println(jsonObject3);
				@SuppressWarnings("unchecked")
				Set<String> set = jsonObject3.keySet();
				Iterator<String> it = set.iterator();
				while(it.hasNext())
				{
					String key = it.next();
					String values = (String) jsonObject3.get(key);
					System.out.println(key+"  "+values);
				}
				iterat2++;
			}
			
			iterat++;
		}
		
		
		
		
		
		
		
	
		ArrayList< String> arr = new ArrayList<String>();
		arr.add("mir");
		arr.add("m");
		arr.add("mi");
		System.out.println(arr);
		for(int i =0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
		
	

	}

}
