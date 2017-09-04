package com.soussidev.kotlin.matarialsortabletableview.providers;

import com.soussidev.kotlin.matarialsortabletableview.SortState;

/**
 * Created by Soussi on 02/09/2017.
 */

public interface SortStateViewProvider {

    int NO_IMAGE = 0;

    /**
     * Gives the drawable resource for the given {@link SortState}.
     *
     * @param state The {@link SortState} to return the drawable resource for.
     * @return The drawable resource for the given {@link SortState}.
     */
    int getSortStateViewResource(final SortState state);
}
