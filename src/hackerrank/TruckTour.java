package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 12/25/2016. <pre>
 * Suppose there is a circle. There are  petrol pumps on that circle. PetrolPump pumps are numbered  0 to  N-1(both inclusive). You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular petrol pump will give, and (2) the distance from that petrol pump to the next petrol pump.

 Initially, you have a tank of infinite capacity carrying no petrol. You can start the tour at any of the petrol pumps. Calculate the first point from where the truck will be able to complete the circle. Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.

 Input Format

 The first line will contain the value of N.
 The next  N lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump will give and the distance between that petrol pump and the next petrol pump.

 Constraints:


 Output Format

 An integer which will be the smallest index of the petrol pump from which we can start the tour.

 Sample Input

 3
 1 5
 10 3
 3 4
 Sample Output

 1
 Explanation

 We can start the tour from the second petrol pump.
 </pre>
 */
public class TruckTour {

	public static void main(String[] args) {
		TruckTour tt = new TruckTour();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PetrolPump[] pumps = new PetrolPump[n];
		for (int i = 0; i < n; i++) {
			pumps[i] = new PetrolPump(sc.nextInt(), sc.nextInt());
		}
		int startPoint = tt.printTour(pumps, n);
		System.out.println(startPoint);
	}

	int printTour(PetrolPump[] pumps, int n) {
		int start = 0;
		int end = 1;
		int currPetrol = pumps[start].quantity - pumps[start].distance;
		while (end != start || currPetrol < 0) {
			while (currPetrol < 0 && start != end) {
				currPetrol -= pumps[start].quantity - pumps[start].distance;
				start = (start + 1) % n;
				if (start == 0) {
					return -1;
				}
			}
			currPetrol += pumps[end].quantity - pumps[end].distance;
			end = (end + 1) % n;
		}
		return start;
	}

	static class PetrolPump {
		int quantity;
		int distance;

		public PetrolPump(int q, int d) {
			this.quantity = q;
			this.distance = d;
		}
	}

}
