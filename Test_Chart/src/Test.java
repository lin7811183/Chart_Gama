import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Test {
	
	

	public static void main(String[] args) {
		ResultSet ResultSet;
		// TODO Auto-generated method stub
		try {
			//¸ü¤JJDBC Driver 
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;"+ "databaseName=ManagerDB;user=sa;password=!QAZ2wsx;");
	        DatabaseMetaData metadata = conn.getMetaData();           
	        //System.out.println("Database Name: "+ metadata.getDatabaseProductName());
	        System.out.println("Connect MS DB");
	        Statement Statement = conn.createStatement();
	        String query = "SELECT * FROM [ManagerDB].[dbo].[Host_Service_Type]";
	        ResultSet = Statement.executeQuery(query);
	        GameWorldList List;
	        while (ResultSet.next()) {
	        	List = new GameWorldList(ResultSet.getString("Host_Name"),ResultSet.getString("Host_Service"),ResultSet.getString("Service_Type"));
	            System.out.println(ResultSet.getString(1) + ", " + ResultSet.getString(2) + ", " + ResultSet.getString(3));
	        }
	        
		}catch(Exception x) {
			System.out.println("MS DB Connet Error....");
		}
		
	}

}
