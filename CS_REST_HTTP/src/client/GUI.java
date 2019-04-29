package client;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import server.Movie;
import java.awt.TextArea;


public class GUI extends JFrame implements ActionListener{
	
	private JLabel l0 = new JLabel("Movie Application");
	private JLabel l1 = new JLabel("Movie Id");
	private JLabel l2 = new JLabel("Movie Name");
	private JLabel l3 = new JLabel("Movie Price");
	private JLabel l4 = new JLabel("Movie Time");
	
	private JTextField t1 = new JTextField("");
	private JTextField t2 = new JTextField("");
	private JTextField t3 = new JTextField("");
	private JTextField t4 = new JTextField("");
	
	private JButton b1 = new JButton("POST");
	private JButton b2 = new JButton("DELETE");
	private JButton b3 = new JButton("PUT");
	private JButton b5 = new JButton("GET");
	private JButton b4 = new JButton("GET ALL");
	private JButton b6 = new JButton("EXIT");	
	private JButton b7 = new JButton("CLEAR");
	
	private TextArea textArea = new TextArea();

	
    GUI(){
	
	Container con = getContentPane();
	Font f = new Font("TimesRoman",Font.BOLD,20);
	getContentPane().setLayout(null);
	l0.setBounds(188, 13, 166, 27);
	l0.setFont(f);
	con.add(l0);
	l1.setBounds(28, 62, 119, 25);
	getContentPane().add(l1);
	t1.setBounds(144, 62, 210, 25);
	getContentPane().add(t1);
	l2.setBounds(28, 100, 119, 25);
	getContentPane().add(l2);
	t2.setBounds(145, 100, 209, 25);
	getContentPane().add(t2);
	l3.setBounds(28, 138, 119, 25);
	getContentPane().add(l3);
	t3.setBounds(145, 138, 209, 25);
	getContentPane().add(t3);
	l4.setBounds(28, 176, 119, 25);
	getContentPane().add(l4);
	t4.setBounds(145, 176, 209, 25);
	getContentPane().add(t4);
	b1.setBounds(384, 62, 159, 25);
	getContentPane().add(b1);
	b3.setBounds(384, 100, 159, 25);
	getContentPane().add(b3);
	b2.setBounds(384, 176, 159, 25);
	getContentPane().add(b2);
	b5.setBounds(383, 138, 160, 25);
	getContentPane().add(b5);
	b6.setBounds(384, 289, 159, 25);
	getContentPane().add(b6);
	b4.setBounds(384, 214, 159, 25);
	getContentPane().add(b4);
	
	
	textArea.setBounds(26, 223, 328, 229);
	getContentPane().add(textArea);
	b7.setBounds(384, 251, 159, 25);
	getContentPane().add(b7);
	b6.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b1.addActionListener(this);
	b7.addActionListener(this);
	setSize(573,509);
	setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		
		if(target==b1) {
				
					try {
						postMethod();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
		}
		
		if(target==b2) {
			try {
				deleteMethod();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(target==b3) {
			try {
				putMethod();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(target==b4) {
			try {
				getAllMethod();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(target==b5) {
			try {
				getMethod();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(target==b7) {
			
			clearAll();
		}
		
		if(target==b6) {
			System.exit(0);
		}
	}
	
	public void postMethod() throws Exception{
		
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/A00258748PrabhanshuPincha/rest/movie").build();

	System.out.println(uri.toString());
	HttpPost httpPost = new HttpPost(uri);
	httpPost.setHeader("Accept", "text/html");
	CloseableHttpClient client = HttpClients.createDefault();
	
	// POST
	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	nameValuePairs.add(new BasicNameValuePair("id", t1.getText()));
	nameValuePairs.add(new BasicNameValuePair("MovieName",  t2.getText()));
	nameValuePairs.add(new BasicNameValuePair("MoviePrice", t3.getText()));
	nameValuePairs.add(new BasicNameValuePair("MovieTime", t4.getText()));
	
	httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	System.out.println("Sending request...");
	CloseableHttpResponse response = client.execute(httpPost);
	System.out.println("Response: " + response.toString());
	JOptionPane.showMessageDialog(null, "POST Successfull");
    clearAll();
		
	}
	
	public void deleteMethod() throws Exception{
		
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/A00258748PrabhanshuPincha/rest/movie/"+t1.getText()).build();
		System.out.println(uri.toString());
		
		HttpDelete httpDelete = new HttpDelete(uri);
		httpDelete.setHeader("Accept", "text/html");
		CloseableHttpClient client = HttpClients.createDefault();
		
		System.out.println("Sending DELETE request...");
		CloseableHttpResponse response = client.execute(httpDelete);
		System.out.println("Response: " + response.toString());
		JOptionPane.showMessageDialog(null, "Deleted Successfully");
		clearAll();
	}
	
	public void putMethod() throws Exception{
	
		URI uri = new URIBuilder() 
				.setScheme("http") 
				.setHost("localhost") 
				.setPort(8080) 
				.setPath("/A00258748PrabhanshuPincha/rest/movie/"+t1.getText()).build();
		System.out.println(uri.toString()); 
	
	
	HttpPut httpPut = new HttpPut(uri); 
	httpPut.setHeader("Accept", "text/html"); 
	CloseableHttpClient client = HttpClients.createDefault(); 
	// PUT 
	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1); 
	nameValuePairs.add(new BasicNameValuePair("MovieName", t2.getText()));
	nameValuePairs.add(new BasicNameValuePair("MoviePrice", t3.getText())); 
	nameValuePairs.add(new BasicNameValuePair("MovieTime", t4.getText())); 
	httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs)); 
	System.out.println("Sending PUT request...");
	CloseableHttpResponse response = client.execute(httpPut); 
	System.out.println("Response: " + response.toString());
	JOptionPane.showMessageDialog(null, "PUT Successfull");

	}
	
	public void getMethod() throws Exception {
		
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/A00258748PrabhanshuPincha/rest/movie/"+t1.getText()).build();
		
		System.out.println(uri.toString());
		
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Accept", "application/xml");
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		HttpEntity entity = response.getEntity();
		String text = EntityUtils.toString(entity);
		System.out.println(text);
		
		Movie movie = new ParseMovie().doParseMovie(text);
		textArea.append(String.valueOf("\nID: " + movie.getId() + "\n" + "Name: " + movie.getMovieName() + "\n" +  "Price: " + movie.getMoviePrice() + "\n" +  "Time: " + movie.getMovieTime() + "\n"));

		
	}
	
	public void getAllMethod() throws Exception {
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/A00258748PrabhanshuPincha/rest/movie").build();
		
		System.out.println(uri.toString());
		
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Accept", "application/xml");
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		HttpEntity entity = response.getEntity();
		String text = EntityUtils.toString(entity);
		System.out.println(text);
		
		List<Movie> movieList = new ParseMovies().doParseMovies(text);
		for(Movie movie : movieList) {
			textArea.append(String.valueOf("\nID: " + movie.getId() + "\n" + "Name: " + movie.getMovieName() + "\n" +  "Price: " + movie.getMoviePrice() + "\n" +  "Time: " + movie.getMovieTime() + "\n"));
		}
	}
	
	public void clearAll() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		textArea.setText("");
	}
}
