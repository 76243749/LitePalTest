package com.myandroid.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.myandroid.litepaltest.db.Book;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button createBtn;
    private Button addBtn;
    private Button editBtn;
    private Button delBtn;
    private Button selectBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createBtn = (Button) findViewById(R.id.create_btn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
                Toast.makeText(MainActivity.this,"创建成功",Toast.LENGTH_SHORT).show();
            }
        });

        addBtn = (Button) findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                for(int i=1;i<10;i++){
                    int ids = i;
                    String names = "names"+i;
                    book.setId(ids);
                    book.setName(names);
                    book.setAuthor("asdfasdf");
                    book.setPrice(165.44);
                    book.setPages(50);
                    book.save();
                }
                Toast.makeText(MainActivity.this,"插入成功",Toast.LENGTH_SHORT).show();
            }
        });

        editBtn = (Button) findViewById(R.id.edit_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(160.44);
                book.setPages(501);
                book.updateAll("name=?","asdfasdfsaf");
                Toast.makeText(MainActivity.this,"更新成功",Toast.LENGTH_SHORT).show();
            }
        });

        delBtn = (Button) findViewById(R.id.del_btn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class,"name = ?","aa");
                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });

        selectBtn = (Button) findViewById(R.id.select_btn);
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = DataSupport.findAll(Book.class);
                for(Book book:books){
                    Log.d("Main:","Name:"+book.getName());
                }
            }
        });
    }
}
