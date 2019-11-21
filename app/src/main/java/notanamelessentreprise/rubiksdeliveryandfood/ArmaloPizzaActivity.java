package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArmaloPizzaActivity extends AppCompatActivity {

    //esperar db
    private ImageView imgToppings;
    private ImageView imgCondimentos;
    private ImageView imgCarnePizza;
    private ImageView imgQuesoPizza;
    private ImageView imgSalsa;
    private ImageView imgIngredienteElegido;

    private double precio = 10.00;
    private TextView lblPrecio;

    ListView lista;
    String[] ingredientes;
    ArrayAdapter<String> adaptador;

    LinearLayout lyVertical;
    LinearLayout lyHorizontalPrincipal;

    Context context = this;

    private FloatingActionButton btnfCarrito;

    //Lista para pasar datos
    ArrayList<String> datosDePedido = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armalo_pizza);

        imgToppings = (ImageView) findViewById(R.id.imgToppings);
        imgCondimentos = (ImageView) findViewById(R.id.imgCondimentos);
        imgCarnePizza = (ImageView) findViewById(R.id.imgCarne);
        imgQuesoPizza = (ImageView) findViewById(R.id.imgQueso);
        imgSalsa = (ImageView) findViewById(R.id.imgSalsa);
        lblPrecio = (TextView) findViewById(R.id.lblPrecio);

        btnfCarrito = (FloatingActionButton) findViewById(R.id.btnfCarrito);

        //son pa aniadir las imagenes a medida q se arma
        lyVertical = (LinearLayout) findViewById(R.id.lyVertical);
        lyHorizontalPrincipal = (LinearLayout) findViewById(R.id.lyHorizontalPrincipal);


        lista = (ListView) findViewById(R.id.lista);

        //pa q no este vacio
        ingredientes = new String[]{""};
        adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
        lista.setAdapter(adaptador);


        final LinearLayout.LayoutParams layoutImagenes = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, 35
        );


        imgToppings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ingredientes = getResources().getStringArray(R.array.array_tipos_de_toppings);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {
                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        //        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);
                        //guardar contenido como si fuera el nombre de la imagen
                        int imagen = R.drawable.btntoppings;
                        switch (contenido) {
                            case "Piña":
                                imagen = R.drawable.toppings_pina;
                                precio += 2;
                                break;
                            case "Cereza Cherry":
                               imagen = R.drawable.toppings_cherry;
                                precio += 3;
                                break;
                            case "Champiñones":
                                imagen = R.drawable.toppings_champinones;
                                precio += 2;
                                break;
                            case "Pimientos":
                                imagen = R.drawable.toppings_pimientos;
                                precio += 2;
                                break;
                            case "Brocoli":
                                imagen = R.drawable.toppings_brocoli;
                                precio += 1;
                                break;
                            case "Tomate":
                                imagen = R.drawable.verduras_tomate;
                                precio += 1;
                                break;
                            case "Aceitunas":
                                imagen = R.drawable.toppings_aceitunas;
                                precio += 1;
                                break;
                        }
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add(contenido);
                    }
                });

            }
        });

        imgCondimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_condimentos);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.condimentos_oregano;
                        switch (contenido) {
                            case "Oregano":
                                imagen = R.drawable.condimentos_oregano;
                                precio += 1;
                                break;
                            case "Locoto en polvo":
                                imagen = R.drawable.condimentos_locotopolvo;
                                precio += 2;
                                break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add(contenido);
                    }
                });

            }
        });

        imgCarnePizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_carnes_pizza);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.btnotrascarnes;
                        switch (contenido) {
                            case "Carne molida":
                                imagen = R.drawable.carne_carnemolida;
                                precio += 10;
                                break;
                            case "Pepperoni":
                                imagen = R.drawable.otrascarnes_pepperoni;
                                precio += 5;
                                break;
                            case "Salchicha":
                                imagen = R.drawable.otrascarnes_salchichas;
                                precio += 5;
                                break;
                            case "Jamon":
                                imagen = R.drawable.otrascarnes_jamon;
                                precio += 6;
                                break;
                            case "Chorizo":
                                imagen = R.drawable.otrascarnes_chorizo;
                                precio += 10;
                                break;
                            case "Salami":
                                imagen = R.drawable.otrascarnes_salami;
                                precio += 15;
                                break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add(contenido);
                    }
                });

            }
        });

        imgQuesoPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_queso_pizza);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.btnquesos;
                        switch (contenido) {
                            case "Mozarella":
                                imagen = R.drawable.queso_mozzarella;
                                precio += 40;
                                break;
                            case "Cheddar":
                                imagen = R.drawable.queso_cheddar;
                                precio += 30;
                                break;
                            case "Gouda":
                                imagen = R.drawable.queso_gouda;
                                precio += 35;
                                break;
                            case "Gruyere":
                                imagen = R.drawable.queso_gruyere;
                                precio += 30;
                                break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add("Queso "+contenido);
                    }
                });

            }
        });

        imgSalsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_salsas);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.btnsalsas;
                        switch (contenido) {
                            case "Tomate Tradicional":
                                imagen = R.drawable.adherezos_ketchup;
                                precio += 5;
                                break;
                            case "Tomate Picante":
                                imagen = R.drawable.adherezos_salsapicante;
                                precio += 6;
                                break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add("Salsa "+contenido);
                    }
                });

            }
        });

        btnfCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuActivity.class);
                double precioTotal = MenuActivity.getPrecio()+precio;
                MenuActivity.setPrecio(precioTotal);
                startActivity(intent);
            }

        });
    }

}
