package com.example.dai_tp2_bis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ganaste extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganaste);
        Bundle DatosRecibidos;
        DatosRecibidos=this.getIntent().getExtras();
        String NombreJugador=DatosRecibidos.getString("NombreJugador");
        Bundle CantidadMovimientos;
        CantidadMovimientos=this.getIntent().getExtras();
        int CantMov=CantidadMovimientos.getInt("CantidadMovimientos");
        TextView textViewGanaste;
        textViewGanaste=findViewById(R.id.TextViewGanaste);
        textViewGanaste.setText("Felicidades al jugador "+NombreJugador+" ganaste el juego en "+CantMov+" movimientos");
    }
    void Reiniciar(View Vista)
    {
        Intent Volver;
        Volver=new Intent(this,ActividadPrincipal.class);
        startActivity(Volver);
    }
}
