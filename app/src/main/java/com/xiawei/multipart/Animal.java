package com.xiawei.multipart;

/**
 * 功能描述：
 * 类名：       com.xiawei.multipart.Animal
 * 创建者：      xiaweizi
 * 创建时间：    2017/6/4 09:35
 * 项目名称：    MultiPart
 */
public class Animal {
    public static final int PERSON  = 1;
    public static final int KOGNBAI = 2;
    public static final int DAO     = 3;
    public static final int CAT     = 4;
    public static final int ERROR   = -1;

    public int type = ERROR;
    public BaseBean data;
}