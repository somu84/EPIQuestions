package CommonExamples;

class Node{
	int i;
	Node next;
	
	Node(int a){
		this.i = a;
		this.next = null;
	}
	
	public void add(int a){
		Node n = new Node(a);
		Node l = this;
		while(l.next != null)
			l = l.next;
		l.next = n;
	}
}
public class ZipList {

	public static void zipList(Node n, int l){
		
		int num = 1;
		Node a;
		Node n1 ;
		int cnt = 1;
		while(n.next != null){
			a = n.next;
			n1 = n; 
			cnt = num;
			while(cnt < l - num){
				n1 = n1.next;
				cnt++;
			}			
			n.next = n1.next;
			n1.next.next = a;
			n1.next = null;
			if(a.next != null){
				n = n.next.next;
			}
			else{
				break;
			}
			num++;
		}
	}
	
	public static void main(String[] args){
		Node l = new Node (0);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		
		zipList(l,5);
		
		while(l.next != null){
			System.out.print(l.i+" ->");
			l = l.next;
		}
		System.out.print("null");
	}
}
