package es.jujoru.juanjoseruanoappevaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.jujoru.juanjoseruanoappevaluation.Controlador.AsyncTaskPhotos;
import es.jujoru.juanjoseruanoappevaluation.Modelos.PhotoList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {
    ListView lvItem;
    PhotoList listaPhotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = (ListView)findViewById(R.id.lvItem);

        AsyncTaskPhotos asyncTaskPhotos = new AsyncTaskPhotos(lvItem,this);
        asyncTaskPhotos.execute();

        //  cargarJSON();

    }
    private void cargarJSON(){
      /*  Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestClient restClient = retrofit.create(RestClient.class);
        Call<PhotoList> call = restClient.getData();

        call.enqueue(new Callback<PhotoList>() {
            @Override
            public void onResponse(Call<PhotoList> call, Response<PhotoList> response) {
                switch (response.code()) {
                    case 200:
                        listaPhotos = response.body();

                        cargarAdaptador();
                        break;
                    case 401:

                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onFailure(Call<PhotoList> call, Throwable t) {
                Log.e("error", t.toString());
            }




        });*/


    }

    public void cargarAdaptador(){

        AdaptadorPhoto adaptadorPhoto = new AdaptadorPhoto(getApplicationContext(),listaPhotos.getPhotos());
        lvItem.setAdapter(adaptadorPhoto);
    }

}
