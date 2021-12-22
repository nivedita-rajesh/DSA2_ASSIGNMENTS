import java.util.*;

public class U4AIE20153_A5 
{
	static Scanner in =new Scanner(System.in);
    int M[][];
    int Res[][],Mres[][];
    
    public void getMatrix(int R,int C)
    {
        M=new int [R][C];
        int JC[];
        int CP[];
        int IR[];
        int N[];
        String jstr;
        for(int l=0;l<1;l++)
        {
            in.nextLine();
            jstr=in.nextLine();
            jstr=jstr.replace(" ", "");
            JC=new int[jstr.length()];
            for(int f=0;f<jstr.length();f++)
            {
                char ch=jstr.charAt(f);
                int a = Integer.parseInt(String.valueOf(ch));
                JC[f]=a;
            }
            int len=jstr.length()+1;
            CP=new int[len];
            int k,ele=0;
            for(k=0;k<len;k++)
            {
                CP[k]=in.nextInt();
                
            }
            ele=CP[len-1];
            IR=new int[ele-1];
            for(k=0;k<ele-1;k++)
            {
                IR[k]=in.nextInt();
            }
            N=new int[IR.length];
            for(k=0;k<IR.length;k++)
            {
                N[k]=in.nextInt();
            }
            
            int cnt=0;
            for(int s=0;s<JC.length;s++)
            {
                int c=0,r=0;
                c=JC[s];
                int ne=CP[s+1]-CP[s];
                for(int d=0;d<ne;d++)
                {
                    r=IR[cnt];
                    M[r-1][c-1]=N[cnt];
                    cnt++;
                }
            }
            
        }
    }

    void transpose(int M[][],int MT[][],int R,int C)
    {
        int i, j;
        for (i = 0; i < C; i++)
        {
        	for (j = 0; j < R; j++)
        	{
                    MT[i][j] = M[j][i];
        	}
        }
        
        Res=MT;
    }
    
    void multiplyMatrix(int rb, int cb, int Bt[][],int ra, int ca, int At[][])
    {
         int i, j, k;
         int s=0,n=0;
         if (ra != cb) 
         {
             return;
         }
         int res[][] = new int[rb][ca];
         
         for (i = 0; i < rb; i++) 
         {
              for (j = 0; j < ca; j++) 
              {
                  for (k = 0; k < ra; k++)
                  {
                      res[i][j] += Bt[i][k] * At[k][j];
                  }
              }
         }
      
         for (i = 0; i < rb; i++) 
         {
              for (j = 0; j < ca; j++) 
              {
                  {
                      if(res[i][j]!=0)
                      {
                          s=s+res[i][j];
                          n++;
                      }
                  }
              }
         }
         System.out.print(n+" ");
         System.out.print(s+" ");
    }
    
    void prd(int rb, int cb, int Bt[][],int ra, int ca, int At[][])
    {
        int cnt=0,i,j; 
        int res[][]=new int[rb][ca];
        ArrayList<Integer> nz =new ArrayList <Integer>();
        
        while(cnt<cb)
        {
            for (i = 0; i < rb; i++) 
            {
                  for (j = 0; j < ca; j++) 
                  {
                     {
                          res[i][j]=0;
                     }
                  }
            }
            
            for (i = 0; i < rb; i++) 
            {
                 for (j = 0; j < ca; j++) 
                 {
                     for (int k = 0; k < ra; k++)
                     {
                         res[i][j] = Bt[i][cnt] * At[cnt][j];
                     }
                 }
            }
   
            int ed=0;
            for ( int k = 0; k <rb; k++) 
             {
                  for (int  l = 0; l <ca; l++) 
                  {
                      if(res[k][l]!=0)
                      {
                         ed++;
                      }
                      
                  }
             }
             if(ed!=0)
            	 nz.add(ed);
             
             cnt++;
        }
        
        System.out.print(nz.size()+" ");
        for (Integer w : nz) 
        {
            System.out.print(w+" ");
        }
        
    }
    
    public static void main (String[] args)
    {
        
        U4AIE20153_A5 Ma = new U4AIE20153_A5();
        int m,n,p;
        m=in.nextInt();
        n=in.nextInt();
        p=in.nextInt();
        
        int A[][]=new int[m][n];
        int B[][]=new int[n][p];
        int AT[][]=new int[n][m];
        int BT[][]=new int[p][n];
        Ma.getMatrix(m,n);
        A=Ma.M;
        Ma.getMatrix(n,p);
        B=Ma.M;
        
        Ma.transpose(A,AT, m, n);
        AT=Ma.Res;
        Ma.transpose(B,BT, n, p);
        BT=Ma.Res;
        Ma.prd(p, n, BT, n, m, AT);
        Ma.multiplyMatrix(p, n, BT,n, m, AT );
        in.close();
    }
}
