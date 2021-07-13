package freshPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class nthRarestElementInArray {
	
	public static int nthMostRare(int[] elements, int n) {
		Map<Integer, Long> map = Arrays.stream(elements).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        Comparator<Map.Entry<Integer, Long>> comp = Comparator.comparing(entry -> entry.getValue());
        List<Map.Entry<Integer, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(comp);
        return list.get(n-1).getKey();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
		System.out.println(x);

	}

}
