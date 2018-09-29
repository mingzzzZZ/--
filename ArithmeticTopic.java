package ��������1;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
public class ArithmeticTopic {
    
    private static Random random = new Random();
    public static int range;
    
                               
   
    //�����������
    private String[] createNumber(int range) {
    	
        String numberArr[]=new String[2];
        //numberArr[0]�Ǽٷ�����numberArr[1]�������
    	int up =1+random.nextInt(range);
        int down = 0;
        String numberStringT="";//�����
        String numberStringF="";//�ٷ���
        if(random.nextBoolean()) {
            down = up;	
            up = 1+random.nextInt(range);
            if(down==up) 
            	down=0;
        }
        //�жϼٷ���
        if(down>0) {         	
            	numberStringF = ""+up+"/"+down; 
        }else {
            numberStringF = "" +up;
        }
        //�ж������
        if(down>0) {         	
            if(up>down){
            	int inte=up/down;
            	up=up%down;
            	if(up==0){
            		numberStringT="" +inte;
            	}else{
            		numberStringT=""+inte+"'"+up+"/"+down;
            	}
            }else if(up<down){
            	numberStringT = ""+up+"/"+down;
            }
        }else {
            numberStringT = "" +up;
        }
        numberArr[0]=numberStringF;
        numberArr[1]=numberStringT;

        return numberArr;
    }
    
    //����������ʽ
    private String[] createExp() {
    	String expArr[]=new String[2];
    	
        char opt = '+';
        switch(random.nextInt(3))  {
            case 0 : opt = '+';    break;
            case 1 : opt = '-';    break;
            case 2 : opt = '*';    break;
            case 3 : opt = '/';    break;
            default: break;
        };
      
        String c1[]=createNumber(range);
        String c2[]=createNumber(range);
   
        expArr[0]=c1[0]+opt+c2[0];//�ٱ��ʽ
        expArr[1]=c1[1]+opt+c2[1];//����ʽ
  
         
        return expArr;
    }
    //����׺���ʽת���ɺ�׺���ʽ
    public static ArrayList transform(String prefix) {
   
        int i, len = prefix.length();
        prefix=prefix+ '#';
        Stack<Character> stack = new Stack<Character>();// �����������ջ
        stack.push('#');
        ArrayList postfix = new ArrayList();
       
        for (i = 0; i < len + 1; i++) {
      
            if (Character.isDigit(prefix.charAt(i))) {
                if (Character.isDigit(prefix.charAt(i+1))) {
                    postfix.add(10 * (prefix.charAt(i)-'0') + (prefix.charAt(i+1)-'0'));
                    i++;
                } else {
                    postfix.add((prefix.charAt(i)-'0'));
                }
            } else {
                switch (prefix.charAt(i)) {
                case '(':
                    stack.push(prefix.charAt(i));
                    break;
                case ')':
                    while (stack.peek() != '(') {
                        postfix.add(stack.pop());
                    }
                    stack.pop();
                    break;
                default:// Ĭ�������:+ - * /
                    while (stack.peek() != '#'
                            && compare(stack.peek(), prefix.charAt(i))) {
                        postfix.add(stack.pop());// ���ϵ�ջ��ֱ����ǰ�Ĳ����������ȼ�����ջ��������
                    }
                    if (prefix.charAt(i) != '#') {// �����ǰ�Ĳ���������'#'(������)����ô�������ջ
                        stack.push(prefix.charAt(i));// ���ı�ʶ��'#'�ǲ���ջ��
                    }
                    break;
                }
            }
        }
        return postfix;
    }
    //�Ƚ������֮������ȼ�
    public static boolean compare(char peek, char cur) {
        if (peek == '*'
                && (cur == '+' || cur == '-' || cur == '/' || cur == '*')) {
            return true;
        } else if (peek == '/'
                && (cur == '+' || cur == '-' || cur == '*' || cur == '/')) {
            return true;
        } else if (peek == '+' && (cur == '+' || cur == '-')) {
            return true;
        } else if (peek == '-' && (cur == '+' || cur == '-')) {
            return true;
        } else if (cur == '#') {
            return true;
        }
        return false;
    }
    
    //�����׺���ʽ
    public static double calculate(ArrayList postfix){
     
        int i,size=postfix.size();
        double res=0;
        Stack<Double> stack_num=new Stack<Double>();
        for(i=0;i<size;i++){
            if(postfix.get(i).getClass()==Integer.class){
            	
                stack_num.push(Double.parseDouble(String.valueOf( postfix.get(i))));                  
                
            }else{
        
            	double a=stack_num.pop();
            	double b=stack_num.pop();
                switch((Character)postfix.get(i)){
                case '+':
                    res=b+a;
             
                    break;
                case '-':
                    res=b-a;
                
                    break;
                case '*':
                    res=b*a;
                  
                    break;
                case '/':
                    res=b/a;
                   
                    break;
                }
                stack_num.push(res);
              
            }
        }
        res=stack_num.pop();
        return res;
    }
  
 //���ļ� �����ļ���д�ļٷ���ת����С��   
    public  double[] readAndRead()
    {		
    	double[] answers=new double[100];
        try
        {
            FileReader fr = new FileReader("Answers.txt");//��Ҫ��ȡ���ļ�·��
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            
            
            int i=0;
            while(s!=null)//�����ǰ�в�Ϊ��
            {	
                ArrayList postfix = transform(s);
                answers[i]=calculate(postfix);
               
                s= br.readLine();
                i++;
            }
                    br.close();
                    fr.close();		
        }catch(IOException e)
            {
                System.out.println("ָ���ļ�������");
            }
        
        
        return answers;
    }	
    
    
    
    public static void main(String[] args) {
    	
        ArithmeticTopic topic = new ArithmeticTopic(); 
        
        Scanner sc= new Scanner(System.in);
        System.out.println("��������������ڵ����֣�");
        range=sc.nextInt();
        topic.createNumber(range);
        System.out.println("������������ٸ�������ʽ��");
        int num=sc.nextInt();
        
        double[] results=new double[num];
        String[] express=new String[2];
        for(int i=0;i<num;i++){
        	express=topic.createExp();
        	System.out.println(express[1]);
        	String s = express[0];
            ArrayList postfix = transform(s);
        	FileWriter fw = null;
             try {
             //����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
 	            File f=new File("Exersies.txt");
 	            fw = new FileWriter(f, true);
             } catch (IOException e) {
             	e.printStackTrace();
             }
             PrintWriter pw = new PrintWriter(fw);
             pw.println(i+1+"."+express[1]);
             pw.flush();
             try {
 	            fw.flush();
 	            pw.close();
 	            fw.close();
             } catch (IOException e) {
             	e.printStackTrace();
             }
        	
      
            
            results[i]=calculate(postfix);
         
            
           
        }
        System.out.println("����s�ύ��");
        Scanner sc1=new Scanner(System.in);
        String submit=sc1.nextLine();
        if(submit.equals("s")){
            double[] ans=topic.readAndRead();
            
            int indexC=0;
            int indexW=0;
            int[] coarr=new int[10];
            int[] wrarr=new int[10];
            for(int i=0;i<results.length;i++){
     
            	if(results[i]==ans[i]){
            		indexC+=1;
            		
            	}else {
            		indexW+=1;
            	
                }
            }
            System.out.println("��ȷ:"+indexC);
         
            System.out.println("����:"+indexW);
          
            FileWriter fw = null;
            try {
            //����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
                File f=new File("Gread.txt");
                fw = new FileWriter(f, true);
            } catch (IOException e) {
            	e.printStackTrace();
            }
            PrintWriter pw = new PrintWriter(fw);
            pw.println("��ȷ:"+indexC);
            pw.println("����:"+indexW);
            pw.flush();
            try {
                fw.flush();
                pw.close();
                fw.close();
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }