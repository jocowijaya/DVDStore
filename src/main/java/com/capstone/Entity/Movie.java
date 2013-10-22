package com.capstone.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movie_table")

public class Movie extends Product {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(nullable = false)
    private String classification;
    @Column(nullable = false)
    private String castName;
    @Column(nullable = false)
    private String director;
    @Column(nullable = false)
    private String runtime;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Movie()
    {

	}

    public Movie(String title, Integer nbrInStock, String image, String classification, String castName, String director, String runtime) {
        super(title, nbrInStock, image);
        this.classification = classification;
        this.castName = castName;
        this.director = director;
        this.runtime = runtime;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getCastName() {
        return castName;
    }

	public void setCastName(String castName) {
		this.castName = castName;
    }

	public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
		this.director = director;
    }

    public String getRuntime() {
		return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

}