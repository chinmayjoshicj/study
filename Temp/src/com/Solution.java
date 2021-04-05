package com;

import java.util.*;

public class Solution {
	static HashMap<String, ArrayList<Double>> hm = new HashMap<String, ArrayList<Double>>();

	public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
		@Override
		public void putNewRating(String app, int rating) {
			// YOUR CODE HERE

//        	String arr[]=app.split(",");
//        	for (int i = 0; i < arr.length; i++) {
//				String value[]=arr[i].split(" ");
//				System.out.println(value[0]+" "+value[1]);
//			}
			if (hm.containsKey(app)) {
				ArrayList<Double> arrayList = hm.get(app);
				arrayList.add((double) rating);
			}
			else
			{
				ArrayList<Double> arrayList= new ArrayList<Double>();
				arrayList.add((double) rating);
//				hm.put(app,arrayList.add((double) rating));
				hm.put(app, arrayList);
			}
		}

		@Override
		public double getAverageRating(String app) {
			ArrayList<Double> arrayList = hm.get(app);
			double sum=0;
			for (int i = 0; i < arrayList.size(); i++) {
				sum+=arrayList.get(i);
			}
			return (sum/arrayList.size());
		}

		@Override
		public int getRatingsCount(String app) {
			// YOUR CODE HERE
			return hm.get(app).size();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface RatingStatisticsCollector {
		// Ratings feed will call this method when new app rating information is
		// received. This is input to your class. ratings is a non negative integer
		// between 0 to 10.
		public void putNewRating(String app, int rating);

		// Report the average rating of the app.
		public double getAverageRating(String app);

		// Report the total number of rating for an app.
		public int getRatingsCount(String app);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numLines = Integer.parseInt(scanner.nextLine());
		int currentLine = 0;
		while (currentLine++ < numLines) {
			final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
			final Set<String> apps = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			for (int i = 0; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String app = tokens[0];
				apps.add(app);
				final int runs = Integer.parseInt(tokens[1]);

				stats.putNewRating(app, runs);

			}

			for (String app : apps) {
				System.out.println(
						String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
			}

		}
		scanner.close();

	}
}