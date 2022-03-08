package com.bamboo.nano.message

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bamboo.nano.R
import com.bamboo.nano.model.MessageInfo
import com.bamboo.nano.model.NoticeInfo
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

fun viewPagerAdapter(
    supportFragmentManager: FragmentManager,
    fragments: List<Fragment>
) = object :
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}

class NoticeAdapter : BaseQuickAdapter<NoticeInfo, BaseViewHolder>(R.layout.item_notice) {

    override fun convert(helper: BaseViewHolder, item: NoticeInfo) {
        helper.setText(R.id.tvTitle, item.title)
        helper.setBackgroundRes(R.id.tvTitle, if (!item.read) android.R.color.holo_blue_dark else android.R.color.holo_blue_light)
    }
}

class MessageAdapter: BaseQuickAdapter<MessageInfo, BaseViewHolder>(R.layout.item_message){
    override fun convert(helper: BaseViewHolder, item: MessageInfo?) {
        helper.setText(R.id.tvTitle, item?.title)
        helper.setText(R.id.tvSubTitle, item?.subTitle)
    }
}