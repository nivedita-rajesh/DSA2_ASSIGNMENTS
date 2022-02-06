import java.util.*;
public class SpellCorrection
{
	static Hashtable<String, Integer> ht = new Hashtable<>();
	int count=0,c=0;
	boolean f=false;
	
	void add(String s,int i)
	{
		ht.put(s,i);
	}
	
	void del(String s)
	{
		ht.remove(s);
	}
	
	void find(String str[],int p)
	{
		for(int l=0;l<p;l++)
		{
			if(ht.containsKey(str[l]))
			{
				System.out.print("Y"+" ");
			}
			else
			{
				replace(str[l]);
				insert(str[l]);
				delete(str[l]);
				swapping(str[l]);
				insSpace(str[l]);
				c=count;
				System.out.print(c+" ");
				count=0;
			}
		}
	}
	void replace(String s)
	{
		char ch;
		String str=s;
        for(int j=0;j<str.length();j++)
        {
            for(ch = 'a'; ch <= 'z'; ++ch)
            {
            	str=str.substring(0,j)+ch+str.substring(j);
                if(ht.containsKey(str))
                {
                    count++;
                }str=s;
            }
        }
        
        for(ch = 'a'; ch <= 'z'; ++ch)
        {
            if(ht.containsKey(str+ch))
            {
                count++;
            }
        }
	}
	
	void insert(String s)
	{
		String str=s;
		char ch;
        for(int i=0;i<str.length();i++)
        {
            for(ch = 'a'; ch <= 'z'; ++ch)
            {
               str=str.substring(0,i)+ch+str.substring(i+1);
               if(ht.containsKey(str))
                {
                    count++;
                }str=s;
            }
        }
    }
	
	void delete(String s)
	{
		String str=s;
		for(int i=0;i<s.length();i++)
		{
			str=str.substring(0, i)+str.substring(i+1);
			if(ht.containsKey(str))
			{
				count++;
			}
			str=s;
		}
	}
	
	void swapping(String s)
	{
		String str=s;
		for(int i=0;i<s.length()-1;i++)
		{
			char cstr[]=str.toCharArray();
			char temp=cstr[i];
			cstr[i]=cstr[i+1];
			cstr[i+1]=temp;
			
			str=String.valueOf(cstr);
			if(ht.containsKey(str))
			{
				count++;
			}
			str=s;
		}
	}
	
	void insSpace(String s)
	{
		String str=s;
		String s1,s2;
        for(int i=1;i<str.length();i++)
        {
            s1=str.substring(0, i);
            s2=str.substring(i, str.length());
            if(ht.containsKey(s1) && ht.containsKey(s2))
            {
                count++;
            }
        }
	}
	
	
	public static void main(String[] args)
	{
		Scanner in =new Scanner(System.in);
		SpellCorrection sp=new SpellCorrection();
		char ch;
		String st;
		 
		
		for(int i=0;i<3;i++)
		{
			ch=in.next().charAt(0);
			if(ch=='A')
			{
				int m=in.nextInt();
				for(int j=1;j<=m;j++)
				{
					st=in.next();
					sp.add(st,j);
				}
			}
			else
			if(ch=='D')
			{
				int n=in.nextInt();
				for(int j=1;j<=n;j++)
				{
					st=in.next();
					sp.del(st);
				}
			}
			else
			if(ch=='F')
			{
				int p=in.nextInt();
				String str[]=new String[p];
				for(int k=0;k<p;k++)
				{
					str[k]=in.next();
					
				}
				sp.find(str, p);
			}
		}
		in.close();
	}
}
