package com.example.arqdsis.provapratica;

import android.content.Context;

import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jose on 05/05/2017.
 *
 * jose bruno januario
 * RA:201517258
 */
public class PaisRequest {
        //OkHttpClient client = new OkHttpClient();

    /**
     *
     * @param url
     * @param chave
     * @return
     * @throws IOException
     *  * jose bruno januario
     * RA:201517258

     */
        public ArrayList<Pais> get (String url, String chave) throws IOException {
            ArrayList<Pais> lista = new ArrayList<>();
            System.out.println(url);

          //  DownloadManager.Request request = new DownloadManager.Request.Builder().url(url).build();
            System.out.println(request);
          //  Response response = client.newCall(request).execute();
          //  System.out.println(response);
           // String jsonString = response.body().string();
            System.out.println(jsonString);

            try{
                JSONArray root = new JSONArray(jsonString);
                JSONObject item = null;
                for(int i = 0; i < root.length(); i++){
                    item = (JSONObject)root.get(i);
                    String nome = item.getString("nome");
                    String capital = item.getString("capital");
                    String area = item.getString("area");
                    String populacao = item.getString("populacao");
                    int id = item.getInt("id");

                    lista.add(new Pais(id,nome, capital, area, populacao));
                }
            } catch (JSONException e){
                throw new IOException(e);
            } finally {
                if(lista.size() == 0){
                    lista.add(new Pais());
                }
            }
            return lista;
        }

    /**
     *
     * @param context
     * @return
     *  * jose bruno januario
     * RA:201517258

     */
    public boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}


