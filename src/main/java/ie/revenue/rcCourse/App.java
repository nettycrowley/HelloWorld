package ie.revenue.rcCourse;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App implements Displayable 
{
	public static String organisation = "Revenue Commisioners";
	
	public static void displayOrgansation(){
		System.out.println(organisation);
	}
	
	protected String name = "";
	
	protected String password = "";
	
	protected ArrayList<String> months = new ArrayList<String>();
	
	
    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}

    public ArrayList<String> getMonths() {
		return months;
	}

	public void setMonths(ArrayList<String> months) {
		this.months = months;
	}
	//@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public App(ArrayList<String> months) {
		super();
		this.months = months;
	}

	//constructors
	public App(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		populateMonths();
	}
	
	public App(){
		populateMonths();
	}
	
	public String toJson(){
		ObjectMapper objectMapper = new ObjectMapper();
		
		String json = "";
		try {
			json = objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public void populateMonths(){
		months.clear();
		
		months.add("jan");
		months.add("feb");
		months.add("mar");
		months.add("apr");
		months.add("may");
		months.add("jun");
		months.add("jul");
		months.add("aug");
		months.add("sep");
		months.add("oct");
		months.add("nov");
		months.add("dec");
	}
	
	
	public static void main(String[] args){
		App app = new App("Aidan", "secret");
		System.out.println(app.toJson());
		
		System.out.println(App.organisation);
		
		App.displayOrgansation();
		
		//System.out.println(app.organisation);
		
		System.out.println(Math.PI);
		System.out.println(Math.random());
		
		app.display();
		Displayable d = app;
		d.display();
		
		
		
	}

	public void display() {
		System.out.println(toJson());
		
	}

	

}
