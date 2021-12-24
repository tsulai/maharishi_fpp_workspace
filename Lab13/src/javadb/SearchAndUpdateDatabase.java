package javadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class SearchAndUpdateDatabase {
	private static String searchByIdQuery = "Select person.firstname, person.lastname,person.ssn,address.street, address.city,address.state,address.zip from person inner join address on person.id = address.id and person.id = ? ";
	private static String insertPersonQuery = "insert into  person (firstname,lastname,ssn) values (?,?,?) ";
	private static String inserAddressQuery = "insert into  address (street,city,state,zip,id) values (?,?,?,?,?)";
	private static String updatePersonQuery = "update person set firstname = ?, lastname = ? , ssn = ? where id = ?";
	private static String updateAddressQuery = "update address set street = ? , city = ? , state = ? , zip = ? where id = ?";
	private static final Logger LOG = Logger.getLogger(SearchAndUpdateDatabase.class.getName());
	
	public static Address searchAddress(String id) throws SQLException {
		Connection conn = null;
		Address address = null;
		Person person = null;
		try {
			conn = ConnectManager.getConnection();
			PreparedStatement stat = conn.prepareStatement(searchByIdQuery);
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				person = new Person(rs.getString("firstname").trim(),rs.getString("lastname").trim(), rs.getString("ssn").trim());
				address = new Address(person, rs.getString("street").trim(),rs.getString("city").trim(), rs.getString("state").trim(), rs.getString("zip").trim());
			}
			
		}
		catch(SQLException e) {
			LOG.warning("SQLException thrown " + e.getMessage());
		}
		finally {
			if(conn!= null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					LOG.warning("SQLException thrown while clossing Database Connection " + e.getMessage());
				}
			}
		}
		return address;
	}
	
	public static void updateAddress(String firstName, String lastName, String ssn, String street, String city , String state, String zip) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectManager.getConnection();
			
			// update person
			PreparedStatement stat = conn.prepareStatement(insertPersonQuery,Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, firstName);
			stat.setString(2, lastName);
			stat.setString(3, ssn);
			stat.executeUpdate();	
			
			int key = -1;
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getInt(1);
				
				// update address
				PreparedStatement stat2 = conn.prepareStatement(inserAddressQuery);
				stat2.setString(1, street);
				stat2.setString(2, city);
				stat2.setString(3, state);
				stat2.setString(4, zip);
				stat2.setInt(5, key);
				stat2.executeUpdate();
				
			} else {
				LOG.info("No generated key for " + stat.toString());
			}
			
			
		}
		catch(SQLException e) {
			LOG.warning("SQLException thrown " + e.getMessage());
		}
		finally {
			if(conn!= null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					LOG.warning("SQLException thrown while clossing Database Connection " + e.getMessage());
				}
			}
		}
		
	}
}
