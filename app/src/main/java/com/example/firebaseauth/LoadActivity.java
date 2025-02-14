package com.example.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoadActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText txtinprut,txtinpnombre, txtinpdiagnostico,txtinptiempoev,txtinpedad,txtinpsexo,txtinpfecha,txtinpamorbidos,txtinpmedicamentos,txtinpherida1;
    public String disrut = "rut",disnombre="name",disdiagnostico="diag",distiempo="tiempoev",dissexo="sexo",disfecha="fecha",disamorbidos="amorbidos",dismedicamentos="medicamentos",disedad ="edad",disherida1="herida1";
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    EditText buscadorcorto;
    Button btnbuscarcorto;
    fragmentficha fragment_ficha = new fragmentficha();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Inicio");
        setSupportActionBar(toolbar);
        buscadorcorto = findViewById(R.id.editTextbuscador);
        btnbuscarcorto = findViewById(R.id.botonbuscar);

        navigationView = findViewById(R.id.navigationView);


        drawerLayout = findViewById(R.id.drawer);
        navigationView.bringToFront();

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        FrameLayout frameLayout;
        frameLayout = findViewById(R.id.layoutframe);


        txtinprut = findViewById(R.id.RUT);
        txtinpnombre = findViewById(R.id.nombre);
        txtinpdiagnostico = findViewById(R.id.diagnostico);
        txtinptiempoev = findViewById(R.id.tiempoevolucion);
        txtinpedad = findViewById(R.id.edad);
        txtinpsexo = findViewById(R.id.sexo);
        txtinpfecha = findViewById(R.id.fecha);
        txtinpamorbidos = findViewById(R.id.amorbidos);
        txtinpmedicamentos=findViewById(R.id.medicamentos);
        txtinpherida1 = findViewById(R.id.herida1);
        //getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment_ficha).commit();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        if (menuItem.getItemId() == R.id.test) {
            Intent intent = new Intent(this, firebase.class);
            startActivity(intent);

        }

        if (menuItem.getItemId() == R.id.another) {
            Toast.makeText(this, "agrega la actividad flojo", Toast.LENGTH_LONG).show();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void buscarpaciente(View view) {
        String rut = buscadorcorto.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
       DocumentReference load = db.collection("datosPacienteins").document(rut);
        load.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String ruta = documentSnapshot.getString(disrut);
                    txtinprut.setText(ruta);
                    String name = documentSnapshot.getString(disnombre);
                    txtinpnombre.setText(name);
                    String diag = documentSnapshot.getString(disdiagnostico);
                    txtinpdiagnostico.setText(diag);
                    String tiempoev = documentSnapshot.getString(distiempo);
                    txtinptiempoev.setText(tiempoev);
                    String edad = documentSnapshot.getString(disedad);
                    txtinpedad.setText(edad);
                    String sexo = documentSnapshot.getString(dissexo);
                    txtinpsexo.setText(sexo);
                    String amorbidos = documentSnapshot.getString(disamorbidos);
                    txtinpamorbidos.setText(amorbidos);
                    String medicamentos = documentSnapshot.getString(dismedicamentos);
                    txtinpmedicamentos.setText(medicamentos);
                    String fecha = documentSnapshot.getString(disfecha);
                    txtinpfecha.setText(fecha);
                    String herida1= documentSnapshot.getString(disherida1);
                    txtinpherida1.setText(herida1);


                } else {
                    Toast.makeText(LoadActivity.this,"no se encuentra el paciente intentelo nuevamente",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}