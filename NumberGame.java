import java.io.*;
import java.util.*;


public class NumberGame
{
	static void game(ArrayList<Integer> digits,int n)
	{
		int index=0,flag=0,val,max;
		String s="";
		for(int i=n-1;i>0;i--)
		{
			if(digits.get(i)<digits.get(i-1))
			{
				index=i;
				flag=1;
				break;
			}
		}
		
		if(flag!=1)
		{
			flag=-1;
			System.out.println("-1");
		}
		
		if(flag!=-1)
		{
			val=digits.get(index-1);
            max=index;
            int diff=val-digits.get(index);
            int diff1=0;
            for(int j=index+1;j<n;j++) 
            {
                diff1=val-digits.get(j);
                if(diff1<diff && diff1>0)
                {
                    diff=diff1;
                    max=j;
                }
            }
			Collections.swap(digits, max,index-1);
            Collections.sort(digits.subList(index,n));
            Collections.reverse(digits.subList(index, n));
            
            for (Integer x : digits) 
            {
                s += x.toString();
            }
            System.out.println(s);
            
		 }
	}
											
	public static void main(String[] args) 
    {
		Scanner in= new Scanner(System.in);
		
		int t,n,num;
		t=in.nextInt();
		for(int i=0;i<t;i++)
		{
			ArrayList<Integer> Digits=new ArrayList<Integer>();
			n=in.nextInt();
			for(int j=0;j<n;j++)
			{
				num=in.nextInt();
				Digits.add(num);
			}
			game(Digits,n);
		}
		in.close();
    }
}