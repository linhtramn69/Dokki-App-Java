package thud.datbandokki.xuly;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private  Integer[] Images;
    private String[] Texts;

    public ImageAdapter(Context context, Integer[] images){
        mContext = context;
        Images = images;
    }

    @Override
    public int getCount() {
        return Images.length;
    }

    @Override
    public Object getItem(int i) {
        return Images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(Images[i]);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(360, 360));
        imageView.setPadding(10,30,10,30);
        return imageView;
    }
}
