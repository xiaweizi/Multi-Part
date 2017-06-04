package com.xiawei.multipart;

import android.content.Context;

import com.xiawei.multipart.bean.Cat;
import com.xiawei.multipart.bean.Dog;
import com.xiawei.multipart.bean.Kongbai;
import com.xiawei.multipart.bean.Person;

import java.util.List;

import static com.xiawei.multipart.Animal.CAT;
import static com.xiawei.multipart.Animal.DAO;
import static com.xiawei.multipart.Animal.KOGNBAI;
import static com.xiawei.multipart.Animal.PERSON;

/**
 * 功能描述：
 * 类名：       com.xiawei.multipart.AnimalAdapter
 * 创建者：      xiaweizi
 * 创建时间：    2017/6/4 09:50
 * 项目名称：    MultiPart
 */
public class AnimalAdapter extends CommonAdapter<Animal>{

    public AnimalAdapter(
            Context context, List<Animal> datas,
            MultiItemTypeSupport<Animal> multiItemTypeSupport) {
        super(context, datas, multiItemTypeSupport);
    }

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

    private void dealWithkongbai(int position, CommonHolder holder, Animal item) {
        Kongbai kongbai = (Kongbai) item.data;
        holder.setText(R.id.tv_kongbai, kongbai.name);
    }

    private void dealWithDao(int position, CommonHolder holder, Animal item) {
        Dog dog = (Dog) item.data;
        holder.setText(R.id.tv_dog, dog.name);
    }

    private void dealWithCat(int position, CommonHolder holder, Animal item) {
        Cat cat = (Cat) item.data;
        holder.setText(R.id.tv_cat, cat.name);
    }

    private void dealWithPerson(int position, CommonHolder holder, Animal item) {
        Person person = (Person) item.data;
        holder.setText(R.id.tv_person, person.name);
    }
}