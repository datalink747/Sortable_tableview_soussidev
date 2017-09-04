package com.soussidev.kotlin.sortable_tableview_soussidev.model;

/**
 * Created by Soussi on 02/09/2017.
 */

public class Marque_smartphone {

    private String name_marque;
    private int logo_marque;

    public Marque_smartphone(String name_marque, int logo_marque) {
        this.name_marque = name_marque;
        this.logo_marque = logo_marque;
    }

    public String getName_marque() {
        return name_marque;
    }

    public void setName_marque(String name_marque) {
        this.name_marque = name_marque;
    }

    public int getLogo_marque() {
        return logo_marque;
    }

    public void setLogo_marque(int logo_marque) {
        this.logo_marque = logo_marque;
    }
}
