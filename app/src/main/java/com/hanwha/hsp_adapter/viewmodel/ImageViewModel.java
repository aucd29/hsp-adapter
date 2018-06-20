/*
 * Copyright (C) Hanwha System Corp. 2018. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
