package CommonExamples;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class NodeG{
    Integer id;
    LinkedList<NodeG>adj;
    NodeG(int i){
        this.id = i;
        this.adj = new LinkedList<>();
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        List<NodeG> vertices = new LinkedList<>();
        for(int i=1; i<=N; i++){
        	NodeG n = new NodeG(i);
            vertices.add(n);
        }
        //Build the Graph
        for(int i=0; i<M; i++){
            int s = in.nextInt();
            int t = in.nextInt();
            NodeG sN = vertices.get(s-1);
            NodeG sT = vertices.get(t-1);
            sT.adj.add(sN);
        }
        NodeG root = vertices.get(0);
        int maxRem = getMaxRem(root);
        System.out.println(result);
    }
    static int result = 0;
    public static int getMaxRem(NodeG curr){
        int i = 1;
       // int localCnt = 0;
        for(NodeG child: curr.adj){
        	int localRes = getMaxRem(child);
         //   localCnt = i;
            if(localRes % 2 == 0)
            	result += 1;
            i+=localRes;
        }
        return i;
    }
}