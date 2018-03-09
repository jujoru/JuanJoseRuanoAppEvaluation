package es.jujoru.juanjoseruanoappevaluation.Controlador;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;

import es.jujoru.juanjoseruanoappevaluation.ActivityDetails;
import es.jujoru.juanjoseruanoappevaluation.AdaptadorPhoto;
import es.jujoru.juanjoseruanoappevaluation.Modelos.Photo;
import es.jujoru.juanjoseruanoappevaluation.Modelos.PhotoList;



public class AsyncTaskPhotos extends AsyncTask<String, Void, PhotoList>{
    final  String EXTRA_FOTO = "FOTO";
    ListView listView;
    Context c;
    PhotoList listaPhotos;
    ProgressDialog dialog;


   public AsyncTaskPhotos(ListView listView, Context c){
       this.listView=listView;
       this.c=c;
   }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog= new ProgressDialog(c);
        dialog.setMessage("Cargando datos");
        dialog.setProgressStyle(ProgressDialog.THEME_HOLO_DARK);
        dialog.setCancelable(false);
        dialog.setMax(100);
        dialog.show();

    }

    @Override
    protected PhotoList doInBackground(String... params) {
        try {
            listaPhotos = Conn.start().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPhotos;
    }

    @Override
    protected void onPostExecute(PhotoList photoList) {
        super.onPostExecute(photoList);

        AdaptadorPhoto adaptadorPhoto = new AdaptadorPhoto(c,photoList.getPhotos());
        listView.setAdapter(adaptadorPhoto);

        dialog.dismiss();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Photo p = ((Photo)parent.getItemAtPosition(position));

                Intent i=new Intent(c, ActivityDetails.class);
                i.putExtra(EXTRA_FOTO,p.getImgSrc());
                c.startActivity(i);
            }
        });
    }





}
