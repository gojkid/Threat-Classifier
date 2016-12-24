package Encryption;
public class Decrypt extends Encrypt 
{
    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    static char DB2[][]=new char[10][9];
    /*
     * The decryption is pretty simple.Suppose the encrypted message is     i.2V8<MBd
     STEP 1:088098009(Each number map to a particular row in the 2-d array DB2[][],
            & one of the row contains that particular symbol)
     STEP 2:880890900(Each set of to digit no. is reversed individually)
     STEP 3:XYZ(Respective ASCII values)
     STEP 4:CBA
     STEP 5:ABC(Reverse the string)
     */
    String Decrypt_l4(String a)
    {
        String temp="";
        char c;
        int len=a.length(),i=0,j=0,k=0;
        while(i<len)
        {
            c=a.charAt(i++);
            for(k=0;k<10;k++)
                for(j=0;j<9;j++)
                if(c==DB2[k][j])
            {
                temp=temp+k;
                k=10;j=9; 
            }
        }
        return temp;
    }
    String Decrypt_l3(String a)
    {
        String t="",n="";
        a=super.Encrypt_l1(a);
        int len=a.length(),i=0,x=0;
        while(i<len)
        {
            n=""+a.charAt(i);
            x=Integer.parseInt(n);
            x=x-7;//7 is an arbitary no. given by the designer 
            if(x<0)
            x=x+10;
            t=t+x;
             x=0;n="";i++;
        }
        return t;
    }
    String Decrypt_l2(String a)
    {
        String temp="";
        char c;
        int len=a.length(),i=0,t=0;
        while((i+3)<=len)
        {
            t=Integer.parseInt(a.substring(i,i+3));
            c=(char)t;
            temp=temp+c;
            i=i+3;
        }
        return temp;
    }
    String Decrypt_l1(String a)
    {
        return super.Encrypt_l1(a);
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
    public String Decrypt(String a)
    {
        Decrypt d=new Decrypt();
        String temp=a;
        assign();
        temp=d.Decrypt_l4(temp);
        temp=d.Decrypt_l3(temp);
        temp=d.Decrypt_l2(temp);
        temp=d.Decrypt_l1(temp);
        return temp;
    }
}