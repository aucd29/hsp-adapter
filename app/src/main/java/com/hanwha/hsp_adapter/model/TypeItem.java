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

package com.hanwha.hsp_adapter.model;

import com.hanwha.libhsp_adapter.arch.adapter.IHspDiff;
import com.hanwha.libhsp_adapter.arch.adapter.IHspItem;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 28.. <p/>
 */
public class TypeItem implements IHspItem, IHspDiff {
    public static final int TYPE_SECTION = 1;
    public static final int TYPE_TITLE   = 0;

    public int type;
    public String title;

    public TypeItem(int type, String title) {
        this.type  = type;
        this.title = title;
    }

    @Override
    public int type() {
        return type;
    }

    @Override
    public boolean compare(Object item) {
        TypeItem newItem = (TypeItem) item;

        return this.type == newItem.type && this.title.equals(newItem.title);
    }
}
