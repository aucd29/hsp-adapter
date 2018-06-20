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

package com.hanwha.hsp_adapter.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hanwha.hsp_adapter.R;
import com.hanwha.hsp_adapter.ViewController;
import com.hanwha.hsp_adapter.base.BaseFragment;
import com.hanwha.hsp_adapter.base.FragmentParams;
import com.hanwha.hsp_adapter.databinding.FrgmtMainBinding;
import com.hanwha.hsp_adapter.viewmodel.MainViewModel;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 28.. <p/>
 */
public class MainFrgmt extends BaseFragment<FrgmtMainBinding> {
    @Override
    protected int layoutId() {
        return R.layout.frgmt_main;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainViewModel vmodel = viewModel(MainViewModel.class);
        vmodel.init();
        vmodel.changeFrgmt.observe(this, classType -> {
//            ViewController.get(getActivity()).replace(R.id.main_layout, classType);

            ViewController.get(this).show(FragmentParams.builder()
                    .containerId(R.id.main_layout)
                    .fragment(classType)
                    .build());
        });

        mBinding.setVmodel(vmodel);
    }
}
