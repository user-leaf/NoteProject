package com.sesame.module_test.test_anim

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.LayoutAnimationController
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_test.R
import kotlinx.android.synthetic.main.activity_test_anim.*

class AnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_anim)

        val tvBlue = findViewById<TextView>(R.id.tvBlue)
        tvBlue.setOnClickListener {
//            val translateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_translate)
//            tvBlue.startAnimation(translateAnimation)

//            tvBlue.animate().rotation(360f).duration = 2000

//            val objectAnimator = ObjectAnimator.ofInt(tvValue, "value", 102, 923)
//            objectAnimator.duration = 5000
//            objectAnimator.interpolator = AccelerateInterpolator()
//            objectAnimator.start()

            layoutAnimation()
        }
    }

    private fun layoutAnimation() {
        val animation = AlphaAnimation(0f, 1f)
        animation.duration = 2000
        val controller = LayoutAnimationController(animation, 1f)
        controller.order = LayoutAnimationController.ORDER_NORMAL
        flContainer.layoutAnimation = controller

        for (index in 0..3) {
            val inflate = layoutInflater.inflate(R.layout.layout_animation, flContainer, false)
            flContainer.addView(inflate)
        }
    }
}