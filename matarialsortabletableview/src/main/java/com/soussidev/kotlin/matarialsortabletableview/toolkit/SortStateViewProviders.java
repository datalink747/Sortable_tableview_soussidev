package com.soussidev.kotlin.matarialsortabletableview.toolkit;

import com.soussidev.kotlin.matarialsortabletableview.R;
import com.soussidev.kotlin.matarialsortabletableview.SortState;
import com.soussidev.kotlin.matarialsortabletableview.providers.SortStateViewProvider;

/**
 * Created by Soussi on 02/09/2017.
 */

public final class SortStateViewProviders {

    private SortStateViewProviders() {
        //no instance
    }

    /**
     * Gives a {@link SortStateViewProvider} that will provide dark (transparent black) arrows.
     *
     * @return The described {@link SortStateViewProvider}.
     */
    public static SortStateViewProvider darkArrows() {
        return new DarkSortStateViewProvider();
    }

    /**
     * Gives a {@link SortStateViewProvider} that will provide bright (transparent white) arrows.
     *
     * @return The described {@link SortStateViewProvider}.
     */
    public static SortStateViewProvider brightArrows() {
        return new BrightSortStateViewProvider();
    }


    private static class DarkSortStateViewProvider implements SortStateViewProvider {

        @Override
        public int getSortStateViewResource(final SortState state) {
            switch (state) {
                case SORTABLE:
                    return R.drawable.ic_dark_sortable;
                case SORTED_ASC:
                    return R.drawable.ic_dark_sorted_asc;
                case SORTED_DESC:
                    return R.drawable.ic_dark_sorted_desc;
                default:
                    return NO_IMAGE;
            }
        }
    }


    private static class BrightSortStateViewProvider implements SortStateViewProvider {

        @Override
        public int getSortStateViewResource(final SortState state) {
            switch (state) {
                case SORTABLE:
                    return R.drawable.ic_light_sortable;
                case SORTED_ASC:
                    return R.drawable.ic_light_sorted_asc;
                case SORTED_DESC:
                    return R.drawable.ic_light_sorted_desc;
                default:
                    return NO_IMAGE;
            }
        }
    }

}
