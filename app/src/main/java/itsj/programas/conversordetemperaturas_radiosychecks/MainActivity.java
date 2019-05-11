package itsj.programas.conversordetemperaturas_radiosychecks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

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

        radioF=findViewById(R.id.radio_f);

        radioK=findViewById(R.id.radio_k);

        radioR=findViewById(R.id.radio_r);

        checkC=findViewById(R.id.check_c);

        checkF=findViewById(R.id.check_f);

        checkK=findViewById(R.id.check_k);

        checkR=findViewById(R.id.check_r);

        cajaC.setEnabled(false);
        cajaF.setEnabled(false);
        cajaK.setEnabled(false);
        cajaR.setEnabled(false);



    }
}
