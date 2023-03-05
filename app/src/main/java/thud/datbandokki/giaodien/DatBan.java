package thud.datbandokki.giaodien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import thud.datbandokki.R;

public class DatBan extends AppCompatActivity {

    Spinner spnMucDich;
    String arrMucDich[] = { "Ăn uống bình thường", "Trang trí sinh nhật", "Trang trí hẹn hò" };
    int arrDonGia[] = {139000, 159000, 179000};
    Spinner spnThoiGian;
    String arrThoiGian[] = { "9h-10h30", "10h30-12h", "12h-13h30", "13h30-15h", "15h-16h30", "16h30-18h", "18h-19h30", "19h30-21h" };
    EditText edtDonGia, edtTongTien;
    TextInputLayout layoutSoNguoi, layoutTreEm, layoutHoTen, layoutSdt;
    TextInputEditText edtSoNguoi, edtTreEm, edtHoTen, edtSdt;
    int songuoi, sotreem, dongia, tongtien;
    TextView txtNgay;
    String strMucDich, strNgay, strHoTen, strSdt, strThanhToan;
    DatePickerDialog.OnDateSetListener myDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datban);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setIcon(R.mipmap.brand);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        myActionBar.setBackgroundDrawable(colorDrawable);

        layoutSoNguoi = findViewById(R.id.layout_songuoi);
        layoutTreEm = findViewById(R.id.layout_sotreem);
        layoutHoTen = findViewById(R.id.layout_hoten);
        layoutSdt = findViewById(R.id.layout_sdt);
        edtSoNguoi = findViewById(R.id.edt_songuoi);
        edtTreEm = findViewById(R.id.edt_sotreem);
        edtHoTen = findViewById(R.id.edt_hoten);
        edtSdt = findViewById(R.id.edt_sdt);
        edtDonGia = findViewById(R.id.edt_dongia);
        edtTongTien = findViewById(R.id.edt_tongtien);

        txtNgay = findViewById(R.id.txt_ngay);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        strNgay = dateFormat.format(calendar.getTime());
        txtNgay.setText("Ngày đặt: " + strNgay);

        spnThoiGian = findViewById(R.id.spn_thoigian);
        ArrayAdapter<String> adapterTG = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrThoiGian);
        adapterTG.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnThoiGian.setAdapter(adapterTG);

        spnMucDich = findViewById(R.id.spn_mucdich);
        ArrayAdapter<String> adapterMD = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrMucDich);
        adapterMD.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnMucDich.setAdapter(adapterMD);
        spnMucDich.setOnItemSelectedListener(new ChonMucDich());
    }

    private class ChonMucDich implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            strMucDich = arrMucDich[i];
            dongia = arrDonGia[i];
            edtDonGia.setText("Đơn giá: " + dongia);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            strMucDich = "";
            dongia = 0;
        }
    }

    public void ChonNgay(View view) {
        Calendar calendar = Calendar.getInstance();
        int iniYear = calendar.get(Calendar.YEAR);
        int iniMonth = calendar.get(Calendar.MONTH);
        int iniDay = calendar.get(Calendar.DAY_OF_MONTH);
        myDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                strNgay = i2 + "/" + i1 + "/" + i;
                txtNgay.setText("Ngày đặt: " + strNgay);
            }
        };
        DatePickerDialog dialog = new DatePickerDialog(this, myDateSetListener, iniYear, iniMonth, iniDay);
        dialog.setTitle("Chọn ngày đặt bàn");
        dialog.show();
    }

    public boolean TinhTien(View view) {
        strHoTen = edtHoTen.getText().toString().trim();
        if(strHoTen.length()==0){
            layoutHoTen.setError("Lỗi chưa nhập họ tên khách hàng");
            edtHoTen.requestFocus();
            return false;
        }
        else
            layoutHoTen.setError(null);

        strSdt = edtSdt.getText().toString().trim();
        if(strSdt.length()==0){
            layoutSdt.setError("Lỗi chưa nhập số điện thoại");
            edtSdt.requestFocus();
            return false;
        }
        else
            layoutSdt.setError(null);

        String strSoNguoi = edtSoNguoi.getText().toString().trim();
        if(strSoNguoi.length()==0 || Integer.parseInt(strSoNguoi)==0){
            layoutSoNguoi.setError("Lỗi nhập số lượng khách");
            edtSoNguoi.requestFocus();
            return false;
        }
        else {
            layoutSoNguoi.setError(null);
            songuoi = Integer.parseInt(strSoNguoi);
        }
        tongtien = songuoi * dongia;

        String strTreEm = edtTreEm.getText().toString().trim();
        if(strTreEm.length()==0 || Integer.parseInt(strTreEm)==-1){
            layoutTreEm.setError("Lỗi nhập số lượng khách");
            edtTreEm.requestFocus();
            return false;
        }
        else {
            layoutTreEm.setError(null);
            sotreem = Integer.parseInt(strTreEm);
        }
        tongtien = tongtien + sotreem * 69000;

        edtTongTien.setText("Tổng tiền: " + tongtien);
        return true;
    }

    public void DatBan(View view) {
        if (!TinhTien(view))
            return;

        RadioGroup grpThanhToan = findViewById(R.id.grp_thanhtoan);
        int id = grpThanhToan.getCheckedRadioButtonId();
        RadioButton rad = findViewById(id);
        strThanhToan = rad.getText().toString();

        Bundle bundleGoi = new Bundle();
        bundleGoi.putString("MucDich", strMucDich);
        bundleGoi.putInt("DonGia", dongia);
        bundleGoi.putString("Ngay", strNgay);
        bundleGoi.putString("ThoiGian", String.valueOf(spnThoiGian.getSelectedItem()));
        bundleGoi.putString("HoTen", strHoTen);
        bundleGoi.putString("Sdt", strSdt);
        bundleGoi.putInt("SoNguoi", songuoi);
        bundleGoi.putInt("SoTreEm", sotreem);
        bundleGoi.putString("ThanhToan", strThanhToan);
        bundleGoi.putInt("TongTien", tongtien);
        Intent intent = new Intent(this, XacNhanDatBan.class);
        intent.putExtras(bundleGoi);
        startActivity(intent);
    }

    public void DongActivity(View view) {
        finish();
    }

}
