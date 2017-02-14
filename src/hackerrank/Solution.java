package hackerrank;

import java.io.BufferedReader;
import java.util.*;

public class Solution {
	public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);
		int square = 0;
		int rectangle = 0;
		int polygon = 0;
		while(sc.hasNext()){
			Map<Integer, Integer> map = new HashMap<>();
			for(int i = 0; i<4; i++){
				int key = sc.nextInt();
				if(map.get(key) != null){
					map.put(key, map.get(key)+1);
				}else{
					map.put(key, 1);
				}
			}
			if(map.keySet().size() == 1){
				square++;
			}else if(map.keySet().size() == 2){
				rectangle++;
			}else{
				polygon++;
			}
		}
		System.out.println(square+" "+rectangle+" "+polygon);
	}
}
