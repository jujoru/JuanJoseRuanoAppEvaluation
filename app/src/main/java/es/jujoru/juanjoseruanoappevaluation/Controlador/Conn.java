package es.jujoru.juanjoseruanoappevaluation.Controlador;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import es.jujoru.juanjoseruanoappevaluation.Modelos.PhotoList;
import es.jujoru.juanjoseruanoappevaluation.Modelos.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nino Ruano on 05/03/2018.
 */

public class Conn {



    static Call<PhotoList> start(){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestClient restClient = retrofit.create(RestClient.class);
        Call<PhotoList> call = restClient.getData();
        return call;

    }


}
