package two.pointers;
//https://www.hellointerview.com/learn/code/two-pointers
public class TwoPointers {
	
	//https://www.techiedelight.com/trapping-rain-water-within-given-set-bars/
	private static void trapping_rain_water(final int[] arr) {
		// calculate the highest bar on each side of a specific bar
		// the max'm water that can be collected on top of any bar is the lowest among
		// two left and right highest bars
		System.out.println();
		System.out.println(" -- trapping_rain_water -- ");
		int[] left = new int[arr.length]; // storing highest bars from left
		int[] right = new int[arr.length]; // storing highest bars from right
		left[0] = arr[0];
		right[arr.length - 1] = arr[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(arr[i], left[i - 1]);
		}
		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = Math.max(arr[i], right[i + 1]);
		}
		// maxm amount of water that can be stored
		int maxWater = 0;
		for (int i = 0; i < arr.length; i++) {
			// for any bar - the max water that can be stored at that bar will be min of max
			// bar heights on both sides
			maxWater += Math.min(left[i], right[i]) - arr[i];
		}
		System.out.println("Maximum Water that can be stored = " + maxWater);
	}

	// https://www.youtube.com/watch?v=pq7Xon_VXeU&list=PLrqwCI95Biv2Vhe-GwxcGUUxPtPAEYsx_&index=3
	private static void trapping_rain_water_ON_O1(final int[] arr) {
		System.out.println("  -- trapping_rain_water_ON_O1 --");
		int leftMax = 0, rightMax = 0;
		int start = 0;
		int end = arr.length - 1;
		int totalWater = 0;
		while (start < end) {
			if (arr[start] > arr[end]) {
				if (arr[end] >= rightMax)
					rightMax = arr[end];
				else
					totalWater += rightMax - arr[end];
				--end;
			} else {
				if (arr[start] >= leftMax)
					leftMax = arr[start];
				else
					totalWater += leftMax - arr[start];
				++start;
			}
		}
		System.out.println("Maximum Water that can be stored = " + totalWater);
	}

	// http://www.geeksforgeeks.org/trapping-rain-water/
	public static void trappingRainWater(int[] barsLengthHeight) {
		double waterAmmulated = 0.0d;
		// pre-compute the highest bar on the left side of each bar
		int[] highestLeftBar = new int[barsLengthHeight.length];
		// pre-compute the highest bar on the right side of each bar
		int[] highestRightBar = new int[barsLengthHeight.length];
		// compute
		highestLeftBar[0] = barsLengthHeight[0];
		highestRightBar[barsLengthHeight.length - 1] = barsLengthHeight[barsLengthHeight.length - 1];
		for (int i = 1; i < barsLengthHeight.length; i++)
			highestLeftBar[i] = Math.max(barsLengthHeight[i - 1], barsLengthHeight[i]);
		for (int i = barsLengthHeight.length - 2; i >= 0; i--)
			highestRightBar[i] = Math.max(barsLengthHeight[i + 1], barsLengthHeight[i]);
		// Calculate the accumulated water element by element
		// consider the amount of water on i'th bar, the
		// amount of water accumulated on this particular
		// bar will be equal to min(left[i], right[i]) - arr[i] .
		for (int i = 0; i < barsLengthHeight.length; i++)
			waterAmmulated += Math.min(highestLeftBar[i], highestRightBar[i]) - barsLengthHeight[i];

		System.out.println(" water acumulated " + waterAmmulated);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trapping_rain_water(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
		trapping_rain_water_ON_O1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
	}

}
