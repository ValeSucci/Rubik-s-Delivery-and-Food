package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MenuHamburguesaActivity extends AppCompatActivity {


    private Context context;

    private ImageButton btnimgAnadirPedidoH;
    private Toolbar tlbVerOrdenH;
    private TextView lblPrecioTotalH;


    // Paso 1
    private DatabaseReference databaseRef;

    private ListView productsListView;
    private ProductosAdapter productosAdapter;

    private double precioTotalH = 0.00;

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hamburguesa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;

        btnimgAnadirPedidoH = (ImageButton) findViewById(R.id.btnimgAnadirPedidoH);
        tlbVerOrdenH = (Toolbar) findViewById(R.id.tlbVerOrdenH);
        lblPrecioTotalH = (TextView) findViewById(R.id.lblPrecioTotalH);

        precioTotalH = MenuActivity.precio;
        lblPrecioTotalH.setText(Double.toString(precioTotalH)+"0");


        ArrayList<Productos> products = new ArrayList<>();
        productosAdapter = new ProductosAdapter(context, products,lblPrecioTotalH);

        productsListView = (ListView) findViewById(R.id.lstHamburguesas);
        productsListView.setAdapter(productosAdapter);

        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        // Firebase

        // Paso 2
        databaseRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference productosRef = databaseRef.child("hamburguesas"); //nombre de la rama

        productosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                productosAdapter.clear();
                for (DataSnapshot msgSnapshot : snapshot.getChildren()) {
                Productos msg = msgSnapshot.getValue(Productos.class);
                productosAdapter.add(msg);
            }
        }

        @Override
        public void onCancelled(DatabaseError error) {
            Toast.makeText(getApplicationContext(), R.string.cancel_process, Toast.LENGTH_SHORT).show();
        }
    });

        btnimgAnadirPedidoH.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, MenuActivity.class);
            precioTotalH = Double.parseDouble(lblPrecioTotalH.getText().toString());
            MenuActivity.setPrecio(precioTotalH);
            lblPrecioTotalH.setText(Double.toString(MenuActivity.getPrecio())+"0");
            startActivity(intent);
            }
        });

        productsListView.setClickable(true);
        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                // Log.i("Click", "click en el elemento" + posicion + "de la lista");
//                TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                //              String producto = texto.getText().toString();
                //Log.e("Item seleccionado", producto);

                Productos prod = (Productos)productsListView.getItemAtPosition(posicion);

                Intent intent = new Intent(context, VistaDeDetalleActivity.class);
                String[] datosProducto = new String[] {prod.getNombre(), String.valueOf(prod.getPrecio()),prod.getDescripcion(),prod.getFotoUrl()};
                // Toast.makeText(context, nombreProd + String.valueOf(precioProd)+fotoProd, Toast.LENGTH_SHORT).show();
                intent.putExtra("datos_producto", datosProducto);
                startActivity(intent);

            }
        });

        tlbVerOrdenH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VerOrdenActivity.class);
                startActivity(intent);
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
