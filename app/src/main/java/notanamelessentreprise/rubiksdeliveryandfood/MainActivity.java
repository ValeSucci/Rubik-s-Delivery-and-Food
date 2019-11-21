package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ImageView imgLogo;
    private Button btnSignIn;
    private CustomGifView gifview;

    public static boolean conCuenta = false;

    public static boolean getConCuenta() {
        return conCuenta;
    }

    public static void setConCuenta(boolean nuevoConCuenta) {
        conCuenta = nuevoConCuenta;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        MainActivity.setConCuenta(false);

        //si existe una cuenta guardada no entra a la pantalla del logo, directo al menu
        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        String usuario_almacenado = prefs.getString("usuario","");
        String password_almacenado = prefs.getString("password","");

        if(usuario_almacenado.compareTo("")!=0 && password_almacenado.compareTo("")!=0)
        {
            Intent a=new Intent(getApplicationContext(),MenuPrincipalActivity.class);
            MainActivity.setConCuenta(true);
            finish();
            startActivity(a);
        }

        imgLogo=(ImageView) findViewById(R.id.imgLogo);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        gifview = (CustomGifView)findViewById(R.id.gifview);


        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuPrincipalActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });

        gifview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
