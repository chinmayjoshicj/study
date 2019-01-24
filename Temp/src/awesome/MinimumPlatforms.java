package awesome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Train {
	int arrValTime;
	int deptTime;

	public Train(int arrValTime, int deptTime) {
		super();
		this.arrValTime = arrValTime;
		this.deptTime = deptTime;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.arrValTime + " " + this.deptTime);
	}
}

public class MinimumPlatforms {
	static int maxPlatforms = 0;
	static int minDeptTime = 0;

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		ArrayList<Train> trains = new ArrayList<>();

		for (int i = 0; i < dep.length; i++) {
			Train t = new Train(arr[i], dep[i]);
			trains.add(t);
		}
		Collections.sort(trains, new Comparator<Train>() {
			@Override
			public int compare(Train o1, Train o2) {
				// TODO Auto-generated method stub
				return o1.arrValTime - o2.arrValTime;
			}
		});
		/*
		 * for (Train train : trains) { System.out.println(train.arrValTime); }
		 */
		// System.out.println(trains);
		ArrayList<Train> platforms = new ArrayList<>();
		platforms.add(trains.get(0));
		minDeptTime = trains.get(0).deptTime;
		boolean firstTrain = true;
		int trainsStanding = 1;
		for (int i = 0; i < trains.size(); i++) {
			if (firstTrain == true) {
				firstTrain = false;
				continue;
			} else {
				boolean added = false;
				for (int j = 0; j < trainsStanding; j++) {
					if (!added) {
						System.out.println("Checking for " + platforms.get(j).deptTime + " Platform with train "
								+ trains.get(i).arrValTime);
						if (platforms.get(j).deptTime > trains.get(i).arrValTime) {
							continue;
						} else {
							added = true;
							System.out.println("Removing " + platforms.get(j).deptTime);
							platforms.remove(j);
							System.out.println("Addnig " + trains.get(i).deptTime);
							platforms.add(trains.get(i));
							System.out.println("Size id " + platforms.size());
						}
					}
				}
				if (!added) {
					System.out.println("Addnig " + trains.get(i).deptTime);
					platforms.add(trains.get(i));

				}
				if (maxPlatforms < platforms.size()) {
					maxPlatforms = platforms.size();
				}
			}
		}
		System.out.println("Minimum Platforms " + maxPlatforms);
	}
}
