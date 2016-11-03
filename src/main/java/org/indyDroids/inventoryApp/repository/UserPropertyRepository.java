package org.indyDroids.inventoryApp.repository;

import org.indyDroids.inventoryApp.beans.UserProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPropertyRepository extends CrudRepository<UserProperty, Long> {

}