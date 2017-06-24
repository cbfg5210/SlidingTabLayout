# SlidingTabLayout

SlidingTabLayout主要解决了android的TabLayout不能定义指示条长度与Tab文字长度相等的问题

## 效果图：

![slidingtablayout.gif](https://raw.githubusercontent.com/cbfg5210/SlidingTabLayout/master/capture/slidingtablayout.gif)


## 使用：

Step 1. Add the JitPack repository to your build file

allprojects {

		repositories {
    
			...
      
			maven { url 'https://jitpack.io' }
      
		}
	}
  
 
 Step 2. Add the dependency
 
 dependencies {
 
		compile 'com.github.cbfg5210:SlidingTabLayout:v1.0'
    
	}
