package com.soussidev.kotlin.matarialsortabletableview.listeners;

/**
 * Created by Soussi on 02/09/2017.
 */

public interface TableHeaderClickListener {
    /**
     * This method is called of a table header was clicked.
     *
     * @param columnIndex The index of the column that was clicked.
     */
    void onHeaderClicked(final int columnIndex);

}
