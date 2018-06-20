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

import com.hanwha.libhsp_adapter.arch.adapter.IHspDiff;
import com.hanwha.libhsp_adapter.arch.adapter.IHspItem;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 6. 11.. <p/>
 */
public interface BaseTypeItem extends IHspItem, IHspDiff {
    int TYPE_SECTION = 1;
    int TYPE_TITLE   = 0;
}