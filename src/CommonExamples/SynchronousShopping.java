package CommonExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Shop{
	int label;
	Map<Shop, Integer> road;
	Set<Integer> fish;
	
	Shop(int label){
		this.label = label;
		this.road = new HashMap<>();
		this.fish = new HashSet<>();
	}
}
public class SynchronousShopping {
	
	public static void main(String[] args) throws Exception{
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = bfr.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int K = Integer.parseInt(tmp[2]);
		Shop[] shops = new Shop[N];
		for(int i=1; i<=N; i++){
			Shop nShop = new Shop(i);
			shops[i-1] = nShop;
			tmp = bfr.readLine().split(" ");
			int num = Integer.parseInt(tmp[0]);
			for(int j = 1; j<=num; j++){
				nShop.fish.add(Integer.parseInt(tmp[j]));
			}
		}
		for(int m = 1; m<= M; m++){
			
		}

	}

}
