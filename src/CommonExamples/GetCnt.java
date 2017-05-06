package CommonExamples;

import java.util.*;

public class GetCnt {
	static class Element{
        int i, j;
        Element(int a, int b){
            i = a;
            j = b;
        }
        @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Element other = (Element) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
    }
    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        Element[] e = new Element[X.size()];
        for(int i = 0; i < X.size(); i++){
            e[i] = new Element(X.get(i), Y.get(i));
        }
        Element s = e[0];
        int cnt = 0;
        for(int l = 1; l < e.length; l++){
            cnt += getCnt(s, e[l]);
            s = e[l];
        }
        return cnt;
    }
    
    public static int getCnt(Element a, Element b){
        Queue<Element> q = new LinkedList<>();
        final int[][] SHIFT = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        int cnt = 0;
        HashSet<Element>v = new HashSet<>();
        HashMap<Element, Element> parent = new HashMap<>();
        q.add(a);
        while(!q.isEmpty()){
            Element curr = q.poll();
            if(v.contains(curr)) continue;
            v.add(curr);
            if(curr.equals(b)){
                while(curr != null){
                    curr = parent.get(curr);
                    cnt++;
                }
                return cnt;
            }
            for(int[]n : SHIFT){
                Element t = new Element(curr.i+n[0], curr.j+n[1]);
                if(isValid(t)){
                    q.add(t);
                    parent.put(t, curr);
                }
            }
        }
        return cnt;
    }
    
    public static boolean isValid(Element e){
        if(e.i < 0 || e.j < 0){
            return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	ArrayList<Integer> X = new ArrayList<>();
    	ArrayList<Integer> Y = new ArrayList<>();
    	X.add(2);
    	X.add(7);
    	X.add(13);
    	Y.add(2);
    	Y.add(1);
    	Y.add(5);
    	System.out.println(coverPoints(X, Y));
    }
}
