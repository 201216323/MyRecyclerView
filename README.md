###网易栏目切换效果
点击下面的RecyclerView的item，会有一个view的移动的动画；动画完成以后，下面的RecyclerView会有一个item删除的动画，对应上面的RecyclerView有一个item增加的动画；然后拖动上面RecyclerView的item可以进行排序，左右滑动可以进行删除。
整体效果还是和网易新闻的Tabs很像，细节上处理稍微有点不一样。网易上面的item是点击删除，我这里处理成了滑动删除。


![这里写图片描述](http://img.blog.csdn.net/20160809180726893)



###高仿知乎的侧滑删除
偶尔看到知乎首页的侧滑删除，感觉还不错，当滑动的距离小于红块的一半，松开手指以后，会自动收缩当前item;当滑动的距离超过一半，松开手指以后，会自动将当前item删除。效果图如下：


![这里写图片描述](http://img.blog.csdn.net/20160615143043158)




###城市导航列表
左侧的列表根据拼音自动排序，支持头部悬停，点击Item会提示选择的城市；右侧是一个快速导航栏，点击字母会提示选择的字母，左侧列表会滑动到对应位置，支持导航栏快速滑动。


![这里写图片描述](http://img.blog.csdn.net/20160729171814268)



###RecyclerView实现的支持下拉刷新与上拉加载的SwipeRefreshLayout。
SwipeRefreshLayout作为官方的下拉刷新控件，简洁美观的风格使其广泛应用在项目中。美中不足的是SwipeRefreshLayout缺少上拉加载的效果，今天结合RecyclerView实现一个支持下拉刷新与上拉加载的SwipeRefreshLayout。

看一下最后实现的效果图：

![这里写图片描述](http://img.blog.csdn.net/20170110150342096?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdHlrMDkxMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)