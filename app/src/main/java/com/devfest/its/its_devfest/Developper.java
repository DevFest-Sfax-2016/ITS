package com.devfest.its.its_devfest;

/**
 * Created by jihed on 27/11/2016.
 */

public class Developper {
    public String nom;
    public String prenom;
    public String email;
    public String tel;
    public int image;

    public Developper(String nom, String prenom, String email, int image,String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.image = image;
        this.tel = tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
