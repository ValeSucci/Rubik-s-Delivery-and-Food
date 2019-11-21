package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
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

public class ArmaloHamburguesaActivity extends AppCompatActivity {

    //H

    private ImageView imgPanSuperior;
    private ImageView imgCarneDeRes;
    private ImageView imgCarneDePollo;
    private ImageView imgCarneVegetariana;
    private ImageView imgQueso;
    private ImageView imgVegetales;
    private ImageView imgAdherezos;
    private ImageView imgOtrasCarnes;
    private ImageView imgHuevo;
    private ImageView imgPanInferior;
    private ImageView imgIngredienteElegido;

    private double precio = 0.00;
    private TextView lblPrecio;
    private BaseDeDatos baseDeDatos;
    private SQLiteDatabase db;
    public static final int VERSION = 1;

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
        setContentView(R.layout.activity_armalo_hamburguesa);

        imgPanSuperior = (ImageView) findViewById(R.id.imgPanSuperior);
        imgCarneDeRes = (ImageView) findViewById(R.id.imgCarneRes);
        imgCarneDePollo = (ImageView) findViewById(R.id.imgCarnePollo);
        imgCarneVegetariana = (ImageView) findViewById(R.id.imgCarneVegetariana);
        imgQueso = (ImageView) findViewById(R.id.imgQueso);
        imgVegetales = (ImageView) findViewById(R.id.imgVegetales);
        imgAdherezos = (ImageView) findViewById(R.id.imgAdherezo);
        imgOtrasCarnes = (ImageView) findViewById(R.id.imgOtrasCarnes);
        imgHuevo = (ImageView) findViewById(R.id.imgHuevo);
        imgPanInferior = (ImageView) findViewById(R.id.imgPanInferior);
        lblPrecio = (TextView) findViewById(R.id.lblPrecio);

        btnfCarrito = (FloatingActionButton) findViewById(R.id.btnfCarrito);

        baseDeDatos = new BaseDeDatos(context, VERSION);

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


        imgPanSuperior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                ingredientes = getResources().getStringArray(R.array.array_tipos_de_pan);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {
                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        int imagen = R.drawable.pan_tradicional_superior;
                                Log.e("Item seleccionado", contenido);

                        db = baseDeDatos.getReadableDatabase();

                       /* Cursor ingredienteExistentePrecio = db.rawQuery("SELECT precio FROM ingredientes WHERE nombre ='" +
                               contenido+ "'", null);

                        Cursor ingredienteExistenteImagen = db.rawQuery("SELECT imagen FROM ingredientes WHERE nombre ='" +
                                contenido+ "'", null);

                       if(ingredienteExistentePrecio.moveToFirst()) {
                           precio += Double.parseDouble(ingredienteExistentePrecio.getString(0));
                      }
                        if(ingredienteExistenteImagen.moveToFirst()) {
                            imagen = ingredienteExistenteImagen.getInt(0);
                            Log.i("imagen", ""+imagen+"");
                        }*/

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);
                        //guardar contenido como si fuera el nombre de la imagen

                        switch (contenido) {
                            case "Tradicional":
                                imagen = R.drawable.pan_tradicional_superior;
                                precio += 0.5;
                                break;
                            case "Sin Semillas":
                                imagen = R.drawable.pan_sinsemilla_superior;
                                precio += 1;
                                break;
                            case "Croissant":
                                imagen = R.drawable.pan_croissant_superior;
                                precio += 1;
                                break;
                            case "Integral":
                                imagen = R.drawable.pan_integral_superior;
                                precio += 1;
                                break;
                            case "Tostadas":
                                imagen = R.drawable.pan_tostadas_superior;
                                precio += 1;
                                break;
                            case "Marraqueta":
                                imagen = R.drawable.pan_marraqueta_superior;
                                precio += 0.5;
                                break;
                        }
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add("Pan "+contenido);
                    }
                });

            }
        });

        imgCarneDeRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tamanios_de_carne_de_res);
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

                        int imagen = R.drawable.btnhamres;
                        switch (contenido) {
                            case "8 oz":
                                imagen = R.drawable.carne_res;
                                precio += 10;
                                break;
                            case "10 oz":
                                imagen = R.drawable.carne_res;
                                precio += 15;
                                break;
                            case "12 oz":
                                imagen = R.drawable.carne_res;
                                precio += 20;
                                break;
                            case "15 oz":
                                imagen = R.drawable.carne_res;
                                precio += 25;
                                break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add("Carne de res de "+contenido);
                    }
                });

            }
        });

        imgQueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_quesos);
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
                            case "Criollo":
                                imagen = R.drawable.queso_criollo;
                                precio += 3;
                                break;
                            case "Americano Tradicional":
                                imagen = R.drawable.queso_americano;
                                precio += 4;
                                break;
                            case "Mozarella":
                                imagen = R.drawable.queso_mozzarella;
                                precio += 4;
                                break;
                            case "Cheddar":
                                imagen = R.drawable.queso_cheddar;
                                precio += 5;
                                break;
                            case "Gouda":
                                imagen = R.drawable.queso_gouda;
                                precio += 6;
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

        imgCarneDePollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tamanios_de_carne_de_pollo);
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

                        int imagen = R.drawable.btnhampollo;
                        switch (contenido) {
                            case "8 oz":
                                imagen = R.drawable.carne_pollo;
                                precio += 10;
                                break;
                            case "10 oz":
                                imagen = R.drawable.carne_pollo;
                                precio += 15;
                                break;
                            case "12 oz":
                                imagen = R.drawable.carne_pollo;
                                precio += 20;
                                break;
                            case "15 oz":
                                imagen = R.drawable.carne_pollo;
                                precio += 25;
                                break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add("Carne de pollo de "+contenido);
                    }
                });

            }
        });

        imgCarneVegetariana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tamanios_de_carne_vegetariana);
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

                        int imagen = R.drawable.btnhamveg;
                        switch (contenido) {
                            case "8 oz":
                                imagen = R.drawable.carne_vegetariana;
                                precio += 12;
                                break;
                            case "10 oz":
                                imagen = R.drawable.carne_vegetariana;
                                precio += 18;
                                break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add("Carne vegetariana de "+contenido);
                    }
                });

            }
        });

        imgVegetales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_vegetales);
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

                        int imagen = R.drawable.btnverduras;
                        switch (contenido) {
                            case "Tomate":
                                imagen = R.drawable.verduras_tomate;
                                precio += 1;
                                break;
                            case "Lechuga":
                                imagen = R.drawable.verduras_lechuga;
                                precio += 1;
                                break;
                            case "Cebolla":
                                imagen = R.drawable.verduras_cebolla;
                                precio += 1;
                                break;
                            case "Pepinillos":
                                imagen = R.drawable.verduras_pepinillos;
                                precio += 1;
                                break;
                            case "Rabanos":
                                imagen = R.drawable.verduras_rabanos;
                                precio += 1;
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

        imgAdherezos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_adherezos);
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

                        int imagen = R.drawable.btnadherezos;
                        switch (contenido) {
                            case "Mayonesa":
                                imagen = R.drawable.adherezos_mayonesa;
                                precio += 0.5;
                                break;
                            case "Ketchup":
                                imagen = R.drawable.adherezos_ketchup;
                                precio += 0.5;
                                break;
                            case "Mostaza":
                                imagen = R.drawable.adherezos_mostaza;
                                precio += 0.5;
                                break;
                            case "Salsa golf":
                                imagen = R.drawable.adherezos_golf;
                                precio += 1;
                                break;
                            case "Barbacoa":
                                imagen = R.drawable.adherezos_barbacoa;
                                precio += 3;
                                break;
                            case "Miel y mostaza":
                                imagen = R.drawable.adherezos_mielymostaza;
                                precio += 3;
                                break;
                            case "Hot mustard":
                                imagen = R.drawable.adherezos_hotmustard;
                                precio += 3;
                                break;
                            case "Salsa picante":
                                imagen = R.drawable.adherezos_salsapicante;
                                precio += 3;
                                break;
                            case "Llajua tradicional":
                                imagen = R.drawable.adherezos_llajua;
                                precio += 1;
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

        imgHuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_huevos);
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

                        int imagen = R.drawable.huevo_frito;
                        switch (contenido) {
                            case "Frito":
                                imagen = R.drawable.huevo_frito;
                                precio += 2;
                                break;
                            case "Revuelto":
                                imagen = R.drawable.huevo_revuelto;
                                precio += 2;
                                break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add("Huevo "+contenido);
                    }
                });

            }
        });

        imgOtrasCarnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes = getResources().getStringArray(R.array.array_tipos_de_otras_carnes);
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
                            case "Tocino":
                                imagen = R.drawable.otrascarnes_tocino;
                                precio += 4;
                                break;
                            case "Jamon":
                                imagen = R.drawable.otrascarnes_jamon;
                                precio += 3;
                                break;
                            case "Salami":
                                imagen = R.drawable.otrascarnes_salami;
                                precio += 6;
                                break;
                            case "Pepperoni":
                                imagen = R.drawable.otrascarnes_pepperoni;
                                precio += 5;
                                break;
                            case "Salchicha":
                                imagen = R.drawable.otrascarnes_salchichas;
                                precio += 4;
                                break;
                            case "Chorizo":
                                imagen = R.drawable.otrascarnes_chorizo;
                                precio += 6;
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

        imgPanInferior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ingredientes = getResources().getStringArray(R.array.array_tipos_de_pan);
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
                        //guardar contenido como si fuera el nombre de la imagen
                        int imagen = R.drawable.pan_tradicional_inferior;
                        switch (contenido) {
                            case "Tradicional":
                                imagen = R.drawable.pan_tradicional_inferior;
                                precio += 0.5;
                                break;
                            case "Sin Semillas":
                                imagen = R.drawable.pan_sinsemilla_inferior;
                                precio += 1;
                                break;
                            case "Croissant":
                                imagen = R.drawable.pan_croissant_inferior;
                                precio += 1;
                                break;
                            case "Integral":
                                imagen = R.drawable.pan_integral_inferior;
                                precio += 1;
                                break;
                            case "Tostadas":
                                imagen = R.drawable.pan_tostadas_inferior;
                                precio += 1;
                                break;
                            case "Marraqueta":
                                imagen = R.drawable.pan_marraqueta_inferior;
                                precio += 0.5;
                                break;
                        }
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);
                        lblPrecio.setText("Bs. " + Double.toString(precio) + "0");
                        datosDePedido.add("Pan "+contenido);
                    }
                });

            }
        });

        btnfCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuActivity.class);
                //datosDePedido.add(0, Double.toString(precio));
                //intent.putExtra("datos_de_pedido", datosDePedido);
                double precioTotal = MenuActivity.getPrecio()+precio;
                MenuActivity.setPrecio(precioTotal);
                startActivity(intent);
            }

        });
    }
}
