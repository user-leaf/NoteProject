package com.bamboo.nano.popup;

import android.content.Context;
import android.view.animation.Animation;

import com.bamboo.nano.R;

import razerdp.basepopup.BasePopupWindow;
import razerdp.util.animation.AlphaConfig;
import razerdp.util.animation.AnimationHelper;

public class MyPopupArrow extends BasePopupWindow {

    public MyPopupArrow(Context context) {
        super(context);
        setContentView(createPopupById(R.layout.popup_arrow));
    }

    @Override
    protected Animation onCreateShowAnimation(int width, int height) {
        return AnimationHelper.asAnimation()
                .withAlpha(AlphaConfig.IN)
                .toShow();
    }

    @Override
    protected Animation onCreateDismissAnimation(int width, int height) {
        return AnimationHelper.asAnimation()
                .withAlpha(AlphaConfig.OUT)
                .toDismiss();
    }


}
