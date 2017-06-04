package com.xiawei.multipart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 * 类名：       com.xiawei.multipart.CommonAdapter
 * 创建者：      xiaweizi
 * 创建时间：    2017/6/4 09:28
 * 项目名称：    MultiPart
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater          mInflater;
    protected Context                 mContext;
    protected List<T>                 mDatas;
    protected int                     mLayoutId;
    protected MultiItemTypeSupport<T> multiItemTypeSupport;

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        this.mContext = context;
        this.mDatas = (List)(datas == null?new ArrayList():datas);
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mLayoutId = layoutId;
    }

    public CommonAdapter(Context context, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {
        this.mContext = context;
        this.mDatas = (List)(datas == null?new ArrayList():datas);
        this.mInflater = LayoutInflater.from(this.mContext);
        this.multiItemTypeSupport = multiItemTypeSupport;
    }

    public int getItemViewType(int position) {
        if(this.multiItemTypeSupport != null) {
            this.multiItemTypeSupport.getItemViewType(position, position < this.mDatas.size()?this.mDatas.get(position):null);
        }

        return super.getItemViewType(position);
    }

    public int getViewTypeCount() {
        return this.multiItemTypeSupport != null?this.multiItemTypeSupport.getViewTypeCount():super.getViewTypeCount();
    }

    public int getCount() {
        return this.mDatas == null?0:this.mDatas.size();
    }

    public T getItem(int position) {
        return this.mDatas == null?null:(this.mDatas.size() == 0?null:this.mDatas.get(position));
    }

    public long getItemId(int position) {
        return (long)position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        CommonHolder holder = this.getViewHolder(position, convertView, parent);
        this.convert(position, holder, this.getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(int var1, CommonHolder var2, T var3);

    private CommonHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return this.multiItemTypeSupport != null?(this.mDatas != null && this.mDatas.size() > 0?CommonHolder.get(this.mContext, convertView, parent, this.multiItemTypeSupport.getLayoutId(position, this.mDatas.get(position)), position):CommonHolder.get(this.mContext, convertView, parent, this.multiItemTypeSupport.getLayoutId(position, null), position)):CommonHolder.get(this.mContext, convertView, parent, this.mLayoutId, position);
    }
}