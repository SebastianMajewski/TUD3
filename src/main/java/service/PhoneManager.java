package service;

import domain.Part;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.PhoneRepository;
import domain.Phone;
import repository.PartRepository;

@Component
public class PhoneManager 
{

    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private PartRepository partRepository;
	
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
    
    public int removePartsByName(Phone phone, String name)
    {
        int i = 0;
        List<Part> toRemove = phone.removePartsWithName(name);
        phoneRepository.save(phone);
        for(Part part : toRemove)
        {
            i++;
            partRepository.delete(part.getId());
        }
        return i;
    }
    
    public List<Phone> getPhonesStartsWith(String letter)
    {
        return phoneRepository.findByModelRegex("^"+letter);
    }
    
}
