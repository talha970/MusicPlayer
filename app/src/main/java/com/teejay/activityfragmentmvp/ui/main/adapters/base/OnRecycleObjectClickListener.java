package com.teejay.activityfragmentmvp.ui.main.adapters.base;

/**
 * Created by tjaved on 2/2/18.
 */

public interface OnRecycleObjectClickListener<T> extends BaseRecycleListener {
    void OnItemClick(T item);
}
