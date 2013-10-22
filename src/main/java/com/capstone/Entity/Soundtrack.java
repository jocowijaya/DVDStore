
package com.capstone.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "soundtrack_table")

public class Soundtrack extends Product {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(nullable = false)
    private String album;
    @Column(nullable = false)
    private String artist;
    @Column(nullable = false)
    private Integer nbrOfTracks;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Soundtrack()
    {

    }

    public Soundtrack(String title, Integer nbrInStock, String image, String album, String artist, Integer nbrOfTracks) {
        super(title, nbrInStock, image);
        this.album = album;
        this.artist = artist;
        this.nbrOfTracks = nbrOfTracks;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
		this.artist = artist;
    }

    public Integer getNbrOfTracks() {
		return nbrOfTracks;
    }

    public void setNbrOfTracks(Integer nbrOfTracks) {
        this.nbrOfTracks = nbrOfTracks;
    }

}