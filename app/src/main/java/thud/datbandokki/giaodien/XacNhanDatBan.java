package thud.datbandokki.giaodien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import thud.datbandokki.R;

public class XacNhanDatBan extends AppCompatActivity {

    String strThongTin, strMucDich, strNgay, strThoiGian, strHoTen, strSdt, strThanhToan;
    int dongia, songuoi, sotreem, tongtien;
    TextView txtThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xacnhandatban);

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setIcon(R.mipmap.brand);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        myActionBar.setBackgroundDrawable(colorDrawable);

        Intent intent = getIntent();
        Bundle bundleNhan = intent.getExtras();
        strMucDich = bundleNhan.getString("MucDich", "");
        strNgay = bundleNhan.getString("Ngay", "");
        strThoiGian = bundleNhan.getString("ThoiGian", "");
        strHoTen = bundleNhan.getString("HoTen", "");
        strSdt = bundleNhan.getString("Sdt", "");
        strThanhToan = bundleNhan.getString("ThanhToan", "");
        dongia = bundleNhan.getInt("DonGia", 0);
        songuoi = bundleNhan.getInt("SoNguoi", 0);
        sotreem = bundleNhan.getInt("SoTreEm", 0);
        tongtien = bundleNhan.getInt("TongTien", 0);

        strThongTin = "Họ tên khách hàng: " + strHoTen;
        strThongTin += "\nSố điện thoại: " + strSdt;
        strThongTin += "\nNgày: " + strNgay;
        strThongTin += "\nThời gian: " + strThoiGian;
        strThongTin += "\nMục đích: " + strMucDich;
        strThongTin += "\nĐơn giá: " + dongia;
        strThongTin += "\nSố lượng người: " + songuoi;
        strThongTin += "\nSố lượng trẻ em: " + sotreem;
        strThongTin += "\nHình thức thanh toán: " + strThanhToan;
        strThongTin += "\nTổng tiền: " + tongtien;

        txtThongTin = findViewById(R.id.txt_khachhang);
        txtThongTin.setText(strThongTin);
    }

    public void XacNhan(View view) {
//        setResult(RESULT_OK);
//        finish();
        Toast.makeText(this, "Đặt bàn thành công", Toast.LENGTH_SHORT).show();
    }

    public void HuyBo(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}