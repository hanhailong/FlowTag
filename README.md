# FlowTagLayout
Android流式布局，支持点击、单选、多选等，适合用于产品标签等，用法采用Adapter模式，和ListView、GridView用法一样！

2016/6/26号新添加初始化标签功能，使用非常简单，只要你的Adapter实现OnInitSelectedPosition即可，对于点击模式是不存在初始化标签一说的；对于单选模式来说，如果有多个初始化选择，则默认去第一个；对于多选来说正常使用！！！

****

##特色

* 填充数据和ListView、GridView用法一样使用Adapter，更新数据直接通过adapter.notifyDataChanged来更新
* 支持点击、单选、多选事件
* 三种模式：FLOW_TAG_CHECKED_NONE、FLOW_TAG_CHECKED_SINGLE、FLOW_TAG_CHECKED_MULTI
* 支持OnTagClickListener单点事件
* 支持OnTagSelectListener单选、多选事件

****

#效果图

![image](https://github.com/hanhailong/AndroidStudyResources/blob/master/screenshot/flow_tag.gif?raw=true)

#版本更新

##2016/6/26
* 添加初始化选中标签
    * 单选模式下初始化标签只有第一个起作用
    * 多选模式下只要设置初始化选中就可以
* 添加初始化选中标签代码示例
	 * Adapter实现OnInitSelectedPosition接口
	 * 实现接口中isSelectedPosition方法就可以，选中返回true，不选中默认返回false
	 
	 
			 public class TagAdapter<T> extends BaseAdapter implements OnInitSelectedPosition {
			 @Override
		    		public boolean isSelectedPosition(int position) {
		        	if (position % 2 == 0) {
		            	return true;
		        	}
		        	return false;
		    	}
			 }
    

#TODO

* 复用View...


#联系我

如果大家在使用过程中遇到任何问题都可以联系我，谢谢！！！最好是发邮件，我每天都会抽时间看一下我的邮箱：hanhailong.cool@163.com
