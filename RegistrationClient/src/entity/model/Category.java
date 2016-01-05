package entity.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.ws.rs.DELETE;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "category", catalog = "test", uniqueConstraints = { @UniqueConstraint(columnNames = "CATEGORY_NAME") })
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3107851177153175035L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", nullable = false)
	private Integer categoryId;
	@Column(name = "CATEGORY_NAME", unique = true, nullable = false, length = 10)
	private String categoryName;
	@OneToMany(mappedBy = "category")
	@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	private Set<SubCategory> subCategoryRecords;

	public Category() {

	}

	public Category(Integer categoryId, String categoryName, Set<SubCategory> subCategoryRecords) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subCategoryRecords = subCategoryRecords;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<SubCategory> getSubCategoryRecords() {
		return subCategoryRecords;
	}

	public void setSubCategoryRecords(Set<SubCategory> subCategoryRecords) {
		this.subCategoryRecords = subCategoryRecords;
	}

}
