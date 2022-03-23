package cn.nurasoft.rvdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cn.nurasoft.recyclerview.RecyclerTouchListener
import cn.nurasoft.recyclerview.callback.OnRowClickListener
import cn.nurasoft.recyclerview.callback.OnSwipeOptionsClickListener


class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var recyclerviewAdapter: RecyclerviewAdapter
    private lateinit var touchListener: RecyclerTouchListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recyclerview)
        recyclerviewAdapter = RecyclerviewAdapter(this)
        val taskList: MutableList<Task> = ArrayList()
        var task = Task(
            "苹果",
            "苹果，是落叶乔木，通常树木可高至15米，但栽培树木一般只高3-5米左右。树干呈灰褐色，树皮有一定程度的脱落。苹果树开花期是基于各地气候而定，但一般集中在4-5月份。苹果是异花授粉植物，大部分品种自花不能结成果实",
            R.drawable.ic_apple
        )
        taskList.add(task)
        task = Task(
            "香蕉",
            "是芭蕉科、芭蕉属植物。植株丛生，具匐匍茎，矮型的高3.5米以下，一般高不及2米，高型的高4-5米，假茎均浓绿而带黑斑，被白粉，尤以上部为多。",
            R.drawable.ic_banana
        )
        taskList.add(task)
        task = Task("樱桃", "樱桃在中国久经栽培，品种颇多，供食用，也可酿樱桃酒。枝、叶、根、花也可供药用", R.drawable.ic_cherry)
        taskList.add(task)
        task = Task("梨", "梨，通常品种是一种落叶乔木或灌木，极少数品种为常绿，属于被子植物门双子叶植物纲蔷薇科苹果亚科。", R.drawable.ic_germo)
        taskList.add(task)
        task = Task(
            "桃",
            "蔷薇科、桃属植物。落叶小乔木；叶为窄椭圆形至披针形，长15厘米，宽4厘米，先端成长而细的尖端，边缘有细齿，暗绿色有光泽，叶基具有蜜腺",
            R.drawable.ic_peach
        )
        taskList.add(task)
        task = Task(
            "番茄",
            "西红柿，是 [9]  管状花目、茄科、番茄属的一种一年生或多年生草本植物，体高0.6～2米，全体生粘质腺毛，有强烈气味，茎易倒伏，叶羽状复叶或羽状深裂",
            R.drawable.ic_potato
        )
        taskList.add(task)
        recyclerviewAdapter.setTaskList(taskList)
        rv.adapter = recyclerviewAdapter
        touchListener = RecyclerTouchListener(this, rv)
        touchListener.setOnRowClickListener(object : OnRowClickListener {
                override fun onRowClicked(position: Int) {
                    Toast.makeText(applicationContext, taskList[position].name, Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onIndependentViewClicked(independentViewID: Int, position: Int) {}
            })
            .setSwipeOptionViews(R.id.img_edit, R.id.img_delete)
            .setOnSwipeOptionClickListener(R.id.clMain, R.id.llOption,object :
                OnSwipeOptionsClickListener {
                override fun onSwipeOptionClicked(viewID: Int, position: Int) {
                    when (viewID) {
                        R.id.img_delete -> {
                            taskList.removeAt(position)
                            recyclerviewAdapter.setTaskList(taskList)
                        }
                        R.id.img_edit -> Toast.makeText(
                            applicationContext,
                            "不能编辑",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        rv.addOnItemTouchListener(touchListener)
    }

    public override fun onResume() {
        super.onResume()
        rv.addOnItemTouchListener(touchListener)
    }
}