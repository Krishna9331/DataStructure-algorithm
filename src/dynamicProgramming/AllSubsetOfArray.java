package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mishrk3 on 5/11/2017.
 */
public class AllSubsetOfArray {

	public List<List<Integer>> findAllSubsets(int[] numbers) {
		List<List<Integer>> subsets = new ArrayList<>();
		// push empty subset
		List<Integer> emptySubset = new ArrayList<>();
		subsets.add(emptySubset);
		for (int i = 0; i < numbers.length; i++) {
			int j = 0;
			int n = subsets.size();
			while (j < n) {
				List<Integer> subset = subsets.get(j);
				List<Integer> tmp = new ArrayList<>();
				subset.stream().forEach(e -> tmp.add(e));
				tmp.add(numbers[i]);
				subsets.add(tmp);
				j++;
			}
		}

		return subsets;
	}

	public static void main(String[] args) {
		AllSubsetOfArray asa = new AllSubsetOfArray();
		int[] num = {
				1, 3, 5, 2
		};
		List<List<Integer>> allSubsets = asa.findAllSubsets(num);
		allSubsets.forEach(subset -> {
			subset.forEach(i -> System.out.printf(i + " "));
			System.out.println();
		});
		System.out.println("no of subset is: " + allSubsets.size());
	}
}
