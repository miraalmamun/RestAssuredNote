package createJson;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonRead {

	public static void main(String[] args) throws Exception {

		String jsonpath = System.getProperty("user.dir") + "\\test2.json";
		File file = new File(jsonpath);
		FileReader fr = new FileReader(file);
		JSONParser json = new JSONParser();
		JSONObject jsonObject = (JSONObject) json.parse(fr);

		JSONArray jsonArray = (JSONArray) jsonObject.get("testdata");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);

			String testName = (String) jsonObject2.get("testName");
			System.out.println(testName);
			JSONArray jsonArray2 = (JSONArray) jsonObject2.get("data");
			for (int j = 0; j < jsonArray2.size(); j++) {
				JSONObject jsonObject3 = (JSONObject) jsonArray2.get(j);
				@SuppressWarnings("unchecked")
				Set<String> s = jsonObject3.keySet();

				Iterator<String> itr = s.iterator();
				while (itr.hasNext()) {
					String key = itr.next();
					String value = (String) jsonObject3.get(key);
					System.out.println(key+"-->"+value);
				}

			}

		}

	}

}
