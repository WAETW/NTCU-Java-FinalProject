import java.util.*;
import java.text.*;
public class fucking
{
     public static int count=1,display=0,sort=0;
	 public static int list_birthday;
	 public static boolean login()
	 {
	     String account,password;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.print("�n�J�b��:");
		 account=sc.next();
		 System.out.print("�n�J�K�X:");
		 password=sc.next();
		 System.out.println("==============================================");
		 if(!account.equals("cis"))
		 {
		     System.out.println("�b�����~!!!!!!!!!!!!");
			 System.exit(0);
		 }
		 if(!password.equals("1234"))
		 {
		     System.out.println("�K�X���~!!!!!!!!!!!!");
			 System.exit(0);
		 }
		 return true;
	 }
	 public static void select(contactlist[] l)
	 {
	     Scanner sc = new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("��ܵn�J�v��:");
		 System.out.println("�Τ�ݽп�J0 "); 
		 System.out.println("�޲z�ݽп�J1");
         int s=sc.nextInt();
		 System.out.println("==============================================");
		 if(s==0)		 
		 {
		     set_user(l);
		 }
		 else if(s==1)
		 {
		     set_admin(l);
		 }
		 else
		 {
		     System.out.println("87�����A�ݿﶵ�F�A�٥���!");
			 select(l);
		 }
	 }
	 public static void set_user(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("��ܼҦ�:");
		 System.out.println("��^�W�@���п�J0");
		 System.out.println("�s�W�h����ƽп�J1");
		 System.out.println("�R���@����ƽп�J2");
		 System.out.println("��ܩҦ���ƽп�J3");
		 System.out.println("�̹q�ܬd�߸�ƽп�J4");
		 System.out.println("�̩m�W�d�߸�ƽп�J5");
		 System.out.println("��ܬۦP��������ƽп�J6");
		 System.out.println("�ק�@����ƽп�J7");
		 System.out.println("�̥ͤ�(���)�ƦC���(�w�]���j��p)�п�J8");
		 System.out.println("������ܽп�J9");
		 int a=sc.nextInt();
		 System.out.println("==============================================");	 
		 switch (a)
		 {
			 case 0:select(l);
			 case 1:create_data(l);break;
			 case 2:delete_data(l);break;
			 case 3:displaymode(l);break;
			 case 4:search_data_number_display(l);break;
			 case 5:search_data_name_display(l);break;
			 case 6:search_data_category_display(l);break;
			 case 7:change_data(l);break;
			 case 8:sort_birth(l);displaymode(l);break;
			 case 9:page(l);break;
			 default :System.out.println("87�����A�ݿﶵ�F�A�٥���!");
			          set_user(l);break;         
		 }
	 }
	 public static void set_admin(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("��ܼҦ�:");
		 System.out.println("��^�W�@���п�J0");
		 System.out.println("��ܭ��@��п�J1");
		 System.out.println("�ƦC���ǽп�J2");
		 System.out.println("��ܲ{�b�ɶ�3");
		 int a=sc.nextInt();
		 System.out.println("==============================================");	 
		 switch(a)
		 {
			 case 0:select(l);break;
			 case 1:select_display_mode(l);break;
			 case 2:select_sort(l);break;
			 case 3:getDate(l);break;
			 default:System.out.println("87�����A�ݿﶵ�F�A�٥���!");
			         set_admin(l);break;
		 }
	 }
	 public static void create_data(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.print("�n��J�X�����:");
		 int a =sc.nextInt();
		 for(int i=count,j=1;j<=a;j++,i++)
		 {
			 
			 System.out.print("�m�W:");String name=sc.next();System.out.println();
			 System.out.print("�q�ܸ��X:");String phonenumber=sc.next();System.out.println();
			 while(!contactlist.check_phone(phonenumber))
			 {
				 System.out.println("�q�ܮ榡���~!!!!");
			     System.out.print("�q�ܸ��X:");phonenumber=sc.next();System.out.println();
			 }
			 System.out.print("����:");String category=sc.next();System.out.println();
			 System.out.print("e-mail:");String email=sc.next();System.out.println();
			 while(!contactlist.check_email(email))
			 {
				 System.out.println("email�榡���~!!!!");
			     System.out.print("e-mail:");email=sc.next();System.out.println();
			 }
			 System.out.print("�ͤ�:");String birthday=sc.next();System.out.println();
			 while(!contactlist.check_birth(birthday))
			 {
				 System.out.println("�ͤ�榡���~!!!!");
			     System.out.print("�ͤ�:");birthday=sc.next();System.out.println();
			 }
			 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		     Date date = new Date();
             String strDate = sdFormat.format(date);
			 l[i]=new contactlist(name,phonenumber,category,email,birthday,strDate);
		 }
		 count=count+a;
	 }
	 public static void select_display_mode(contactlist[] l)
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("�п�J��ܼҦ�:");
		 System.out.println("��ܥ�����ƽп�J0");
		 System.out.println("��ܩm�W�п�J1");
		 System.out.println("��ܹq�ܽп�J2");
		 System.out.println("��ܤ����п�J3");
		 System.out.println("���e-mail�п�J4");
		 System.out.println("��ܥͤ�п�J5");
		 for(;;)
         {
			 int a=sc.nextInt();
             if(a>=0 && a<=6)
		     {
			     display=a;break;
		     } 
		     else
			     System.out.println("87�����A�ݿﶵ�F�A�٥���!");
		 }
		 System.out.println("==============================================");	 
	 }
	 public static void displaymode(contactlist[] l)
	 {
		 if(count-1==0)
		 {
			 System.out.println("�o�̨S��������!");
		 }
		 for(int i=1;i<=count-1;i++)
		 {
			 switch(display)
			 {
				 case 0:System.out.println("�m�W:"+l[i].list_name+" �q��:"+l[i].list_phonenumber+" ����:"+l[i].list_category+" e-mail:"+l[i].list_email+" �ͤ�:"+l[i].list_birthday+" �[�J�ɶ�:"+l[i].list_date);break;
			     case 1:System.out.println("�m�W:"+l[i].list_name);break;
			     case 2:System.out.println("�q��:"+l[i].list_phonenumber);break;
			     case 3:System.out.println("����:"+l[i].list_category);break;
			     case 4:System.out.println("e-mail:"+l[i].list_email);break;
			     case 5:System.out.println("�ͤ�:"+l[i].list_birthday);break;
			 }
		 }
		 
	 }
	 public static void display_all_data(contactlist l)
	 {
		 System.out.println("�m�W:"+l.list_name+" �q��:"+l.list_phonenumber+" ����:"+l.list_category+" e-mail:"+l.list_email+" �ͤ�:"+l.list_birthday+" �[�J�ɶ�:"+l.list_date);
	 }
	 public static void search_data_number_display(contactlist... token)
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("==============================================");		 
		 System.out.println("�п�J�d�߹q��:");
		 String listphonenumber=sc.next();
		 int a=search_data_number(listphonenumber,token);
		 if(a>0)
			 display_all_data(token[a]);
		 else
			 System.out.println("�o���q�ܤ��s�b!");
		 System.out.println("==============================================");
	 }
	 public static int search_data_number(String listphonenumber,contactlist... token)
	 {
		 for(int i=1;i<=count-1;i++)
		 {
			 if(listphonenumber.equals(token[i].list_phonenumber))
				 return i;
		 }
		 return -1;
	 }
	 public static void search_data_name_display(contactlist... token)
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("�п�J�d�ߦW�r:");
		 String listname=sc.next();
		 int a=search_data_name(listname,token);
		 if(a>-1)
			 display_all_data(token[a]);
		 else 
			 System.out.println("�o�ӤH���b�W�椤!");
		 System.out.println("==============================================");	 
	 }
	 public static int search_data_name(String listname,contactlist... token)
	 {
		 for(int i=1;i<=count-1;i++)
		 {
			 if(listname.equals(token[i].list_name))
				 return i;
		 }
		 return -1;
	 }
	 public static void search_data_category_display(contactlist[] l)
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("�п�J��ܪ����O:");
		 String listcategory=sc.next();
		 for(int i=1;i<=count;i++)
		 {
			 if(listcategory.equals(l[i].list_category))
				 System.out.println("�m�W:"+l[i].list_name+" �q��:"+l[i].list_phonenumber+" ����:"+l[i].list_category+" e-mail:"+l[i].list_email+" �ͤ�:"+l[i].list_birthday+" �[�J�ɶ�:"+l[i].list_date);
		 }
	 }
	 public static void delete_data(contactlist[] l)
	 {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("==============================================");	 
		 System.out.print("�ХX�J�Q�R�����H�W:");
		 String listname=sc.next();
		 int i=search_data_name(listname,l);
		 if(i==-1)
			 System.out.println("87�o�ӤH���b�A���p��ï���O�n�R�T�p!");
		 else
		 {
			 for(int a=i;a<count-1;a++)
			 {
				 if(i==count-1)
				 {
					 break;
				 }
				 l[a]=l[a+1];
			 }
			 count--;
		 }
		 System.out.println("==============================================");	 
		 
	 }
	 public static void change_data(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("�п�J�n�ק�s���H�m�W:");
		 String a=sc.next();
		 int i=search_data_name(a,l);
		 if(i>0)
		 {
			 System.out.print("�m�W:");String name=sc.next();System.out.println();
			 System.out.print("�q�ܸ��X:");String phonenumber=sc.next();System.out.println();
			 while(!contactlist.check_phone(phonenumber))
			 {
				 System.out.println("�q�ܮ榡���~!!!!");
			     System.out.print("�q�ܸ��X:");phonenumber=sc.next();System.out.println();
			 }
			 System.out.print("����:");String category=sc.next();System.out.println();
			 System.out.print("e-mail:");String email=sc.next();System.out.println();
			 while(!contactlist.check_email(email))
			 {
				 System.out.println("email�榡���~!!!!");
			     System.out.print("e-mail:");email=sc.next();System.out.println();
			 }
			 System.out.print("�ͤ�:");String birthday=sc.next();System.out.println();
			 while(!contactlist.check_birth(birthday))
			 {
				 System.out.println("�ͤ�榡���~!!!!");
			     System.out.print("�ͤ�:");birthday=sc.next();System.out.println();
			 }
			 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		     Date date = new Date();
             String strDate = sdFormat.format(date);
			 l[i]=new contactlist(name,phonenumber,category,email,birthday,strDate);
		 }
		 else
			 System.out.println("�s���H���s�b!");
	 }
	 public static void select_sort(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("==============================================");	
		 System.out.println("�п�ܱƦC�覡:");
		 System.out.println("����Ѥj��p�п�J0");
		 System.out.println("����Ѥp��j�п�J1");
		 for(;;)
		 {
			 int i=sc.nextInt();
			 if(i==0 || i==1)
			 {	 
			     sort=i;break;
			 }
			 else
				 System.out.println("87�����A�ݿﶵ�F�A�٥���!");
		 }
	 }
	 public static void sort_birth(contactlist[] l)
	 {
		 switch(sort)
		 {
		     case 0:
		     {
			     for(int i=1;i<=count-1;i++)
			     {
				     for(int a=1;a<=count-i-1;a++)
				     {
					     if(Integer.parseInt(l[a].list_birthday.substring(0,4))<Integer.parseInt(l[a+1].list_birthday.substring(0,4)))
					     {
						     contactlist temp=l[a];
						     l[a]=l[a+1];
						     l[a+1]=temp;
					     }
				     }
			     }
			 	 break;
		     }
		 case 1:
		     {
		         for(int i=1;i<=count-1;i++)
			     {
				     for(int a=1;a<=count-i-1;a++)
				     {
					     if(Integer.parseInt(l[a].list_birthday.substring(0,4))>Integer.parseInt(l[a+1].list_birthday.substring(0,4)))
					     {
						     contactlist temp=l[a];
						     l[a]=l[a+1];
						     l[a+1]=temp;
					     }
				     }
			     }
				 break;
		     }
		 }
	 }
	 public static void page(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("�п�J�@���n��ܴX�����:");
		 int i=sc.nextInt();
		 int c=1;
		 for(int a=1;a<=count+i-1;a++)
		 {
			 for(int j=1;j<=i*a;j++)
			 {
				 if(l[c].list_name!=null)
				 {
					 System.out.println("�m�W:"+l[c].list_name+" �q��:"+l[c].list_phonenumber+" ����:"+l[c].list_category+" e-mail:"+l[c].list_email+" �ͤ�:"+l[c].list_birthday);
				 }
				 c=c+1;
			 }
			 System.out.println("==================================================");
		 }
	 }
	 public static void getDate(contactlist[] l)
	 {
         SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		 Date date = new Date();
         String strDate = sdFormat.format(date);
         System.out.println("�{�b�ɶ�:"+strDate);
	 }
	 public static void list_exit()
	 {
		 System.exit(0);
	 }
}