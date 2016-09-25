import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
public class Database {
	static String JDBC_DRIVER,DB_URL;
	String USER,PASS;
	Connection conn;
	Statement stmt;
	
	public Database()
	{
		   // JDBC driver name and database URL
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost:3306";
		USER = "anshul";
		PASS = "";
		conn = null;
		stmt = null;
		ResultSet rs=null;
		ResultSet rs1=null;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sq;
		      sq = "create  database if not exists AIRLINE";
		      	stmt.execute(sq);
		    	System.out.println("Creating statement...");
		    	String sql="use AIRLINE";
		    	stmt.execute(sql);
		    	
		      
		   }catch(SQLException se1){                      //Handle errors for JDBC
		      se1.printStackTrace();
		   }catch(Exception e){                            //Handle errors for Class.forName
		      e.printStackTrace();
		      }
		     
		   
		

	}
   
   public void signupdetail(String userid, String pass2, String question, String answer, String fname, String lname,
			String gender, String string, String martial, String email,
			String mobileno, String nationality, String address, String city, String state, String country, String pincode){
   {
   try{
     
    	String sq1 = "create table if not exists customerdetail(userid varchar(20) unique, primary key(userid),password varchar(20),question varchar(100),answer varchar(30),fname varchar(20),lname varchar(20),gender varchar(10) ,dob varchar(20),martialstatus varchar(10),emailid varchar(30),mobileno varchar(10),nationality varchar(15),address varchar(50),city varchar(15),state varchar(20),country varchar(20),pincode varchar(8))";
    	stmt.execute(sq1);
        System.out.println("Creating statement...");
    	
        String sql2="insert into customerdetail values('"+userid+"','"+pass2+"','"+question+"','"+answer+"','"+fname+"','"+lname+"','"+gender+"','"+string+"','"+martial+"','"+email+"','"+mobileno+"','"+nationality+"','"+address+"','"+city+"','"+state+"','"+country+"','"+pincode+"')";
        stmt.executeUpdate(sql2);
       
      stmt.close();
      conn.close();
   }catch(SQLException se1){                      //Handle errors for JDBC
      se1.printStackTrace();
   }catch(Exception e){                            //Handle errors for Class.forName
      e.printStackTrace();}
     finally{ //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se3){
         se3.printStackTrace();
      }//end finally 
     }
   }
}
   public boolean checkLogin(String email,String pass)
   {
   	try
   	{
   	     String sql = "SELECT userid,password FROM customerdetail";
   	      ResultSet rs = stmt.executeQuery(sql);
   	      
   	      while(rs.next())
   	      {
   	    	  String myid = rs.getString("userid");
   	          String mypassword = rs.getString("password");
   				int mail = email.compareTo(myid);
   				int word = pass.compareTo(mypassword);
   	          if (mail==0 && word==0)
   	          {
   	        	  System.out.println(true);
   	        	  return true;
   	          }
   	      }
   	      System.out.println(false);
   	      return false;
   	}
   	catch(SQLException se)		//Handle errors for JDBC
   	{
   	      se.printStackTrace();		
   	}
   	catch(Exception e)		//Handle errors for Class.forName
   	{
   		e.printStackTrace();	  
   	}
   	finally			//finally block used to close resources
   	{	
   	      try
   	      {
   	         if(stmt!=null)
   	        	 stmt.close();
   	      }
   	      catch(SQLException se)
   	      {
   	    	  se.printStackTrace();
   	      }
   	      try
   	      {
   	         if(conn!=null)
   	            conn.close();
   	      }
   	      catch(SQLException se)
   	      {
   	    	  se.printStackTrace();
   	      }//end finally try
   	 }//end try
   	return false;
   }

public void addflight(String fid, String flightname, String source, String destination, String departure,
		String arrival, String dof, String economycharge, String economyseat, String businesscharge, String businessseat, String premiumcharge, String premiumseat) {
	try{
		String sq3 = "create table if not exists flightdetail(flightid varchar(10) unique, primary key(flightid),flightname varchar(20),source varchar(20),destination varchar(20),departure varchar(15),arrival varchar(15),dof varchar(20),economycharge VARCHAR(10) ,economyseat VARCHAR(8),businesscharge VARCHAR(10) ,businessseat VARCHAR(8),premiumcharge VARCHAR(10) ,premiumseat VARCHAR(8))";
	stmt.execute(sq3);
    System.out.println("Creating statement...");
	
    String sql2="insert into flightdetail values('"+fid+"','"+flightname+"','"+source+"','"+destination+"','"+departure+"','"+arrival+"','"+dof+"','"+economycharge+"','"+economyseat+"','"+businesscharge+"','"+businessseat+"','"+premiumcharge+"','"+premiumseat+"')";
    stmt.executeUpdate(sql2);
   
    stmt.close();
    conn.close();
	}catch(SQLException se1){                      //Handle errors for JDBC
		se1.printStackTrace();
	}catch(Exception e){                            //Handle errors for Class.forName
		e.printStackTrace();}
	finally{ //finally block used to close resources
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se3){
			se3.printStackTrace();
		}//end finally 
 }
}

public void updateflight(String fid, String flightname, String source, String destination, String departure,
		String arrival, String dof, String economycharge, String economyseat, String businesscharge, String businessseat, String premiumcharge, String premiumseat) {
	// TODO Auto-generated method stub
	try{
	System.out.println("Creating statement...");
	
    String sql2="update flightdetail  set flightname='"+flightname+"',source='"+source+"',destination='"+destination+"',departure='"+departure+"',arrival='"+arrival+"',dof='"+dof+"',economycharge='"+economycharge+"',economyseat='"+economyseat+"',businesscharge='"+businesscharge+"',businessseat='"+businessseat+"',premiumcharge='"+premiumcharge+"',premiumseat='"+premiumseat+"' where flightid='"+fid+"'" ;
    stmt.executeUpdate(sql2);
   
    stmt.close();
    conn.close();
	}catch(SQLException se1){                      //Handle errors for JDBC
		se1.printStackTrace();
	}catch(Exception e){                            //Handle errors for Class.forName
		e.printStackTrace();}
	finally{ //finally block used to close resources
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se3){
			se3.printStackTrace();
		}//end finally 
 }
}

public void deleteflight(String fid) {
	// TODO Auto-generated method stub
	try{
		System.out.println("Creating statement...");
		
	    String sql2="delete from flightdetail where flightid='"+fid+"'" ;
	    stmt.executeUpdate(sql2);
	   
	    stmt.close();
	    conn.close();
		}catch(SQLException se1){                      //Handle errors for JDBC
			se1.printStackTrace();
		}catch(Exception e){                            //Handle errors for Class.forName
			e.printStackTrace();}
		finally{ //finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se3){
				se3.printStackTrace();
			}//end finally 
	 }
}

public ResultSet searchflight(String fid) {
	// TODO Auto-generated method stub
	ResultSet rs=null;
	try{    	
        String sql2="Select * from flightdetail where flightid='"+fid+"'";
        rs=stmt.executeQuery(sql2);
       
      
   }catch(Exception ex){                      //Handle errors for JDBC
      ex.printStackTrace();
  
     }
	return rs;
   
}


public void creditCardSave(String ticketNo,String cardType,String cardNo,String holderName,String bankName,String expiryDate)
{
	   try{

		   String sq6="create table if not exists creditcard(ticketno varchar(20),foreign key(ticketno) references reservation(ticketno),cardno varchar(20),cardtype varchar(10),holdername varchar(20),expirydate date,bank_name varchar(25) )";
		   stmt.execute(sq6);
		   String sql7 = "insert into creditcard values('"+ticketNo+"','"+cardNo+"','"+cardType+"','"+holderName+"','"+expiryDate+"','"+bankName+"')";
		   stmt.executeUpdate(sql7);
		   stmt.close();
		   conn.close();
	   }
	   catch(SQLException se)
	   {
		   se.printStackTrace();
	   }
}
public void chequesave(String ticketno,String chequeno,String bankname,String expirydate)
{
	try{
		String sq8="create table if not exists cheque(ticketno int(5),foreign key(ticketno) references reservation(ticketno),chequeno varchar(20),chequedate varchar(10),bank_name varchar(25) ) ";
		stmt.execute(sq8);
		
		String sq9 = "insert into cheque values('"+ticketno+"','"+chequeno+"','"+bankname+"','"+expirydate+"')";
		stmt.executeUpdate(sq9);
		stmt.close();
		conn.close();
	}catch(SQLException se)
	 {
		   se.printStackTrace();
	 }
}

public ResultSet searchreservation(String userid) {
	ResultSet rs=null;
	try{    	
        String sql2="select customerdetail.userid,customerdetail.fname,customerdetail.lname,customerdetail.gender,customerdetail.mobileno,customerdetail.address,customerdetail.dob from customerdetail where userid='"+userid+"'";
        rs=stmt.executeQuery(sql2);
       
   }catch(Exception ex){                      //Handle errors for JDBC
      ex.printStackTrace();
  
     }
	return rs;
}

public void bookreservation(String userid, String flightno, String ticketno,String dateofflight,String fclass,String seatno,String charge) {
	try{
		String sq8="create table if not exists reservation(userid varchar(20),flightid varchar(10),ticketno int(5),dateofflight varchar(20),flightclass varchar(20),seatno varchar(5),charge varchar(6) ,primary key(ticketno),foreign key(userid) references customerdetail(userid),foreign key(flightid) references flightdetail(flightid))";
		stmt.execute(sq8);
		
		String sq9 = "insert into reservation values('"+userid+"','"+flightno+"','"+ticketno+"','"+dateofflight+"','"+fclass+"','"+seatno+"','"+charge+"')";
		stmt.executeUpdate(sq9);
		stmt.close();
		conn.close();
	}catch(SQLException se)
	 {
		   se.printStackTrace();
	 }
}

public ResultSet ticketreceipt(String userid) {
	ResultSet rs=null;
	try{    	
        String sql2="select c.userid,r.flightid,r.ticketno,f.source,f.destination,f.arrival,f.departure,r.flightclass,r.dateofflight,r.seatno from customerdetail c,flightdetail f,reservation r where f.flightid=r.flightid and c.userid='"+userid+"' ";
        rs=stmt.executeQuery(sql2);
       
   }catch(Exception ex){                      //Handle errors for JDBC
      ex.printStackTrace();
  
   }
	return rs;

}

public ResultSet ticketcancellation(String ticketno) {
	ResultSet rs=null;
	try{    	
        String sql2="select ticketno,flightid,userid,dateofflight,seatno from reservation where ticketno='"+ticketno+"'";
        rs=stmt.executeQuery(sql2);
       
   }catch(Exception ex){                      //Handle errors for JDBC
      ex.printStackTrace();
  
   }
	return rs;

}

public void deleteTicket(String ticketno) {
	// TODO Auto-generated method stub
	try{
		System.out.println("Creating statement...");
		
	    String sql2="delete from reservation where ticketno='"+ticketno+"'" ;
	    stmt.executeUpdate(sql2);
	   
	    stmt.close();
	    conn.close();
		}catch(SQLException se1){                      //Handle errors for JDBC
			se1.printStackTrace();
		}catch(Exception e){                            //Handle errors for Class.forName
			e.printStackTrace();}
		finally{ //finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se3){
				se3.printStackTrace();
			}//end finally 
	 }
}

public ResultSet enquiry(String userid) {
	ResultSet rs=null;
	try{    	
        String sql2="select c.userid,r.ticketno,f.flightid,f.flightname,r.seatno,r.dateofflight from customerdetail c,flightdetail f,reservation r  where c.userid='"+userid+"'";
        rs=stmt.executeQuery(sql2);
       
   }catch(Exception ex){                      //Handle errors for JDBC
      ex.printStackTrace();
  
   }
	return rs;
}

public ResultSet setlocation() {
	ResultSet rs=null;
	try{    	
        String sql2="select source,destination from flightdetail";
        rs=stmt.executeQuery(sql2);
       
   }catch(Exception ex){                      //Handle errors for JDBC
      ex.printStackTrace();
  
   }
	return rs;
}

public ResultSet paymentDetail(String ticketno) {
	ResultSet rs=null;
	try{    	
        String sql2="select r.ticketno,r.userid,r.flightid,r.charge from reservation r,flightdetail f where r.ticketno='"+ticketno+"'";
        rs=stmt.executeQuery(sql2);
       
   }catch(Exception ex){                      //Handle errors for JDBC
      ex.printStackTrace();
  
   }
	return rs;
}

public void addPayment(String ticketno, String userid, String flightno, String amount, String mode) {
	try{

		   String sq6="create table if not exists paymentdetail(ticketno varchar(20),userid varchar(20),flightid varchar(10),amount varchar(5),mode varchar(20));";
		   stmt.execute(sq6);
		   String sql7 = "insert into paymentdetail values('"+ticketno+"','"+userid+"','"+flightno+"','"+amount+"','"+mode+"')";
		   stmt.executeUpdate(sql7);
		   stmt.close();
		   conn.close();
	   }
	   catch(SQLException se)
	   {
		      se.printStackTrace();

	   }
}
public ResultSet createTable(String start, String end) 
{
	  ResultSet rs=null;
		try{    	
	        String sq20="Select * from flightdetail where source='"+start+"' and destination ='"+end+"'";
	        rs=stmt.executeQuery(sq20);
	       	      
	   }catch(Exception ex){                      //Handle errors for JDBC
			JOptionPane.showMessageDialog(null,"FlightDetail table not found","Flight detail",JOptionPane.ERROR_MESSAGE);
	  
	     }
		return rs;
}

public void createflightdetail() {
	try{
		String sq3 = "create table if not exists flightdetail(flightid varchar(10) unique, primary key(flightid),flightname varchar(20),source varchar(20),destination varchar(20),departure varchar(15),arrival varchar(15),dof varchar(20),economycharge VARCHAR(10) ,economyseat VARCHAR(8),businesscharge VARCHAR(10) ,businessseat VARCHAR(8),premiumcharge VARCHAR(10) ,premiumseat VARCHAR(8))";
	stmt.execute(sq3);
	String sql1="create table if not exists ticketno(ticketno varchar(10),inde  int(4))";
	stmt.execute(sql1);
	String sq9 = "insert into ticketno values('1000','1')";
	stmt.executeUpdate(sq9);
    System.out.println("Creating statement...");
	
    
    stmt.close();
    conn.close();
	}catch(SQLException se1){                      //Handle errors for JDBC
		se1.printStackTrace();
	}catch(Exception e){                            //Handle errors for Class.forName
		e.printStackTrace();}
	finally{ //finally block used to close resources
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se3){
			se3.printStackTrace();
		}//end finally 
 }	
}

public ResultSet getEconomySeat(String flightno) {
	ResultSet rs=null;
	try{    	
        String sq20="Select economyseat,economycharge from flightdetail where flightid='"+flightno+"'";
        rs=stmt.executeQuery(sq20);
       	      
   }catch(Exception ex){                      //Handle errors for JDBC
		JOptionPane.showMessageDialog(null,"FlightDetail table not found","Flight detail",JOptionPane.ERROR_MESSAGE);
  
     }
	return rs;
}

public ResultSet getBusinessSeat(String flightno) {
	ResultSet rs=null;
	try{    	
		
        String sq20="Select businessseat,businesscharge from flightdetail where flightid='"+flightno+"'";
        rs=stmt.executeQuery(sq20);
       	      
   }catch(Exception ex){                      //Handle errors for JDBC
		JOptionPane.showMessageDialog(null,"FlightDetail table not found","Flight detail",JOptionPane.ERROR_MESSAGE);
  
     }
	return rs;
}

public ResultSet getPremiumSeat(String flightno) {
	ResultSet rs=null;
	try{    	
		
        String sq20="Select premiumseat,premiumcharge from flightdetail where flightid='"+flightno+"'";
        rs=stmt.executeQuery(sq20);
       	      
   }catch(Exception ex){                      //Handle errors for JDBC
		JOptionPane.showMessageDialog(null,"FlightDetail table not found","Flight detail",JOptionPane.ERROR_MESSAGE);
  
     }
	return rs;
}

public void setEcoSeat(String flightno, String updateEcoseat) {
	try{

		 String sql2="update flightdetail set economyseat='"+updateEcoseat+"' where flightid='"+flightno+"'" ;
		    stmt.executeUpdate(sql2);
		   stmt.close();
		   conn.close();
	   }
	   catch(SQLException se)
	   {
		      se.printStackTrace();
	   }
	   
}
public void setBusSeat(String flightno, String updateBusseat) {
	try{

		 String sql2="update flightdetail set businessseat='"+updateBusseat+"' where flightid='"+flightno+"'" ;
		    stmt.executeUpdate(sql2);
		   stmt.close();
		   conn.close();
	   }
	   catch(SQLException se)
	   {
		      se.printStackTrace();
	   }
	   
}public void setPreSeat(String flightno, String updatePreseat) {
	try{

		 String sql2="update flightdetail set premiumseat='"+updatePreseat+"' where flightid='"+flightno+"'" ;
		    stmt.executeUpdate(sql2);
		   stmt.close();
		   conn.close();
	   }
	   catch(SQLException se)
	   {
		      se.printStackTrace();
	   }
	   
}

public ResultSet getTicketno() {
	ResultSet rs=null;
	try{

		String sql2="Select ticketno from ticketno where inde=1" ;
		rs=stmt.executeQuery(sql2); 
		
	   }
	   catch(SQLException se)
	   {
		      se.printStackTrace();
	   }
	return rs;
	   
}

public void setticketno(String tnos) {
	try{

		 String sql2="update ticketno set ticketno='"+tnos+"' where inde='1'" ;
		    stmt.executeUpdate(sql2);
		   stmt.close();
		   conn.close();
	   }
	   catch(SQLException se)
	   {
		      se.printStackTrace();
	   }
	   
}

}//end FirstExample
