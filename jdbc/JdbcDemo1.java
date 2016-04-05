import java.sql.*;
import java.util.*;
import java.io.*;
public class JdbcDemo1
 {              
        public static void main(String ...l)
     {
         try
          {
	//Scanner sc=new Scanner(System.in);
	//Scanner sc1=new Scanner(System.in);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
	
    //load driver into ram memory	
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","password");
	Statement st= c.createStatement();
	 String s="y";
	 while(s.equals("y"))
         {
             System.out.println(" Enter your choice 1. insert  2.  update  3.  retrieve   4.  delete  "); 
              int n= Integer.parseInt(br.readLine());
             switch(n)
             { 
                  case 1:

                  System.out.println(" Enter name = ");
                   String name=br.readLine();

                     	
                    System.out.println("  enter password =  ");
                     int pass= Integer.parseInt(br.readLine());
	    
                 int i =  st.executeUpdate(" insert into pappu values('"+name+"',"+pass+" )");
	if(i==1)System.out.println(" data inserted");
                   else    {  System.out.println(" fail");}

	break;
              case 2:
                    System.out.println("  enter password =  ");
                      pass= Integer.parseInt(br.readLine());
	   i =  st.executeUpdate(" update pappu set name='lomesh' where password="+pass+" ");
	if(i==1)System.out.println(" data updated");
                   else    {  System.out.println(" fail");}

	break;

	 case 3:
                   
	   ResultSet rs=  st.executeQuery(" select * from pappu ");
	while(rs.next())
                 {
                  System.out.println(" name = " + rs.getString(1)+ "  password =  "+ rs.getInt(2));
	}     

	break;
	
	case 4:
                   System.out.println(" enter name ");
                    name=br.readLine();
                      i=st.executeUpdate(" delete from pappu where name='"+name+"' ");
                     if(i==1)  System.out.println( "data deleted");
                     else     
		System.out.println( "error");
	   

	break;
	

  
               }
	System.out.println(" do you want to continue enter y for yes ");
	s=br.readLine();
                } //closing of while                      
	 } 
 catch(Exception e)
{
 System.out.println(" error"+e.getMessage());
}      
}
}
                 