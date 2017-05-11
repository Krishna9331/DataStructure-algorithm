package generalproblems;

/**
 * Created by mishrk3 on 4/19/2017.
 */
public class ABC {

	static int[] pushback(int[] input) {

		int length = input.length;
		int key = 0;
		int j;
		for(int i = 1; i < length; i++){
			key = input[i];
			if(key < 0){
				continue;
			}
			j = i-1;
			while(j >= 0 && input[j] < 0){
				input[j+1] = input[j];
				j = j-1;
			}
			input[j+1] = key;
		}
		return input;
	}

	static int[] pushback1(int[] input) {

		return input;
	}

	public static void main(String[] args) {
		int[] a = {1, -1, 3, 2, -7, -5, 11, 6};
		int [] res = pushback(a);
		System.out.println();
	}
}
