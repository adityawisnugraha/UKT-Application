package com.example.uktapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Config2Activity extends AppCompatActivity {

    Button next;
    Spinner bangunan_bobot,motor_bobot,mobil_bobot,emas_bobot,ayah_bobot,ibu_bobot,total_bobot;
    String bobot_bangunan,bobot_motor,bobot_mobil,bobot_emas,bobot_ayah,bobot_ibu,bobot_total;
    DatabaseReference reff;
    Bobot bobot;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config2);

        bangunan_bobot = (Spinner) findViewById(R.id.luas_bangunan);
        motor_bobot = (Spinner) findViewById(R.id.motor);
        mobil_bobot = (Spinner) findViewById(R.id.mobil);
        emas_bobot = (Spinner) findViewById(R.id.emas);
        ayah_bobot = (Spinner) findViewById(R.id.ayah);
        ibu_bobot = (Spinner) findViewById(R.id.ibu);
        total_bobot = (Spinner) findViewById(R.id.keluarga);
        next = (Button) findViewById(R.id.next);
        bobot = new Bobot();
        reff = FirebaseDatabase.getInstance().getReference().child("Bobot");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        bangunan_bobot.setOnItemSelectedListener(new aksi_bangunan());
        motor_bobot.setOnItemSelectedListener(new aksi_motor());
        mobil_bobot.setOnItemSelectedListener(new aksi_mobil());
        emas_bobot.setOnItemSelectedListener(new aksi_emas());
        ayah_bobot.setOnItemSelectedListener(new aksi_ayah());
        ibu_bobot.setOnItemSelectedListener(new aksi_ibu());
        total_bobot.setOnItemSelectedListener(new aksi_total());

        final String bobot_sekolah = getIntent().getStringExtra("masihsekolah");
        final String bobot_keluarga = getIntent().getStringExtra("bobotkeluarga");
        final String bobot_listrik = getIntent().getStringExtra("bobotlistrik");
        final String bobot_pbb = getIntent().getStringExtra("bobotpbb");
        final String bobot_rumah = getIntent().getStringExtra("bobotrumah");
        final String bobot_tanah = getIntent().getStringExtra("bobottanah");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bobot.setBobot_ayah(bobot_ayah);
                bobot.setBobot_bangunan(bobot_bangunan);
                bobot.setBobot_emas(bobot_emas);
                bobot.setBobot_ibu(bobot_ibu);
                bobot.setBobot_keluarga(bobot_keluarga);
                bobot.setBobot_listrik(bobot_listrik);
                bobot.setBobot_mobil(bobot_mobil);
                bobot.setBobot_motor(bobot_motor);
                bobot.setBobot_pbb(bobot_pbb);
                bobot.setBobot_sekolah(bobot_sekolah);
                bobot.setBobot_rumah(bobot_rumah);
                bobot.setBobot_tanah(bobot_tanah);
                bobot.setBobot_total(bobot_total);
                reff.setValue(bobot);
                Toast.makeText(Config2Activity.this,"data masuk",Toast.LENGTH_LONG).show();
            }
        });


    }

    public class aksi_bangunan implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = bangunan_bobot.getSelectedItem().toString();
            if (item.equals("5")) {
                bobot_bangunan = "5";
            } else if (item.equals("4")) {
                bobot_bangunan = "4";
            } else if (item.equals("3")) {
                bobot_bangunan = "3";
            } else if (item.equals("2")) {
                bobot_bangunan = "2";
            } else if (item.equals("1")) {
                bobot_bangunan = "1";
            } else {
                bobot_bangunan = "0";
                Toast.makeText(Config2Activity.this,"Error, Isi Form dengan Benar !!!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }
    public class aksi_motor implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = motor_bobot.getSelectedItem().toString();
            if (item.equals("5")) {
                bobot_motor = "5";
            } else if (item.equals("4")) {
                bobot_motor = "4";
            } else if (item.equals("3")) {
                bobot_motor = "3";
            } else if (item.equals("2")) {
                bobot_motor = "2";
            } else if (item.equals("1")) {
                bobot_motor = "1";
            } else {
                bobot_motor = "0";
                Toast.makeText(Config2Activity.this,"Error, Isi Form dengan Benar !!!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }
    public class aksi_mobil implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = mobil_bobot.getSelectedItem().toString();
            if (item.equals("5")) {
                bobot_mobil = "5";
            } else if (item.equals("4")) {
                bobot_mobil = "4";
            } else if (item.equals("3")) {
                bobot_mobil = "3";
            } else if (item.equals("2")) {
                bobot_mobil = "2";
            } else if (item.equals("1")) {
                bobot_mobil = "1";
            } else {
                bobot_mobil = "0";
                Toast.makeText(Config2Activity.this,"Error, Isi Form dengan Benar !!!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }
    public class aksi_emas implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = emas_bobot.getSelectedItem().toString();
            if (item.equals("5")) {
                bobot_emas = "5";
            } else if (item.equals("4")) {
                bobot_emas = "4";
            } else if (item.equals("3")) {
                bobot_emas = "3";
            } else if (item.equals("2")) {
                bobot_emas = "2";
            } else if (item.equals("1")) {
                bobot_emas = "1";
            } else {
                bobot_emas = "0";
                Toast.makeText(Config2Activity.this,"Error, Isi Form dengan Benar !!!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }
    public class aksi_ayah implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = ayah_bobot.getSelectedItem().toString();
            if (item.equals("5")) {
                bobot_ayah = "5";
            } else if (item.equals("4")) {
                bobot_ayah = "4";
            } else if (item.equals("3")) {
                bobot_ayah = "3";
            } else if (item.equals("2")) {
                bobot_ayah = "2";
            } else if (item.equals("1")) {
                bobot_ayah = "1";
            } else {
                bobot_ayah = "0";
                Toast.makeText(Config2Activity.this,"Error, Isi Form dengan Benar !!!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }
    public class aksi_ibu implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = ibu_bobot.getSelectedItem().toString();
            if (item.equals("5")) {
                bobot_ibu = "5";
            } else if (item.equals("4")) {
                bobot_ibu = "4";
            } else if (item.equals("3")) {
                bobot_ibu = "3";
            } else if (item.equals("2")) {
                bobot_ibu = "2";
            } else if (item.equals("1")) {
                bobot_ibu = "1";
            } else {
                bobot_ibu = "0";
                Toast.makeText(Config2Activity.this,"Error, Isi Form dengan Benar !!!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }
    public class aksi_total implements AdapterView.OnItemSelectedListener{

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = total_bobot.getSelectedItem().toString();
            if (item.equals("5")) {
                bobot_total = "5";
            } else if (item.equals("4")) {
                bobot_total = "4";
            } else if (item.equals("3")) {
                bobot_total = "3";
            } else if (item.equals("2")) {
                bobot_total = "2";
            } else if (item.equals("1")) {
                bobot_total = "1";
            } else {
                bobot_total = "0";
                Toast.makeText(Config2Activity.this,"Error, Isi Form dengan Benar !!!", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }

}
