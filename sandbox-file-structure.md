# 沙盒文件结构 #

![](http://i.imgur.com/tzxmWs7.png)

![](http://i.imgur.com/z1BOhmu.png)

![](http://i.imgur.com/2GK5r59.png)


### \system\\app ###

　　这个里面主要存放的是常规下载的应用程序，可以看到都是以APK格式结尾的文件。在这个文件夹下的程序为系统默认的组件，自己安装的软件将不会出现在这里，而是\\data\\文件夹中。



### \\system\\bin ###

　　这个目录下的文件都是系统的本地程序，从bin文件夹名称可以看出是binary二进制的程序，里面主要是Linux系统自带的组件，



### \\system\\etc ###

　　从文件夹名称来看保存的都是系统的配置文件，比如APN接入点设置等核心配置。



### \\system\\fonts ###

　　字体文件夹，除了标准字体和粗体、斜体外可以看到文件体积最大的可能是中文字库，或一些unicode字库，



### \\system\\framework ###

　　framework主要是一些核心的文件，从后缀名为jar可以看出是是系统平台框架。

### \\system\\lib ###

　　lib目录中存放的主要是系统底层库，如平台运行时库。



### \\system\\media ###

　　铃声音乐文件夹，除了常规的铃声外还有一些系统提示事件音


### \\system\\sounds ###

　　默认的音乐测试文件，仅有一个test.mid文件，用于播放测试的文件。

　　\\system\\sounds\\test.mid



### \\system\\usr ###

　　用户文件夹，包含共享、键盘布局、时间区域文件等。



　　另外，除系统文件夹结构外，再来一些文件夹介绍，供大家参考。

　　cache ：缓存临时文件夹，基本别无用处。

　　data ：存放用户安装的软件以及各种数据。

　　default.prop : 默认配置文件

　　dev ：设备节点文件的存放地

　　etc ： 指向 /system/etc ，配置文件存放目录

　　init : 系统启动到文件系统的时候第一个运行的程序。

　　init.goldfish.rc : 初始化文件

　　init.rc : 初始化文件

　　proc ： /proc文件系统下的多种文件提供的系统信息不是针对某个特定进程的，而是能够在整个系统范围的上下文中使用。

　　root ：为空 。

　　sbin：只放了一个用於调试的adbd程序

　　sdcard：是SD卡中的FAT32文件系统挂载的目录

　　sqlite_stmt_journals: 一个根目录下的tmpfs文件系统，用於存放临时文件数据。

　　sys ：用於挂载 sysfs文件系统。 在设备模型中,sysfs文件系统用来表示设备的结构.将设备的层次结构形象的反应到用户空间中.用户空间可以修改sysfs中的文件属性来修改设备的属性值

　　system ：系统中的大部分东西都在这各目录下，很重要的一个目录文件

　　xbin ：下放了很多系统管理工具，这些工具不是到toolbox的链接，每个都是可执行程序。如果你看到这些命令你会发现他们根本不常用，他们都是为系统管理员准备的，是一些系统管理和配置工具。这个文件夹的作用相当於标准Linux文件系统中的 /sbin。

　　modules：使用来存放内核模块(主要是fs和net)和模块配置文件的地方。

　　framework： 是JAVA平台的一些核心文件，属於JAVA平台系统框架文件。里面的文件都是.jar和.odex文件。

　　备注：什么是odex文件? odex是被优化过的JAVA程序文件，体积通常是.jar的4倍左右。执行效率比.jar高。

　　fonts ：字体库文件的存放目录。

　　etc ：这里存放了系统中几乎所有的配置文件，根目录下的/etc就链结於此。

　　build.prop ：是一个属性文件，在Android系统中.prop文件很重要，记录了系统的设置和改变，类似於/etc中的文件。

　　media ：里面主要是存放了系统的铃声的，分为 notificati**(通知)、ui(界面)、alarms(警告)和ringtones(铃声)，里面都是.ogg音频文件。

　　bin ：是存放用户常用的工具程序的，其中大部分是到toolbox的链接(类似嵌入式Linux中的busybox)。toolbox应该是 google简化版的busybox。

　　usr ：用户的配置文件，如键盘布局、共享、时区文件等等。您可以cat 来看看。

　　app ：存放的是Android系统自带的JAVA应用程序。

　　lost found ：yaffs文件系统固有的，类似回收站的文件夹，只有是yaffs文件系统都会有。

　　lib ：存放几乎所有的共享库(.so)文件。

　　sd ：SD卡中的EXT2分区的挂载目录

　　init.rc :一个初始化脚本，用於将/system/modules和/system/xbin挂载为cramfs，避免系统被无意破坏


