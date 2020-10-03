package com.sebastian.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mostrar;
    Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, mas, menos, por, div, igual, raiz, x, c;
    int acumular=0;
    int presente =0;
    double rai=0;
    String ra="";
    String presenteOperador="";
    boolean controlar=false;
    boolean operador=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrar = findViewById(R.id.editmostrar);
        uno = findViewById(R.id.btn1);
        dos = findViewById(R.id.btn2);
        tres = findViewById(R.id.btn3);
        cuatro = findViewById(R.id.btn4);
        cinco = findViewById(R.id.btn5);
        seis = findViewById(R.id.btn6);
        siete = findViewById(R.id.btn7);
        ocho = findViewById(R.id.btn8);
        nueve = findViewById(R.id.btn9);
        cero = findViewById(R.id.btn0);
        mas = findViewById(R.id.btnmas);
        menos = findViewById(R.id.btnmenos);
        por = findViewById(R.id.btnpor);
        div = findViewById(R.id.btndiv);
        igual = findViewById(R.id.btnigual);
        raiz = findViewById(R.id.btnraiz);
        x = findViewById(R.id.btnx);
        c = findViewById(R.id.btnnada);
        mostrar.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        cero.setOnClickListener(this);
        mas.setOnClickListener(this);
        menos.setOnClickListener(this);
        por.setOnClickListener(this);
        div.setOnClickListener(this);
        igual.setOnClickListener(this);
        raiz.setOnClickListener(this);
        c.setOnClickListener(this);
        x.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String valor;

        int num=0;

        if(!TextUtils.isEmpty(mostrar.getText().toString())){
            num = Integer.parseInt(mostrar.getText().toString());
            valor = mostrar.getText().toString();
        }else {
            valor="";
        }
        switch (v.getId()){
            case R.id.btn1:
                valor = valor + "1";
                mostrar.setText(valor);
                break;
            case R.id.btn2:
                valor = valor + "2";
                mostrar.setText(valor);
                break;
            case R.id.btn3:
                valor = valor + "3";
                mostrar.setText(valor);
                break;
            case R.id.btn4:
                valor = valor + "4";
                mostrar.setText(valor);
                break;
            case R.id.btn5:
                valor = valor + "5";
                mostrar.setText(valor);
                break;
            case R.id.btn6:
                valor = valor + "6";
                mostrar.setText(valor);
                break;
            case R.id.btn7:
                valor = valor + "7";
                mostrar.setText(valor);
                break;
            case R.id.btn8:
                valor = valor + "8";
                mostrar.setText(valor);
                break;
            case R.id.btn9:
                valor = valor + "9";
                mostrar.setText(valor);
                break;
            case R.id.btn0:
                valor = valor + "0";
                mostrar.setText(valor);
                break;
            case R.id.btnmas:
                if(TextUtils.isEmpty(mostrar.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Error antes ingrese un valor",Toast.LENGTH_LONG).show();
                }else{

                    if(!operador){
                        acumular = Integer.parseInt(mostrar.getText().toString());
                        mostrar.setText("");
                        controlar=true;
                        operador=true;
                        presenteOperador="+";
                    }
                }

                break;
            case R.id.btnmenos:
                if(TextUtils.isEmpty(mostrar.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Error antes ingrese un valor",Toast.LENGTH_LONG).show();
                }else{

                    if(!operador){
                        acumular = Integer.parseInt(mostrar.getText().toString());
                        mostrar.setText("");
                        controlar=true;
                        operador=true;
                        presenteOperador="-";
                    }
                }
                break;
            case R.id.btnpor:
                if(TextUtils.isEmpty(mostrar.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Error antes ingrese un valor",Toast.LENGTH_LONG).show();
                }else{

                    if(!operador){
                        acumular = Integer.parseInt(mostrar.getText().toString());
                        mostrar.setText("");
                        controlar=true;
                        operador=true;
                        presenteOperador="*";
                    }
                }
                break;
            case R.id.btndiv:
                if(TextUtils.isEmpty(mostrar.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Error antes ingrese un valor",Toast.LENGTH_LONG).show();
                }else{

                    if(!operador){
                        acumular = Integer.parseInt(mostrar.getText().toString());
                        mostrar.setText("");
                        controlar=true;
                        operador=true;
                        presenteOperador="/";
                    }
                }
                break;
            case R.id.btnigual:
                if(mostrar.getText().toString()!=""){
                    if(controlar){
                        presente= Integer.parseInt(mostrar.getText().toString());
                        if(presenteOperador=="+"){
                            mostrar.setText(acumular+presente+"");
                            presenteOperador="";
                        }
                        if(presenteOperador=="-"){
                            mostrar.setText(acumular-presente+"");
                            presenteOperador="";
                        }
                        if(presenteOperador=="*"){
                            mostrar.setText(acumular*presente+"");
                            presenteOperador="";
                        }
                        if(presenteOperador=="/"){
                            if(presente!=0){
                                mostrar.setText(acumular/presente+"");
                                presenteOperador="";
                            }else{
                                Toast.makeText(getApplicationContext(),"El denominador no puede ser 0",Toast.LENGTH_LONG).show();
                            }

                        }
                       if(presenteOperador=="sqrt"){
                            //if(acumular==0){
                                rai= sqrt(presente);
                                ra=String.valueOf(rai);
                                mostrar.setText(acumular+Integer.parseInt(ra)+"");
                            //    presenteOperador="";
                           // }//else{
                               // mostrar.setText((int) (acumular*Math.sqrt(presente)));
                              //  presenteOperador="";
                            //}
                        }
                       if(presenteOperador=="x"){

                       }

                        acumular = acumular+Integer.parseInt(mostrar.getText().toString());
                        operador=false;
                        controlar=false;
                    }
                }else{
                    mostrar.setText("");
                    Toast.makeText(getApplicationContext(),"Ingresar el segundo dato",Toast.LENGTH_LONG).show();
                    operador=true;
                    controlar=true;
                }


                break;
            case R.id.btnraiz:
                if(!operador){
                    acumular = Integer.parseInt(mostrar.getText().toString());
                    mostrar.setText("");
                    controlar=true;
                    operador=true;
                    presenteOperador="sqrt";
                }
                break;
            case R.id.btnx:
                acumular = Integer.parseInt(mostrar.getText().toString());

                    int inverso=0,cifra=0;
                    while(acumular > 0){
                        cifra = acumular%10;
                        inverso = inverso * 10 + cifra;
                        acumular/=10;
                    }
                    mostrar.setText(inverso+"");

                break;
            case R.id.btnnada:
                acumular=0;
                mostrar.setText("");
                operador=false;
                controlar=false;
                break;

        }
    }
}
