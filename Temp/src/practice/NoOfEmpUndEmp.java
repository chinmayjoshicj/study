package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class NoOfEmpUndEmp {

	public static void main(String[] args) {
		HashMap<String, List<String>> map = new HashMap<>();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("A");
		arrayList.add("B");
		map.put("C", arrayList);
		ArrayList<String> arrayList1 = new ArrayList<>();
		arrayList1.add("C");
		arrayList1.add("E");
		map.put("F", arrayList1);
		ArrayList<String> arrayList2 = new ArrayList<>();
		arrayList2.add("D");
		map.put("E", arrayList2);
		ArrayList<String> arrayList3 = new ArrayList<>();
		map.put("A", arrayList3);
		map.put("B", arrayList3);

		Set<Entry<String, List<String>>> entrySet = map.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			int count = 0;
			System.out.print(entry.getKey() + ": ");
			List<String> value = entry.getValue();
			count = count + value.size();
			for (String string : value) {
				List<String> list = map.get(string);
				if (list != null) {
					count += list.size();
				}
			}
			System.out.println(count);
		}
	}
}
