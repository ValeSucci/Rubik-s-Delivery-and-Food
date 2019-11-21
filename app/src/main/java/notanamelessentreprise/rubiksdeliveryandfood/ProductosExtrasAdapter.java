package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import notanamelessentreprise.rubiksdeliveryandfood.Productos1.SubCategoria.ItemList;

import static android.content.ContentValues.TAG;

/**
 * Created by HP on 23/3/2017.
 */

public class ProductosExtrasAdapter extends ArrayAdapter<Productos1> {
    //    private CheckBox checkBox;
    private TextView lblPrecioTotal;
    private static double precioTotal;
    private ImageButton imgbtnCheck;

    private boolean checked = false;

    public static double getPrecioTotal() {
        return precioTotal;
    }

    public static void setPrecioTotal(double precioTotal1) {
        precioTotal = precioTotal1;
    }

    public ProductosExtrasAdapter(Context context, List<Productos1> objects) {
        super(context, 0, objects);
//        this.lblPrecioTotal = lblPrecioTotal;
        precioTotal = MenuActivity.getPrecio();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       /* if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_producto, parent, false);
        }

        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imgFotoProducto);
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombreProducto);
        //  TextView descripcionTextView = (TextView) convertView.findViewById(R.id.lblDescripcionProducto);
        TextView lblPrecio = (TextView) convertView.findViewById(R.id.lblPrecioProducto);
        imgbtnCheck = (ImageButton) convertView.findViewById(R.id.imgbtnCheck);


        final Productos1 p = getItem(position);


        //TODO hacer q cambie la imagen de check

        imgbtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p.getChecked()) {
                    precioTotal -= p.getPrecio();
//                    imgbtnCheck.setImageBitmap(BitmapFactory.decodeResource(Resources.getSystem(),android.R.drawable.checkbox_off_background));
                    VerOrdenActivity.listaDePedidos.remove(p);
                    //  imgbtnCheck.setBackgroundColor(Color.GRAY);
                    p.setChecked(false);
                    view.setBackgroundColor(Color.GRAY);
                } else {
                    precioTotal += p.getPrecio();
//                    imgbtnCheck.setImageBitmap(BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.checkbox_on_background) );
                    VerOrdenActivity.listaDePedidos.add(p);
                    // imgbtnN.setBackgroundColor(Color.CYAN);
                    p.setChecked(true);
                    view.setBackgroundColor(Color.CYAN);
                }
                Log.i(TAG, "check en boton de "+p.getNombre()+" con checked "+p.getChecked()+" en posicion "+position + imgbtnCheck.toString());
                lblPrecioTotal.setText(Double.toString(precioTotal) +"0");
            }
        });

        lblNombre.setText(p.getNombre());
        // descripcionTextView.setText(p.getDescripcion());
        lblPrecio.setText(p.getPrecio() + "");

        Glide.with(getContext())
                .load(p.getFotoUrl())
                .centerCrop()
                .crossFade()
                .into(imgFoto);*/

        return convertView;

    }

    public boolean getChecked() {return checked;}
}
