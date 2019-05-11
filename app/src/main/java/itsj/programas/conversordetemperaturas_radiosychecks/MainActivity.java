package itsj.programas.conversordetemperaturas_radiosychecks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener, View.OnClickListener {

    EditText cajaEntrada, cajaC, cajaF, cajaK, cajaR;
    RadioButton radioC, radioF, radioK, radioR;
    CheckBox checkC, checkF, checkK, checkR;
    DecimalFormat redondear =new DecimalFormat("###,###,##0.####");
    String respaldo="";
    double tempEntrada, tempSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaEntrada=findViewById(R.id.caja_entrada);

        cajaC=findViewById(R.id.caja_c);
        cajaF=findViewById(R.id.caja_f);
        cajaK=findViewById(R.id.caja_k);
        cajaR=findViewById(R.id.caja_r);

        radioC=findViewById(R.id.radio_c);
        radioC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                habilitarCheckBoxes(false, true, true, true);
            }
        });

        radioF=findViewById(R.id.radio_f);
        radioF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                habilitarCheckBoxes(true, false, true, true);
            }
        });

        radioK=findViewById(R.id.radio_k);
        radioK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                habilitarCheckBoxes(true, true, false, true);
            }
        });

        radioR=findViewById(R.id.radio_r);
        radioR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                habilitarCheckBoxes(true, true, true, false);
            }
        });

        checkC=findViewById(R.id.check_c);
        checkC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkC.isChecked())
                    cajaC.setText("");
                convertir();
            }
        });

        checkF=findViewById(R.id.check_f);
        checkF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkF.isChecked())
                    cajaF.setText("");
                convertir();
            }
        });

        checkK=findViewById(R.id.check_k);
        checkK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkK.isChecked())
                    cajaK.setText("");
                convertir();
            }
        });

        checkR=findViewById(R.id.check_r);
        checkR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkR.isChecked())
                    cajaR.setText("");
                convertir();
            }
        });

        cajaC.setEnabled(false);
        cajaF.setEnabled(false);
        cajaK.setEnabled(false);
        cajaR.setEnabled(false);



    }

    public void convertir(){
        limpiarCajas();
        if(cajaEntrada.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Ingrese un valor para convertir.", Toast.LENGTH_SHORT).show();
            limpiarCheckBoxes();
        }
        else if(radioC.isChecked() || radioF.isChecked() || radioK.isChecked() || radioR.isChecked()){
            if(radioC.isChecked()) {
                if(checkF.isChecked())
                    cajaF.setText(redondear.format((tempEntrada*1.8)+32)+"");
                if(checkK.isChecked())
                    cajaK.setText(redondear.format(tempEntrada+273.15)+"");
                if(checkR.isChecked())
                    cajaR.setText(redondear.format((tempEntrada*1.8)+491.67)+"");
            }
            else if(radioF.isChecked()){
                if(checkC.isChecked())
                    cajaC.setText(redondear.format((tempEntrada-32)/1.8)+"");
                if(checkK.isChecked())
                    cajaK.setText(redondear.format((tempEntrada+459.67)/1.8)+"");
                if(checkR.isChecked())
                    cajaR.setText(redondear.format(tempEntrada+459.67)+"");
            }
            else if(radioK.isChecked()){
                if(checkC.isChecked())
                    cajaC.setText(redondear.format(tempEntrada-273.15)+"");
                if(checkF.isChecked())
                    cajaF.setText(redondear.format(((tempEntrada-273.15)*1.8)+32)+"");
                if(checkR.isChecked())
                    cajaR.setText(redondear.format(tempEntrada*1.8)+"");
            }
            else if(radioR.isChecked()){
                if(checkC.isChecked())
                    cajaC.setText(redondear.format((tempEntrada-491.67)/1.8)+"");
                if(checkF.isChecked())
                    cajaF.setText(redondear.format(tempEntrada-459.67)+"");
                if(checkK.isChecked())
                    cajaK.setText(redondear.format(tempEntrada/1.8)+"");
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Seleccione la unidad de medida de la temperatura a convertir.", Toast.LENGTH_LONG).show();
            limpiarCheckBoxes();
        }
    }

    public void habilitarCheckBoxes(boolean c, boolean f, boolean k, boolean r){
        limpiarCajas();
        limpiarCheckBoxes();

        checkC.setEnabled(c);
        cajaC.setEnabled(c);

        checkF.setEnabled(f);
        cajaF.setEnabled(f);

        checkK.setEnabled(k);
        cajaK.setEnabled(k);

        checkR.setEnabled(r);
        cajaR.setEnabled(r);
    }

    public void limpiarCajas(){
        cajaC.setText("");
        cajaF.setText("");
        cajaK.setText("");
        cajaR.setText("");
    }

    public void limpiarCheckBoxes(){
        checkC.setChecked(false);
        checkF.setChecked(false);
        checkK.setChecked(false);
        checkR.setChecked(false);
    }

    @Override
    public void onClick(View v) {}

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
}
