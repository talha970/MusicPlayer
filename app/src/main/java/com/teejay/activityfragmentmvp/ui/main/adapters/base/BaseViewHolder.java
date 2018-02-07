package com.teejay.activityfragmentmvp.ui.main.adapters.base;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tjaved on 2/2/18.
 */

public abstract class BaseViewHolder<T, L extends BaseRecycleListener> extends RecyclerView.ViewHolder  {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void onBind(T item, @Nullable L listener);

}
