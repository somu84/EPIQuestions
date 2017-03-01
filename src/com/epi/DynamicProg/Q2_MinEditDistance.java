package com.epi.DynamicProg;
/**
 * https://www.youtube.com/watch?v=We3YDTzNXEk&index=8&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 * @author Somu
 *
 */
public class Q2_MinEditDistance {
	public static int getMinEditDistance(char[] src, char[] dest){
		int[][]temp = new int[src.length+1][dest.length+1];
		for(int i=0; i<temp[0].length; i++){
			temp[0][i] = i;
		}
		for(int i=0; i<temp.length; i++){
			temp[i][0] = i;
		}
		for(int i=1; i<=src.length; i++){
			for(int j=1; j<=dest.length; j++){
				if(src[i-1] == dest[j-1]){
					temp[i][j] = temp[i-1][j-1];
				}
				else{
					temp[i][j] = min(temp[i-1][j-1], temp[i][j-1],temp[i-1][j])+1;
				}
			}
		}
		
		printEdits(temp,src,dest);
		return temp[src.length][dest.length];
	}
	private static int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
	
	public static void printEdits(int[][]T, char[]src, char[] dest){
		int i=T.length -1;
		int j = T[0].length -1;
		while(true){
			if(i==0 || j==0)
				break;
			if(src[i-1] ==dest[j-1] ){
				i-=1;
				j-=1;
			}
			else if(T[i][j] == T[i-1][j-1]+1){
				System.out.println("Replace "+src[i-1]+" in src, with "+dest[j-1]);
				i-=1;
				j-=1;
			}
			else if(T[i][j] == T[i][j-1]+1){
				System.out.println("Delete "+src[i-1]+" in src");
				i -=1;
			}
			else if(T[i][j] == T[i-1][j]+1){
				System.out.println("Delete "+dest[j-1]+" in dest");
			}
		}
	}
	public static void main(String[] args){
		String src = "carthouse";
		String dest = "orchestra";
		System.out.println("Min Edits Req: "+getMinEditDistance(src.toCharArray(), dest.toCharArray()));
	}

}
