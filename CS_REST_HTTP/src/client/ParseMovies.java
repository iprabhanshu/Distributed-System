package client;
import java.io.*;
import java.util.*;
import org.xmlpull.v1.*;

import server.Movie;

public class ParseMovies {
	boolean inMovies = false;
	boolean inMovie = false;
	boolean inId = false;
	boolean inMovieName = false;
	boolean inMoviePrice = false;
	boolean inMovieTime = false;
	
	Movie currentMovie;
	List<Movie> currentMovieList;
	
	public List<Movie> doParseMovies(String s) throws Exception {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser pullParser = factory.newPullParser();
		pullParser.setInput(new StringReader(s));
		processDocument(pullParser);
		return currentMovieList;
	}
	
	public void processDocument(XmlPullParser pullParser) throws XmlPullParserException, IOException {
		int eventType = pullParser.getEventType();
		do {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start Document");
			} 
			else if (eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			} 
			else if (eventType == XmlPullParser.START_TAG) {
				processStartElement(pullParser);
			} 
			else if (eventType == XmlPullParser.END_TAG) {
				processEndElement(pullParser);
			} 
			else if (eventType == XmlPullParser.TEXT) {
				processText(pullParser);
			}
			eventType = pullParser.next();
		} while (eventType != XmlPullParser.END_DOCUMENT);
	}
	
	public void processStartElement(XmlPullParser event) {
		String name = event.getName();
		if(name.equals("movies")) {
			inMovies = true;
			currentMovieList = new ArrayList<Movie>();
		} 
		else if (name.equals("movie")) {
			inMovie = true;
			currentMovie = new Movie();
		} 
		else if (name.equals("id")) {
			inId = true;
		} 
		else if (name.equals("movieName")) {
			inMovieName = true;
		} 
		else if (name.equals("moviePrice")) {
			inMoviePrice = true;
		} 
		else if (name.equals("movieTime")) {
			inMovieTime = true;
		}
	}
	
	public void processEndElement(XmlPullParser event) {
		String name = event.getName();
		if(name.equals("movies")) {
			inMovies = false;
		} 
		else if (name.equals("movie")) {
			inMovie = false;
			currentMovieList.add(currentMovie);
		} 
		else if (name.equals("id")) {
			inId = false;
		} 
		else if (name.equals("movieName")) {
			inMovieName = false;
		} 
		else if (name.equals("moviePrice")) {
			inMoviePrice = false;
		} 
		else if (name.equals("movieTime")) {
			inMovieTime = false;
		}
	}

	public void processText(XmlPullParser event) throws XmlPullParserException {
		if(inId) {
			String s = event.getText();
			currentMovie.setId(Integer.parseInt(s));
		}
		if(inMovieName) {
			String s = event.getText();
			currentMovie.setMovieName(s);
		}
		if(inMoviePrice) {
			String s = event.getText();
			currentMovie.setMoviePrice(s);
		}
		if(inMovieTime) {
			String s = event.getText();
			currentMovie.setMovieTime(s);
		}
	}
}
