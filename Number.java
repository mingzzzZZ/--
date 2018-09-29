import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Number {

	int count;
	int numerato;
	int denominator;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNumerato() {
		return numerato;
	}

	public void setNumerato(int numerato) {
		this.numerato = numerato;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public Number(String str) {
		boolean fra = false,fu=false;
		int coun=0;
		int left = 0, right = 0;
		char[] charArr = str.trim().toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if(charArr[i] == '-'){
				fu=true;
				
			}
			if (charArr[i] >= '0' && charArr[i] <= '9') {
				if (fra) {
					right = right * 10 + (charArr[i] - '0');

				} else {
					left = left * 10 + (charArr[i] - '0');

				}

			} 
			if(charArr[i]=='/') {
				fra = true;

			}
			if(charArr[i]=='’') {
				coun=left;
				left=0;

			}

		}
		if (fra) {
			if(fu)
				coun = -coun;
			this.setCount(coun);
			this.setNumerato(left);
			this.setDenominator(right);
				

		} else {
			if(fu)
				left = -left;
			this.setCount(left);
			this.setNumerato(0);
			this.setDenominator(0);
		}

	}
	public Number(){
		this.setCount(0);
		this.setNumerato(0);
		this.setDenominator(0);
	}
	public Number add(Number num2){
		Number an = new Number();
		if(this.getDenominator()==0 && num2.getDenominator()==0){
			an.setCount(this.getCount() + num2.getCount());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()!=0){
			an.setCount(this.getCount() + num2.getCount());
			an.setDenominator(this.getDenominator() * num2.getDenominator());
			an.setNumerato(this.getNumerato()* num2.getDenominator() + num2.getNumerato() * this.getDenominator());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()==0){
			an.setCount(this.getCount() + num2.getCount());
			an.setDenominator(this.getDenominator());
			an.setNumerato(this.getNumerato());
		}
		if(this.getDenominator()==0 && num2.getDenominator()!=0){
			an.setCount(this.getCount() + num2.getCount());
			an.setDenominator(num2.getDenominator());
			an.setNumerato(num2.getNumerato());
		}
		an.trim();
		return an;
		
	}
	public Number sub(Number num2){
		Number an = new Number();
		if(this.getDenominator()==0 && num2.getDenominator()==0){
			an.setCount(this.getCount() - num2.getCount());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()!=0){
			an.setCount(this.getCount() - num2.getCount());
			an.setDenominator(this.getDenominator() * num2.getDenominator());
			an.setNumerato(this.getNumerato()* num2.getDenominator() - num2.getNumerato() * this.getDenominator());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()==0){
			an.setCount(this.getCount() - num2.getCount());
			an.setDenominator(this.getDenominator());
			an.setNumerato(this.getNumerato());
		}
		if(this.getDenominator()==0 && num2.getDenominator()!=0){
			an.setCount(this.getCount() - num2.getCount());
			an.setDenominator(num2.getDenominator());
			an.setNumerato(-num2.getNumerato());
		}
		an.trim();
		return an;
		
	}
	public Number muti(Number num2){
		Number an = new Number();
		if(this.getDenominator()==0 && num2.getDenominator()==0){
			an.setCount(this.getCount() * num2.getCount());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()!=0){
			an.setCount(0);
			an.setDenominator(this.getDenominator() * num2.getDenominator());
			an.setNumerato((this.getNumerato() + this.getCount() * this.getDenominator()) *
					(num2.getNumerato() + num2.getCount() * num2.getDenominator()));
		}
		if(this.getDenominator()!=0 && num2.getDenominator()==0){
			an.setCount(0);
			an.setDenominator(this.getDenominator());
			an.setNumerato(this.getNumerato() * num2.getCount());
		}
		if(this.getDenominator()==0 && num2.getDenominator()!=0){
			an.setCount(0);
			an.setDenominator(num2.getDenominator());
			an.setNumerato(num2.getNumerato() * this.getCount());
		}
		an.trim();
		return an;
		
	}
	
	public Number division(Number num2){
		Number an = new Number();
		if(this.getDenominator()!=0 && num2.getDenominator()!=0){
			an.setCount(0);
			an.setDenominator(this.getDenominator() * (num2.getNumerato() + num2.getCount() * num2.getDenominator()));
			an.setNumerato((this.getNumerato() + this.getCount() * this.getDenominator()) *
					num2.getDenominator());
		}
		if(this.getDenominator()==0 && num2.getDenominator()==0){
			an.setCount(0);
			an.setNumerato(this.getCount());
			an.setDenominator(num2.getCount());
		}
		if(this.getDenominator()==0 && num2.getDenominator()!=0){
			an.setCount(0);
			an.setDenominator(num2.getNumerato());
			an.setNumerato(num2.getDenominator() * this.getCount());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()==0){
			an.setCount(0);
			an.setDenominator(this.getDenominator() * num2.getCount());
			an.setNumerato(this.getNumerato());
		}
		an.trim();
		return an;
		
	}
	public void trim(){
		if(this.getDenominator()==0)
			return;
		int count = this.getCount();
		if(this.getNumerato()<0&&this.getCount()>0){
			this.setNumerato(this.getCount()*this.getDenominator() + this.getNumerato());
			this.setCount(0);
		}
		//化为带分数
		if(this.getNumerato()>=this.getDenominator()){
			count += this.getNumerato()/this.getDenominator();
			this.setCount(count);
			this.setNumerato(this.getNumerato()%this.getDenominator());
			
		}
		//分数约分
		for(int i=2;i<this.getDenominator();i++){
			if(this.getNumerato()%i==0&&this.getDenominator()%i==0){
				this.setNumerato(this.getNumerato()/i);
				this.setDenominator(this.getDenominator()/i);
			}
			
		}
		if(this.getNumerato()==0)
			this.setDenominator(0);
		
		
	}
	public String toString(){
		if(this.getDenominator()==0){
			return String.valueOf(this.getCount());
			
		}else{
			String str = "";
			if(this.getCount()!=0){
				str += String.valueOf(this.getCount())+ "’";								
			}
			str += String.valueOf(this.getNumerato())+ "/" + this.getDenominator();
			return str;
		}
	}
	public void create(int n){
		
		
		Random rand = new Random();
		int fenshu = rand.nextInt(5+1); 
		if(fenshu == 1){
			this.setCount(0);
			this.setDenominator(rand.nextInt(10)+1);
			this.setNumerato(rand.nextInt(this.getDenominator())+1);
			this.trim();
		}else{
			this.setCount(rand.nextInt(n)+1);
			this.setDenominator(0);
			this.setNumerato(0);
		}	

		
	}
	String CreateMathAnswer() {
		char[] tempStringtoChar =question.toCharArray()	;  //存放String转换的字符
		List<Character> opeartorList =new ArrayList<Character>();		//存放运算符
		for(int i=0;i<tempStringtoChar.length;i++) {
			switch (tempStringtoChar[i]) {
			case '+':
				opeartorList.add('+');
				break;
			case '-':
				opeartorList.add('-');
				break;
			case '*':
				opeartorList.add('*');
				break;
			case '/':
				opeartorList.add('/');
				break;
			default:
			    break;
			}
		}
		List<Character> tempOpeartorList = new ArrayList<Character>();  //存放运算符备份
		tempOpeartorList.addAll(opeartorList);
		if(!onlyOne) {
			opeator.add(tempOpeartorList);
		}
		String[] tempStringNum = question.split("[+ * / -]");		//存放String类型的计算符
		List<Integer> numList =new ArrayList<Integer>();		//存放运算数
		for(int i=0;i<tempStringNum.length;i++) {
			numList.add(Integer.parseInt(tempStringNum[i]));
		}
		List<Integer> tempNumList = new ArrayList<Integer>();		//存放运算数备份
		tempNumList.addAll(numList);
		if(!onlyOne) {
			number.add(tempNumList);
		}
		int denominator =1;
		boolean divFlag =false;
		if (opeartorList.contains('/')) {
			divFlag =true;		//将除数化简成一个
			for(int i=0;i<opeartorList.size();i++) {
				if(opeartorList.get(i).equals('/')) {
					for(int j=1;j<opeartorList.size();j++) {
						if(opeartorList.get(j).equals('/')) {
							numList.set(j, numList.get(j)*numList.get(j+1));
						}
						else if(opeartorList.get(j).equals('*')) {
							numList.set(i, numList.get(j+1)*numList.get(i));
						}
						else {
							break;
						}
						opeartorList.remove(j);
						numList.remove(j+1);
						j--;
					}
				}
			}
			for(int i=0;i<opeartorList.size();i++) {
				if(opeartorList.get(i) =='/') {
					denominator *=numList.get(i+1);
				}
			}
			if(opeartorList.contains('*')) {
				for(int i=0;i<opeartorList.size();i++) {
					if(opeartorList.get(i)=='*') {
						numList.set(i, (numList.get(i)*numList.get(i+1)));
						numList.remove(i+1);
						opeartorList.remove(i);
						i--;
					}
				}
			}
			for(int i=0;i<opeartorList.size();i++) {
				boolean condition=opeartorList.get(i).equals('+')||opeartorList.get(i).equals('-');
				if(condition) {
					if(i==0) {
						numList.set(0, numList.get(0)*denominator);
					}
					else if(i==opeartorList.size()-1) {
						numList.set(numList.size()-1, numList.get(numList.size()-1)*denominator);
						if(opeartorList.get(i-1).equals('+')||opeartorList.get(i-1).equals('-')) {
							numList.set(i, numList.get(i)*denominator);
						}
					}
					else {
							if(opeartorList.get(i-1).equals('+')||opeartorList.get(i-1).equals('-')) {
								numList.set(i, numList.get(i)*denominator);
							}
						}
					}
				}
			for(int i=0;i<opeartorList.size();i++) {
				if(opeartorList.get(i).equals('/')) {
					numList.set(i, (numList.get(i)*denominator/numList.get(i+1)));
					numList.remove(i+1);
					opeartorList.remove(i);
					i--;
				}
			}
			if(divFlag) {
				if(opeartorList.contains('*')) {
					for(int i=0;i<opeartorList.size();i++) {
						if(opeartorList.get(i)=='*') {
							numList.set(i, (numList.get(i)*numList.get(i+1)));
							numList.remove(i+1);
							opeartorList.remove(i);
							i--;
						}
					}
				}
			}
			if(numList.size()!=1) {
				for(int i=0;i<opeartorList.size();i++) {
					switch (opeartorList.get(i)) {
					case '+':
						numList.set(0, (numList.get(0)+numList.get(1)));
						break;
					case '-':
						numList.set(0, (numList.get(0)+numList.get(1)));
						break;
					}
					numList.remove(1);
				}
			}

	public boolean equals(Number num) {
		if (num.getCount() == this.getCount() && num.getDenominator() == this.getDenominator()
				&& num.getNumerato() == this.getNumerato()) {
			return true;
		}
		return false;
	}
}
