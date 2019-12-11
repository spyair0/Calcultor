package com.example.andriod;
import android.util.Log;
import java.util.Stack;
public class Expression {
    public static StringBuffer toPostfix(String infix){
        Stack<String> stack = new Stack<String>();
        StringBuffer postfix = new StringBuffer(infix.length()*2);
        int i = 0;
        while(i<infix.length()){
            char ch = infix.charAt(i);
            switch(ch){
                case'+':case'-':
                    while(!stack.isEmpty()&&!stack.peek().equals("("))
                        postfix.append(stack.pop());
                    stack.push(ch+"");
                    i++;
                    break;
                case'×':case'÷':case'^': case'!': case'%':
                    while(!stack.isEmpty()&&(stack.peek().equals("×")||stack.peek().equals("÷")||stack.peek().equals("^")
                            ||stack.peek().equals("!")||stack.peek().equals("%")))
                        postfix.append(stack.pop());
                    stack.push(ch+"");
                    i++; break;
                case'(':
                    stack.push(ch+"");
                    i++; break;
                case')':
                    String out = stack.pop();
                    while(out!=null&&!out.equals("(")){
                        postfix.append(out);
                        out = stack.pop();
                    }
                    i++;
                     break;
                default:
                    while(i<infix.length()&&ch>='0'&&ch<='9'||i<infix.length()&&ch=='.'){
                        postfix.append(ch);
                        i++;
                        if(i<infix.length())
                            ch = infix.charAt(i);
                    }
                    postfix.append(" ");
            }
        }
        while(!stack.isEmpty())
            postfix.append(stack.pop());
        return postfix;
    }
    public static Double toValue(StringBuffer postfix){
        Stack<Double> stack = new Stack<Double>();
        double value = 0;
        for(int i =0;i<postfix.length();i++){
            char ch = postfix.charAt(i);
            if(ch>='0'&&ch<='9'){
                value = 0;
                String sum="";
                while(ch!=' '){
                    sum+=ch;
                    ch = postfix.charAt(++i);
                }
                stack.push(Double.valueOf(sum));
            }
            else
            if(ch!=' '){
                double y = 0,x = 0;
                if(!stack.empty()) y=stack.pop();
                if(!stack.empty()) x = stack.pop();
                switch(ch){
                    case'+':value = x+y; break;
                    case'-':value = x-y; break;
                    case'×':value = x*y; break;
                    case'÷':value = x/y; break;
                    case'^':
                        if(y==2){
                          value=x*x;
                          break;
                        }else if(y==3){
                            value=x*x*x;
                            break;
                        }
                    case'!':
                        double sum=1;
                        for(double j=y;j>=1;j--){
                            sum=j*sum;
                        }
                        value=sum;
                        break;
                    case'%':
                        if(x==0){
                        value=y/100;
                        break;
                        }
                        else
                            value=x/y;
                        break;
                }
                stack.push(value);
            }
        }
        return stack.pop();
    }

}
