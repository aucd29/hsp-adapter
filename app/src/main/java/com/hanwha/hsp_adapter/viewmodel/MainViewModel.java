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
