package Login;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import com.mysql.cj.xdevapi.Statement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

 
public class DBConnection {
	private static final String HashMap = null;
	private ResultSet rs;
	private Statement st;
	private Connection con;
	private int result;
	
	public DBConnection() {

		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/login";
		String user = "root";
		String passwd = "*ehdrb1201";

		try {
			Class.forName(className);
			con = DriverManager.getConnection(url, user, passwd);
			st = con.createStatement();
			System.out.println("Connect Success!");
		} catch(Exception e) {
			System.out.println("Connect Failed!");
			e.printStackTrace();
		} 
    }



	public String isAdmin(String adminID, String adminPW) {
		try {
			String SQL = "SELECT * FROM info WHERE adminID = '" + adminID + "' and adminPW = '" + adminPW + "'";
			rs = st.executeQuery(SQL);
			if(rs.next())
				return rs.getString(2);
		}catch(Exception e){
			System.out.println("오류 발생"+e.getMessage());
		}
		return "오류";
	}

	public int login(String ID, String PW) {
		try {
			String SQL = "SELECT * FROM info WHERE ID = '" + ID + "' and PW = '" + PW + "'";
			System.out.println(SQL);
			rs = st.executeQuery(SQL);
			if(rs.next())
				return rs.getInt(7);
		}catch(Exception e){
			System.out.println("오류 발생"+e.getMessage());
		}
		return -1;
	}

	public boolean register(String ID, String PW, String Name, String DOB, String Phone, String Gender) {
		try {
			String SQL = "INSERT INTO info (ID, PW, Name, DOB, Phone, Gender) VALUES ('" + ID + "', '"+ PW + "', '"+ Name + "', '"+ DOB + "', '"+ Phone + "', '"+ Gender + "')";
			System.out.println(SQL);
			result = st.executeUpdate(SQL);
			System.out.println(result);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public ArrayList<String> getInfo(String ID) {
		ArrayList<String> toReturn = new ArrayList<String>();
		try {
			String SQL = "SELECT * FROM info WHERE ID = '" + ID + "'";
			System.out.println(SQL);
			rs = st.executeQuery(SQL);
			if(rs.next()) {
			toReturn.add(rs.getString(1));
			toReturn.add(rs.getString(2));
			toReturn.add(rs.getString(3));
			toReturn.add(rs.getString(4));
			toReturn.add(rs.getString(5));
			toReturn.add(rs.getString(6));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			return toReturn;
		}
	}
	
	public boolean update(String ID, String Name, String DOB, String Phone, String Gender) {
		try {
			String SQL = "UPDATE info SET Name = '" + Name + "', DOB = '" + DOB + "', Phone = '" + Phone + "', Gender = '" + Gender + "' WHERE ID = '" + ID +"'";
			System.out.println(SQL);
			result = st.executeUpdate(SQL);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean delete(String ID) {
		try {
			String SQL = "DELETE FROM info WHERE ID = '" + ID +"'";
			System.out.println(SQL);
			result = st.executeUpdate(SQL);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean IDCheck(String ID) {
		try {
			String SQL = "SELECT * FROM info WHERE ID = '" + ID +"'";
			System.out.println(SQL);
			rs = st.executeQuery(SQL);
			if(rs.next())
				return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean changePW(String ID, String newPW) {
		try {
			String SQL = "UPDATE info set PW = '" + newPW + "' WHERE ID = '" + ID + "'";
			System.out.println(SQL);
			result = st.executeUpdate(SQL);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public ArrayList<ArrayList<String>> getAllInfo() {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		try {
			String SQL = "SELECT * FROM info";
			System.out.println(SQL);
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				ArrayList<String> temp = new ArrayList<String>();
				for(int j = 1; j<=8;j++) {
					temp.add(rs.getString(j));
				}
				table.add(temp);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			return table;
		}
	}
	
	public boolean adminRegister(String ID, String YN) {
		try {
			int isAdmin = YN.equals("Y")?1:0;
			String SQL = "UPDATE info SET isAdmin = '" + isAdmin + "' WHERE ID = '" + ID +"'";
			System.out.println(SQL);
			result = st.executeUpdate(SQL);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean adminApply(String ID) {
		try {
			String SQL = "UPDATE info SET AdminApply = 1 WHERE ID = '" + ID +"'";
			System.out.println(SQL);
			result = st.executeUpdate(SQL);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
}





