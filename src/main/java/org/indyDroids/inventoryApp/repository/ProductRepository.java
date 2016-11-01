package org.indyDroids.inventoryApp.repository;

import org.indyDroids.inventoryApp.beans.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
