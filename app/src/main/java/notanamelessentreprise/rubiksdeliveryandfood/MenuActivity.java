package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

//import static notanamelessentreprise.rubiksdeliveryandfood.R.id.sliderLayout;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout lyhHamburguesa;
    private LinearLayout lyhPizza;
    private LinearLayout lyhHotDog;
    private LinearLayout lyhPollo;
    private LinearLayout lyhExtras;
    private ImageView imgHamburguesa;
    private ImageView imgPizza;
    private ImageView imgHotDog;
    private ImageView imgPollo;
    private ImageView imgExtras;
    private Toolbar tlbVerOrden;
    private TextView lblPrecioTotal;


    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    //ViewPager viewPager;
    private Context context;
    private SliderLayout SliderLayout;

    public static double precio = 0.00;
    public static double precioTotalTotal = 0.00;

    public static double getPrecio() {
        return precio;
    }

    public static void setPrecio(double precioN){
        precio = precioN;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;

        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);
        lyhHamburguesa = (LinearLayout) findViewById(R.id.lyhHamburguesa);
        lyhPizza = (LinearLayout) findViewById(R.id.lyhPizza);
        lyhHotDog = (LinearLayout) findViewById(R.id.lyhHotDog);
        lyhPollo = (LinearLayout) findViewById(R.id.lyhPollo);
        lyhExtras = (LinearLayout) findViewById(R.id.lyhExtras);
        imgHamburguesa = (ImageView) findViewById(R.id.imgHamburguesa);
        imgPizza = (ImageView) findViewById(R.id.imgPizza);
        imgHotDog = (ImageView) findViewById(R.id.imgHotDog);
        imgPollo = (ImageView) findViewById(R.id.imgPollo);
        imgExtras = (ImageView) findViewById(R.id.imgExtras);
        tlbVerOrden = (Toolbar) findViewById(R.id.tlbVerOrden);
        lblPrecioTotal = (TextView) findViewById(R.id.lblPrecioTotal);

        //Slide con daimajia
        TextSliderView textSliderView = new TextSliderView(this);
        textSliderView
                .description("Hamburguesas")
                .image(R.drawable.armaloham);
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {
                Toast.makeText(context, "Con la más deliciosa carne y calidad.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ArmaloHamburguesaActivity.class);
                startActivity(intent);
            }
        });
        sliderShow.addSlider(textSliderView);


        //Slide con daimajia 2
        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView2
                .description("Pizza")
                .image(R.drawable.armalopizza);
        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {
                Toast.makeText(context, "De sabor incomparable.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ArmaloPizzaActivity.class);
                startActivity(intent);
            }
        });
        sliderShow.addSlider(textSliderView2);

        //Slide con daimajia 3
        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView3
                .description("Hot Dog")
                .image(R.drawable.armalohotdog);
        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {
                Toast.makeText(context, "Como tu quieras, desde el pan hasta la salsa.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ArmaloHotDogActivity.class);
                startActivity(intent);
            }
        });
        sliderShow.addSlider(textSliderView3);

        //imagenes de cada division de alimentos
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnham_zpss2i2xyad.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgHamburguesa);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnpizza_zpsshpdbgwm.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgPizza);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnhotdog_zpsk1mbupua.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgHotDog);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnpollo_zpskviqlidb.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgPollo);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnextras_zpseca2wzwu.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgExtras);



        lyhHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MenuHamburguesaActivity.class);
                startActivity(intent);
            }
        });

        lyhPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuPizzaActivity.class);
                startActivity(intent);
            }
        });

        lyhHotDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuHotDogActivity.class);
                startActivity(intent);
            }
        });

        lyhPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuPolloActivity.class);
                startActivity(intent);
            }
        });

        lyhExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuExtrasActivity.class);
                startActivity(intent);
            }
        });

        tlbVerOrden.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                Intent intent = new Intent(context, VerOrdenActivity.class);
                startActivity(intent);
           }
        });

        lblPrecioTotal.setText(Double.toString(precio) + "0");

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
        //
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();break;
            case opcion5:
                AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                        MenuActivity.this);

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
