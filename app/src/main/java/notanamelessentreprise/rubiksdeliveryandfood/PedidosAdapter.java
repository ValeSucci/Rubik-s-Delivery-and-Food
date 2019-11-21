package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by DTIC-123 on 23/03/2017.
 */

public class PedidosAdapter extends ArrayAdapter<Productos> {

    //ddd

    public PedidosAdapter(Context context, List<Productos> objects) {
        super(context, 0, objects);
    }

    private TextView lblNombrePedido;
    private TextView lblCantidadRepPedido;
    private TextView lblDescripcionPedido;
    private TextView lblPrecioPedido;
    private TextView lblEstupidoParentesisAbierto;
    private TextView lblEstupidoParentesisCerrrado;
    private ImageButton imgbtnMas;
    private ImageButton imgbtnMenos;


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_pedido, parent, false);
        }

        lblNombrePedido = (TextView) convertView.findViewById(R.id.lblNombrePedido);
        lblCantidadRepPedido = (TextView) convertView.findViewById(R.id.lblCantidadDeRepPedido);
        lblEstupidoParentesisAbierto = (TextView) convertView.findViewById(R.id.lblEstupidoParentesisAbierto);
        lblEstupidoParentesisCerrrado = (TextView) convertView.findViewById(R.id.lblEstupidoParentesisCerrado);
        lblDescripcionPedido = (TextView) convertView.findViewById(R.id.lblDescripcionPedido);
        lblPrecioPedido = (TextView) convertView.findViewById(R.id.lblPrecioPedido);
        imgbtnMas = (ImageButton) convertView.findViewById(R.id.imgbtnMas);
        imgbtnMenos = (ImageButton) convertView.findViewById(R.id.imgbtnMenos);

        final Productos p = getItem(position);

        lblNombrePedido.setText(p.getNombre());
        lblDescripcionPedido.setText(p.getDescripcion());
        lblPrecioPedido.setText("Bs. "+p.getPrecio() + "0");

        imgbtnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int cantidadDeRepPedidos = Integer.parseInt(lblCantidadRepPedido.toString())+1;
                //lblCantidadRepPedido.setText(cantidadDeRepPedidos);
               // double nuevoPrecio = cantidadDeRepPedidos*p.getPrecio();
                //MenuActivity.setPrecio(nuevoPrecio);
                //lblPrecioPedido.setText("Bs. "+Double.toString(nuevoPrecio)+"0");
              Log.i(TAG, "btn mas en pedido "+p.getNombre()+" con precio "+p.getPrecio());
            }
        });

        imgbtnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(Integer.parseInt(lblCantidadRepPedido.toString()) > 1) {
                    int cantidadDeRepPedidos = Integer.parseInt(lblCantidadRepPedido.toString()) - 1;
                    lblCantidadRepPedido.setText(cantidadDeRepPedidos);
                    double nuevoPrecio = (cantidadDeRepPedidos-1) * p.getPrecio();
                    MenuActivity.setPrecio(nuevoPrecio);
                    lblPrecioPedido.setText("Bs. " + Double.toString(nuevoPrecio) + "0");
                } else {
                    VerOrdenActivity.listaDePedidos.remove(p);
                }*/
                Log.i(TAG, "btn menos en pedido "+p.getNombre()+" con precio "+p.getPrecio());
            }
        });

        return convertView;
    }

}
