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

import com.hanwha.hsp_adapter.model.BaseTypeItem;
import com.hanwha.hsp_adapter.model.TypeItem;
import com.hanwha.hsp_adapter.model.TypeItemSection;
import com.hanwha.libhsp_adapter.arch.viewmodel.RecyclerViewModel;

import java.util.ArrayList;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 28.. <p/>
 */
public class TypeViewModel extends RecyclerViewModel<BaseTypeItem> {
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
        ArrayList<BaseTypeItem> items = new ArrayList<>();
        items.add(new TypeItemSection("SECTION"));
        items.add(new TypeItem("버튼을 선택하여 데이터를 추가하세요"));

        setItems(items);
    }

    public void addTitle() {
        this.items.add(new TypeItem("추가 데이터 " + (++countTitle)));
    }

    public void addSection() {
        this.items.add(new TypeItemSection("SECTION " + (++countSection)));
    }
}
