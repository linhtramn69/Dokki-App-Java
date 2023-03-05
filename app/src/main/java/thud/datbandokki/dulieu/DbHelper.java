package thud.datbandokki.dulieu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "NhanVienDookki.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NHANVIEN = "nhanvien";
    public static final String NV_MSNV = "msnv";
    public static final String NV_HOTEN = "hoten";
    public static final String NV_NGAYSINH = "ngaysinh";
    public static final String NV_GIOITINH = "gioitinh";
    public static final String NV_SDT = "sdt";

    private static final String CREATE_TABLE_NHANVIEN
            = "Create Table " + TABLE_NHANVIEN + "("
            + NV_MSNV + "  Integer Primary Key Autoincrement, "
            + NV_HOTEN + " Text, " + NV_NGAYSINH + " Text, "
            + NV_GIOITINH + " Text, " + NV_SDT + " Text);";

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_NHANVIEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table If Exists " + TABLE_NHANVIEN);
        onCreate(sqLiteDatabase);
    }

}
