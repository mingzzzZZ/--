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
			System.out.println("�Ƿ�Ҫ��������,��������Y����y,��������n");
			sc.next();
			if(sc.equals("n"))
				break;
		}	
		
	}
	public static  void settingN(){
		System.out.println("������Ŀ����");
		Scanner sc = new Scanner(System.in);  
		int num = sc.nextInt();
		n = num;
		
	}
	public  static void settingR(){
		System.out.println("��ֵ��Χ");
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
		 System.out.println("����ɹ����뿪ʼ����\n");
		 Scanner scanner = new Scanner(System.in);
		 String[] myanswer=new String[n];
			for(int i = 0;i<n;i++){
				myanswer[i] = scanner.next();
			}
			
		String rightAnswerResport = "Correct: ",rightAnswerList = "��ȷ�����";//������ȷ�����ع��Ĵ��ⱨ��
		String wrongAnswerResport = "Wrong",wrongAnswerList = "��������";//������󲿷��ع��Ĵ��ⱨ��
		int rightNumber = 0,wrongNumber = 0;//��¼��ȷ�ʹ���ĸ���
		for(int i = 0;i<n;i++){//��ʼУ���û��Ļش�
			if(myanswer[i].equals(answer[i])){
				rightNumber++;
				rightAnswerList = rightAnswerList+ (i+1)+",";
			}else{
				wrongNumber++;
				wrongAnswerList = wrongAnswerList + (i+1) +",";
					}

				}
				System.out.print(rightNumber+"������ȷ"+"    "+rightAnswerList+'\n');
				System.out.print(wrongNumber+"�������"+"    "+wrongAnswerList+'\n');

	}
}
