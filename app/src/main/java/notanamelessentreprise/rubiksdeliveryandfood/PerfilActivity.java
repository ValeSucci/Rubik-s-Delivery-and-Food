package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {
    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

  //  private SQLiteDatabase db;
    //private BaseDeDatos baseDeDatos;
    //private static final int VERSION = 1;
    Context context;

    private TextView lblNombreUser;
    private TextView lblCorreoUser;
    private TextView lblNitUser;
    private TextView lblTelefonoUser;
    private TextView lblDomicilio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

//        baseDeDatos = new BaseDeDatos(context,VERSION);

        context = this;

        lblNombreUser = (TextView) findViewById(R.id.lblNomUser);
        lblCorreoUser = (TextView) findViewById(R.id.lblCorreoUser);
        lblTelefonoUser = (TextView) findViewById(R.id.lblTelUser);
        lblNitUser = (TextView) findViewById(R.id.lblNITUser);
        lblDomicilio = (TextView) findViewById(R.id.lblDirUser);

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        String usuario_almacenado = prefs.getString("usuario","");
        String password_almacenado = prefs.getString("password","");
        String nombre_almacenado = prefs.getString("nombre","");
        String email_almacenado = prefs.getString("email","");
        String telefono_almacenado = prefs.getString("telefono","");
        String domicilio_almacenado = prefs.getString("domicilio","");

        if(usuario_almacenado.compareTo("")!=0 && password_almacenado.compareTo("")!=0) {
            lblNombreUser.setText(nombre_almacenado);
            lblCorreoUser.setText(email_almacenado);
            lblTelefonoUser.setText(telefono_almacenado);
            lblNitUser.setText(usuario_almacenado);
            lblDomicilio.setText(domicilio_almacenado);
        }



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
