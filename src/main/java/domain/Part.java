package domain;

import org.bson.types.ObjectId;

public class Part 
{
    	
	private ObjectId id;
	private String name;
	private double price;

	public ObjectId getId() 
	{
		return this.id;
	}
	
	public void setId(ObjectId id) 
	{
		this.id=id;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name) 
	{
		this.name=name;
	}
	
	public double getPrice() 
	{
		return this.price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
}
