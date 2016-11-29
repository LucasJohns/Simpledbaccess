package vdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class vdbTest {
	public static void main(String[] args){
		final String QUERY = "SELECT * FROM imports";
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost/vehicles","river","mucis");
				PreparedStatement stmt = con.prepareStatement(QUERY)){
			System.out.println(stmt.toString());
			
			ResultSet rs = stmt.executeQuery(QUERY);
			
			while(rs.next()){
				System.out.println(rs.getInt("ID") +", "+rs.getString("Manufacturer")+", "+rs.getInt("modelYear")+", "+rs.getString("model")+", "+rs.getString("color"));
			}
		} catch (SQLException ex){
			System.out.println(ex.getMessage());
		}
	}

}
