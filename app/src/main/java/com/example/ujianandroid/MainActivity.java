package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNamaDepan = (EditText) findViewById(R.id.edNamaDepan);
        EditText edNamaBelakang = (EditText) findViewById(R.id.edNamaBelakang);
        EditText edUmur = (EditText) findViewById(R.id.edUmur);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama_depan = edNamaDepan.getText().toString();
                String isian_nama_belakang = edNamaBelakang.getText().toString();
                String isian_umur = edUmur.getText().toString();

                if(isian_nama_depan.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                }else{
                    String nama_lengkap = isian_nama_depan.concat(" ").concat(isian_nama_belakang);
                    daftar_nama.clear();
                    daftar_nama.add(nama_lengkap);
                    edNamaDepan.setText("");
                    edNamaBelakang.setText("");
                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                    startActivity(intent_list);
                }
            }

            import java.util.Scanner;

            public class TambahUmur {
                public static void main(String[] args) {
                    Scanner input = new Scanner(System.in);

                    System.out.print("Masukkan umur: ");
                    int umur = input.nextInt();

                    if (umur <= 10) {
                        System.out.println("Umur anda adalah anak");
                    } else if (umur <= 20) {
                        System.out.println("Umur anda adalah remaja");
                    } else if (umur <= 40) {
                        System.out.println("Umur anda adalah dewasa");
                    } else if (umur <= 60) {
                        System.out.println("Umur anda adalah lansia");
                    } else {
                        System.out.println("Umur anda adalah tua");
                    }

                }
            }

        });
    }
}