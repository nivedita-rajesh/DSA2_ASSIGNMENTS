import java.util.Scanner;

public class KMP
{
	String SubPat="";
	int IND=0;
	int Lps=0;
	void Index(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
        int lps[] = new int[M]; 
        
        LPS(pat); 
        int i = 0;
        int j = 0;
        
        while (i < N) 
        { 
            if (pat.charAt(j) == txt.charAt(i))
            { 
                j++; 
                i++; 
            } 
            if (j == M) 
            { 
            	IND=i-j; 
                j = lps[j - 1]; 
                break;
            } 
  
            else
            if (i < N && pat.charAt(j) != txt.charAt(i)) 
            { 
                if (j != 0) 
                    j = lps[j - 1]; 
                else
                    i = i + 1; 
            } 
        } 
    } 
  
    void LPS(String pat) 
    { 
    	
    	int n=pat.length();
        int len = 0; 
        int i = 1; 
        int lps[]=new int[n];
        lps[0] = 0; 
  
        while (i < n) 
        { 
            if (pat.charAt(i) == pat.charAt(len))
            { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else 
            { 
                if (len != 0)
                { 
                    len = lps[len - 1]; 
                } 
                else 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
        int res=0;
		int c=0;
		for(int k=0;k<n;k++)
		{
			if(lps[k]==0)
			{
				c++;
			}
		}
		res=n-c;
		Lps=res;
	}
    
	int LongestSub(String txt, String pat)
    {
		int resLen=0;
		boolean f=false;
		int n=pat.length();
		String sub="";
		LPS(pat);
		int rl=Lps;
		int j=0;
		
		for(int i=0;i<=n;i++)
		{
			sub=pat.substring(0,i);
			if(txt.contains(sub))
			{
				f=true;
				SubPat=sub;
				resLen=sub.length();
			}
		}
	
		if(f==true)
		{
			return resLen;
		}
		else
		{
			return 0;
		}
       
    }
	public static void main (String[] args)
    {
		KMP K = new KMP();
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String sT=in.nextLine();
	        String sP =in.nextLine();
	        sT=sT.toLowerCase();
	        sP=sP.toLowerCase();
	        int LpS,Lsub;
	        K.LPS(sP);
	        LpS=K.Lps;
	        Lsub=K.LongestSub(sT, sP); 
	        if(Lsub!=0)
	        	K.Index(K.SubPat, sT);
	        else
	        	K.IND=-1;
	        
	        System.out.println(LpS+" "+Lsub+" "+K.IND);
	        K.IND=0;
	        K.Lps=0;
	        K.SubPat="null";
	   }
       in.close();
     }
}
