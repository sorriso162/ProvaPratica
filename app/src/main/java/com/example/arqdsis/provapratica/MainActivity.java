package com.example.arqdsis.provapratica;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Created by jose on 05/05/2017.
 *  * jose bruno januario
 * RA:201517258

 */
public class MainActivity extends Activity {
    Spinner spinner1;
    ArrayList<Pais> lista;
    PaisRequest requester;
    Intent intent;
    String chave;

    public static final String SERVIDOR = " https://restcountries.eu/rest/v2/region/{region}";
    public static final String APLICACAO = "/ProvaPratica";
    public static final String RECURSO = "/ListaPais";
    public static final String LISTA = " com.example.arqdsis.provapratica.ListaPais";

    /**
     *
     * @param savedInstanceState
     *  * jose bruno januario
     * RA:201517258

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Asia", "Africa","Americas","Oceania","Europe"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
    }

    /**
     *
     * @param view
     *  * jose bruno januario
     * RA:201517258

     */
    public void buscarCliente(View view){
        intent = new Intent(this, ListarPaises.class);
        chave = spinner1.getSelectedItem().toString();
        requester = new PaisRequest();
        if(requester.isConnected(this)){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lista = requester.get(SERVIDOR+APLICACAO+RECURSO, chave);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Lista: "+lista);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            intent.putExtra(LISTA, lista);
                            startActivity(intent);
                        }
                    });

                }
            }).start();

        } else {
            Toast toast = Toast.makeText(this, "Rede indisponÃ­vel", Toast.LENGTH_LONG);
            toast.show();
        }


    }
}

