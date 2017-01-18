package repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Part;

public interface PartRepository extends CrudRepository<Part, ObjectId>
{

	@Query(value = "{ 'name' : ?1 }" )
	List<Part> findByName(String model);
	
	Part findById(ObjectId id);

}
