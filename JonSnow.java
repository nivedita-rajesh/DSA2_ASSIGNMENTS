import java.util.Scanner; 
public class JonSnow
{
	static void attack(int a, int b,int c)
	{
		
		int cut;
		cut=a+b+c;
		if(a==0||b==0||c==0)
		{
			System.out.println("0");
		}
		else
		 if(cut%9==0 && a>(cut/7)-1 && b>(cut/7)-1 && c>(cut/7)-1)
		 {
			 System.out.println("1");
		 }
		/* else
		 if(cut%9==0 && a<(cut/7)-1 && b<(cut/7)-1 && c<(cut/7)-1)
		 {
			 System.out.println("0");
		 }*/
		 else
		 {
			 System.out.println("0");
		 }
	}
	
	public static void main(String[] args)
	{
		Scanner in= new Scanner(System.in);
		int t,a[],b[],c[];
		
		t=in.nextInt();
		a=new int[t];
		b=new int[t];
		c=new int[t];
		for(int i=0;i<t;i++)
		{
			a[i]=in.nextInt();
			b[i]=in.nextInt();
			c[i]=in.nextInt();
			
		}
		for(int i=0;i<t;i++)
		{
			attack(a[i],b[i],c[i]);
		}
	
		
	}

}
