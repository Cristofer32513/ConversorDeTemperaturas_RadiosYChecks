package itsj.programas.conversordetemperaturas_radiosychecks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
