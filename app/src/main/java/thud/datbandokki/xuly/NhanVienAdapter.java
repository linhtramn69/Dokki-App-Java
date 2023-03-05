package thud.datbandokki.xuly;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import thud.datbandokki.dulieu.DbHelper;
import thud.datbandokki.dulieu.NhanVien;

public class NhanVienAdapter {

    private DbHelper myDbHelper;
    private SQLiteDatabase db;
    private String[] allColumns = { DbHelper.NV_MSNV, DbHelper.NV_HOTEN, DbHelper.NV_NGAYSINH, DbHelper.NV_GIOITINH, DbHelper.NV_SDT};

    public NhanVienAdapter(Context context) {
        myDbHelper = new DbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }

    public long insertNhanVien(NhanVien nhanvien){
        db = myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbHelper.NV_MSNV, nhanvien.getMsnv());
        values.put(DbHelper.NV_HOTEN, nhanvien.getHoten());
        values.put(DbHelper.NV_NGAYSINH, nhanvien.getNgaysinh());
        values.put(DbHelper.NV_GIOITINH, nhanvien.getGioitinh());
        values.put(DbHelper.NV_SDT, nhanvien.getSdt());
        return db.insert(DbHelper.TABLE_NHANVIEN, null, values);
    }

    public int updateNhanVien(int msnv, String strHoTen, String strNgaySinh, String strGioiTinh, String strDienThoai){
        ContentValues values = new ContentValues();
        values.put(DbHelper.NV_HOTEN, strHoTen);
        values.put(DbHelper.NV_NGAYSINH, strNgaySinh);
        values.put(DbHelper.NV_GIOITINH, strGioiTinh);
        values.put(DbHelper.NV_SDT, strDienThoai);
        return db.update(DbHelper.TABLE_NHANVIEN, values, DbHelper.NV_MSNV + " = " + msnv, null);
    }

    public int deleteNhanVien(int msnv) {
        return db.delete(DbHelper.TABLE_NHANVIEN, DbHelper.NV_MSNV + " = " + msnv, null);
    }

    private NhanVien cursorToNhanVien (Cursor cursor){
        NhanVien values = new NhanVien();
        values.setMsnv(cursor.getInt(0));
        values.setHoten(cursor.getString(1));
        values.setNgaysinh(cursor.getString(2));
        values.setGioitinh(cursor.getString(3));
        values.setSdt(cursor.getString(4));
        return values;
    }

    public List<NhanVien> ListAllNhanVien(){
        List<NhanVien> lstNhanVien = new ArrayList<NhanVien>();
        Cursor cursor = db.query(DbHelper.TABLE_NHANVIEN, allColumns, null, null, null, null, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                NhanVien values = cursorToNhanVien(cursor);
                lstNhanVien.add(values);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return lstNhanVien;
    }

    public Boolean KiemTraNV(int msnv) {
        Boolean daco = false;
        List<NhanVien> lstNhanVien = ListAllNhanVien();
        int i = 0;
        while ((! daco) && (i < lstNhanVien.size()))
            if (lstNhanVien.get(i).getMsnv() == msnv)
                daco = true;
            else
                i++;
        return daco;
    }

    public void close(){
        db.close();
        myDbHelper.close();
    }
}
