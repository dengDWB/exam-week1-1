# 视图生命周期 #
![](http://i.imgur.com/7nMEW4v.png)

## onCreate() ##
	当Activity首次加载的时候调用的方法，在onCreate()事件中注意savedInstanceState参数，这个参数在可以记录一些信息，比如你的Activity在onStop()事件中可以把一些数据存储在这个参数中，当在进入Activity时，可以从这个参数中获得一些数据，那个这Activity在你进入前和后一样的

## onStart()  ##

	onCreate事件之后执行，Activity已经执行了onStop事件，但是Activity并没有被销毁，用户再次重新查看Activity时会执行onRestart事件，之后会跳过onCreate事件，直接执行Activity的onStart事 件。 

## onResume()  ##

	onStart事件之后执行，Activity还没有被销毁，也没有执行过onStop事件（Activity还继续存在于Task中），则会跳过Activity的onCreate和onStart事件，直接执行onResume事件

## onPause()  ##

	Activity处于可见不可以点击的时候执行

## onStop()  ##
	onPause事件之后执行。如果一段时间内用户还没有重新查看该Activity，则该Activity的onStop事件将会被执行；或者用户直接按了Back键，将该Activity从当前Task中移除，也会执行该Activity的onStop事件

## onRestart()  ##

	onStop事件执行后，如果Activity没有被系统销毁，此时用户又重新查看该Activity，则会执行Activity的onRestart事件，onRestart事件后会跳过Activity的onCreate事件直接执行onStart事件。

## onDestroy()  ##
	Activity被销毁的时候执行，在Activity的onStop事件之后，如果没有再次查看该Activity，Activity则会被销毁

## 一些情形 ##

- 情形一、一个单独的Activity的正常的生命过程是这样的：onCreate->onStart->onPause->onStop->onDestroy。例如：运行一个Activity，进行了一些简单操作（不涉及页面的跳转等），然后按返回键结束。


- 情形二、有两个Activity（a和b），一开始显示a，然后由a启动b，然后在由b回到a，这时候a的生命过程应该是怎么样的呢（a被b完全遮盖）？

	a经历的过程为onCreate->onStart->onResume->onPause->onStop->onRestart->onStart->onResume。这个过程说明了图中，如果Activity完全被其他界面遮挡时，进入后台，并没有完全销毁,而是停留在onStop状态，当再次进入a时，onRestart->onStart->onResume，又重新恢复。

- 情形三、基本情形同二一样，不过此时a被b部分遮盖（比如给b添加个对话框主题 Android:theme="@android:style/Theme.Dialog"）

	a经历的过程是：onCreate->onStart->onResume->onPause->onResume

	所以当Activity被部分遮挡时，Activity进入onPause，并没有进入onStop，从Activity2返回后，执行了onResume

- 情形四、 打开程序，启动a，点击a，启动AlertDialog，按返回键从AlertDialog返回。
	a经历的过程是：onCreate->onStart->onResume

	当启动和退出Dialog时，Activity的状态始终未变，可见，Dialog实际上属于Acitivity内部的界面，不会影响Acitivty的生命周期。