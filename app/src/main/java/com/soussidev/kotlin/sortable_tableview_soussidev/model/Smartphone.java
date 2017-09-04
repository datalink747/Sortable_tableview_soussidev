package com.soussidev.kotlin.sortable_tableview_soussidev.model;

/**
 * Created by Soussi on 02/09/2017.
 */

public class Smartphone {

    private String modele;
    private Marque_smartphone marque_smartphone;
    private double prix;
    private String cat;
    private int qt;

    public Smartphone(Marque_smartphone marque_smartphone, String modele, double prix, String cat, int qt) {
        this.modele = modele;
        this.marque_smartphone = marque_smartphone;
        this.prix = prix;
        this.cat = cat;
        this.qt = qt;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Marque_smartphone getMarque_smartphone() {
        return marque_smartphone;
    }

    public void setMarque_smartphone(Marque_smartphone marque_smartphone) {
        this.marque_smartphone = marque_smartphone;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }
}
