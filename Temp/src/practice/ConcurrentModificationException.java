package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
	public static void main(String args[]) {
		
		/*Example  1*/
		/*List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
				myList.remove(value);
		}

		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");
				// myMap.put("4", "4");
			}
		}*/
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");        list.add("4");
        list.add("5");
        
        // get the iterator
        Iterator<String> itr = list.iterator();
        
        //manipulate list while iterating
        while(itr.hasNext()){
            System.out.println("list is:"+list);
            String str = itr.next();
            System.out.println(str);
            if(str.equals("2"))itr.remove();//Allowed because we are doing it using Iterator Reference and not List Reference
            if(str.equals("3"))list.add("3 found");//ConcurrentModificationException
            //below code don't throw ConcurrentModificationException
            //because it doesn't change modCount variable of list
            if(str.equals("4")) list.set(1, "4");
        }
    }
}

