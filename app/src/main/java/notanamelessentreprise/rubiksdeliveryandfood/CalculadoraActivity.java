package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    private EditText txtMontoPagarBs;
    private EditText txtNumPersonas;
    private RadioButton btnr5;
    private RadioButton btnr10;
    private RadioButton btnr15;
    private RadioButton btnr20;
    private RadioButton btnr25;
    private RadioButton btnr30;
    private Button btnCalcular;
    private Button btnReset;
    private TextView lblTotalPropinaBs;
    private TextView lblTotalBs;
    private TextView lblAporteIndividualBs;

    private RadioGroup groupRad;

    private Context context;

    private double montoAPagar = 0;
    private int numeroDePersonas = 0;
    private double propina = 0;
    private double montoTotal = 0;
    private double montoIndividual = 0;
    private double totalPropina = 0;

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context=this;

        txtMontoPagarBs=(EditText)findViewById(R.id.txtMontoPagarBs);
        txtNumPersonas=(EditText)findViewById(R.id.txtNumPersonas);
        btnr5=(RadioButton)findViewById(R.id.btnr5);
        btnr10=(RadioButton)findViewById(R.id.btnr10);
        btnr15=(RadioButton)findViewById(R.id.btnr15);
        btnr20=(RadioButton)findViewById(R.id.btnr20);
        btnr25=(RadioButton)findViewById(R.id.btnr25);
        btnr30=(RadioButton)findViewById(R.id.btnr30);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        btnReset=(Button)findViewById(R.id.btnReset);
        lblTotalPropinaBs=(TextView)findViewById(R.id.lblTotalPropinaBs);
        lblTotalBs=(TextView)findViewById(R.id.lblTotalBs);
        lblAporteIndividualBs=(TextView)findViewById(R.id.lblAporteIndividualBs);

        groupRad=(RadioGroup)findViewById(R.id.groupRad);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (txtMontoPagarBs.getText().toString().compareTo("") != 0 &&txtNumPersonas.getText().toString().compareTo("") !=0 &&
                        txtNumPersonas.getText().toString().compareTo("0")!=0) {
                    montoAPagar = Double.parseDouble(txtMontoPagarBs.getText().toString());
                    numeroDePersonas = Integer.parseInt(txtNumPersonas.getText().toString());

                    montoTotal = montoAPagar * propina + montoAPagar;
                    montoIndividual = montoTotal / numeroDePersonas;
                    totalPropina = montoAPagar * propina;

                    lblTotalBs.setText("Bs. " + montoTotal);
                    lblTotalPropinaBs.setText("Bs. " + totalPropina);
                    lblAporteIndividualBs.setText("Bs. " + montoIndividual);
                }else{
                    Toast.makeText(context,"Complete todos los campos",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                montoAPagar=0;
                numeroDePersonas=0;
                propina=0;
                montoTotal=0;
                montoIndividual=0;
                totalPropina=0;
                lblTotalBs.setText("Bs. " + montoTotal);
                lblTotalPropinaBs.setText("Bs. " + totalPropina );
                lblAporteIndividualBs.setText("Bs. " + montoIndividual);
                txtNumPersonas.setText("");
                txtMontoPagarBs.setText("");
                groupRad.clearCheck();
            }
        });

       // numeroDePersonas = Integer.valueOf(txtNumPersonas.getText().toString())

        btnr5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            propina=0.05;
            }
        });

        btnr10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                propina=0.1;
            }
        });

        btnr15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                propina=0.15;
            }
        });
        btnr20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                propina=0.2;
            }
        });
        btnr25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                propina=0.25;
            }
        });

        btnr30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                propina=0.3;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (MainActivity.getConCuenta()) {
            menu.add(Menu.NONE, opcion1, Menu.NONE, "Perfil")
                    .setIcon(android.R.drawable.ic_menu_add);
            menu.add(Menu.NONE, opcion2, Menu.NONE, "Historial")
                    .setIcon(android.R.drawable.stat_notify_sdcard_prepare);
        }
        menu.add(Menu.NONE, opcion3, Menu.NONE, "Detalles de la app")
                .setIcon(android.R.drawable.ic_dialog_info);

        if (MainActivity.getConCuenta()) {
            menu.add(Menu.NONE, opcion4, Menu.NONE, "Cerrar Sesión")
                    .setIcon(android.R.drawable.ic_dialog_info);
        } else {
            menu.add(Menu.NONE, opcion5, Menu.NONE, "Login")
                    //cambiar esto creo xD
                    .setIcon(android.R.drawable.ic_dialog_info);
            Intent intent = new Intent(context, LoginActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
