import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
public class demo
{
     public static void main(String[] args)throws IOException
	 {
	     FileWriter fw =new FileWriter("contactlist.txt");
         Scanner sc =new Scanner(System.in);
         contactlist[]	l =new contactlist[129];
		 for(int i=1;i<=128;i++)
		     l[i]=new contactlist();
	     fucking.login();
	     fucking.select(l);
	     while(true)
	     {
	         System.out.println("�i�J�D���п�J0");
			 System.out.println("���}���t�νп�J1");
	         int a=sc.nextInt();
			
			 if(a==0)
			     fucking.select(l);
	         if(a==1)
		     {
			     for(int i=1;i<=fucking.count-1;i++)
			     {
				     String c="�W�r:"+l[i].list_name+" �q�ܸ��X:"+l[i].list_phonenumber+" ����:"+l[i].list_category+" e-mail:"+l[i].list_email+" �ͤ�:"+l[i].list_birthday+"\r\n";
				     fw.write(c);
			     } 
			     fw.close();
				 fucking.list_exit();
		     }
	     }

    }
}
