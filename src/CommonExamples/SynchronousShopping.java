package CommonExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
			tmp = bfr.readLine().split(" ");
			int shop1 = Integer.parseInt(tmp[0]);
			int shop2 = Integer.parseInt(tmp[1]);
			int time = Integer.parseInt(tmp[2]);
			Shop s1 = shops[shop1 -1];
			Shop s2 = shops[shop2 -1];
			s1.road.put(s2, time);
			s2.road.put(s1, time);
		}
		
		int minT = getMinTime(shops, K);
		System.out.println(minT);

	}
	
	public static int getMinTime(Shop[] shops, int K){
		List<Integer> p1 = new ArrayList<>();
		List<Integer> p2 = new ArrayList<>();
		int i = 1;
		while(i<=K){
			p1.add(i);
			p2.add(i+=1);
			i++;
		}
		int t1 = getFishes(shops, p1);
		int t2 = getFishes(shops, p2);
		return t1>t2?t1:t2;
	}
	
	public static int getFishes(Shop[] shops, List<Integer> list){
		Shop start = shops[0];
		Shop end = shops[shops.length -1];
		Queue<Shop> q = new LinkedList<>();
		for(int fish=0;fish<list.size();fish++ ){
			if(start.fish.contains(list.get(fish))){
				list.remove(fish);
			}
		}
		Queue<Shop>visited = new LinkedList<>();
		visited.add(start);
		q.addAll(start.road.keySet());
		while(!list.isEmpty() && !q.isEmpty()){
			
		}
		return 0;
	}

}
