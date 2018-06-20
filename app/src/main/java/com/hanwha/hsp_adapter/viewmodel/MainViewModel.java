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
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.hanwha.hsp_adapter.model.MainItem;
import com.hanwha.hsp_adapter.view.ImageFrgmt;
import com.hanwha.hsp_adapter.view.TypeFrgmt;
import com.hanwha.libhsp_adapter.arch.viewmodel.RecyclerViewModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 28.. <p/>
 */
public class MainViewModel extends RecyclerViewModel<MainItem> {
    private static final Logger mLog = LoggerFactory.getLogger(MainViewModel.class);
    public MutableLiveData<Class> changeFrgmt;

    public MainViewModel(@NonNull Application application) {
        super(application);

        initData();
        initAdapter("main_recycler_item");
    }

    public void init() {
        changeFrgmt = new MutableLiveData<>();
    }

    private void initData() {
        ArrayList<MainItem> mainItems = new ArrayList<>();

        mainItems.add(new MainItem("type", TypeFrgmt.class));
        mainItems.add(new MainItem("image", ImageFrgmt.class));

        setItems(mainItems);

        if (mLog.isDebugEnabled()) {
            mLog.debug("ITEM SIZE : " + mainItems.size());
        }
    }

    public void show(Class clazz) {
        if (mLog.isDebugEnabled()) {
            mLog.debug("CLASS : " + clazz.getSimpleName());
        }

        changeFrgmt.setValue(clazz);
    }
}
