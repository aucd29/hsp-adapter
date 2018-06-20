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

package com.hanwha.hsp_adapter.model;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 6. 11.. <p/>
 */
public class TypeItemSection implements BaseTypeItem {
    public String title;
    public int color;

    public TypeItemSection(String title) {
        this.title = title;
        this.color = 0xffdfdfdf;
    }

    @Override
    public int type() {
        return BaseTypeItem.TYPE_SECTION;
    }

    @Override
    public boolean compare(Object item) {
        TypeItemSection newItem = (TypeItemSection) item;

        return this.title.equals(newItem.title) && color == newItem.color;
    }
}
