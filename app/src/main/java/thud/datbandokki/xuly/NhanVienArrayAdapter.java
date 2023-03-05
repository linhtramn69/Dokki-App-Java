package thud.datbandokki.xuly;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;

import thud.datbandokki.R;
import thud.datbandokki.dulieu.NhanVien;

public class NhanVienArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context;
    int layoutId;
    ArrayList<NhanVien> nvArray;

    public NhanVienArrayAdapter(Activity context, int layoutId, ArrayList<NhanVien> nvArray) {
        super(context, layoutId, nvArray);
        this.context = context;
        this.layoutId = layoutId;
        this.nvArray = nvArray;
    }

    public void setNvArray(ArrayList<NhanVien> nvArray) {
        this.nvArray = nvArray;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return nvArray.size();
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if(nvArray.size()>0 && position>=0){
            final NhanVien nv = nvArray.get(position);
            final TextView txtMSNV = convertView.findViewById(R.id.txt_msnv);
            txtMSNV.setText("STT: "+nv.getMsnv());
            final TextView txtHoTen = convertView.findViewById(R.id.txt_hoten);
            txtHoTen.setText("Họ tên: "+ nv.getHoten());
            final TextView txtNgaySinh = convertView.findViewById(R.id.txt_ngaysinh);
            txtNgaySinh.setText("Ngày sinh: "+ nv.getNgaysinh());
            final TextView txtGioiTinh = convertView.findViewById(R.id.txt_gioitinh);
            txtGioiTinh.setText("Giới tính: " + nv.getGioitinh());
            final TextView txtSdt = convertView.findViewById(R.id.txt_sdt);
            txtSdt.setText("Số điện thoại: " + nv.getSdt());
        }
        return convertView;
    }
}
