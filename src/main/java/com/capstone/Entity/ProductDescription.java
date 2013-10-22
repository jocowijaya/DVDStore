
package com.capstone.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "productDescription_table")
public class ProductDescription {

    // ======================================
    // =             Attributes             =
    // ======================================

	@Id
    @GeneratedValue
    protected Long PDID;
    @Column(nullable = false)
    protected String description;
    @Column(nullable = false)
    protected String category;
    @Column(nullable = false)
    protected String format;
    @Column(nullable = false)
    protected String language;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date releasedDate;

    // ======================================
    // =            Constructors            =
    // ======================================

    public ProductDescription()
    {

	}

    public ProductDescription(String description, String category, String format, String language, Date releasedDate) {
        this.description = description;
        this.category = category;
        this.format = format;
        this.language = language;
        this.releasedDate = releasedDate;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
		this.format = format;
    }

    public String getLanguage() {
		return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

	public Date getReleasedDate() {
		return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

}