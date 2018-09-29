import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculate {
	
    //符号的优先级
   private static final Map<Character, Integer> basic = new HashMap<Character, Integer>();
   static {
       basic.put('-', 1);
       basic.put('+', 1);
       basic.put('*', 2);
       basic.put('÷', 2);
       basic.put('(', 0);
   }
   
	/**
    * 将  中缀表达式  转化为  后缀表达式
    */
   public String tosuffix(String infix){
       List<String> queue = new ArrayList<String>();                                    
       List<Character> stack = new ArrayList<Character>();                             
       
       char[] charArr = infix.trim().toCharArray();                                    
       String standard = "*÷+-()";                                                       
       char ch = '&';                                                                    
       int len = 0;                                                                   
       for (int i = 0; i < charArr.length; i++) {                                        
           
           ch = charArr[i];                                                           
           if(Character.isDigit(ch)) {                                                    
               len++;    
           }else if(ch=='/') {                                            
               len++;
           }else if(ch == '.'){                                                       
               len++;
           }else if(Character.isSpaceChar(ch)) {                                        
               if(len > 0) {                                                            
                   queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i)));    
                   len = 0;                                                            
               }
               continue;                                                                
           }else if(standard.indexOf(ch) != -1) {                                        
               if(len > 0) {                                                            
                   queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i)));   
                   len = 0;                                                            
               }
               if(ch == '(') {                                                            
                   stack.add(ch);                                                      
                   continue;                                                            
               }
               if (!stack.isEmpty()) {                                                    
                   int size = stack.size() - 1;                                        
                   boolean flag = false;                                                
                   while (size >= 0 && ch == ')' && stack.get(size) != '(') {           
                       queue.add(String.valueOf(stack.remove(size)));                   
                       size--;                                                            
                       flag = true;                                                    
                   }
                   while (size >= 0 && !flag && basic.get(stack.get(size)) >= basic.get(ch)) {    
                       queue.add(String.valueOf(stack.remove(size)));                   
                       size--;
                   }
               }
               if(ch != ')') {                                                            
                   stack.add(ch);                                                       
               } else {                                                                
                   stack.remove(stack.size() - 1);
               }
           }
           if(i == charArr.length - 1) {                                                
               if(len > 0) {                                                           
                   queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len+1, i+1)));
               }    
               int size = stack.size() - 1;                                           
               while (size >= 0) {                                                        
                   queue.add(String.valueOf(stack.remove(size)));
                   size--;
               }
           }
           
       }
       return queue.stream().collect(Collectors.joining(","));                            
   }
   
   public static ArrayList transform(String prefix) {
	   
       int i, len = prefix.length();
       prefix=prefix+ '#';
       Stack<Character> stack = new Stack<Character>();// 保存操作符的栈
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
               default:// 默认情况下:+ - * /
                   while (stack.peek() != '#'
                           && compare(stack.peek(), prefix.charAt(i))) {
                       postfix.add(stack.pop());// 不断弹栈，直到当前的操作符的优先级高于栈顶操作符
                   }
                   if (prefix.charAt(i) != '#') {// 如果当前的操作符不是'#'(结束符)，那么入操作符栈
                       stack.push(prefix.charAt(i));// 最后的标识符'#'是不入栈的
                   }
                   break;
               }
           }
       }
       return postfix;
   }
   /**
    * 将 后缀表达式 进行  运算 计算出结果
    */
   public String dealequation(String equation){
       String [] arr = equation.split(",");                                    
       List<String> list = new ArrayList<String>();                            
       
       
       for (int i = 0; i < arr.length; i++) {                                   
           int size = list.size();
           switch (arr[i]) {
           case "+": Number a = new Number(list.remove(size-2)).add(new Number(list.remove(size-2))); 
           list.add(a.toString());     
           break;
           case "-": Number b = new Number(list.remove(size-2)).sub(new Number(list.remove(size-2))); 
           list.add(b.toString());     
           break;
           case "*": Number c = new Number(list.remove(size-2)).muti(new Number(list.remove(size-2))); 
           list.add(c.toString());     
           break; 
           case "÷": Number d = new Number(list.remove(size-2)).division(new Number(list.remove(size-2))); 
           list.add(d.toString());    
           break;
           default: list.add(arr[i]);     
           break;                                    
           }
       }
       
       return list.size() == 1 ? list.get(0) : "运算失败" ;                    
   }

}
