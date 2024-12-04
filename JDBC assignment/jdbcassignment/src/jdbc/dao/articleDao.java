package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import jdbc.bean.article;
import jdbc.utilis.JdbcUtils;

public class articleDao implements DaoInterface<article, Integer> {

	@Override
	public Collection<article> retrieveAll() {
		/*This method connects to DB, fetches all records, converts them
		 * into Java objects of Restaurant class, puts those objects into some
		 * Collection and returns the Collection 
		 */
		//Creating an Empty ArrayList: allRestaurants
		Collection<article> allarticle = new ArrayList<>();
		String sqlQuery = 	"select * from article";
		try(
				//Opening the resources using try-with-resources so that they get
				//closed automatically
				Connection conn = JdbcUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)
				){
				while(rs.next()) {
					//Fetching record values from ResultSet
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String category = rs.getString(3);
					String datecreated = rs.getString(4);
					String creatorName = rs.getString(5);
					//Building Java object (Restaurant) based upon these values
					article ast = 
					new article(id,name,category,datecreated,creatorName);
					//Adding this object (Restaurant) into the ArrayList
					allarticle.add(ast);
				}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return allarticle;
	}

	
	public article retrieveOne(Integer id) {
		article foundRestaurant = null;
		String sqlQuery = 
		"select * from article where id = ?";
		try(
				Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)
				){
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					int id1 = rs.getInt(1);
					String name = rs.getString(2);
					String category = rs.getString(3);
					String datecreated = rs.getString(4);
					String creatorName = rs.getString(5);
					//Building Java object (Restaurant) based upon these values
					foundRestaurant =
							new article(id1,name,category,datecreated,creatorName);

				}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundRestaurant;
	}

	@Override
	public void create(article newarticle) {
		/* This method accepts a 'Restaurant' object: newRestaurant and
		 * stores it as a record in the DB table.
		 */
		String sqlQuery = 
		"insert into article values(?,?,?,?,?)";
		try(
				Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)
				){
				//Extracting the values from Restaurant object: newRestaurant
			    //using getter methods.
				int Id = newarticle.getId();
				String Name = newarticle.getName();
				String category = newarticle.getCategory();
				String datecreated= newarticle.getDatecreated();
				String creatorName =newarticle.getCreatorName();
				//Substituting these values in place of '?' using PreparedStatement
				pstmt.setInt(1,Id);
				pstmt.setString(2,Name);
				pstmt.setString(3, category);
				pstmt.setString(4,datecreated);
				pstmt.setString(5, creatorName);
				int updateCount = pstmt.executeUpdate();
				System.out.println(updateCount + " record inserted.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
//
	@Override
	public void update(article modifiedartical) {
		/* This method receives the modified state of the Restaurant
		object: modifiedRestaurant and reflects that state into DB.
		*/
		String sqlQuery=
		"update article set name = ?, category = ?, datecreated = ?, creatorName = ? where id = ?";
		try(
				Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)
				){
			//Capturing the modified state of Restaurant object:modifiedRestaurant
			//using getter methods
			int Id = modifiedartical.getId();
			String Name = modifiedartical.getName();
			String category = modifiedartical.getCategory();
			String datecreated= modifiedartical.getDatecreated();
			String creatorName =modifiedartical.getCreatorName();
			
			//Substituting these values in place of '?' using PreparedStatement
			pstmt.setInt(5,Id);
			pstmt.setString(1,Name);
			pstmt.setString(2, category);
			pstmt.setString(3,datecreated);
			pstmt.setString(4, creatorName);
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record updated.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
//
	@Override
	public void delete(Integer id) {
		/*
		 * This method performs record deletion against identity.
		 */
		String sqlQuery = 
		"delete from article where id = ?";
		try(
				Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)
				){
			pstmt.setInt(1, id);
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record deleted");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}