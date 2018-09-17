public class contactlist
{
	 public String list_name;
	 public String list_birthday;
	 public String list_phonenumber;
	 public String list_category;
	 public String list_email;
	 public String list_date;
	 public contactlist(String listname,String listnumber,String listcategory,String listmail,String listbirthday,String listdate)
	 {
	     setcontactlist(listname,listnumber,listcategory,listmail,listbirthday,listdate);
	 }
	 public contactlist(){}
	 public void setcontactlist(String listname,String listnumber,String listcategory,String listmail,String listbirthday,String listdate)
	 {
		 this.list_name=listname;
		 this.list_phonenumber=listnumber;
		 this.list_category=listcategory;
		 this.list_email=listmail;
		 this.list_birthday=listbirthday;
		 this.list_date=listdate;
	 }
	 public static boolean check_email(String listemail)
	 {
	     if(listemail.indexOf("@")>0)
		     return true;
		 else
		     return false;
	 }
	 public static boolean check_phone(String listphonenumber)
	 {
		 int a=listphonenumber.length();
		 if(a==10)
		 {
			 if(listphonenumber.matches("[0-9]{10}"))
				 return true;
			 else
				 return false;
		 }
         else if(a==11)
         {
			 if(listphonenumber.matches("[(]{1}[0-9]{2}[)]{1}[0-9]{7}"))
				 return true;
			 else
				 return false;
		 }
		 else
			 return false; 
	 }
	 public static boolean check_birth(String listbirthday)
	 {
		 String month=listbirthday.substring(0,2);
		 String day=listbirthday.substring(2,4);
		 int a=Integer.parseInt(month);
		 int b=Integer.parseInt(day);
		 if (a>=1 && a<=12)
		 {
			 {
				 if(a==1 || a==3 || a==5 || a== 7 || a==8 || a==10 || a==12)
				 {    
				     if(b>=1 && b<=31)
						 return true;
					 else
						 return false;
				 }
				 else if(a==4 || a==6 || a==9 || a==11)
				 {
					 if(b>=1 && b<=30)
				         return true;
					 else
						 return false;
				 }
				 else if(a==2)
				 {
            		 if(b>=1 && b<29)
						 return true;
					 else
						 return false;
				 }
			 }
		 }
		 else
			 return false;
		 return true;
	 }
}