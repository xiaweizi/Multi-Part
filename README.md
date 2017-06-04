##对 `ListView` 的 `BaseAdapter` 简单的封装，实现多布局样式

####效果预览图

![](http://upload-images.jianshu.io/upload_images/4043475-011fd7cd79eb9677.gif?imageMogr2/auto-orient/strip)

####实现步骤
1. 初始化数据
	
	加入从服务器获取数据，对数据进行封装。

		public class Animal {
		    public static final int PERSON  = 1;
		    public static final int KOGNBAI = 2;
		    public static final int DAO     = 3;
		    public static final int CAT     = 4;
		    public static final int ERROR   = -1;
		
		    public int type = ERROR;
		    public BaseBean data;
		}	

	如上所示，则为简单的封装，将不同的 `type` 封装成对应类型，方便后面的判断显示。
2. 创建适配器

	针对不同的数据类型，进行相关的数据处理

	    @Override
	    public void convert(int position, CommonHolder holder, Animal item) {
	        switch (item.type) {
	            case PERSON:
	                dealWithPerson(position, holder, item);
	                break;
	            case CAT:
	                dealWithCat(position, holder, item);
	                break;
	            case DAO:
	                dealWithDao(position, holder, item);
	                break;
	            case KOGNBAI:
	                dealWithkongbai(position, holder, item);
	                break;
	        }
	    }
3. 在多部分接口回调中返回相关的布局

	        mAdapter = new AnimalAdapter(this, mDatas, new MultiItemTypeSupport<Animal>() {
            @Override
            public int getLayoutId(int positon, Animal animal) {
                switch (animal.type) {
                    case PERSON:
                        return R.layout.layout_person;
                    case CAT:
                        return R.layout.layout_cat;
                    case DAO:
                        return R.layout.layout_dog;
                    case KOGNBAI:
                        return R.layout.layout_kongbai;
                    default:
                        return R.layout.layout_kongbai;
                }
            }

            @Override
            public int getViewTypeCount() {
                return 4;
            }

            @Override
            public int getItemViewType(int var1, Animal var2) {
                return 0;
            }
        });

