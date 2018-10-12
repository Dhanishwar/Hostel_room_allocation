package jdbcdemo;

import java.sql.*;

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
        Dept_seg ob = new Dept_seg();
        //ob.department();
        input i = new input();
        Hostel_allocate cs = new Hostel_allocate(i.nof,i.nor,i.block);
        cs.allocate();

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dept", "student" , "student");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from student");
			
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("name") + ", " + myRs.getString("department")+", ");
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
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


