package com.brayadiaz.geometria;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton rCuadrado, rTriangulo, rCirculo, rCubo;
    private RadioGroup rGroup;
    private EditText eLadoCua, eRadio, eLadoTri1, eLadoTri2, eLadoTri3, eLadoCub;
    private Button bCalcular;
    private TextView tInfo;
    private float area, perimetro, a, b, c , vol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rCuadrado = (RadioButton) findViewById(R.id.cuadrado);
        rTriangulo = (RadioButton) findViewById(R.id.triangulo);
        rCirculo = (RadioButton) findViewById(R.id.circulo);
        rCubo = (RadioButton) findViewById(R.id.cubo);

        eLadoCua = (EditText) findViewById(R.id.cLado);
        eRadio = (EditText) findViewById(R.id.cRadio);
        eLadoTri1 = (EditText) findViewById(R.id.cLadoA);
        eLadoTri2 = (EditText) findViewById(R.id.cLadoB);
        eLadoTri3 = (EditText) findViewById(R.id.cLadoC);
        eLadoCub = (EditText) findViewById(R.id.cLadoCu);

        rGroup = (RadioGroup) findViewById(R.id.GroupRadio);
        bCalcular = (Button) findViewById(R.id.boton);
        tInfo = (TextView) findViewById(R.id.info) ;

        eLadoCua.setEnabled(true);
        eRadio.setEnabled(false);
        eLadoTri1.setEnabled(false);
        eLadoTri2.setEnabled(false);
        eLadoTri3.setEnabled(false);
        eLadoCub.setEnabled(false);

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.cuadrado:
                        eLadoCua.setEnabled(true);
                        eRadio.setEnabled(false);
                        eLadoTri1.setEnabled(false);
                        eLadoTri2.setEnabled(false);
                        eLadoTri3.setEnabled(false);
                        eLadoCub.setEnabled(false);
                        break;
                    case R.id.triangulo:
                        eLadoCua.setEnabled(false);
                        eRadio.setEnabled(false);
                        eLadoTri1.setEnabled(true);
                        eLadoTri2.setEnabled(true);
                        eLadoTri3.setEnabled(true);
                        eLadoCub.setEnabled(false);
                        break;
                    case R.id.circulo:
                        eLadoCua.setEnabled(false);
                        eRadio.setEnabled(true);
                        eLadoTri1.setEnabled(false);
                        eLadoTri2.setEnabled(false);
                        eLadoTri3.setEnabled(false);
                        eLadoCub.setEnabled(false);
                        break;
                    case R.id.cubo:
                        eLadoCua.setEnabled(true);
                        eRadio.setEnabled(false);
                        eLadoTri1.setEnabled(false);
                        eLadoTri2.setEnabled(false);
                        eLadoTri3.setEnabled(false);
                        eLadoCub.setEnabled(true);
                        break;
                }
            }
        });

    }

    public void Calcular(View view) {
        if (rCuadrado.isChecked()) {
            a = Float.parseFloat(eLadoCua.getText().toString());
            area = a * a;
            perimetro = a * 4;
            tInfo.setText("Área = " + String.valueOf(area) + " cm^2 \nPerímetro = " + String.valueOf(perimetro) + " cm");
        } else if (rCirculo.isChecked()) {
            a = Float.parseFloat(eRadio.getText().toString());
            area = (float)Math.PI * a * a;
            perimetro = (float)Math.PI * 2  * a;
            tInfo.setText("Área = " + String.valueOf(area) + " cm^2  \nPerímetro = " + String.valueOf(perimetro) + " cm");
        } else if (rTriangulo.isChecked()) {
            a = Float.parseFloat(eLadoTri1.getText().toString());
            b = Float.parseFloat(eLadoTri2.getText().toString());
            c = Float.parseFloat(eLadoTri3.getText().toString());

            perimetro = a + b + c;
            area = (perimetro /2) * ((perimetro / 2) - a) * ((perimetro / 2) - b) * ((perimetro / 2) - c);
            area = (float)Math.sqrt((double) area);
            tInfo.setText("Área = " + String.valueOf(area) + " cm^2  \nPerímetro = " + String.valueOf(perimetro) + " cm");
        } else if (rCubo.isChecked()) {
            a = Float.parseFloat(eLadoCub.getText().toString());
            area =  6 * a * a;
            perimetro = 24  * a;
            vol = a * a * a;
            tInfo.setText("Área = " + String.valueOf(area) + " cm^2  \nPerímetro = " +
                    String.valueOf(perimetro) + " cm\nVolumen: " + String.valueOf(vol) + " cm^3 ");
        }


    }
}