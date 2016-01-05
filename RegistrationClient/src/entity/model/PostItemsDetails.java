package entity.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PostItemsDetails", catalog = "test")
public class PostItemsDetails {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "POST_ID", unique = true, nullable = false)
	private Integer postId;
	@Column(name = "POST_TITLE", unique = true, nullable = false, length = 20)
	private String title;
	@Column(name = "POST_BName", unique = true, nullable = false, length = 20)
	private String businessName;
	@Column(name = "Customer_ID")
	private Integer customerid;
	@Column(name = "CATEGORY_ID")
	private Integer categoryid;
	@Column(name = "SUBCATEGORY_ID")
	private Integer subcategoryid;
	@Column(name = "QUANTITY")
	private Integer Quantity;
	@Column(name = "TOTAL_PRICE")
	private double totalprice;
	@Column(name = "image", unique = false, nullable = false, length = 10000000)
	private byte[] image;

	@Column(name="postDate")
	private Date postDate;

	@Embedded
	private Address address;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getSubcategoryid() {
		return subcategoryid;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public void setSubcategoryid(Integer subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
