package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtUsuario;
    private EditText txtCelular;
    private EditText txtDomicilio;
    private EditText txtEmail;
    private EditText txtContrasenia;
    private EditText txtRepContrasenia;
    private EditText txtNombreFactura;
    private EditText txtNIT;
    private Button btnRegistrarse;
    private SQLiteDatabase db;
    public static final int VERSION = 1;
    private BaseDeDatos baseDeDatos;

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    String[] datosDeCliente = new String[8];
    //private SQLiteDatabase db;
 //   public static final int VERSION = 1;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        context = this;

        baseDeDatos = new BaseDeDatos(context,VERSION);
        db = baseDeDatos.getWritableDatabase();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        BaseDeDatos crearBD = new BaseDeDatos(context,VERSION);
  //      SQLiteDatabase db = crearBD.getWritableDatabase();

        txtNombre = (EditText) findViewById(R.id.txtNombreyApellido);
        txtUsuario = (EditText) findViewById(R.id.txtNombreUsuario);
        txtCelular = (EditText) findViewById(R.id.txtCelularTelefono);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        txtRepContrasenia = (EditText) findViewById(R.id.txtRepContrasenia);
        txtDomicilio = (EditText) findViewById(R.id.txtDomicilio);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtNombreFactura = (EditText) findViewById(R.id.txtNomFac);
        txtNIT = (EditText) findViewById(R.id.txtNIT);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                datosDeCliente[0] = txtNombre.getText().toString();
                datosDeCliente[1] = txtUsuario.getText().toString();
                datosDeCliente[2] = txtCelular.getText().toString();
                datosDeCliente[3] = txtDomicilio.getText().toString();
                datosDeCliente[4] = txtEmail.getText().toString();
                datosDeCliente[5] = txtNombreFactura.getText().toString();
                datosDeCliente[7] = txtNIT.getText().toString();

                if(txtContrasenia.getText().toString().compareTo(txtRepContrasenia.getText().toString()) == 0 && datosDeCliente[1].compareTo("") != 0 &&
                        datosDeCliente[0].compareTo("") != 0 && (datosDeCliente[2].length() == 7 || datosDeCliente[2].length() == 8) &&
                        datosDeCliente[4].contains("@") && datosDeCliente[4].contains(".")) {
                    String[] str = {txtNombre.getText().toString(), txtUsuario.getText().toString(), txtContrasenia.getText().toString(), txtDomicilio.getText().toString(),
                            txtEmail.getText().toString(), txtCelular.getText().toString(), txtNombreFactura.getText().toString(), txtNIT.getText().toString()
                    };


                    Usuario usuario = new Usuario(str);
                    baseDeDatos.guardarUsuario(usuario);
                    db.close();

                    Toast.makeText(getApplicationContext(), "Registro Agregado", Toast.LENGTH_SHORT).show();
                    reiniciarActividad();
                } else {
                        Toast.makeText(context, "Debe llenar los campos obligatoios (*) correctamente", Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }

    private void reiniciarActividad() {
        Intent a=new Intent(getApplicationContext(),MainActivity.class);
        finish();
        startActivity(a);
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

}
