package sdet_CreateJSON;

import java.util.ArrayList;
import java.util.List;

public class Before {
	

	public static Stdnt serialization()
	{   
		

		List<String> l=new ArrayList<>();
		l.add("Java");
		l.add("Selenium");
		
		Stdnt student = new Stdnt(101, "Mir", "AlMamun", "MirMa@gmail.com", "Manager", l);
		
		return student;
	}
		

}
