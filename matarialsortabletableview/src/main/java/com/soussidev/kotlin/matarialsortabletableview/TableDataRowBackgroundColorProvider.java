package com.soussidev.kotlin.matarialsortabletableview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.soussidev.kotlin.matarialsortabletableview.colorizer.TableDataRowColorizer;
import com.soussidev.kotlin.matarialsortabletableview.providers.TableDataRowBackgroundProvider;

/**
 * Created by Soussi on 02/09/2017.
 */

public class TableDataRowBackgroundColorProvider <T> implements TableDataRowBackgroundProvider<T> {

    private final TableDataRowColorizer<T> colorizer;

    /**
     * Creates a new {@link TableDataRowBackgroundColorProvider} using the given {@link TableDataRowColorizer}.
     *
     * @param colorizer The {@link TableDataRowColorizer} that shall be wrapped.
     */
    public TableDataRowBackgroundColorProvider(final TableDataRowColorizer<T> colorizer) {
        this.colorizer = colorizer;
    }

    @Override
    public Drawable getRowBackground(final int rowIndex, final T rowData) {
        return new ColorDrawable(colorizer.getRowColor(rowIndex, rowData));
    }

}
