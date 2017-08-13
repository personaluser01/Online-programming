//formatted solution

//Problem 1726

import java.util.*;
import java.lang.*;
import java.io.*;
class InToPost {																			//covert the expression into postfix expression
    private Stack theStack;
    private String input;
    private String output = "";
    public InToPost(String in ) {
        input = in ;
        int stackSize = input.length();
        theStack = new Stack(stackSize);
    }
    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            output = output + theStack.pop();
        }

        return output;
    }
    public void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                } else
                    output = output + opTop;
            }
        }
        theStack.push(opThis);
    }
    public void gotParen(char ch) {
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(')
                break;
            else
                output = output + chx;
        }
    }
    class Stack {
        private int maxSize;
        private char[] stackArray;
        private int top;
        public Stack(int max) {
            maxSize = max;
            stackArray = new char[maxSize];
            top = -1;
        }
        public void push(char j) {
            stackArray[++top] = j;
        }
        public char pop() {
            return stackArray[top--];
        }
        public char peek() {
            return stackArray[top];
        }
        public boolean isEmpty() {
            return (top == -1);
        }
    }

}
public class Main {
	static int size;
    public static String union(String s1, String s2) {						//union method
        String s = (s1 + s2);
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i != s.lastIndexOf(c))
                s = s.substring(0, i) + s.substring(i + 1, s.length());
            else i++;
        }
        return s;
    }
    public static String intersect(String s1, String s2) {					//intersection method
        String s = "";
        for (char c: s1.toCharArray()) {
            if (s2.indexOf(c) != -1 && s.indexOf(c) == -1)
                s += c;
        }
        return s;
    }
    public static String difference(String s1, String s2) {					//difference method
        String p = intersect(s1, s2);

        char a[] = p.toCharArray();
        char b[] = s1.toCharArray();
        int size = b.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < size; j++) {
                if (b[j] == a[i]) {
                    for (int k = j; k < size - 1; k++)
                        b[k] = b[k + 1];
                    size--;
                }
            }
        }
        char f[] = new char[size];
        for (int i = 0; i < size; i++)
            f[i] = b[i];
        String o = new String(f);
        return o;


    }




    public static void excute(String p[], int n) {
        Stack ss = new Stack();
        String a1;
        String b1;
        for (int i = 0; i < n; i++) {
            if (p[i].equals("+") || p[i].equals("-") || p[i].equals("*")) {
                char a = p[i].charAt(0);
                switch (a) {
                    case '+':
                        a1 = ss.pop().toString();

                        b1 = ss.pop().toString();

                        ss.push(union(b1, a1));
                        break;
                    case '-':
                        a1 = ss.pop().toString();

                        b1 = ss.pop().toString();

                        ss.push(difference(b1, a1));
                        break;
                    case '*':
                        a1 = ss.pop().toString();
                        b1 = ss.pop().toString();
                        ss.push(intersect(a1, b1));

                        break;
                }
            } else {
                ss.push(p[i]);
            }

        }
        String s23 = ss.pop().toString();
        char ch12[] = s23.toCharArray();
        Arrays.sort(ch12);
        s23 = new String(ch12);
        System.out.println("{" + s23 + "}");

    }
	public static int handle(String s)					//the basic purpose of this function to handle the null operands that are in the expression
	{
		   String s1 = s.replace("+{}", "");
            s1 = s1.replace("(", "");
            s1 = s1.replace(")", "");
            s1 = s1.replace("-{}", "");
            s1 = s1.replace("*{}", "");
            s1 = s1.replace("{}+", "");
            s1 = s1.replace("{}-", "");
            s1 = s1.replace("{}*", "");
            String q1 = s1.replace("{", ",");
            String lol1 = q1.replace("}", ",");
            lol1 = lol1.replace("*", ",*,");
            lol1 = lol1.replace("+", ",+,");
            lol1 = lol1.replace("-", ",-,");
            String a1[] = lol1.split(",");
            int size1 = a1.length;
            for (int i = 0; i < size1; i++) {
                if (a1[i].length() == 0) {
                    for (int j = i; j < size1 - 1; j++)
                        a1[j] = a1[j + 1];
                    size1--;
                }
            }
			            if (size1 == 0)
							return 0;
						else
							return 1;
	}
	public static String[] extract(String output)				//this function used to extract the operands from between { }
	{
		 String q = output.replace("{", ",");				
                String lol = q.replace("}", ",");
                lol = lol.replace("*", ",*,");
                lol = lol.replace("+", ",+,");
                lol = lol.replace("-", ",-,");
                String a[] = lol.split(",");
                size = a.length;
                for (int i = 0; i < size; i++) {
                    if (a[i].length() == 0) {
                        for (int j = i; j < size - 1; j++)
                            a[j] = a[j + 1];
                        size--;
                    }
                }
				return a;
	}
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String s = sc.next();

         
            if (handle(s) == 0) {
                System.out.println("{}");
            } else {
                s = s.replace("+{}", "");						//remove null operands
                s = s.replace("-{}", "");
                s = s.replace("*{}", "");
                s = s.replace("{}+", "");
                s = s.replace("{}-", "");
                s = s.replace("{}*", "");

                InToPost theTrans = new InToPost(s);
                String output = theTrans.doTrans();					//we convert the expression into a postfix expression
                   
                excute(extract(output), size);						//this function do all sets operation
            }
        }
    }
}