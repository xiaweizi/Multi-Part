package com.xiawei.multipart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xiawei.multipart.bean.Cat;
import com.xiawei.multipart.bean.Dog;
import com.xiawei.multipart.bean.Kongbai;
import com.xiawei.multipart.bean.Person;

import java.util.ArrayList;
import java.util.List;

import static com.xiawei.multipart.Animal.CAT;
import static com.xiawei.multipart.Animal.DAO;
import static com.xiawei.multipart.Animal.KOGNBAI;
import static com.xiawei.multipart.Animal.PERSON;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private List<Animal>  mDatas;
    private AnimalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        mDatas = new ArrayList<>();

        Animal animal1 = new Animal();
        animal1.type = Animal.KOGNBAI;
        Kongbai kongbai1 = new Kongbai();
        kongbai1.name = "这是空白1";
        animal1.data = kongbai1;
        mDatas.add(animal1);

        // 人

        for (int i = 0; i < 3; i++) {
            Animal per = new Animal();
            per.type = Animal.PERSON;
            Person person = new Person();
            person.name = "这是人类" + (i + 1);
            per.data = person;
            mDatas.add(per);
        }


        Animal animal2 = new Animal();
        animal2.type = Animal.KOGNBAI;
        Kongbai kongbai2 = new Kongbai();
        kongbai2.name = "这是空白2";
        animal2.data = kongbai2;
        mDatas.add(animal2);

        // 狗
        for (int i = 0; i < 8; i++) {
            Animal dogg = new Animal();
            dogg.type = Animal.DAO;
            Dog dog = new Dog();
            dog.name = "这是狗" + (i + 1);
            dogg.data = dog;
            mDatas.add(dogg);
        }

        Animal animal3 = new Animal();
        animal3.type = Animal.KOGNBAI;
        Kongbai kongbai3 = new Kongbai();
        kongbai3.name = "这是空白3";
        animal3.data = kongbai3;
        mDatas.add(animal3);

        for (int i = 0; i < 15; i++) {
            Animal catt = new Animal();
            catt.type = Animal.CAT;
            Cat cat = new Cat();
            cat.name = "这是猫" + (i + 1);
            catt.data = cat;
            mDatas.add(catt);
        }

    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.lv_test);
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
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("xwz--->", "onItemClick: " + mDatas.get(position).data.name + "\tposition:\t" + position);
            }
        });
        mListView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i("xwz--->", "onLongClick: ");
                return true;
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
                                           long id) {
                Log.i("xwz--->", "MainActivity:  " + "onItemLongClick: " + position);
                return true;
            }
        });
    }
}
