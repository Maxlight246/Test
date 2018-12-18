package com.example.admin.test.Danhsachsinhvien;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.admin.test.R;

import java.util.ArrayList;

public class DanhsachActivity extends AppCompatActivity {

    SwipeMenuListView lvSinhVien;
    EditText edTen, edTuoi, edDiachi;
    Button btThem, btSua;
    ArrayList<Sinhvien> sinhvienArrayList = new ArrayList<>();
    SinhvienAdapter adapter;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachsinhvien);
        init();
        //    adapter = new SinhvienAdapter(this,R.layout.item_dssv_layout,sinhvienArrayList);
        adapter = new SinhvienAdapter();
        adapter.context = this;
        adapter.arrSinhvien = sinhvienArrayList;
        lvSinhVien.setAdapter(adapter);

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionAdd();
            }
        });

        btSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionUpdate();
            }
        });
        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sinhvien sinhvien = sinhvienArrayList.get(position);
                edTen.setText(sinhvien.getTen());
                edTuoi.setText(Integer.toString(sinhvien.getTuoi()));
                edDiachi.setText(sinhvien.getDiachi());
                vitri = position;
            }
        });

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(100);
                // set item title
                openItem.setTitle("Undo");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.RED);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(100);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);

            }
        };
        lvSinhVien.setMenuCreator(creator);

        lvSinhVien.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0://undo
                        break;
                    case 1:// delete
                        sinhvienArrayList.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(DanhsachActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                        cleardata();
                        break;

                }
                return false;
            }
        });

        // Right
        lvSinhVien.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);

        // Left
        lvSinhVien.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);


    }

    private void init() {
        lvSinhVien = findViewById(R.id.lv_sinhvien);
        edTen = findViewById(R.id.ed_ten);
        edTuoi = findViewById(R.id.ed_tuoi);
        edDiachi = findViewById(R.id.ed_diachi);
        btThem = findViewById(R.id.bt_them);
        btSua = findViewById(R.id.bt_sua);

    }

    void cleardata() {
        edTen.setText("");
        edTuoi.setText("");
        edDiachi.setText("");
    }

    void actionAdd() {
        if (edTen.getText().toString().isEmpty() || edTuoi.getText().toString().isEmpty() || edDiachi.getText().toString().isEmpty()) {
            Toast.makeText(DanhsachActivity.this, "moi ban nhap du thong tin", Toast.LENGTH_SHORT).show();
        } else {
            sinhvienArrayList.add(new Sinhvien(edTen.getText().toString(),
                    edDiachi.getText().toString(),
                    Integer.parseInt(edTuoi.getText().toString())));
            Toast.makeText(DanhsachActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
            cleardata();
            adapter.notifyDataSetChanged();
        }
    }

    void actionUpdate() {
        Sinhvien sinhviennew = sinhvienArrayList.get(vitri);
        if (edTen.getText().toString().isEmpty() || edTuoi.getText().toString().isEmpty() || edDiachi.getText().toString().isEmpty()) {
            Toast.makeText(DanhsachActivity.this, "hay nhap du du lieu", Toast.LENGTH_SHORT).show();
        } else {
            sinhviennew.setTen(edTen.getText().toString());
            sinhviennew.setTuoi(Integer.parseInt(edTuoi.getText().toString()));
            sinhviennew.setDiachi(edDiachi.getText().toString());
            Toast.makeText(DanhsachActivity.this, "cap nhat thanh cong", Toast.LENGTH_SHORT).show();
            cleardata();
            adapter.notifyDataSetChanged();
        }
    }

}
