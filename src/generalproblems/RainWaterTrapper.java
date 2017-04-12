package generalproblems;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by mishrk3 on 4/11/2017.
 */
public class RainWaterTrapper {

	public int trapRainWater(int[] arr) {
		int water = 0;
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = arr[0];
		right[n - 1] = arr[n - 1];

		for (int i = 1; i < n; i++) {
			left[i] = max(left[i - 1], arr[i]);
		}

		for (int i = n - 2; i >= 0; i--) {
			right[i] = max(right[i + 1], arr[i]);
		}

		for (int i = 0; i < n; i++) {
			water += min(left[i], right[i]) - arr[i];
		}
		return water;
	}

	public static void main(String[] args) {
		RainWaterTrapper rwt = new RainWaterTrapper();
		int[] ele = {
				3, 0, 0, 2, 0, 4
		};
		System.out.println("The amount of water trapped is: " + rwt.trapRainWater(ele) + "units");

		int arr[] = {
				0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
		};
		System.out.println("The amount of water trapped is: " + rwt.trapRainWater(arr) + "units");
	}
}
