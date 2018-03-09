package es.jujoru.juanjoseruanoappevaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import es.jujoru.juanjoseruanoappevaluation.Controlador.AsyncTaskPhotos;

public class ActivityDetails extends AppCompatActivity {
    final  String EXTRA_FOTO = "FOTO";
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = (ImageView)findViewById(R.id.imageDetails);
        Bundle b= getIntent().getExtras();

        if(b!=null){
            String rutaImg = b.getString(EXTRA_FOTO);
            Glide.with(getApplicationContext()).load(rutaImg).into(imageView);
        }
    }
}
