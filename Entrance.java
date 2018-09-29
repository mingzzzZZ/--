import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrance {
	
	static int n ;
	static String ename = "Exercise10.txt";
	static int r ;
	static String aname = "Answers10.txt";
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);  
		while(true){
			settingN();
			settingR();
			run();
			System.out.println("是否还要继续答题,是请输入Y或则y,否则输入n");
			sc.next();
			if(sc.equals("n"))
				break;
		}	
		
	}
	public static  void settingN(){
		System.out.println("输入题目数量");
		Scanner sc = new Scanner(System.in);  
		int num = sc.nextInt();
		n = num;
		
	}
	public  static void settingR(){
		System.out.println("数值范围");
		Scanner sc = new Scanner(System.in);  
		int r1 = sc.nextInt();
		r = r1;
		
	}
	public static void run(){
		
		String[] answer=new String[n];
		 try{
	            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(ename),true));
	            BufferedWriter awriter = new BufferedWriter(new FileWriter(new File(aname),true));
	            for(int i=0;i<n;i++){
	    			Request req = new Request(); 
	    			req.create(r);
	    			Node no = new Node();
	    			no.requestToNode(req);
	    			System.out.print(i+":"+req.getStr()+'\n');
	    			writer.write(i+":"+req.getStr());
	    			writer.newLine();
	    			answer[i]=req.getAnswer();
	    			awriter.write(i+":"+req.getAnswer());
	    			awriter.newLine();
	    		}
	            writer.close();
	            awriter.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }	
		 System.out.println("出题成功，请开始答题\n");
		 Scanner scanner = new Scanner(System.in);
		 String[] myanswer=new String[n];
			for(int i = 0;i<n;i++){
				myanswer[i] = scanner.next();
			}
			
		String rightAnswerResport = "Correct: ",rightAnswerList = "正确的题号";//构造正确部分呢过的答题报告
		String wrongAnswerResport = "Wrong",wrongAnswerList = "错误的题号";//构造错误部分呢过的答题报告
		int rightNumber = 0,wrongNumber = 0;//记录正确和错误的个数
		for(int i = 0;i<n;i++){//开始校验用户的回答
			if(myanswer[i].equals(answer[i])){
				rightNumber++;
				rightAnswerList = rightAnswerList+ (i+1)+",";
			}else{
				wrongNumber++;
				wrongAnswerList = wrongAnswerList + (i+1) +",";
					}

				}
				System.out.print(rightNumber+"道题正确"+"    "+rightAnswerList+'\n');
				System.out.print(wrongNumber+"道题错误"+"    "+wrongAnswerList+'\n');

	}
}
