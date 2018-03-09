package es.jujoru.juanjoseruanoappevaluation.Modelos;

import retrofit2.Call;
import retrofit2.http.GET;
import es.jujoru.juanjoseruanoappevaluation.Modelos.PhotoList;


public interface RestClient {

    @GET("photos?sol=1000&api_key=DEMO_KEY")
    Call<PhotoList> getData();
}
