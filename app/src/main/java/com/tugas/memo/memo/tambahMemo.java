package com.tugas.memo.memo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class tambahMemo extends AppCompatActivity implements View.OnClickListener{

    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText inp_judulmemo;
    private EditText inp_isimemo;

    private Button btn_tambahmemo;
    private Button btn_canceltambahmemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambahmemo);

        //Inisialisasi dari View
        inp_judulmemo = (EditText) findViewById(R.id.inp_judulmemo);
        inp_isimemo = (EditText) findViewById(R.id.inp_isimemo);

        btn_tambahmemo = (Button) findViewById(R.id.btn_tambahmemo);
        btn_canceltambahmemo = (Button) findViewById(R.id.btn_canceltambahmemo);

        //Setting listeners to button
        btn_tambahmemo.setOnClickListener(this);
        btn_canceltambahmemo.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addEmployee(){

        final String judul = inp_judulmemo.getText().toString().trim();
        final String isi_memo = inp_isimemo.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(tambahMemo.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(tambahMemo.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_EMP_NAMA,judul);
                params.put(konfigurasi.KEY_EMP_POSISI,isi_memo);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == btn_tambahmemo){
            addEmployee();
        }

        if(v == btn_canceltambahmemo){
            startActivity(new Intent(this,MemoList.class));
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(tambahMemo.this, MemoList.class));
        finish();
    }
}