package org.indyDroids.inventoryApp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "product_properties")
public class ProductProperty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private long productId;
	
	private String propName;
	private String propValue;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return productId;
	}
	public void setUserId(long productId) {
		this.productId = productId;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public String getPropValue() {
		return propValue;
	}
	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((propName == null) ? 0 : propName.hashCode());
		result = prime * result + ((propValue == null) ? 0 : propValue.hashCode());
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductProperty other = (ProductProperty) obj;
		if (id != other.id)
			return false;
		if (propName == null) {
			if (other.propName != null)
				return false;
		} else if (!propName.equals(other.propName))
			return false;
		if (propValue == null) {
			if (other.propValue != null)
				return false;
		} else if (!propValue.equals(other.propValue))
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}
	
	

}
