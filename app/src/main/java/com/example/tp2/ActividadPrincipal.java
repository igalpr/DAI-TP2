package com.example.tp2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.text.TextUtilsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ActividadPrincipal extends Activity {

    public String NombreJugador;
    public EditText editTextResultado;
    public Button Nombre;
    public Button Verificacion;
    public ImageButton[] arrBotones;
    public TextView textViewVerificar;
    public int ResultadoValidacion;
    public int CantidadMovimientos;
    public int numeroUno;
    public int numeroDos;
    public TextView textViewCantidadMovimientos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        AsignarSegunIDs();
        GenerarNumeroRandom();
        arrBotones=new ImageButton[9];
       AsignarBotones();
        Randomizer();
        for (int i=0;i<arrBotones.length;i++)
        {

            arrBotones[i].setEnabled(false);
        }
    }
    void AsignarSegunIDs()
    {
        textViewVerificar = findViewById(R.id.Verificar);
        CantidadMovimientos=0;
        Nombre=findViewById(R.id.ButtonNombre);
        editTextResultado=findViewById(R.id.RespuestaVerificacion);
        Verificacion=findViewById(R.id.ButonVerificacion);
        textViewCantidadMovimientos=findViewById(R.id.CantidadMovimientos);
        textViewCantidadMovimientos.setText(""+CantidadMovimientos);
    }
    void GenerarNumeroRandom()
    {
        Random GenerarRandom;
        GenerarRandom = new Random();
        numeroUno = GenerarRandom.nextInt(11);
        numeroDos = GenerarRandom.nextInt(11);
        ResultadoValidacion=numeroUno+numeroDos;
        textViewVerificar.setText(numeroUno + "+" + numeroDos);
    }
    void AsignarBotones()
    {
        arrBotones[0]=(ImageButton)findViewById(R.id.Boton1);
        arrBotones[1]=(ImageButton)findViewById(R.id.Boton2);
        arrBotones[2]=(ImageButton)findViewById(R.id.Boton3);
        arrBotones[3]=(ImageButton)findViewById(R.id.Boton4);
        arrBotones[4]=(ImageButton)findViewById(R.id.Boton5);
        arrBotones[5]=(ImageButton)findViewById(R.id.Boton6);
        arrBotones[6]=(ImageButton)findViewById(R.id.Boton7);
        arrBotones[7]=(ImageButton)findViewById(R.id.Boton8);
        arrBotones[8]=(ImageButton)findViewById(R.id.Boton9);
    }
    void habilitar(View Vista)
    {
        EditText editTextNombre;
        editTextNombre=findViewById(R.id.EditTextNombre);
        NombreJugador=editTextNombre.getText().toString();
        editTextResultado.requestFocus();
    }

    void Randomizer()
    {
        boolean VolverAGenerarAzar;
        VolverAGenerarAzar=true;
        while(VolverAGenerarAzar==true)
        {
            int SumoTotalBotones;
            SumoTotalBotones=0;


            for(int punteroBoton=0;punteroBoton<=8;punteroBoton++)
            {
                switch (punteroBoton)
                {
                    case 0:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton1);
                        break;
                    case 1:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton2);
                        break;
                    case 2:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton3);
                        break;
                    case 3:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton4);
                        break;
                    case 4:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton5);
                        break;
                    case 5:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton6);
                        break;
                    case 6:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton7);
                        break;
                    case 7:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton8);
                        break;
                    case 8:
                        SumoTotalBotones+=AsignarBoton(R.id.Boton9);
                        break;
                }
            }
            if(SumoTotalBotones!=0&&SumoTotalBotones!=9)
            {
                VolverAGenerarAzar=false;
            }
        }
    }
    int AsignarBoton(int IdBotonAasignar)
    {
        Random GenerarRandom;
        GenerarRandom=new Random();
        int NumeroImagen;
        NumeroImagen=GenerarRandom.nextInt(2);
        ImageButton imagenSeleccionada;
        imagenSeleccionada=(ImageButton) findViewById(IdBotonAasignar);
        if(NumeroImagen==0)
        {
            imagenSeleccionada.setImageResource(R.drawable.leo);
        }
        else
        {
            imagenSeleccionada.setImageResource(R.drawable.pablo);
        }
        return NumeroImagen;
    }
    public void CambiarBotones(View VistaRecibida)
    {
        CantidadMovimientos++;
        textViewCantidadMovimientos.setText(""+CantidadMovimientos);
        ImageButton BotonSeleccionado;
        BotonSeleccionado=(ImageButton) VistaRecibida;
        //Le asigno el codigo de las 9 imagenes a 9 variables
        Drawable.ConstantState CodigoImagenBoton1;
        CodigoImagenBoton1=arrBotones[0].getDrawable().getConstantState();
        Drawable.ConstantState CodigoImagenBoton2;
        CodigoImagenBoton2=arrBotones[1].getDrawable().getConstantState();
        Drawable.ConstantState CodigoImagenBoton3;
        CodigoImagenBoton3=arrBotones[2].getDrawable().getConstantState();
        Drawable.ConstantState CodigoImagenBoton4;
        CodigoImagenBoton4=arrBotones[3].getDrawable().getConstantState();
        Drawable.ConstantState CodigoImagenBoton5;
        CodigoImagenBoton5=arrBotones[4].getDrawable().getConstantState();
        Drawable.ConstantState CodigoImagenBoton6;
        CodigoImagenBoton6=arrBotones[5].getDrawable().getConstantState();
        Drawable.ConstantState CodigoImagenBoton7;
        CodigoImagenBoton7=arrBotones[6].getDrawable().getConstantState();
        Drawable.ConstantState CodigoImagenBoton8;
        CodigoImagenBoton8=arrBotones[7].getDrawable().getConstantState();
        Drawable.ConstantState CodigoImagenBoton9;
        CodigoImagenBoton9=arrBotones[8].getDrawable().getConstantState();
        //obtengo el codigo de la imagen de leo y la guardo en una variable
        Drawable.ConstantState CodigoIma1;
        CodigoIma1= ContextCompat.getDrawable(this,R.drawable.leo).getConstantState();
        switch (BotonSeleccionado.getId())
        {

            case R.id.Boton1:

                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton1==CodigoIma1)
                {
                    arrBotones[0].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[0].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton2==CodigoIma1)
                {
                    arrBotones[1].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[1].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton4==CodigoIma1)
                {
                    arrBotones[3].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[3].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                break;
            case R.id.Boton2:
                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton1==CodigoIma1)
                {
                    arrBotones[0].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[0].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton2==CodigoIma1)
                {
                    arrBotones[1].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[1].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton3==CodigoIma1)
                {
                    arrBotones[2].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[2].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                break;
            case R.id.Boton3:
                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton2==CodigoIma1)
                {
                    arrBotones[1].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[1].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton3==CodigoIma1)
                {
                    arrBotones[2].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[2].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton6==CodigoIma1)
                {
                    arrBotones[5].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[5].setImageResource(R.drawable.leo);
                }
                break;
            case R.id.Boton4:
                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton1==CodigoIma1)
                {
                    arrBotones[0].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[0].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton4==CodigoIma1)
                {
                    arrBotones[3].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[3].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton7==CodigoIma1)
                {
                    arrBotones[6].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[6].setImageResource(R.drawable.leo);
                }
                break;
            case R.id.Boton5:
                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton2==CodigoIma1)
                {
                    arrBotones[1].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[1].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton4==CodigoIma1)
                {
                    arrBotones[3].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[3].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton6==CodigoIma1)
                {
                    arrBotones[5].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[5].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton8==CodigoIma1)
                {
                    arrBotones[7].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[7].setImageResource(R.drawable.leo);
                }
                break;
            case R.id.Boton6:
                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton3==CodigoIma1)
                {
                    arrBotones[2].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[2].setImageResource(R.drawable.leo);
                }

                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton6==CodigoIma1)
                {
                    arrBotones[5].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[5].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton9==CodigoIma1)
                {
                    arrBotones[8].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[8].setImageResource(R.drawable.leo);
                }
                break;
            case R.id.Boton7:
                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton4==CodigoIma1)
                {
                    arrBotones[3].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[3].setImageResource(R.drawable.leo);
                }

                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton7==CodigoIma1)
                {
                    arrBotones[6].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[6].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton8==CodigoIma1)
                {
                    arrBotones[7].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[7].setImageResource(R.drawable.leo);
                }
                break;
            case R.id.Boton8:
                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton7==CodigoIma1)
                {
                    arrBotones[6].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[6].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton8==CodigoIma1)
                {
                    arrBotones[7].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[7].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton9==CodigoIma1)
                {
                    arrBotones[8].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[8].setImageResource(R.drawable.leo);
                }
                break;
            case R.id.Boton9:
                //comparo el codigo de cada imagen con el de la imagen de leo
                //si es igual le cambio a la imagen de pablo y sino le cambio a la imagen de leo
                if(CodigoImagenBoton5==CodigoIma1)
                {
                    arrBotones[4].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[4].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton6==CodigoIma1)
                {
                    arrBotones[5].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[5].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton8==CodigoIma1)
                {
                    arrBotones[7].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[7].setImageResource(R.drawable.leo);
                }
                if(CodigoImagenBoton9==CodigoIma1)
                {
                    arrBotones[8].setImageResource(R.drawable.pablo);
                }
                else
                {
                    arrBotones[8].setImageResource(R.drawable.leo);
                }
                break;
        }
        boolean Ganaste=true;
        Drawable.ConstantState imagenA=arrBotones[1].getDrawable().getConstantState();
        for(ImageButton aux : arrBotones)
        {
            if (aux.getDrawable().getConstantState() != imagenA)
            {
                Ganaste=false;
            }
        }
        if(Ganaste==true)
        {
            Bundle MiBunedle;
            MiBunedle=new Bundle();
            MiBunedle.putString("NombreJugador",NombreJugador);
            Bundle Movimientos;
            Movimientos=new Bundle();
            Movimientos.putInt("CantidadMovimientos",CantidadMovimientos);
            Intent Ganador;
            Ganador=new Intent(this,Ganaste.class);
            Ganador.putExtras(MiBunedle);
            Ganador.putExtras(Movimientos);
            startActivity(Ganador);
        }
    }
    void VerificarInformacion(View vista)
    {
        int Resultado;
        Resultado=Integer.valueOf(editTextResultado.getText().toString());
        ImageView VerificarVeracidad;
        VerificarVeracidad=findViewById(R.id.ImagenVerificacion);
        if(Resultado==ResultadoValidacion && NombreJugador!=null)
        {
            VerificarVeracidad.setImageResource(R.drawable.tic);
            for (int i=0;i<arrBotones.length;i++)
            {

                arrBotones[i].setEnabled(true);
            }
            Verificacion.setEnabled(false);
            editTextResultado.setEnabled(false);
        }
        else
        {
            VerificarVeracidad.setImageResource(R.drawable.cruz);
        }
    }

}
