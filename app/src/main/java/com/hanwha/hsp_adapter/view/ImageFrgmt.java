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
import com.hanwha.hsp_adapter.base.BaseFragment;
import com.hanwha.hsp_adapter.viewmodel.ImageViewModel;
import com.hanwha.hsp_adapter.databinding.FrgmtImageBinding;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2018. 5. 28.. <p/>
 */
public class ImageFrgmt extends BaseFragment<FrgmtImageBinding> {
    @Override
    protected int layoutId() {
        return R.layout.frgmt_image;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageViewModel vmodel = viewModel(ImageViewModel.class);
        mBinding.setVmodel(vmodel);
    }
}
