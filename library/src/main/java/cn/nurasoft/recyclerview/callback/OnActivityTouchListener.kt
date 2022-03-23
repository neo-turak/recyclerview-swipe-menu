package cn.nurasoft.recyclerview.callback

import android.view.MotionEvent
/**
 *@author   Hugo

 *@time    2022/3/23 下午1:56
 *@project  RecyclerView Library
 *Think Twice, Code Once!
 */
interface OnActivityTouchListener {
    fun getTouchCoordinates(ev: MotionEvent?)
}