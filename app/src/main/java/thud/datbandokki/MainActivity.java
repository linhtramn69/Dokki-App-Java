package thud.datbandokki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import thud.datbandokki.giaodien.DatBan;
import thud.datbandokki.giaodien.ThongTinNhanVien;
import thud.datbandokki.xuly.ImageAdapter;

public class MainActivity extends AppCompatActivity {

    private Integer[] Images = {R.mipmap.table, R.mipmap.staff, R.mipmap.exit};
    Class[] arrClasses = {DatBan.class, ThongTinNhanVien.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gdvMenu = findViewById(R.id.gdv_menu);
        ImageAdapter adapter = new ImageAdapter(this, Images);
        gdvMenu.setAdapter(adapter);
        gdvMenu.setOnItemClickListener(new ChonCongViec());
    }

    private class ChonCongViec implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(i == 2)
                finish();
            else {
                Intent intent = new Intent(MainActivity.this, arrClasses[i]);
                startActivity(intent);
            }
        }
    }
}