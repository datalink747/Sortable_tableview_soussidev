package com.soussidev.kotlin.matarialsortabletableview.listeners;

/**
 * Created by Soussi on 02/09/2017.
 */

public interface SwipeToRefreshListener {

    void onRefresh(final RefreshIndicator refreshIndicator);

    /**
     * Interface representing the refresh indicator shown to the user.
     */
    interface RefreshIndicator {

        /**
         * Hides the refresh indicator shown to the user.
         */
        void hide();

        /**
         * Shows the refresh indicator to the user.
         */
        void show();

        /**
         * Indicates whether or not the refresh indicator is shown to the user.
         *
         * @return Boolean indicating whether or not the refresh indicator is shown to the user.
         */
        boolean isVisible();
    }

}
