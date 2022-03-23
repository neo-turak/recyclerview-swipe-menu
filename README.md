# recyclerview-swipe-menu
# RecyclerView 滑动删除
RecyclerView swipe menu item.
可以通过右滑出现删除等操作菜单。
还包括点击，长按事件。

[![](https://jitpack.io/v/Neo-Turak/recyclerview-swipe-menu.svg)](https://jitpack.io/#Neo-Turak/recyclerview-swipe-menu)
# 使用方法：
# How to Use
1.添加jitPack Maven仓库：
1.Add it in your root build.gradle at the end of repositories:
```groovy

    allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

2.添加依赖
2. Add the dependency
```groovy
    dependencies {
        implementation 'com.github.Neo-Turak:recyclerview-swipe-menu:v1.0.0'
    }
```

2.创建TouchListener实例
```kotlin
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


![效果](img/screenshot1.png "效果图1")  

左边滑动后。  

![效果](img/screenshot2.png "效果图2")  

