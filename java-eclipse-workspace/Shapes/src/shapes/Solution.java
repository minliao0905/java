package shapes;

import java.util.ArrayList;

public class Solution {
	Node last=null, nextStart=null;
	 public Node connect(Node root) {
		 if(root==null)
	        return root;
		 Node start = root;
		 while(start!=null) {
			 last=null;
			 nextStart=null;
			 for(Node p = start;p!=null;p=p.next) {
				 if(p.left!=null) {
					 handle(p.left);
				 }
				 if(p.right!=null) {
					 handle(p.right);
				 }
				 
			 }
			 start = nextStart;
		 }
		 return root;
	    }
	 public void handle(Node p) {
		 if(last!=null) {
			 last.next=p;
		 }
		 if(nextStart==null) {
			 nextStart=p;
		 }
		 last=p;
	 }
	 public static void main(String[] args) {
		  ArrayList<Node> notes = new ArrayList<Node>();
		int[] a= {1,2,5,6};
		for(int i:a) {
			 Node p = new Node();
			 p.val = i;
			 p.right=p.left=p.next = null;
			 notes.add(p);
		 }
		 for(Node i:notes) {
			 Node p = new Node();
			 p.val = i.val;
			 System.out.println(p);
			System.out.println(p.val);
	 }
	 
}
	 }
