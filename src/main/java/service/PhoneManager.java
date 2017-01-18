package service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.PhoneRepository;
import domain.Phone;

@Component
public class PhoneManager 
{

	@Autowired
	private  PhoneRepository phoneRepository;
	
	public void add(Phone phone)
	{
		phoneRepository.save(phone);
	}	
	
    public void clear() 
    {
        phoneRepository.deleteAll();
    }
        
	public List<Phone> getPhoneByModel(String model)
	{
		return phoneRepository.findByModel(model);
	}
	
	
	public Phone getPhone(ObjectId id)
	{
		return phoneRepository.findById(id);
	}
	
	public void remove(Phone phone) 
	{
        phoneRepository.delete(phone);
    }
        
    public Iterable<Phone> getAll() 
    {
        return phoneRepository.findAll();
    }
}
