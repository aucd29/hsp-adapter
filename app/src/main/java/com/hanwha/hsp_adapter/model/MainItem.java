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

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 28.. <p/>
 */
public class MainItem {
    public String title;
    public Class clazz;

    public MainItem(String title, Class clazz) {
        this.title = title;
        this.clazz = clazz;
    }
}
