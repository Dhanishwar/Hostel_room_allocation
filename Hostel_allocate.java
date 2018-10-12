package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hostel_allocate {
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	int flo=0, ro=0, blo=0;
	public Hostel_allocate() {
		
	}
	public Hostel_allocate(int f, int r, int b){
		flo=f;
		ro=r;
		blo=b;
	}
	public void allocate() throws SQLException {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename", "student" , "student");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			Statement Stmt = myConn.createStatement();
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from cse");
			ResultSet Rs = Stmt.executeQuery("select * from cse");
			int rcount=1, fcount=1, bcount=1, scount=1 ;
			System.out.println(ro+" "+flo+" "+blo);
			char c ='A';
			//Allocating for CSE students 
			int i=10;
			while(myRs.next()) {
					
				
				if(scount>4) {
					scount=1;
					rcount++;
					System.out.println("room "+rcount);
					if(rcount>ro) {
						rcount=1;
						bcount++;
						c++;
						
					
					if(bcount>blo) {
						bcount=1;
						fcount++;
						c='A';
						if(fcount>flo) {
							System.out.println("Student capacity exceeded");
							break;
						}
					}
					}
					
				}
				String id = myRs.getString("id");
				String room = c +""+fcount+"0"+rcount;
						//update users set num_points = ? where first_name = ?;
				String s = "update cse set "+"room = '"+room+"' where id = '"+id+"'";
				Stmt.executeUpdate(s);
						System.out.println(room);
				
				scount++;
				
			}
			scount=1;
			if(rcount<ro-1)
			rcount++;
			else {
				if(bcount<blo-1) {
					bcount++;
					c++;
				}
				else {
					if(fcount<flo-1) {
						fcount++;
					}
					else {
						System.out.println("Student capacity exceeded");
					}
				}
			}
			if(fcount<flo) {
				myRs = myStmt.executeQuery("select * from ece");
				Rs = Stmt.executeQuery("select * from ece");
				//Allocating for ECE students
				while(myRs.next()) {
					
					
					if(scount>4) {
						scount=1;
						rcount++;
						System.out.println("room "+rcount);
						if(rcount>ro) {
							rcount=1;
							bcount++;
							c++;
							
						
						if(bcount>blo) {
							bcount=1;
							fcount++;
							c='A';
							if(fcount>flo) {
								System.out.println("Student capacity exceeded");
								break;
							}
						}
						}
						
					}
					String id = myRs.getString("id");
					String room = c +""+fcount+"0"+rcount;
							//update users set num_points = ? where first_name = ?;
					String s = "update ece set "+"room = '"+room+"' where id = '"+id+"'";
					Stmt.executeUpdate(s);
							System.out.println(room);
					
					scount++;
					
				}
				
			}
			scount=1;
			if(rcount<ro-1)
			rcount++;
			else {
				if(bcount<blo-1) {
					bcount++;
					c++;
				}
				else {
					if(fcount<flo-1) {
						fcount++;
					}
					else {
						System.out.println("Student capacity exceeded");
					}
				}
			}
			if(fcount<flo) {
				myRs = myStmt.executeQuery("select * from eee");
				Rs = Stmt.executeQuery("select * from eee");
				//Alloacating rooms
				while(myRs.next()) {
					
					
					if(scount>4) {
						scount=1;
						rcount++;
						System.out.println("room "+rcount);
						if(rcount>ro) {
							rcount=1;
							bcount++;
							c++;
							
						
						if(bcount>blo) {
							bcount=1;
							fcount++;
							c='A';
							if(fcount>flo) {
								System.out.println("Student capacity exceeded");
								break;
							}
						}
						}
						
					}
					String id = myRs.getString("id");
					String room = c +""+fcount+"0"+rcount;
							//update users set num_points = ? where first_name = ?;
					String s = "update eee set "+"room = '"+room+"' where id = '"+id+"'";
					Stmt.executeUpdate(s);
							System.out.println(room);
					
					scount++;
					
				}
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}


}
