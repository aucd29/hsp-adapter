/*
 * Copyright (C) Hanwha S&C Ltd., 2018. All rights reserved.
 *
 * This software is covered by the license agreement between
 * the end user and Hanwha S&C Ltd., and may be
 * used and copied only in accordance with the terms of the
 * said agreement.
 *
 * Hanwha S&C Ltd., assumes no responsibility or
 * liability for any errors or inaccuracies in this software,
 * or any consequential, incidental or indirect damage arising
 * out of the use of the software.
 */

package com.hanwha.hsp_adapter.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.hanwha.hsp_adapter.R;
import com.hanwha.hsp_adapter.model.ImageItem;
import com.hanwha.libhsp_adapter.arch.viewmodel.RecyclerViewModel;

import java.util.ArrayList;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 28.. <p/>
 */
public class ImageViewModel extends RecyclerViewModel<ImageItem> {
    public ImageViewModel(@NonNull Application application) {
        super(application);

        ArrayList<ImageItem> items = new ArrayList<>();
        items.add(new ImageItem("money", R.drawable.ic_attach_money_black_24dp));
        items.add(new ImageItem("audio", R.drawable.ic_audiotrack_black_24dp));
        items.add(new ImageItem("battery", R.drawable.ic_battery_full_black_24dp));

        setItems(items);
        initAdapter("image_recycler_item");
    }
}
