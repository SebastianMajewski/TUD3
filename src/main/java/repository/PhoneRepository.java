package repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import domain.Phone;
import org.springframework.data.mongodb.repository.Query;

public interface PhoneRepository extends CrudRepository<Phone, ObjectId> 
{	
    List<Phone> findByModel(String name);
    Phone findById(ObjectId id);
    List<Phone> findByModelRegex(String regex);
}
