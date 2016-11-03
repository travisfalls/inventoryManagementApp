package org.indyDroids.inventoryApp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_properties")
public class UserProperty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private long userId;
	
	private String propName;
	private String propValue;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long productId) {
		this.userId = productId;
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
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		UserProperty other = (UserProperty) obj;
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
		if (userId != other.userId)
			return false;
		return true;
	}
	
	

}
