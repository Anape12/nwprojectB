package jp.nw.base;

import java.util.HashMap;
import java.util.Map;

public class BaseAppLogic {


	protected Map<Integer, String> getWeek(){

		Map<Integer, String> week = new HashMap<Integer, String>();
		week.put(1, "日");
		week.put(2, "月");
		week.put(3, "火");
		week.put(4, "水");
		week.put(5, "木");
		week.put(6, "金");
		week.put(7, "土");

		return week;
	}

}
