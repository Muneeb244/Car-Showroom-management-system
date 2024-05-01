package car;

public class Car {
	private String Name;
	private String Company;
	private int Model;
	private int price;
	private String Engine;
	
	public Car()
	{
		Name=null;
		Company= null;
		Model = 0;
		price = 0;
		Engine= null;
	}
	
	
	

	public String getCompany() {
		return Company;
	}


	public void setCompany(String company) {
		Company = company;
	}


	public int getModel() {
		return Model;
	}


	public void setModel(int model) {
		Model = model;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getEngine() {
		return Engine;
	}


	public void setEngine(String engine) {
		Engine = engine;
	}


	public String getName() {
		return Name;
	}
		
}
