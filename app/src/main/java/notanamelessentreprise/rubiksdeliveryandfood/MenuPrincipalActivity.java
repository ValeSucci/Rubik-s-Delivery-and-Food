package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Context context;

    private LinearLayout lyvMenu;
    private LinearLayout lyvContactenos;
    private LinearLayout lyvCalculadora;
    private LinearLayout lyvVideos;
    private LinearLayout lyvPerfil;
    private ImageView imgMenu;
    private ImageView imgContactenos;
    private ImageView imgCalculadora;
    private ImageView imgVideos;
    private ImageView imgPerfil;

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        context = this;

        lyvMenu = (LinearLayout) findViewById(R.id.lyvMenu);
        lyvContactenos = (LinearLayout) findViewById(R.id.lyvContactenos);
        lyvCalculadora = (LinearLayout) findViewById(R.id.lyvCalculadora);
        lyvVideos = (LinearLayout) findViewById(R.id.lyvVideos);
        lyvPerfil = (LinearLayout) findViewById(R.id.lyvPerfil);
        imgMenu = (ImageView) findViewById(R.id.imgMenu);
        imgContactenos = (ImageView) findViewById(R.id.imgContactenos);
        imgCalculadora = (ImageView) findViewById(R.id.imgCalculadora);
        imgVideos = (ImageView) findViewById(R.id.imgVideos);
        imgPerfil = (ImageView) findViewById(R.id.imgPerfil);

        //Imagenes con Picasso: URL y PlaceHolder para espera de descarga

        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btnmenu_zpsurqwg1vf.png").placeholder(R.drawable.rubik2).into(imgMenu);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btncontact_zpsjdeyfx7x.png").placeholder(R.drawable.rubik2).into(imgContactenos);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btncalculadora_zpsvri3rnor.png").placeholder(R.drawable.rubik2).into(imgCalculadora);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btnvideos_zpsaagvtdcc.png").placeholder(R.drawable.rubik2).into(imgVideos);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btnperfil_zps1ly0aevv.png").placeholder(R.drawable.rubik2).into(imgPerfil);



        lyvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuActivity.class);
                startActivity(intent);
            }
        });

        lyvContactenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ContactenosActivity.class);
                startActivity(intent);
            }
        });

        lyvCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CalculadoraActivity.class);
                startActivity(intent);
            }
        });

        lyvVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoActivity.class);
                startActivity(intent);
            }

        });

        lyvPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(MainActivity.getConCuenta()) {
            menu.add(Menu.NONE, opcion1, Menu.NONE, "Perfil");
        }
            menu.add(Menu.NONE, opcion2, Menu.NONE, "Informacion de la app");
        if(MainActivity.getConCuenta()) {
            menu.add(Menu.NONE, opcion3, Menu.NONE, "Historial");
        } else {
             menu.add(Menu.NONE, opcion4, Menu.NONE, "Log In");
        }
        if(MainActivity.getConCuenta()) {
             menu.add(Menu.NONE, opcion5, Menu.NONE, "Cerrar Sesion");
        }

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
              case opcion5:
               AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                        MenuPrincipalActivity.this);

                Dialogo.setTitle("Atención!");
                Dialogo.setMessage("¿Seguro que desea cerrar sesión?");

                Dialogo.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //cambiar los datos de MisPreferencias como pa q se borre

                                MainActivity.setConCuenta(false);
                                //Abrimos el archivo de preferencias
                                SharedPreferences prefs =
                                        getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);

                                //Editamos los campos existentes y en este caso borramos la cuenta existente
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("usuario", "");
                                editor.putString("password", "");
                                //Concretamos la edicion
                                editor.commit(); //pa guardar


                                Intent intent = new Intent(context, MainActivity.class);
                                finish();
                                startActivity(intent);
                            }
                        });
                Dialogo.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Ten mas cuidado con lo que presionas", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                Dialogo.show();

                break;
            case opcion4:
                Intent intent = new Intent(context, LoginActivity.class);
                intent.putExtra("datos_de_cliente", new String[]{"","","","","","",""});
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

}
