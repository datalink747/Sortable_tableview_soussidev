package com.soussidev.kotlin.sortable_tableview_soussidev;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.soussidev.kotlin.matarialsortabletableview.listeners.SwipeToRefreshListener;
import com.soussidev.kotlin.matarialsortabletableview.listeners.TableDataClickListener;
import com.soussidev.kotlin.matarialsortabletableview.listeners.TableDataLongClickListener;
import com.soussidev.kotlin.sortable_tableview_soussidev.model.Marque_smartphone;
import com.soussidev.kotlin.sortable_tableview_soussidev.model.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

final  SortableSmartphoneTableView smartphoneTableView = (SortableSmartphoneTableView) findViewById(R.id.tableView);

        if(smartphoneTableView !=null)
        {
            final SmartphoneTableDataAdapter smartphoneTableDataAdapter = new SmartphoneTableDataAdapter(this, DataListOfSmartphones(), smartphoneTableView);

            smartphoneTableView.setDataAdapter(smartphoneTableDataAdapter);
            smartphoneTableView.addDataClickListener(new SmartphoneClickListener());
            smartphoneTableView.addDataLongClickListener(new SmartphoneLongClickListener());
            smartphoneTableView.setSwipeToRefreshEnabled(true);
            smartphoneTableView.setSwipeToRefreshListener(new SwipeToRefreshListener() {
                @Override
                public void onRefresh(final RefreshIndicator refreshIndicator) {

                    smartphoneTableView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            refreshIndicator.hide();
                            Toast.makeText(MainActivity.this, "Update Table: ", Toast.LENGTH_SHORT).show();
                        }
                    }, 3000);

                }
            });
        }

    }

    private class SmartphoneClickListener implements TableDataClickListener<Smartphone> {

        @Override
        public void onDataClicked(final int rowIndex, final Smartphone clickedData) {
            final String Phone = "Marque: " + clickedData.getMarque_smartphone().getName_marque() + "Modele: " + clickedData.getModele();
            Toast.makeText(MainActivity.this, Phone, Toast.LENGTH_SHORT).show();
        }
    }

    private class SmartphoneLongClickListener implements TableDataLongClickListener<Smartphone> {

        @Override
        public boolean onDataLongClicked(final int rowIndex, final Smartphone clickedData) {
            final String phone = "Edit Modele: " + clickedData.getMarque_smartphone().getName_marque() + " " + clickedData.getModele();
            Toast.makeText(MainActivity.this, phone, Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    //lists of Data

    public static List<Smartphone> DataListOfSmartphones() {
        final Marque_smartphone Samsung = new Marque_smartphone("Samsung", R.mipmap.samsung_pic);
        final Smartphone Galaxy_s1 = new Smartphone(Samsung, "Galaxy S1", 350, "3G",5);
        final Smartphone Galaxy_s2 = new Smartphone(Samsung, "Galaxy S2", 450, "3G",10);
        final Smartphone Galaxy_s3 = new Smartphone(Samsung, "Galaxy S3", 550, "3G",4);
        final Smartphone Galaxy_s4 = new Smartphone(Samsung, "Galaxy S4", 650, "4G",30);
        final Smartphone Galaxy_s5 = new Smartphone(Samsung, "Galaxy S5", 950, "4G",45);
        final Smartphone Galaxy_s6 = new Smartphone(Samsung, "Galaxy S6",1350, "4G",1);
        final Smartphone Galaxy_s7 = new Smartphone(Samsung, "Galaxy S7", 1850, "4G",23);
        final Smartphone Galaxy_s8 = new Smartphone(Samsung, "Galaxy S8", 2350, "4G",13);

        final Marque_smartphone Sony = new Marque_smartphone("Sony", R.mipmap.sony_pic);
        final Smartphone Xperia_z1 = new Smartphone(Sony, "Xperia Z1", 550, "3G",15);
        final Smartphone Xperia_z2 = new Smartphone(Sony, "Xperia Z2", 750, "3G",22);
        final Smartphone Xperia_z3 = new Smartphone(Sony, "Xperia Z3", 1150, "4G",12);
        final Smartphone Xperia_z4 = new Smartphone(Sony, "Xperia Z4", 1950, "4G",2);
        final Smartphone Xperia_z5 = new Smartphone(Sony, "Xperia Z5", 2250, "4G",7);

        final Marque_smartphone Google_pixel = new Marque_smartphone("Google Pixel", R.mipmap.google_pixel_pic);
        final Smartphone Pixel = new Smartphone(Google_pixel, "Pixel", 1550, "LTE",6);
        final Smartphone Pixel_XL = new Smartphone(Google_pixel, "Pixel XL", 2150, "LTE",17);

        final List<Smartphone> smartphones = new ArrayList<>();
        smartphones.add(Galaxy_s1);
        smartphones.add(Galaxy_s2);
        smartphones.add(Galaxy_s3);
        smartphones.add(Galaxy_s4);
        smartphones.add(Galaxy_s5);
        smartphones.add(Galaxy_s6);
        smartphones.add(Galaxy_s7);
        smartphones.add(Galaxy_s8);

        smartphones.add(Xperia_z1);
        smartphones.add(Xperia_z2);
        smartphones.add(Xperia_z3);
        smartphones.add(Xperia_z4);
        smartphones.add(Xperia_z5);

        smartphones.add(Pixel);
        smartphones.add(Pixel_XL);

        return smartphones;
    }

}
