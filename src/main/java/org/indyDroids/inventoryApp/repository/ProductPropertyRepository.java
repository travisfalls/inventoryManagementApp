package org.indyDroids.inventoryApp.repository;


import org.indyDroids.inventoryApp.beans.ProductProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPropertyRepository extends CrudRepository<ProductProperty, Long> {

}