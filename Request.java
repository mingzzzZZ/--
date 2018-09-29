import java.util.Random;

public class Request {
	
	String str;
	String answer;
	String postfix;
	Node node;
	
	public void setStr(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}	
	public String getAnswer() {
		return answer;
	}
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	public String getPostfix() {
		return postfix;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public Request(String str){
		this.setStr(str);
		Calculate ca = new Calculate();
		String post = ca.tosuffix(str);
		String an = ca.dealequation(post);  
		
		this.setStr(str);
		this.setAnswer(an);
		this.setPostfix(post);
		Node no1 = new Node();
		no1=no1.requestToNode(this);
		this.setNode(no1);
	}
	public Request(){
		
		
	}
	public String create(int n){
		Random rand = new Random();
		int len =  rand.nextInt(2);
		String str = "";  
		if(len==0){
			Number num1 = new Number();
			num1.create(n);
			Number num2 = new Number();
			num2.create(n);
			char f = 0;
			int ff = rand.nextInt(4);
			if(ff==0)
				f='+';
			if(ff==1)
				f='-';
			if(ff==2)
				f='*';
			if(ff==3)
				f='¡Â';
			
			str = num1.toString() + f + num2.toString();
			
		}else{
			Number num1 = new Number();num1.create(n);
			Number num2 = new Number(); num2.create(n);
			Number num3 = new Number(); num3.create(n);
			char f = 0;
			int ff = rand.nextInt(4);
			if(ff==0)
				f='+';
			if(ff==1)
				f='-';
			if(ff==2)
				f='*';
			if(ff==3)
				f='¡Â';
			char f2 = 0;
			int ff2 = rand.nextInt(4);
			if(ff2==0)
				f2='+';
			if(ff2==1)
				f2='-';
			if(ff2==2)
				f2='*';
			if(ff2==3)
				f2='¡Â';
			int kk = rand.nextInt(5);
			if(kk==1)
				str = "("+num1.toString() + f + num2.toString()+ ")" + f2 + num3.toString();
			if(kk==2)
				str = num1.toString() + f + "(" + num2.toString() + f2 + num3.toString() + ")";
			else
			str = num1.toString() + f + num2.toString() + f2 + num3.toString();
			
		}
		Calculate ca = new Calculate();
		String post = ca.tosuffix(str);
		String an = ca.dealequation(post);  
		this.setStr(str);
		this.setAnswer(an);
		this.setPostfix(post);
		Node no1 = new Node();
		no1=no1.requestToNode(this);
		this.setNode(no1);
		
		return str;
	}
	
	public boolean equals(Request req){
		if(this.getNode().equals(req.getNode())){
			return true;
		}
		else
		return false;
	}

}
