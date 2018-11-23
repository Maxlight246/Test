package com.example.admin.test.QuanLyTaiLieu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.admin.test.R;

public class SachActivity extends TaiLieuActivity {
    EditText edAuthor,edBook,edPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sach_layout);
    }

    @Override
    void init() {
        super.init();
        edAuthor = findViewById(R.id.ed_author);
        edBook = findViewById(R.id.ed_book);
        edPage = findViewById(R.id.ed_sotrang);
    }
}
