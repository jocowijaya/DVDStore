
package com.capstone.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game_table")

public class Game extends Product {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(nullable = false)
    private String classification;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private int nbrOfPlayers;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "systemRequirement_fk", nullable = false)
    private SystemRequirement systemRequirement;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Game()
    {

    }

    public Game(String title, Integer nbrInStock, String image, String classification, String manufacturer, int nbrOfPlayers) {
        super(title, nbrInStock, image);
        this.classification = classification;
        this.manufacturer = manufacturer;
        this.nbrOfPlayers = nbrOfPlayers;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public int getNbrOfPlayers() {
	return nbrOfPlayers;
    }

    public void setNbrOfPlayers(int nbrOfPlayers) {
        this.nbrOfPlayers = nbrOfPlayers;
    }

    public SystemRequirement getSystemRequirement() {
	return systemRequirement;
    }

    public void setSystemRequirement(SystemRequirement systemRequirement) {
        this.systemRequirement = systemRequirement;
    }

}