package entity.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "subcategory", catalog = "test")
public class SubCategory {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SUBCATEGORY_ID", nullable = false)
	private Integer subcategoryId;
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	private String subCategoryName;

	public SubCategory() {

	}

	public SubCategory(Integer subcategoryId, Category category, String categoryName) {
		super();
		this.subcategoryId = subcategoryId;
		this.category = category;
		this.subCategoryName = categoryName;
	}

	public Integer getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "SUBCATEGORY_NAME")
	public String getCategoryName() {
		return subCategoryName;
	}

	public void setCategoryName(String categoryName) {
		this.subCategoryName = categoryName;
	}

}
