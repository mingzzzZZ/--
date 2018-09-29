import java.util.ArrayList;
import java.util.List;

public class Node {

	String data;
	Node left;
	Node right;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node(String data){
		this.setData(data);
		
	}
	public Node(){
		
	}
	public Node requestToNode(Request re){
		String [] arr = re.getPostfix().split(",");                         
	    List<Node> list = new ArrayList<Node>();                            
	        	        
		for (int i = 0; i < arr.length; i++) {
			int size = list.size();
			switch (arr[i]) {
			case "+":
				Node a = new Node(arr[i]);
				a.setLeft(list.remove(size - 2));
				a.setRight(list.remove(size - 2));
				list.add(a);
				break;
			case "-":
				Node b = new Node(arr[i]);
				b.setLeft(list.remove(size - 2));
				b.setRight(list.remove(size - 2));
				list.add(b);
				break;
			case "*":
				Node c = new Node(arr[i]);
				c.setLeft(list.remove(size - 2));
				c.setRight(list.remove(size - 2));
				list.add(c);
				break;
			case "¡Â":
				Node d = new Node(arr[i]);
				d.setLeft(list.remove(size - 2));
				d.setRight(list.remove(size - 2));
				list.add(d);
				break;
			default:
				list.add(new Node(arr[i]));
				break; 
			}
		}

	        return list.get(0);
	}
	public boolean equals(Node node){
		if(!this.getData().equals(node.getData())){
			return false;		
		}
		if(this.getLeft()==null&&this.getRight()==null&&node.getLeft()==null&&node.getRight()==null){
			if(this.getData().equals(node.getData()))
			{
				return true;				
			}
			else
				return false;
			
		}
		if(this.getData().equals("*")||this.getData().equals("+"))
		if(this.getLeft()!=null&&this.getRight()!=null&&node.getLeft()!=null&&node.getRight()!=null){
			if(this.getLeft().equals(node.getLeft())&&this.getRight().equals(node.getRight()))
				return true;
			if(this.getLeft().equals(node.getRight())&&this.getRight().equals(node.getLeft()))
			   return true;
			
		}
		return false;
	}

}
