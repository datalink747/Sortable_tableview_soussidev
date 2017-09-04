package com.soussidev.kotlin.sortable_tableview_soussidev;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.soussidev.kotlin.matarialsortabletableview.TableView;
import com.soussidev.kotlin.matarialsortabletableview.toolkit.LongPressAwareTableDataAdapter;
import com.soussidev.kotlin.sortable_tableview_soussidev.model.Smartphone;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by Soussi on 03/09/2017.
 */

public class SmartphoneTableDataAdapter extends LongPressAwareTableDataAdapter<Smartphone> {

    private static final int TEXT_SIZE = 14;
    private static final NumberFormat PRIX_FORMAT = NumberFormat.getNumberInstance();


    public SmartphoneTableDataAdapter(final Context context, final List<Smartphone> data, final TableView<Smartphone> tableView) {
        super(context, data, tableView);
    }

    @Override
    public View getDefaultCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        final Smartphone smartphone = getRowData(rowIndex);
        View renderedView = null;

        switch (columnIndex) {
            case 0:
                renderedView = renderProducerLogo(smartphone, parentView);
                break;
            case 1:
                renderedView = renderModelSmartphone(smartphone);
                break;
            case 2:
                renderedView = renderCatSmartphone(smartphone);

                break;
            case 3:
                renderedView = renderPrix(smartphone);
                break;
            case 4:
                renderedView = renderQTSmartphone(smartphone);
                break;
        }

        return renderedView;
    }

    @Override
    public View getLongPressCellView(int rowIndex, int columnIndex, ViewGroup parentView) {
        final Smartphone smartphone = getRowData(rowIndex);
        View renderedView = null;

        switch (columnIndex) {
            case 1:
                renderedView = renderEditableModeleOfSmartphone(smartphone);
                break;
            default:
                renderedView = getDefaultCellView(rowIndex, columnIndex, parentView);
        }

        return renderedView;
    }


    private View renderPrix(final Smartphone smartphone) {
        final String prix_smartphone = PRIX_FORMAT.format(smartphone.getPrix()) + " DT";

        final TextView textView = new TextView(getContext());
        textView.setText(prix_smartphone);
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);

        if (smartphone.getPrix() < 500) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.table_prix_bas));
        } else if (smartphone.getPrix() > 1000) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.table_prix_haute));
        }
        else if (smartphone.getPrix() > 500 && smartphone.getPrix() < 1000) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.table_prix_passable));
        }

        return textView;
    }

    private View renderString(final String value) {
        final TextView textView = new TextView(getContext());
        textView.setText(value);
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);
        return textView;
    }

    private View renderModelSmartphone(final Smartphone smartphone) {
        return renderString(smartphone.getModele());
    }

    private View renderCatSmartphone(final Smartphone smartphone) {
        return renderString(smartphone.getCat());
    }

    private View renderQTSmartphone(final Smartphone smartphone) {

        final TextView textView = new TextView(getContext());
        textView.setText(String.valueOf(smartphone.getQt()));
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);

        if (smartphone.getQt() > 10) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.table_prix_bas));
        } else if (smartphone.getQt() <= 10 && smartphone.getQt() >=2) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.table_prix_passable));
        }
          else if (smartphone.getQt() < 2) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.table_prix_haute));
    }

        return textView;
    }

    private View renderProducerLogo(final Smartphone smartphone, final ViewGroup parentView) {
        final View view = getLayoutInflater().inflate(R.layout.table_cell_image, parentView, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(smartphone.getMarque_smartphone().getLogo_marque());
        return view;
    }

    private static class SmartphoneModelUpdater implements TextWatcher {

        private Smartphone ModelUpdate;

        public SmartphoneModelUpdater(Smartphone ModelUpdate) {
            this.ModelUpdate = ModelUpdate;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // no used
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // not used
        }

        @Override
        public void afterTextChanged(Editable s) {
            ModelUpdate.setModele(s.toString());
        }
    }


    private View renderEditableModeleOfSmartphone(final Smartphone smartphone) {
        final EditText editText = new EditText(getContext());
        editText.setText(smartphone.getModele());
        editText.setPadding(20, 10, 20, 10);
        editText.setTextSize(TEXT_SIZE);
        editText.setSingleLine();
        editText.addTextChangedListener(new SmartphoneModelUpdater(smartphone));
        return editText;
    }
}



