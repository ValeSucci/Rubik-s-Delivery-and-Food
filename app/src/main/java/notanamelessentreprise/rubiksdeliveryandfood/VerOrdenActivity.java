package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VerOrdenActivity extends AppCompatActivity {

    public static ArrayList<Productos> listaDePedidos = new ArrayList<>();

    Context context;

    private Toolbar tlbCerrarVerOrden;
    private ListView lstListaDePedidos;
    private TextView lblPrecioAPagar;
    private Button btnConfirmarPedido;

    private PedidosAdapter pedidosAdapter;
    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_orden);

        context = this;

        tlbCerrarVerOrden = (Toolbar) findViewById(R.id.tlbCerrarVerOrden);
        lstListaDePedidos = (ListView) findViewById(R.id.lstPedidos);
        lblPrecioAPagar = (TextView) findViewById(R.id.lblPrecioTotalAPagar);
        btnConfirmarPedido = (Button) findViewById(R.id.btnConfirmarPedido);

        lblPrecioAPagar.setText(Double.toString(MenuActivity.getPrecio()));

        if(!listaDePedidos.isEmpty()) {
            pedidosAdapter = new PedidosAdapter(context, listaDePedidos);

            lstListaDePedidos = (ListView) findViewById(R.id.lstPedidos);
            lstListaDePedidos.setAdapter(pedidosAdapter);
        }


        btnConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GraciasActivity.class);
                startActivity(intent);
            }
        });

        tlbCerrarVerOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

}
