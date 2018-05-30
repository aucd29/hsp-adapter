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
