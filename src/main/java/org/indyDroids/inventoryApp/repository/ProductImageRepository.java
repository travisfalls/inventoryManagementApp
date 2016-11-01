package org.indyDroids.inventoryApp.repository;


import org.indyDroids.inventoryApp.beans.ProductImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Long> {
	
	ProductImage findByProductId(Long id);

}
