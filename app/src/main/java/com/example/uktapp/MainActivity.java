package com.example.uktapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.ArrayUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid,cloneGrid;
    TextView text;
    CardView cardView;
    DatabaseReference reff,dbase;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        cloneGrid = (GridLayout)findViewById(R.id.secondGrid);
        text = (TextView)findViewById(R.id.Text);
        reff = FirebaseDatabase.getInstance().getReference();

        setSingleEvent(mainGrid);
        setSingleEvent1(cloneGrid);
        //Set Event
    }

    private void setSingleEvent(GridLayout mainGrid){
        for (int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if(finalI==0)
                    {
                        Intent intent = new Intent(MainActivity.this,DaftarActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI==1)
                    {
                        Intent intent = new Intent(MainActivity.this,ConfigActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Please set activity for this card item",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
    private void setSingleEvent1(GridLayout cloneGrid){
        for (int i=0;i<cloneGrid.getChildCount();i++)
        {
            CardView cardView = (CardView) cloneGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if(finalI==0)
                    {
                        //Proses Normalisasi Matriks
                        reff.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()){
                                    maxid=(dataSnapshot.getChildrenCount());
                                    int c = 1;
                                    for(int b = 1;b<=(maxid-1);b++) {
                                        c++;
                                    }
                                    double[] ayah = new double[c];
                                    double[] bangunan = new double[c];
                                    double[] emas = new double[c];
                                    double[] ibu = new double[c];
                                    double[] keluarga = new double[c];
                                    double[] listrik = new double[c];
                                    double[] mobil = new double[c];
                                    double[] motor = new double[c];
                                    double[] pbb = new double[c];
                                    double[] rumah = new double[c];
                                    double[] sekolah = new double[c];
                                    double[] tanah = new double[c];
                                    double[] total = new double[c];
                                    for(int i = 1;i<=(maxid-1);i++){
                                        String a = String.valueOf(i);
                                        ayah[i]=Double.parseDouble(dataSnapshot.child(a).child("ayah").getValue().toString());
                                        bangunan[i]=Double.parseDouble(dataSnapshot.child(a).child("bangunan").getValue().toString());
                                        emas[i]=Double.parseDouble(dataSnapshot.child(a).child("emas").getValue().toString());
                                        ibu[i]=Double.parseDouble(dataSnapshot.child(a).child("ibu").getValue().toString());
                                        keluarga[i]=Double.parseDouble(dataSnapshot.child(a).child("keluarga").getValue().toString());
                                        listrik[i]=Double.parseDouble(dataSnapshot.child(a).child("listrik").getValue().toString());
                                        mobil[i]=Double.parseDouble(dataSnapshot.child(a).child("mobil").getValue().toString());
                                        motor[i]=Double.parseDouble(dataSnapshot.child(a).child("motor").getValue().toString());
                                        pbb[i]=Double.parseDouble(dataSnapshot.child(a).child("pbb").getValue().toString());
                                        rumah[i]=Double.parseDouble(dataSnapshot.child(a).child("rumah").getValue().toString());
                                        sekolah[i]=Double.parseDouble(dataSnapshot.child(a).child("sekolah").getValue().toString());
                                        tanah[i]=Double.parseDouble(dataSnapshot.child(a).child("tanah").getValue().toString());
                                        total[i]=Double.parseDouble(dataSnapshot.child(a).child("total").getValue().toString());
                                    }
                                    double bobot_ayah = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_ayah").getValue().toString());
                                    double bobot_bangunan = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_bangunan").getValue().toString());
                                    double bobot_emas = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_emas").getValue().toString());
                                    double bobot_ibu = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_ibu").getValue().toString());
                                    double bobot_keluarga = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_keluarga").getValue().toString());
                                    double bobot_listrik = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_listrik").getValue().toString());
                                    double bobot_mobil = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_mobil").getValue().toString());
                                    double bobot_motor = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_motor").getValue().toString());
                                    double bobot_pbb = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_pbb").getValue().toString());
                                    double bobot_rumah = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_rumah").getValue().toString());
                                    double bobot_sekolah = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_sekolah").getValue().toString());
                                    double bobot_tanah = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_tanah").getValue().toString());
                                    double bobot_total = Double.parseDouble(dataSnapshot.child("Bobot").child("bobot_total").getValue().toString());

                                    double[] fix_ayah = new double[c];
                                    double[] fix_bangunan = new double[c];
                                    double[] fix_emas = new double[c];
                                    double[] fix_ibu = new double[c];
                                    double[] fix_keluarga = new double[c];
                                    double[] fix_listrik = new double[c];
                                    double[] fix_mobil = new double[c];
                                    double[] fix_motor = new double[c];
                                    double[] fix_pbb = new double[c];
                                    double[] fix_rumah = new double[c];
                                    double[] fix_sekolah = new double[c];
                                    double[] fix_tanah = new double[c];
                                    double[] fix_total = new double[c];
                                    for (int i = 1;i<=(maxid-1);i++){
                                        fix_ayah[i] = ayah[i]*ayah[i];
                                        fix_bangunan[i] = bangunan[i]*bangunan[i];
                                        fix_emas[i] = emas[i]*emas[i];
                                        fix_ibu[i] = ibu[i]*ibu[i];
                                        fix_keluarga[i] = keluarga[i]*keluarga[i];
                                        fix_listrik[i] = listrik[i]*listrik[i];
                                        fix_mobil[i] = mobil[i]*mobil[i];
                                        fix_motor[i] = motor[i]*motor[i];
                                        fix_pbb[i] = pbb[i]*pbb[i];
                                        fix_rumah[i] = rumah[i]*rumah[i];
                                        fix_sekolah[i] = sekolah[i]*sekolah[i];
                                        fix_tanah[i] = tanah[i]*tanah[i];
                                        fix_total[i] = total[i]*total[i];
                                    }
                                    double totalAyah =0;
                                    double totalBangunan =0;
                                    double totalEmas =0;
                                    double totalIbu =0;
                                    double totalKeluarga =0;
                                    double totalListrik =0;
                                    double totalMobil =0;
                                    double totalMotor =0;
                                    double totalPbb =0;
                                    double totalRumah =0;
                                    double totalSekolah =0;
                                    double totalTanah =0;
                                    double totalTotal =0;
                                    for (double value : fix_ayah){
                                        totalAyah += value;
                                    }
                                    for (double value : fix_bangunan){
                                        totalBangunan += value;
                                    }
                                    for (double value : fix_emas){
                                        totalEmas += value;
                                    }
                                    for (double value : fix_ibu){
                                        totalIbu += value;
                                    }
                                    for (double value : fix_keluarga){
                                        totalKeluarga += value;
                                    }
                                    for (double value : fix_listrik){
                                        totalListrik += value;
                                    }
                                    for (double value : fix_mobil){
                                        totalMobil += value;
                                    }
                                    for (double value : fix_motor){
                                        totalMotor += value;
                                    }
                                    for (double value : fix_pbb){
                                        totalPbb += value;
                                    }
                                    for (double value : fix_rumah){
                                        totalRumah += value;
                                    }
                                    for (double value : fix_sekolah){
                                        totalSekolah += value;
                                    }
                                    for (double value : fix_tanah){
                                        totalTanah += value;
                                    }
                                    for (double value : fix_total){
                                        totalTotal += value;
                                    }
                                    double sqrt_totalAyah = Math.sqrt(totalAyah);
                                    double sqrt_totalBangunan = Math.sqrt(totalBangunan);
                                    double sqrt_totalEmas = Math.sqrt(totalEmas);
                                    double sqrt_totalIbu = Math.sqrt(totalIbu);
                                    double sqrt_totalKeluarga = Math.sqrt(totalKeluarga);
                                    double sqrt_totalListrik = Math.sqrt(totalListrik);
                                    double sqrt_totalMobil = Math.sqrt(totalMobil);
                                    double sqrt_totalMotor = Math.sqrt(totalMotor);
                                    double sqrt_totalPbb = Math.sqrt(totalPbb);
                                    double sqrt_totalRumah = Math.sqrt(totalRumah);
                                    double sqrt_totalSekolah = Math.sqrt(totalSekolah);
                                    double sqrt_totalTanah = Math.sqrt(totalTanah);
                                    double sqrt_totalTotal = Math.sqrt(totalTotal);

                                    double[] norm_ayah = new double[c];
                                    double[] norm_bangunan = new double[c];
                                    double[] norm_emas = new double[c];
                                    double[] norm_ibu = new double[c];
                                    double[] norm_keluarga = new double[c];
                                    double[] norm_listrik = new double[c];
                                    double[] norm_mobil = new double[c];
                                    double[] norm_motor = new double[c];
                                    double[] norm_pbb = new double[c];
                                    double[] norm_rumah = new double[c];
                                    double[] norm_sekolah = new double[c];
                                    double[] norm_tanah = new double[c];
                                    double[] norm_total = new double[c];
                                    for(int i = 1;i<=(maxid-1);i++){
                                        norm_ayah[i] = ayah[i]/sqrt_totalAyah;
                                        norm_bangunan[i] = bangunan[i]/sqrt_totalBangunan;
                                        norm_emas[i] = emas[i]/sqrt_totalEmas;
                                        norm_ibu[i] = ibu[i]/sqrt_totalIbu;
                                        norm_keluarga[i] = keluarga[i]/sqrt_totalKeluarga;
                                        norm_listrik[i] = listrik[i]/sqrt_totalListrik;
                                        norm_mobil[i] = mobil[i]/sqrt_totalMobil;
                                        norm_motor[i] = motor[i]/sqrt_totalMotor;
                                        norm_pbb[i] = pbb[i]/sqrt_totalPbb;
                                        norm_rumah[i] = rumah[i]/sqrt_totalRumah;
                                        norm_sekolah[i] = sekolah[i]/sqrt_totalSekolah;
                                        norm_tanah[i] = tanah[i]/sqrt_totalTanah;
                                        norm_total[i] = total[i]/sqrt_totalTotal;
                                    }
                                    List <Double> fixnorm_ayah = new ArrayList<Double>();
                                    for (int i = 1;i<=(maxid-1);i++){
                                        fixnorm_ayah.add(norm_ayah[i]);
                                    }
                                    double maxfix_norm_ayah = Collections.max(fixnorm_ayah);
                                    text.setText(String.valueOf(maxfix_norm_ayah));
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Toast.makeText(MainActivity.this,"Database Error",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    else if (finalI==1)
                    {

                    }
                    else if (finalI==2)
                    {

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Please set activity for this card item",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}