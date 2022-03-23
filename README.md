# recyclerview-swipe-menu
# RecyclerView 滑动删除
RecyclerView swipe menu item.
可以通过右滑出现删除等操作菜单。
还包括点击，长按事件。


![效果](img/screenshot1.png "效果图1")  

左边滑动后。  

![效果](img/screenshot2.png "效果图2")  

使用方法：
1.引入gradle依赖：
```
  implementation 'androidx.core:core-ktx:1.7.0'

```

2.创建TouchListener实例
```
//RecyclerView
val rv:RecyclerView=view.findView(R.id.recyclerView)
//Touch Listener
val touchListener = RecyclerTouchListener(this, rv)
        touchListener.setOnRowClickListener(object : OnRowClickListener {
                override fun onRowClicked(position: Int) {
                    //Item Click Events
                }

                override fun onIndependentViewClicked(independentViewID: Int, position: Int) {}
            })
            //register the Menu Options View ID
            .setSwipeOptionViews(R.id.img_edit, R.id.img_delete)
            //Main ViewGroup and Menu ViewGroup
            .setOnSwipeOptionClickListener(R.id.clMain, R.id.llOption,object :
                OnSwipeOptionsClickListener {
                override fun onSwipeOptionClicked(viewID: Int, position: Int) {
                    when (viewID) {
                        R.id.img_delete -> {
                            //Do something
                        }
                        R.id.img_edit ->{
                            //Do something
                        }
                    }
                }
            })
            //attach to RecyclerView
        rv.addOnItemTouchListener(touchListener)

```