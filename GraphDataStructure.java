import java.util.Scanner;

public class U4AIE20153_DSA2_A6
{
	int M[][],no;
	void Option1(int vertex)
	{
		int count=0;
		for(int i=0;i<no;i++)
		{
			if(M[vertex-1][i]!=0)
			{
				count++;
			}
		}
		System.out.print(count+" ");
	}
	
	void Option2(int r,int c)
	{
		System.out.print(M[r-1][c-1]+" ");
	}
	
	void Option3()
	{
		int count=0;
		for(int i=0;i<no;i++)
		{
			for(int j=0;j<no;j++)
			{
				if(i>j)
				{
					if(M[i][j]!=0)
					{
						count++;
					}
				}
			}
		}
		System.out.print(count);
	}
	
	void Option4()
	{
		int sum=0;
		for(int i=0;i<no;i++)
		{
			for(int j=0;j<no;j++)
			{
				if(i>j)
				{
					if(M[i][j]!=0)
					{
						sum=sum+M[i][j];
					}
				}
			}
		}
		System.out.print(sum);
	}
	
	void Option5()
	{
		for(int i=0;i<no;i++)
		{
			for(int j=0;j<no;j++)
			{
				if(i<j)
				{
					if(M[i][j]!=0)
					{
						System.out.print((i+1)+" "+(j+1)+" "+M[i][j]+"\n");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		U4AIE20153_DSA2_A6 G=new U4AIE20153_DSA2_A6();
		Scanner in =new Scanner(System.in);
		int n;
		n=in.nextInt();
		G.no=n;
		G.M=new int[n][n];
		String str;
		int opt;
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			int r=0,c=0,pos=2,Epos=3;
			str=in.nextLine();
			str=str.replace(" ", "");
			char ch[]=new char[str.length()];
			ch=str.toCharArray();
			for(int j=2;j<ch.length;j=j+2)
			{
				r=i;
				c= Integer.parseInt(String.valueOf(ch[pos]))-1;
				G.M[r][c]=Integer.parseInt(String.valueOf(ch[Epos]));
				pos=pos+2;
				Epos=Epos+2;
			}
		}
		int num;
		opt=in.nextInt();
		if(opt==1)
		{
			in.nextLine();
			String s;
			int vert,v=1;
			s=in.nextLine();
			s=s.replace(" ", "");
			char charS[]=new char[s.length()];
			charS=s.toCharArray();
			num=Integer.parseInt(String.valueOf(charS[0]));
			for(int i=0;i<num;i++)
			{
				vert=Integer.parseInt(String.valueOf(charS[v]));
				G.Option1(vert);
				v++;
			}
		}
		
		else
		if(opt==2)
		{
			in.nextLine();
			String s;
			s=in.nextLine();
			s=s.replace(" ", "");
			char charS[]=new char[s.length()];
			charS=s.toCharArray();
			int ro,co,t1=1,t2=2;
			num=Integer.parseInt(String.valueOf(charS[0]));
			for(int y=0;y<num;y++)
			{
				ro=Integer.parseInt(String.valueOf(charS[t1]));
				co=Integer.parseInt(String.valueOf(charS[t2]));
				G.Option2(ro, co);
				t1=t1+2;t2=t2+2;
			}
			
		}
		
		else
		if(opt==3)
		{
			G.Option3();
		}
		
		else
		if(opt==4)
		{
			G.Option4();
		}
		
		else
		if(opt==5)
		{
			G.Option5();
		}
		
		in.close();
	}
}
