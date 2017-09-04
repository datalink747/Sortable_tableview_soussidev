package com.soussidev.kotlin.matarialsortabletableview;

import android.view.View;

import com.soussidev.kotlin.matarialsortabletableview.listeners.TableHeaderClickListener;

import java.util.Set;

/**
 * Created by Soussi on 02/09/2017.
 */

public class InternalHeaderClickListener implements View.OnClickListener {

    private final Set<TableHeaderClickListener> listeners;
    private final int columnIndex;

    public InternalHeaderClickListener(final int columnIndex, final Set<TableHeaderClickListener> listeners) {
        this.columnIndex = columnIndex;
        this.listeners = listeners;
    }

    @Override
    public void onClick(final View view) {
        informHeaderListeners();
    }

    private void informHeaderListeners() {
        for (final TableHeaderClickListener listener : listeners) {
            try {
                listener.onHeaderClicked(columnIndex);
            } catch (final Throwable t) {
                t.printStackTrace();
                // continue calling listeners
            }
        }
    }
}

