package server;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "movie")
@XmlType(propOrder = { "id", "movieName", "moviePrice", "movieTime"})
public class Movie {

	 
	private int id;
	private String MovieTime;
	private String MovieName;
	private String MoviePrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieTime() {
		return MovieTime;
	}
	public void setMovieTime(String movieTime) {
		MovieTime = movieTime;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getMoviePrice() {
		return MoviePrice;
	}
	public void setMoviePrice(String moviePrice) {
		MoviePrice = moviePrice;
	}

 
}
