package server;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.servlet.ServletContext;
import javax.servlet.http.*;

@Path("/movie")
public class MovieResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Movie>getmovies(){
		return MovieDao.INSTANCE.getMovies();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Path("{movieId}")
	public Movie getmovie(@PathParam("movieId") String id){	
		return MovieDao.INSTANCE.getMovie(Integer.parseInt(id));
	}
	
	@POST
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public void postmovie(@FormParam("id") String id,
			@FormParam("MovieName") String MovieName,
			@FormParam("MoviePrice") String MoviePrice,
			@FormParam("MovieTime") String MovieTime,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("Inside POST id = " + id);
		System.out.println("MovieName = " + MovieName);
		
		Movie movie = new Movie();
		movie.setId(Integer.parseInt(id));
		movie.setMovieName(MovieName);
		movie.setMoviePrice(MoviePrice);
		movie.setMovieTime(MovieTime);
		
		MovieDao.INSTANCE.create(movie);
		servletResponse.sendRedirect("../createmovie.html");
		
	}
	
	@DELETE
	@Produces({ MediaType.TEXT_HTML })
	@Path("{movieId}")
	public void deletemovie(@PathParam("movieId") String id) throws IOException {
		System.out.println("Delete id: " + id);
		MovieDao.INSTANCE.delete(Integer.parseInt(id));
	}
	
	@PUT
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Path("{movieId}")
	public static void putmovie(@PathParam("movieId") String id,
			@FormParam("MovieName") String MovieName,
			@FormParam("MoviePrice") String MoviePrice,
			@FormParam("MovieTime") String MovieTime,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("PUT id = " + id);
		
		Movie movie = new Movie();
		movie.setId(Integer.parseInt(id));
		movie.setMovieName(MovieName);
		movie.setMoviePrice(MoviePrice);
		movie.setMovieTime(MovieTime);
		MovieDao.INSTANCE.update(movie);
	}
}
