package com.example.admin.test.Danhsachsinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.test.R;

import java.util.ArrayList;

public class Danhsach extends AppCompatActivity {

    ListView lvSinhVien;
    EditText edTen,edTuoi, edDiachi;
    Button btThem, btSua;
    ArrayList<Sinhvien> sinhvienArrayList =new ArrayList<>();
    SinhvienAdapter adapter;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachsinhvien);
        init();
    //    adapter = new SinhvienAdapter(this,R.layout.item_dssv_layout,sinhvienArrayList);
        adapter =new SinhvienAdapter();
        adapter.context = this;
        adapter.arrSinhvien=sinhvienArrayList;
        lvSinhVien.setAdapter(adapter);

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edTen.getText().toString().isEmpty()||edTuoi.getText().toString().isEmpty()||edDiachi.getText().toString().isEmpty()){
                    Toast.makeText(Danhsach.this, "moi ban nhap du thong tin", Toast.LENGTH_SHORT).show();
                }else {
                    sinhvienArrayList.add(new Sinhvien(edTen.getText().toString(),
                        edDiachi.getText().toString(),
                        Integer.parseInt(edTuoi.getText().toString())));
                Toast.makeText(Danhsach.this, "them thanh cong", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                }
            }
        });

        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sinhvien sinhvien = sinhvienArrayList.get(position);
                edTen.setText(sinhvien.getTen());
                edTuoi.setText(Integer.toString(sinhvien.getTuoi()));
                edDiachi.setText(sinhvien.getDiachi());
                vitri=position;
            }
        });

        btSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sinhvien sinhviennew = sinhvienArrayList.get(vitri);
                sinhviennew.setTen(edTen.getText().toString());
                sinhviennew.setTuoi(Integer.parseInt(edTuoi.getText().toString()));
                sinhviennew.setDiachi(edDiachi.getText().toString());
                Toast.makeText(Danhsach.this, "cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        });

        lvSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                sinhvienArrayList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void init() {
        lvSinhVien = findViewById(R.id.lv_sinhvien);
        edTen = findViewById(R.id.ed_ten);
        edTuoi = findViewById(R.id.ed_tuoi);
        edDiachi=findViewById(R.id.ed_diachi);
        btThem =findViewById(R.id.bt_them);
        btSua=findViewById(R.id.bt_sua);

    }
}
