package com.capstone.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;

@Entity
@Table(name = "product_table")
@Inheritance(strategy = InheritanceType.JOINED)

public class Product {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    protected Long PID;
    @Column(nullable = false)
    protected String title;
    @Column(nullable = false)
    protected Integer nbrInStock;
    @Column(nullable = false)
    protected String image;

	@OneToOne(fetch = FetchType.EAGER, cascade= CascadeType.REMOVE)
	@JoinColumn(name = "productDescription_fk", nullable = false)
    private ProductDescription productDescription;
	@OneToOne(fetch = FetchType.EAGER, cascade= CascadeType.REMOVE)
	@JoinColumn(name = "salesProduct_fk", nullable = false)
    private SalesProduct salesProduct;
    @OneToOne(fetch = FetchType.EAGER, cascade= CascadeType.REMOVE)
	@JoinColumn(name = "leasesProduct_fk", nullable = false)
    private LeasesProduct leasesProduct;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Product()
    {

	}

    public Product(String title, Integer nbrInStock, String image) {
        this.title = title;
        this.nbrInStock = nbrInStock;
        this.image = image;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getPID() {
        return PID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNbrInStock() {
        return nbrInStock;
    }

    public void setNbrInStock(Integer nbrInStock) {
		this.nbrInStock = nbrInStock;
    }

    public String getImage() {
		return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductDescription getProductDescription(){
		return productDescription;
	}

	public void setProductDescription(ProductDescription productDescription){
		this.productDescription = productDescription;
	}

	public SalesProduct getSalesProduct(){
		return salesProduct;
	}

	public void setSalesProduct(SalesProduct salesProduct){
		this.salesProduct = salesProduct;
	}

	public LeasesProduct getLeasesProduct(){
		return leasesProduct;
	}

	public void setLeasesProduct(LeasesProduct leasesProduct){
		this.leasesProduct = leasesProduct;
	}

}