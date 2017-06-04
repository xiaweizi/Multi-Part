package com.xiawei.multipart;

/**
 * 功能描述：
 * 接口名：      com.xiawei.multipart.MultiItemTypeSupport
 * 创建者：      xiaweizi
 * 创建时间：    2017/6/4 09:28
 * 项目名称：    MultiPart
 */
public interface MultiItemTypeSupport<T> {
    int getLayoutId(int var1, T var2);

    int getViewTypeCount();

    int getItemViewType(int var1, T var2);
}
