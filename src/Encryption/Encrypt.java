package Encryption;
public class Encrypt 
{
    static char DB2[][]=new char[10][9];
    
    /*
     * The algorithm is pretty simple.Suppose the message is 'ABC'.
     STEP 1:CBA(Reverse the message)
     STEP 2:XYZ
     STEP 3:880890900(Respective ASCII values)
     STEP 4:088098009(Each set of to digit no. is reversed individually)
     STEP 5:i.2V8<MBd(Each number map to a particular row in the 2-d array DB2[][],
     * & each row contains unique symbols,& and one of the symbol is selected randomly)
     */
    String Encrypt_l1(String a)
    {
        String temp="";
        int len=a.length();
        while(len>0)
        temp=temp+a.charAt(--len);
        return temp;
    }
    String Encrypt_l2(String a)
    {
        String temp="";
        int len=a.length(),A=0,i=0;
        while(i<len)
        {
            A=(int)(a.charAt(i++));
            if(A<100)
                temp=temp+"0"+A;
            else
                temp=temp+A;
        }
        return temp;
    }
    String Encrypt_l3(String a)
    {
        a=Encrypt_l1(a);
        String temp="",res="";
        int len=a.length(),i=0,x=0;
        while(i<len)
        {
            temp=""+a.charAt(i);
            x=Integer.parseInt(temp);
            x=x+7;   //7 is an arbitary no. given by the designer 
            if(x>=10)
                x=x-10;
            res=res+x;
            x=0;temp="";i++;
        }
        return res;
        
    }
    String Encrypt_l4(String a)
    {
        String temp="",t="";
        int len=a.length(),i=0,k=0;
        while(len>i)
        {
        t=""+a.charAt(i++);
        k=Integer.parseInt(t);
        int n=(int)(Math.random()*100);
        temp=temp+DB2[k][n%9];
        t="";
        }
        return temp;
    }
    public static void assign()
    {
        
        int t=33;
        for(int i=0;i<9;i++)
            for(int j=0;j<10;j++)
            {
                DB2[j][i]=(char)t;
                t++;
            }
    }
    public String Encrypt(String a)
    {
        
        Encrypt e=new Encrypt();
        String temp=a;
        assign();
        temp=e.Encrypt_l1(temp);
        temp=e.Encrypt_l2(temp);
        temp=e.Encrypt_l3(temp);
        temp=e.Encrypt_l4(temp);
        return temp;
    }
    
}