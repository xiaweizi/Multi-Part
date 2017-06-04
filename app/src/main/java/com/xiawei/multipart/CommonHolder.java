package com.xiawei.multipart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 功能描述：
 * 类名：       com.xiawei.multipart.CommonHolder
 * 创建者：      xiaweizi
 * 创建时间：    2017/6/4 09:29
 * 项目名称：    MultiPart
 */
public class CommonHolder {
    private final SparseArray<View> mViews;
    private       View              mConvertView;
    private       int               position;
    public        int               mLayoutId;

    private CommonHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.position = position;
        this.mLayoutId = layoutId;
        this.mViews = new SparseArray();
        this.mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        this.mConvertView.setTag(this);
    }

    public static CommonHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if(convertView == null) {
            return new CommonHolder(context, parent, layoutId, position);
        } else {
            CommonHolder holder = (CommonHolder)convertView.getTag();
            return holder.mLayoutId != layoutId?new CommonHolder(context, parent, layoutId, position):holder;
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public <T extends View> T getView(int viewId) {
        View view = (View)this.mViews.get(viewId);
        if(view == null) {
            view = this.mConvertView.findViewById(viewId);
            this.mViews.put(viewId, view);
        }

        return (T) view;
    }


    public CommonHolder setText(int viewId, String text) {
        TextView textView = (TextView)this.getView(viewId);
        textView.setText(text);
        return this;
    }

    public CommonHolder setEnable(int viewId, boolean enable) {
        Button btn = (Button)this.getView(viewId);
        btn.setEnabled(enable);
        return this;
    }

    public CommonHolder setChecked(int viewId, boolean checked) {
        CheckBox checkBox = (CheckBox)this.getView(viewId);
        checkBox.setChecked(checked);
        return this;
    }

    public CommonHolder setViewVisibility(int viewId, int visibility) {
        View view = this.getView(viewId);
        view.setVisibility(visibility);
        return this;
    }

    public CommonHolder setViewOnClickListener(int viewId, View.OnClickListener listener) {
        View view = this.getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public CommonHolder setViewTag(int viewId, Object tag) {
        View view = this.getView(viewId);
        view.setTag(tag);
        return this;
    }

    public Object getViewTag(int viewId) {
        return this.getView(viewId).getTag();
    }

    public CommonHolder setImageResource(int viewId, int resId) {
        ImageView imageView = (ImageView)this.getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    public CommonHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageView = (ImageView)this.getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public CommonHolder setBackground(int viewId, int res) {
        View view = this.getView(viewId);
        view.setBackgroundResource(res);
        return this;
    }

    public CommonHolder setBackgroundDrawable(int viewId, Drawable drawable) {
        View view = this.getView(viewId);
        view.setBackground(drawable);
        return this;
    }

    public CommonHolder setBackgroundColor(int viewId, int color) {
        View view = this.getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public int getPosition() {
        return this.position;
    }

    public CommonHolder setTextColor(int viewId, int res) {
        TextView textView = (TextView)this.getView(viewId);
        textView.setTextColor(res);
        return this;
    }
}