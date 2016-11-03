package org.indyDroids.inventoryApp.repository;


import org.indyDroids.inventoryApp.beans.UserImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImageRepository extends CrudRepository<UserImage, Long> {
	
	UserImage findByUserId(Long id);

}
