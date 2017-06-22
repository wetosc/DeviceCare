package com.labs.fi141.devicecare.ui;

import android.view.View;

/**
 * Created by eugenius on 5/20/17.
 */

public interface RecyclerViewClickListener {

    void onClick(View view, int position);
    void onLongClick(View view, int position);
}
