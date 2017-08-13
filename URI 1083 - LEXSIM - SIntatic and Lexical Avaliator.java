//Formatted Solution


//Problem 1083
import java.io.*;
import java.util.*;
import java.lang.*;
class InToPost 
	{
		private Stack theStack;
		private String input;
		private String output = "";
		public InToPost(String in) {
		input = in;
		int stackSize = input.length();
		theStack = new Stack(stackSize);
	}
	public String doTrans()
	{
      for (int j = 0; j < input.length(); j++) 
	  {
         char ch = input.charAt(j);
         switch (ch) {
		 case '^':
			gotOper(ch,6);
			break;
		case '*':
		case '/':
			gotOper(ch,5);
			break;
		case '+':
		case '-':
			gotOper(ch,4);
			break;
		case '>':
		case '<': 
		case '=':
		case '#':
			gotOper(ch,3);
			break;
		case '.':
			gotOper(ch, 2);
		    break;
		case '|':
			gotOper(ch, 1);
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
         }
         else {
            int prec2;
            if(opTop == '^')
			 prec2 =  6;
		else if (opTop == '*' || opTop == '/')
			prec2 =  5;
		else if (opTop == '+' || opTop == '-')
			prec2 =  4;
		else if (opTop == '>' || opTop == '<' || opTop == '=' || opTop == '#')
			prec2 =  3;
		else if (opTop == '.')
			prec2 = 2;
			else prec2 = 1;
		
            if (prec2 < prec1) { 
               theStack.push(opTop);
               break;
            }
		    else
            output = output + opTop;
         }
      }
      theStack.push(opThis);
   }
   public void gotParen(char ch){ 
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
public class Main
	{
		public static boolean SyntaxError(String infix)			//Checking for SyntaxError
			{
				int n=infix.length();
		
				String line=infix;
				int count = line.length() - line.replace("(", "").length();		//check for Number of "("
				String line2=infix;
				int count2 = line2.length() - line2.replace(")", "").length();	//check for Number of ")"
	
				int noerror=1;
				if(count==count2)
					noerror=0;													//if both count equal then no error
				char d[]=infix.toCharArray();
				int count1=0,error=0;
		
				for(int i=0;i<n-1;i++)											//checking for two consecutive operators and operands 
					{ 
						int x2=d[i];
						int x1=d[i+1];
						char ch1=d[i];
						char ch2=d[i+1];
						if(d[i]=='+'|| d[i]=='-'|| d[i]=='^' || d[i]=='*' || d[i]=='/' || d[i]=='>' || d[i]=='<' || d[i]=='=' || d[i]=='#' || d[i]=='.' || d[i]=='|')
							{
								if(d[i+1]=='+'|| d[i+1]=='-'|| d[i+1]=='^' || d[i+1]=='*' || d[i+1]=='/' || d[i+1]=='>' || d[i+1]=='<' || d[i+1]=='=' || d[i+1]=='#' || d[i+1]=='.' || d[i+1]=='|')
									count1++;
							}
						if( (ch1>='a' && ch1<='z') || (ch1>='A' && ch1<= 'Z') || (ch1>='0' && ch1<='9') )
							{
								if( (ch2>='a' && ch2<='z') || (ch2>='A' && ch2<= 'Z') || (ch2>='0' && ch2<='9') )
									error++;
							}
					}
						if(error>0 || noerror!=0 || count1>0)					//if any error found send true
							return true;
						else
							return false;
			}
	public static boolean LexicalError(String infix)							//checking for LexicalError
		{
			String testing=infix;
			String a[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};   //set of Characters
			String b[]={"+","-","^","*","/",">","<","=","#",".","|"};																//set of operators
			String c[]={"0","1","2","3","4","5","6","7","8","9"};																	//set of numbers
		
	
			for(int i=0;i<26;i++)
				{  
					testing=testing.replace(a[i],"");									//delete all characters from expression
				}
			for(int i=0;i<26;i++)
				{ 
					testing=testing.replace(a[i].toLowerCase(),"");
				}
			for(int i=0;i<11;i++)
				{
					testing=testing.replace(b[i],"");									//delete all operators from expression
				}
			for(int i=0;i<10;i++)
				{
					testing=testing.replace(c[i],"");									//delete all numbers from expression
				}
			testing=testing.replace("(","");											//delete all small brackets from expression
			testing=testing.replace(")","");
			if(testing.length()!=0)													//if after deleting all if anything left in expression it means its a LexicalError.
				return true;
			else
				return false;
		}
	public static void main(String arg[])
		{
			Scanner sc=new Scanner(System.in);
	
			while(sc.hasNext())
				{
					String infix;
	 
					infix=sc.next();
		
					if(LexicalError(infix))
						System.out.println("Lexical Error!");
					else if(SyntaxError(infix))
						System.out.println("Syntax Error!");
					else
					{
						InToPost t=new InToPost(infix);
						System.out.println(t.doTrans());
					}
				}
		}
	}