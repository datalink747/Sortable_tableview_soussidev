package com.soussidev.kotlin.sortable_tableview_soussidev;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.soussidev.kotlin.matarialsortabletableview.SortableTableView;
import com.soussidev.kotlin.matarialsortabletableview.model.TableColumnWeightModel;
import com.soussidev.kotlin.matarialsortabletableview.toolkit.SimpleTableHeaderAdapter;
import com.soussidev.kotlin.matarialsortabletableview.toolkit.SortStateViewProviders;
import com.soussidev.kotlin.matarialsortabletableview.toolkit.TableDataRowBackgroundProviders;
import com.soussidev.kotlin.sortable_tableview_soussidev.model.Smartphone;

/**
 * Created by Soussi on 02/09/2017.
 */

public class SortableSmartphoneTableView  extends SortableTableView {

    public SortableSmartphoneTableView(final Context context) {
        this(context, null);
    }

    public SortableSmartphoneTableView(final Context context, final AttributeSet attributes) {
        this(context, attributes, android.R.attr.listViewStyle);
    }

    public SortableSmartphoneTableView(final Context context, final AttributeSet attributes, final int styleAttributes) {
        super(context, attributes, styleAttributes);

        final SimpleTableHeaderAdapter simpleTableHeaderAdapter = new SimpleTableHeaderAdapter(context, R.string.marque, R.string.model, R.string.cat, R.string.prix, R.string.qantite);
        simpleTableHeaderAdapter.setTextColor(ContextCompat.getColor(context, R.color.table_header_text));
        setHeaderAdapter(simpleTableHeaderAdapter);

        final int rowColorEven = ContextCompat.getColor(context, R.color.table_data_row_even);
        final int rowColorOdd = ContextCompat.getColor(context, R.color.table_data_row_odd);
        setDataRowBackgroundProvider(TableDataRowBackgroundProviders.alternatingRowColors(rowColorEven, rowColorOdd));
        setHeaderSortStateViewProvider(SortStateViewProviders.brightArrows());

        final TableColumnWeightModel tableColumnWeightModel = new TableColumnWeightModel(5);
        tableColumnWeightModel.setColumnWeight(0, 3);
        tableColumnWeightModel.setColumnWeight(1, 3);
        tableColumnWeightModel.setColumnWeight(2, 2);
        tableColumnWeightModel.setColumnWeight(3, 3);
        tableColumnWeightModel.setColumnWeight(4, 2);
        setColumnModel(tableColumnWeightModel);

        setColumnComparator(0, Smartphone_compare.getMarqueCompare());
        setColumnComparator(1, Smartphone_compare.getModeleSmartphoneCompare());
        setColumnComparator(2, Smartphone_compare.getCatSmartphoneCompare());
        setColumnComparator(3, Smartphone_compare.getPrixSmartphoneCompare());
        setColumnComparator(4, Smartphone_compare.getQt_SmartphoneCompare());
    }
}
