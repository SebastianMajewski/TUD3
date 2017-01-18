package domain;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class Phone 
{

	private ObjectId id;
	private boolean sold;
	private double price;
	private String model;
	private int megapixels;
	
	private List<Part> parts = new ArrayList<Part>();
	

	public ObjectId getId() 
	{
		return this.id;
	}
	
	public void setId(ObjectId id) 
	{
		this.id=id;
	}
	
	public boolean getSold() 
	{
		return this.sold;
	}
	
	public void setSold(boolean sold) 
	{
		this.sold = sold;
	}
	
	public double getPrice() 
	{
		return this.price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public String getModel() 
	{
		return this.model;
	}
	
	public void setModel(String model) 
	{
		this.model = model;
	}
	
	public int getMegaPixels() 
	{
		return this.megapixels;
	}
	
	public void setMegaPixels(int mp) 
	{
		this.megapixels = mp;
	}
	
	public void addPart(Part input) 
	{
		this.parts.add(input);
	}
	
	
	public List<Part> getParts() 
	{
		return this.parts;
	}
	
}
