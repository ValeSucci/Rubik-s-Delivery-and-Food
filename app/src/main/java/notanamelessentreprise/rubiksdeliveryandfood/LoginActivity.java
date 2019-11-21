package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtUsuario;
    private EditText txtPassword;
    private TextView lblregis;

    private SQLiteDatabase db;
    private BaseDeDatos baseDeDatos;
    private static final int VERSION = 1;

    String usuario_registrado;
    String password_registrado;

    private Context context;
    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    //private boolean usuarioRegistrado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;

        baseDeDatos = new BaseDeDatos(context, VERSION);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        lblregis = (TextView) findViewById(R.id.lblregis);


        lblregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RegistroActivity.class);
                startActivity(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String campo_usuario = txtUsuario.getText().toString();
                String campo_password = txtPassword.getText().toString();

                MainActivity.setConCuenta(true);
                //TODO desde db.

                db = baseDeDatos.getReadableDatabase();

                Cursor usuarioExistente = db.rawQuery("SELECT contrasenia FROM usuarios WHERE usuario ='" +
                        campo_usuario + "'", null);

                Cursor usuarioExistenteNombre = db.rawQuery("SELECT nombre FROM usuarios WHERE usuario ='" +
                        campo_usuario + "'", null);

                Cursor usuarioExistenteEmail = db.rawQuery("SELECT email FROM usuarios WHERE usuario ='" +
                        campo_usuario + "'", null);

                Cursor usuarioExistenteTelefono = db.rawQuery("SELECT celulartelefono FROM usuarios WHERE usuario ='" +
                        campo_usuario + "'", null);


                Cursor usuarioExistenteDomicilio = db.rawQuery("SELECT domicilio FROM usuarios WHERE usuario ='" +
                        campo_usuario + "'", null);

                if (usuarioExistente.moveToFirst()) {
                    if (usuarioExistente.getString(0).equals(campo_password)) {
                        Toast.makeText(context, "User: " + campo_usuario + ", password: " + campo_password, Toast.LENGTH_SHORT).show();
                        usuarioExistente.close();


                        SharedPreferences prefs =
                                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("usuario", campo_usuario);
                        editor.putString("password", campo_password);
                        if (usuarioExistenteNombre.moveToFirst()) {
                            editor.putString("nombre", usuarioExistenteNombre.getString(0));
                        }
                        if (usuarioExistenteEmail.moveToFirst()) {
                            editor.putString("email", usuarioExistenteEmail.getString(0));
                        }
                        if (usuarioExistenteTelefono.moveToFirst()) {
                            editor.putString("telefono", usuarioExistenteTelefono.getString(0));
                        }
                        if (usuarioExistenteDomicilio.moveToFirst()) {
                            editor.putString("domicilio", usuarioExistenteDomicilio.getString(0));
                        }


                        editor.commit();


                        Intent intent = new Intent(context, MenuPrincipalActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(context, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    //de nuevo
// comentario inutil

}

