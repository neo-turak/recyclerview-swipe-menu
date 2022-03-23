package cn.nurasoft.rvdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cn.nurasoft.rvdemo.RecyclerviewAdapter.MyViewHolder

class RecyclerviewAdapter internal constructor(private val mContext: Context) :
    RecyclerView.Adapter<MyViewHolder>() {
    private var taskList: List<Task>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.task_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (name, desc,logo) = taskList[position]
        holder.tvTaskName.text = name
        holder.tvTaskDesc.text = desc
        holder.ivLogo.setImageDrawable(ContextCompat.getDrawable(mContext,logo))
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setTaskList(taskList: List<Task>) {
        this.taskList = taskList
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val tvTaskName: TextView = itemView.findViewById(R.id.task_name)
         val tvTaskDesc: TextView = itemView.findViewById(R.id.task_desc)
        val ivLogo:ImageView=itemView.findViewById(R.id.logo)
    }

    init {
        taskList = ArrayList()
    }
}