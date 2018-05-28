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

import com.hanwha.hsp_adapter.model.TypeItem;
import com.hanwha.libhsp_adapter.arch.viewmodel.RecyclerViewModel;

import java.util.ArrayList;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 28.. <p/>
 */
public class TypeViewModel extends RecyclerViewModel<TypeItem> {
    int countTitle = 0;
    int countSection = 0;

    public TypeViewModel(@NonNull Application application) {
        super(application);

        initData();
        initAdapter(new String[] {
                "type_recycler_item_title",
                "type_recycler_item_section"});
    }

    private void initData() {
        ArrayList<TypeItem> items = new ArrayList<>();
        items.add(new TypeItem(TypeItem.TYPE_SECTION, "SECTION"));
        items.add(new TypeItem(TypeItem.TYPE_TITLE, "버튼을 선택하여 데이터를 추가하세요"));

        setItems(items);
    }

    public void addTitle() {
        this.items.add(new TypeItem(TypeItem.TYPE_TITLE, "추가 데이터 " + (++countTitle)));
    }

    public void addSection() {
        this.items.add(new TypeItem(TypeItem.TYPE_SECTION, "SECTION " + (++countSection)));
    }
}
