/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Part;
import repository.PartRepository;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartManager 
{
    @Autowired
    private  PartRepository partRepository;
        
    public void add(Part part) 
    {
        this.partRepository.save(part);
    }
        
    public void clear() 
    {
        this.partRepository.deleteAll();
    }
        
    public List<Part> getPartByName(String name)
    {
        return partRepository.findByName(name);
    }
	
	
	public Part getPart(ObjectId id)
	{
		return partRepository.findById(id);
	}
}
