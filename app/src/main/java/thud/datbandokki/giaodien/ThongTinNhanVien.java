package thud.datbandokki.giaodien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import thud.datbandokki.R;
import thud.datbandokki.dulieu.NhanVien;
import thud.datbandokki.xuly.NhanVienAdapter;
import thud.datbandokki.xuly.NhanVienArrayAdapter;

public class ThongTinNhanVien extends AppCompatActivity {

    NhanVienAdapter nvAdapter;
    NhanVienArrayAdapter nvArrayAdapter;
    List<NhanVien> lstNhanVien;
    ListView lvNhanVien;

    TextInputLayout layoutHoten, layoutNgaySinh, layoutSdt;
    TextInputEditText edtHoTen, edtNgaySinh, edtSdt;
    String strGioiTinh;
    int msnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinnhanvien);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setIcon(R.mipmap.brand);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        myActionBar.setBackgroundDrawable(colorDrawable);

        layoutHoten = findViewById(R.id.layout_hoten);
        layoutNgaySinh = findViewById(R.id.layout_ngaysinh);
        layoutSdt = findViewById(R.id.layout_sdt);
        edtHoTen = findViewById(R.id.edt_hoten);
        edtNgaySinh = findViewById(R.id.edt_ngaysinh);
        edtSdt = findViewById(R.id.edt_sdt);

        nvAdapter = new NhanVienAdapter(this);
        lvNhanVien = findViewById(R.id.lst_nhanvien);
        lstNhanVien = nvAdapter.ListAllNhanVien();
        nvArrayAdapter = new NhanVienArrayAdapter(this, R.layout.danhsach_nhanvien_list, (ArrayList<NhanVien>) lstNhanVien);
        lvNhanVien.setAdapter(nvArrayAdapter);

       nvArrayAdapter.setNvArray((ArrayList<NhanVien>) nvAdapter.ListAllNhanVien());
       lvNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                msnv = lstNhanVien.get(i).getMsnv();
                edtHoTen.setText(lstNhanVien.get(i).getHoten());
                edtNgaySinh.setText(lstNhanVien.get(i).getNgaysinh());
                edtSdt.setText(lstNhanVien.get(i).getSdt());
                strGioiTinh = lstNhanVien.get(i).getGioitinh();

                RadioButton rdoNu = findViewById(R.id.rdo_nu);;
                RadioButton rdoNam = findViewById(R.id.rdo_nam);;
                if(strGioiTinh.equalsIgnoreCase("Nữ")){
                    rdoNu.setChecked(true);  ;
                }
                else{
                    rdoNam.setChecked(true);  ;
                }
            }
        });

    }

    public void ThemNhanVien(View view) {
        String strHoTen, strNgaySinh, strSdt;
        RadioGroup grpGioiTinh = findViewById(R.id.grp_gioitinh);
        int id = grpGioiTinh.getCheckedRadioButtonId();
        RadioButton rad = findViewById(id);
        strGioiTinh = rad.getText().toString();

        strHoTen = edtHoTen.getText().toString().trim();
        if(strHoTen.length()==0){
            layoutHoten.setError("Lỗi nhập họ tên");
            edtHoTen.requestFocus();
            return;
        }
        else {
            layoutHoten.setError(null);
        }

        strNgaySinh = edtNgaySinh.getText().toString().trim();
        if(strNgaySinh.length()==0){
            layoutNgaySinh.setError("Lỗi nhập ngày sinh");
            edtNgaySinh.requestFocus();
            return;
        }
        else {
            layoutNgaySinh.setError(null);
        }

        strSdt = edtSdt.getText().toString().trim();
        if(strSdt.length()==0){
            layoutSdt.setError("Lỗi nhập số điện thoại");
            edtSdt.requestFocus();
            return;
        }
        else {
            layoutSdt.setError(null);
        }

        int msnv = lstNhanVien.size()+1;

        if(nvAdapter.KiemTraNV(msnv)){
            msnv=msnv+1;
        }

        NhanVien nv = new NhanVien(msnv, strHoTen, strNgaySinh, strGioiTinh, strSdt);
        nvAdapter.insertNhanVien(nv);
        Toast.makeText(this, "Thêm nhân viên thành công", Toast.LENGTH_SHORT).show();
        nvArrayAdapter.setNvArray((ArrayList<NhanVien>) nvAdapter.ListAllNhanVien());
    }

    public void XoaNhanVien(View view) {
        nvAdapter.deleteNhanVien(msnv);
        Toast.makeText(this, "Xoá nhân viên thành công", Toast.LENGTH_SHORT).show();
        nvArrayAdapter.setNvArray((ArrayList<NhanVien>) nvAdapter.ListAllNhanVien());
    }

    public void LuuNhanVien(View view) {
        String strHoTen, strNgaySinh, strSdt;
        RadioGroup grpGioiTinh = findViewById(R.id.grp_gioitinh);
        int id = grpGioiTinh.getCheckedRadioButtonId();
        RadioButton rad = findViewById(id);
        strGioiTinh = rad.getText().toString();

        strHoTen = edtHoTen.getText().toString().trim();
        if(strHoTen.length()==0){
            layoutHoten.setError("Lỗi nhập họ tên");
            edtHoTen.requestFocus();
            return;
        }
        else {
            layoutHoten.setError(null);
        }

        strNgaySinh = edtNgaySinh.getText().toString().trim();
        if(strNgaySinh.length()==0){
            layoutNgaySinh.setError("Lỗi nhập ngày sinh");
            edtNgaySinh.requestFocus();
            return;
        }
        else {
            layoutNgaySinh.setError(null);
        }

        strSdt = edtSdt.getText().toString().trim();
        if(strSdt.length()==0){
            layoutSdt.setError("Lỗi nhập số điện thoại");
            edtSdt.requestFocus();
            return;
        }
        else {
            layoutSdt.setError(null);
        }
        nvAdapter.updateNhanVien(msnv, strHoTen, strNgaySinh, strGioiTinh, strSdt);
        Toast.makeText(this, "Cập nhật nhân viên thành công", Toast.LENGTH_SHORT).show();

        nvArrayAdapter.setNvArray((ArrayList<NhanVien>) nvAdapter.ListAllNhanVien());
    }

    public void DongActivity(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        nvAdapter.close();
    }
}