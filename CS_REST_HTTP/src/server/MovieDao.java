package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

  
public enum MovieDao {
	INSTANCE;
	 
	public List<Movie> getMovies() {
	 
List<Movie> movies= new ArrayList<Movie>();
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
	
			Statement stmt = conn.createStatement();
			System.out.println("in select");
			String sql = "SELECT * from Movie ";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			
			while (rs.next()) {
				Movie mv = new Movie();
				mv.setId(Integer.parseInt(rs.getString("id")));
				mv.setMovieName(rs.getString("MovieName"));
				mv.setMoviePrice(rs.getString("MoviePrice"));
				mv.setMovieTime(rs.getString("MovieTime"));
				movies.add(mv);	
			} 
			 
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movies;
	}
	
	public Movie getMovie(int id) {
		//return MoviesMap.get(id);
		Movie mv = new Movie(); 
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
	
			Statement stmt = conn.createStatement();
			 
			String sql = "SELECT * from Movie where id = '" + id +"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
			 
				mv.setId(Integer.parseInt(rs.getString("id")));
				mv.setMovieName(rs.getString("MovieName"));
				mv.setMoviePrice(rs.getString("MoviePrice"));
				mv.setMovieTime(rs.getString("MovieTime"));
					
			} 
			 
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	public void create(Movie mv) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
	
			Statement stmt = conn.createStatement();
			System.out.println("in insert");
			String sql = "INSERT INTO Movie VALUES ('" + mv.getId() + "','" + mv.getMovieName() + "','" + mv.getMoviePrice() + "','" + mv.getMovieTime() + "')";
			
			System.out.println(sql);
			stmt.executeUpdate(sql);
			 
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void delete(int id) {

		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		
			Statement stmt = conn.createStatement();
			System.out.println("de");
			String sql = "DELETE FROM Movie where id= '" + id + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void update(Movie mv) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
	
			Statement stmt = conn.createStatement();
			System.out.println("in update");
			String sql = "UPDATE Movie SET MovieName = '" + mv.getMovieName() + "',  MoviePrice = '" + mv.getMoviePrice() + "', MovieTime = '" + mv.getMovieTime() + "' where id = '" +  mv.getId() + "'";
			
			System.out.println(sql);
			stmt.executeUpdate(sql);
			 
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
