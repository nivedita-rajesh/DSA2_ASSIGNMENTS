import java.util.Scanner;

public class QuickUnionUF 
{
    int[] parent;
    int[] child;

    int FindCount;
    public QuickUnionUF(int nn)
    {
        parent = new int[nn];
        child = new int[nn];
        for (int i = 0; i < nn; i++)
        {
            parent[i] = i;
            child[i] = 1;
        }
    }

    public int find(int p) 
    {
    	FindCount=0;
        while (p != parent[p])
        {
        	p = parent[p];
        	FindCount++;
        }
        return p;
    }
    
    public void Union(int p, int q) 
    {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;

        if (child[i] < child[j]) 
        {
            parent[i] = j;
            child[j] += child[i];
        } 
        else
        if(child[i]==child[j])
        {
        	if(i>j)
        	{
        		parent[j] = i;
                child[i] += child[j];
        	}
        	else
        	{
        		parent[i] = j;
                child[j] += child[i];
        	}
        }
        else
        {
            parent[j] = i;
            child[i] += child[j];
        }
    }
    
    void optN(int[] givenArr)
    {
    	int count=1, findArr[];
    	findArr=new int[givenArr.length];
    	for(int i=0;i<givenArr.length;i++)
    	{
    		findArr[i]=find(givenArr[i]);
    	}
    	
        for (int k = 1; k <givenArr.length; k++)
        {
            int j = 0;
            for (j = 0; j < k; j++)
                if (findArr[k] == findArr[j])
                    break;
            if (k == j)
                count++;
        }
    	System.out.println(count);
    }
    
    void optZ(int num,int[] zarr,int[] ZARR)
    {
    	int flag,count;
    	for(int i=0;i<num;i++)
    	{
    		count=0;
    		flag=find(zarr[i]);
    		for(int j=0;j<ZARR.length;j++)
    		{
    			if(find(ZARR[j])==flag)
    				count++;
    		}
    		System.out.print(count+" ");
    	}
    }
    
    void optF(int num,int[] faar)
    {
    	for(int i=0;i<num;i++)
    	{
    		System.out.print(find(faar[i])+" ");
    	}
    }
    
    void optD(int num,int[] daar)
    {
    	for(int i=0;i<num;i++)
    	{
    		find(daar[i]);
    		System.out.print(FindCount+" ");
    	}
    }
    
    void optS(int num,int[] saar,int uni[])
    {
    	int flagS, depthS,count;
    	int flagU,depthU;
    	for(int i=0;i<num;i++)
    	{
    		flagS=find(saar[i]);
    		depthS=FindCount;
    		count=0;
    		for(int j=0;j<uni.length;j++)
    		{
    			flagU=find(uni[j]);
    			depthU=FindCount;
    			if(flagS==flagU && depthS==depthU)
    			{
    				count++;
    			}
    		}
    		System.out.print(count-1+" ");
    	}
    }
    public static void printSets(int[] universe, QuickUnionUF ds)
    {
    	int arr[]=new int[universe.length]; int count=0;
        for (int i=0;i<universe.length;i++)
        {
            System.out.print(ds.find(i) + " ");
            arr[count]=ds.find(i);
        	//count++;
        }}
    public static void main(String[] args) 
    {
        QuickUnionUF uf = new QuickUnionUF(200);
        Scanner in = new Scanner(System.in);
        int n;
        n=in.nextInt();
        int UFArr[]=new int[n];
		
        for(int i=0;i<n;i++)
		{
			UFArr[i]=in.nextInt();
		}
		
        int m=in.nextInt();
		int mj=2*m;
		//System.out.println(mj);
		int arr[]=new int[mj];
		
		for(int j=0;j<mj;j++)
		{
			arr[j]=in.nextInt();
		}
		for(int k=0;k<mj-1;k=k+2)
		{
			uf.Union(arr[k],arr[k+1]);
		}
       
		char ch;
		ch=in.next().charAt(0);
		
		if(ch=='N')
		{
			uf.optN(UFArr);
		}
		else
		if(ch=='Z')
		{
			int num;
	    	num=in.nextInt();
	    	int zarr[]=new int[num];
	    	for(int i=0;i<num;i++)
	    	{
	    		zarr[i]=in.nextInt();
	    	}
	    	uf.optZ(num,zarr,UFArr);
		}
		else
		if(ch=='F')
		{
			int num,faar[];
			num=in.nextInt();
			faar=new int[num];
			
			for(int i=0;i<num;i++)
			{
				faar[i]=in.nextInt();
			}
			uf.optF(num, faar);
		}
		else
		if(ch=='D')
		{
			int num,daar[];
			num=in.nextInt();
			daar=new int[num];
			
			for(int i=0;i<num;i++)
			{
				daar[i]=in.nextInt();
			}
			uf.optD(num, daar);
		}
		else
		if(ch=='S')
		{
			int num,saar[];
			num=in.nextInt();
			saar=new int[num];
			
			for(int i=0;i<num;i++)
			{
				saar[i]=in.nextInt();
			}
			uf.optS(num, saar,UFArr);
		}
		
		printSets(arr, uf);
        in.close();
     }
}
