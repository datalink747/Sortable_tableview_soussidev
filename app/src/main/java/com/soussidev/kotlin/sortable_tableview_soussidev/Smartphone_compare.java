package com.soussidev.kotlin.sortable_tableview_soussidev;

import com.soussidev.kotlin.sortable_tableview_soussidev.model.Smartphone;

import java.util.Comparator;

/**
 * Created by Soussi on 02/09/2017.
 */

public class Smartphone_compare {

    public Smartphone_compare() {
    }

    private static class MarqueCompare implements Comparator<Smartphone> {

        @Override
        public int compare(final Smartphone smartphone1, final Smartphone smartphone2) {
            return smartphone1.getMarque_smartphone().getName_marque().compareTo(smartphone2.getMarque_smartphone().getName_marque());
        }
    }

    private static class ModeleSmartphoneCompare implements Comparator<Smartphone> {

        @Override
        public int compare(final Smartphone smartphone1, final Smartphone smartphone2) {
            return smartphone1.getModele().compareTo(smartphone2.getModele());
        }
    }

    private static class CatSmartphoneCompare implements Comparator<Smartphone> {

        @Override
        public int compare(final Smartphone smartphone1, final Smartphone smartphone2) {
            return smartphone1.getCat().compareTo(smartphone2.getCat());
        }
    }

    private static class PrixSmartphoneCompare implements Comparator<Smartphone> {

        @Override
        public int compare(final Smartphone smartphone1, final Smartphone smartphone2) {
            if (smartphone1.getPrix() < smartphone2.getPrix()) return -1;
            if (smartphone1.getPrix() > smartphone2.getPrix()) return 1;
            return 0;
        }
    }

    private static class Qt_SmartphoneCompare implements Comparator<Smartphone> {

        @Override
        public int compare(final Smartphone smartphone1, final Smartphone smartphone2) {
            return smartphone1.getQt() - smartphone2.getQt();
        }
    }



    public static Comparator<Smartphone> getMarqueCompare() {
        return new MarqueCompare();
    }

    public static Comparator<Smartphone> getModeleSmartphoneCompare() {
        return new ModeleSmartphoneCompare();
    }

    public static Comparator<Smartphone> getCatSmartphoneCompare() {
        return new CatSmartphoneCompare();
    }

    public static Comparator<Smartphone> getPrixSmartphoneCompare() {
        return new PrixSmartphoneCompare();
    }

    public static Comparator<Smartphone> getQt_SmartphoneCompare() {
        return new Qt_SmartphoneCompare();
    }


}
