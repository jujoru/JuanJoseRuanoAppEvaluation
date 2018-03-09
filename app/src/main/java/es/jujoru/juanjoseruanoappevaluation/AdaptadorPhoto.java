package es.jujoru.juanjoseruanoappevaluation;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import es.jujoru.juanjoseruanoappevaluation.Modelos.Photo;


public class AdaptadorPhoto extends ArrayAdapter {

    private Context context;
    private List<Photo> photos;


    public AdaptadorPhoto(Context context, List<Photo> photos)  {
        super(context, R.layout.photo_layout, photos);
        this.photos=photos;
        this.context = context;
    }
    public View getView(int position, View view, ViewGroup viewGroup){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.photo_layout,null);

            if(position%2==0){
                item.setBackgroundColor(Color.GRAY);
            }else{
                item.setBackgroundColor(Color.LTGRAY);
            }
            TextView tvEarth = (TextView) item.findViewById(R.id.tvEarth);
            tvEarth.setText(photos.get(position).getEarthDate());

            TextView tvCameraName = (TextView) item.findViewById(R.id.tvCameraName);
            tvCameraName.setText(photos.get(position).getCamera().getFullName());

            ImageView imageView = (ImageView) item.findViewById(R.id.ivImage);

            String url = photos.get(position).getImgSrc();
            Glide.with(item).load(url).into(imageView);

        return item;
    }


}
