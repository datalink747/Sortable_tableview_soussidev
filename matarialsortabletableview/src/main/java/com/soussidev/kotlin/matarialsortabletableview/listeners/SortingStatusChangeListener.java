package com.soussidev.kotlin.matarialsortabletableview.listeners;

import com.soussidev.kotlin.matarialsortabletableview.SortingStatus;

/**
 * Created by Soussi on 02/09/2017.
 */

public interface SortingStatusChangeListener {
    /**
     * Callback method that is called when the {@link SortingStatus} has changed.
     *
     * @param newSortingStatus The new {@link SortingStatus}.
     */
    void onSortingStatusChanged(final SortingStatus newSortingStatus);
}
