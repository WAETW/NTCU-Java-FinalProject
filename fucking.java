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
		 System.out.print("登入帳號:");
		 account=sc.next();
		 System.out.print("登入密碼:");
		 password=sc.next();
		 System.out.println("==============================================");
		 if(!account.equals("cis"))
		 {
		     System.out.println("帳號錯誤!!!!!!!!!!!!");
			 System.exit(0);
		 }
		 if(!password.equals("1234"))
		 {
		     System.out.println("密碼錯誤!!!!!!!!!!!!");
			 System.exit(0);
		 }
		 return true;
	 }
	 public static void select(contactlist[] l)
	 {
	     Scanner sc = new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("選擇登入權限:");
		 System.out.println("用戶端請輸入0 "); 
		 System.out.println("管理端請輸入1");
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
		     System.out.println("87都給你看選項了你還打錯!");
			 select(l);
		 }
	 }
	 public static void set_user(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("選擇模式:");
		 System.out.println("返回上一頁請輸入0");
		 System.out.println("新增多筆資料請輸入1");
		 System.out.println("刪除一筆資料請輸入2");
		 System.out.println("顯示所有資料請輸入3");
		 System.out.println("依電話查詢資料請輸入4");
		 System.out.println("依姓名查詢資料請輸入5");
		 System.out.println("顯示相同分類的資料請輸入6");
		 System.out.println("修改一筆資料請輸入7");
		 System.out.println("依生日(月份)排列資料(預設為大到小)請輸入8");
		 System.out.println("分頁顯示請輸入9");
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
			 default :System.out.println("87都給你看選項了你還打錯!");
			          set_user(l);break;         
		 }
	 }
	 public static void set_admin(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("==============================================");
		 System.out.println("選擇模式:");
		 System.out.println("返回上一頁請輸入0");
		 System.out.println("顯示哪一行請輸入1");
		 System.out.println("排列順序請輸入2");
		 System.out.println("顯示現在時間3");
		 int a=sc.nextInt();
		 System.out.println("==============================================");	 
		 switch(a)
		 {
			 case 0:select(l);break;
			 case 1:select_display_mode(l);break;
			 case 2:select_sort(l);break;
			 case 3:getDate(l);break;
			 default:System.out.println("87都給你看選項了你還打錯!");
			         set_admin(l);break;
		 }
	 }
	 public static void create_data(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.print("要輸入幾筆資料:");
		 int a =sc.nextInt();
		 for(int i=count,j=1;j<=a;j++,i++)
		 {
			 
			 System.out.print("姓名:");String name=sc.next();System.out.println();
			 System.out.print("電話號碼:");String phonenumber=sc.next();System.out.println();
			 while(!contactlist.check_phone(phonenumber))
			 {
				 System.out.println("電話格式錯誤!!!!");
			     System.out.print("電話號碼:");phonenumber=sc.next();System.out.println();
			 }
			 System.out.print("分類:");String category=sc.next();System.out.println();
			 System.out.print("e-mail:");String email=sc.next();System.out.println();
			 while(!contactlist.check_email(email))
			 {
				 System.out.println("email格式錯誤!!!!");
			     System.out.print("e-mail:");email=sc.next();System.out.println();
			 }
			 System.out.print("生日:");String birthday=sc.next();System.out.println();
			 while(!contactlist.check_birth(birthday))
			 {
				 System.out.println("生日格式錯誤!!!!");
			     System.out.print("生日:");birthday=sc.next();System.out.println();
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
		 System.out.println("請輸入顯示模式:");
		 System.out.println("顯示全部資料請輸入0");
		 System.out.println("顯示姓名請輸入1");
		 System.out.println("顯示電話請輸入2");
		 System.out.println("顯示分類請輸入3");
		 System.out.println("顯示e-mail請輸入4");
		 System.out.println("顯示生日請輸入5");
		 for(;;)
         {
			 int a=sc.nextInt();
             if(a>=0 && a<=6)
		     {
			     display=a;break;
		     } 
		     else
			     System.out.println("87都給你看選項了你還打錯!");
		 }
		 System.out.println("==============================================");	 
	 }
	 public static void displaymode(contactlist[] l)
	 {
		 if(count-1==0)
		 {
			 System.out.println("這裡沒有任何資料!");
		 }
		 for(int i=1;i<=count-1;i++)
		 {
			 switch(display)
			 {
				 case 0:System.out.println("姓名:"+l[i].list_name+" 電話:"+l[i].list_phonenumber+" 分類:"+l[i].list_category+" e-mail:"+l[i].list_email+" 生日:"+l[i].list_birthday+" 加入時間:"+l[i].list_date);break;
			     case 1:System.out.println("姓名:"+l[i].list_name);break;
			     case 2:System.out.println("電話:"+l[i].list_phonenumber);break;
			     case 3:System.out.println("分類:"+l[i].list_category);break;
			     case 4:System.out.println("e-mail:"+l[i].list_email);break;
			     case 5:System.out.println("生日:"+l[i].list_birthday);break;
			 }
		 }
		 
	 }
	 public static void display_all_data(contactlist l)
	 {
		 System.out.println("姓名:"+l.list_name+" 電話:"+l.list_phonenumber+" 分類:"+l.list_category+" e-mail:"+l.list_email+" 生日:"+l.list_birthday+" 加入時間:"+l.list_date);
	 }
	 public static void search_data_number_display(contactlist... token)
	 {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("==============================================");		 
		 System.out.println("請輸入查詢電話:");
		 String listphonenumber=sc.next();
		 int a=search_data_number(listphonenumber,token);
		 if(a>0)
			 display_all_data(token[a]);
		 else
			 System.out.println("這筆電話不存在!");
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
		 System.out.println("請輸入查詢名字:");
		 String listname=sc.next();
		 int a=search_data_name(listname,token);
		 if(a>-1)
			 display_all_data(token[a]);
		 else 
			 System.out.println("這個人不在名單中!");
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
		 System.out.println("請輸入顯示的類別:");
		 String listcategory=sc.next();
		 for(int i=1;i<=count;i++)
		 {
			 if(listcategory.equals(l[i].list_category))
				 System.out.println("姓名:"+l[i].list_name+" 電話:"+l[i].list_phonenumber+" 分類:"+l[i].list_category+" e-mail:"+l[i].list_email+" 生日:"+l[i].list_birthday+" 加入時間:"+l[i].list_date);
		 }
	 }
	 public static void delete_data(contactlist[] l)
	 {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("==============================================");	 
		 System.out.print("請出入想刪除的人名:");
		 String listname=sc.next();
		 int i=search_data_name(listname,l);
		 if(i==-1)
			 System.out.println("87這個人不在你的聯絡簿中是要刪三小!");
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
		 System.out.println("請輸入要修改連絡人姓名:");
		 String a=sc.next();
		 int i=search_data_name(a,l);
		 if(i>0)
		 {
			 System.out.print("姓名:");String name=sc.next();System.out.println();
			 System.out.print("電話號碼:");String phonenumber=sc.next();System.out.println();
			 while(!contactlist.check_phone(phonenumber))
			 {
				 System.out.println("電話格式錯誤!!!!");
			     System.out.print("電話號碼:");phonenumber=sc.next();System.out.println();
			 }
			 System.out.print("分類:");String category=sc.next();System.out.println();
			 System.out.print("e-mail:");String email=sc.next();System.out.println();
			 while(!contactlist.check_email(email))
			 {
				 System.out.println("email格式錯誤!!!!");
			     System.out.print("e-mail:");email=sc.next();System.out.println();
			 }
			 System.out.print("生日:");String birthday=sc.next();System.out.println();
			 while(!contactlist.check_birth(birthday))
			 {
				 System.out.println("生日格式錯誤!!!!");
			     System.out.print("生日:");birthday=sc.next();System.out.println();
			 }
			 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		     Date date = new Date();
             String strDate = sdFormat.format(date);
			 l[i]=new contactlist(name,phonenumber,category,email,birthday,strDate);
		 }
		 else
			 System.out.println("連絡人不存在!");
	 }
	 public static void select_sort(contactlist[] l)
	 {
		 Scanner sc =new Scanner(System.in);
		 System.out.println("==============================================");	
		 System.out.println("請選擇排列方式:");
		 System.out.println("月份由大到小請輸入0");
		 System.out.println("月份由小到大請輸入1");
		 for(;;)
		 {
			 int i=sc.nextInt();
			 if(i==0 || i==1)
			 {	 
			     sort=i;break;
			 }
			 else
				 System.out.println("87都給你看選項了你還打錯!");
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
		 System.out.println("請輸入一頁要顯示幾筆資料:");
		 int i=sc.nextInt();
		 int c=1;
		 for(int a=1;a<=count+i-1;a++)
		 {
			 for(int j=1;j<=i*a;j++)
			 {
				 if(l[c].list_name!=null)
				 {
					 System.out.println("姓名:"+l[c].list_name+" 電話:"+l[c].list_phonenumber+" 分類:"+l[c].list_category+" e-mail:"+l[c].list_email+" 生日:"+l[c].list_birthday);
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
         System.out.println("現在時間:"+strDate);
	 }
	 public static void list_exit()
	 {
		 System.exit(0);
	 }
}