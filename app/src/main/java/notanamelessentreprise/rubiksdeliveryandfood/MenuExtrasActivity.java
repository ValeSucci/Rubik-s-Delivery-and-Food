package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import notanamelessentreprise.rubiksdeliveryandfood.Productos1.SubCategoria;
import notanamelessentreprise.rubiksdeliveryandfood.Productos1.SubCategoria.ItemList;

public class MenuExtrasActivity extends AppCompatActivity {
    private ArrayList<Productos1>pProductosArrayList;
    private ArrayList<SubCategoria> pSubItemArrayListG;
    private ArrayList<SubCategoria> pSubItemArrayListB;
    private ArrayList<SubCategoria> pSubItemArrayListSl;
    private LinearLayout mLinearListView;

    private ProductosExtrasAdapter productosExtrasAdapter;
    boolean esPrimerClick =false;
    boolean esSegundoClick = false;

    private Context context;

    private ImageButton imgbtnAnadirPedidoE;
    private Toolbar tlbVerOrdenE;
    private TextView lblPrecioTotalE;

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    private double precioTotalE = MenuActivity.getPrecio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_extras);
        mLinearListView=(LinearLayout)findViewById(R.id.linear_listview);
        tlbVerOrdenE = (Toolbar) findViewById(R.id.tlbVerOrdenE);
        lblPrecioTotalE=(TextView) findViewById(R.id.lblPrecioTotalE);
        imgbtnAnadirPedidoE=(ImageButton) findViewById(R.id.btnimgAnadirPedidoE);

        lblPrecioTotalE.setText(Double.toString(MenuActivity.getPrecio()));

        context = this;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Papas fritas
        ArrayList<ItemList> mItemListArrayPF = new ArrayList<ItemList>();
        mItemListArrayPF.add(new ItemList("Pequeño","Bs. 5"));
        mItemListArrayPF.add(new ItemList("Mediano","Bs. 7"));
        mItemListArrayPF.add(new ItemList("Grande","Bs. 10"));

        //Arroz
        ArrayList<ItemList> mItemListArrayA = new ArrayList<ItemList>();
        mItemListArrayA.add(new ItemList("Pequeño","Bs. 10"));
        mItemListArrayA.add(new ItemList("Grande","Bs. 15"));

        //Soda CocaCola y esos
        ArrayList<ItemList> mItemListArrayS = new ArrayList<ItemList>();
        mItemListArrayS.add(new ItemList("Pequeño","Bs. 5"));
        mItemListArrayS.add(new ItemList("Mediano","Bs. 7.5"));
        mItemListArrayS.add(new ItemList("Grande","Bs. 10"));

        //Tradicional
        ArrayList<ItemList> mItemListArraySlT = new ArrayList<>();
        mItemListArraySlT.add(new ItemList("Mayonesa","Bs. 0.5"));
        mItemListArraySlT.add(new ItemList("Ketchup","Bs. 0.5"));
        mItemListArraySlT.add(new ItemList("Mostaza","Bs. 0.5"));
        mItemListArraySlT.add(new ItemList("Llajua Tradicional","Bs. 1"));

        //Extravagante
        ArrayList<ItemList> mItemListArraySlE = new ArrayList<>();
        mItemListArraySlE.add(new ItemList("Salsa Golf","Bs. 1"));
        mItemListArraySlE.add(new ItemList("Salsa Barbacoa","Bs. 3"));
        mItemListArraySlE.add(new ItemList("Miel y Mostaza","Bs. 3"));
        mItemListArraySlE.add(new ItemList("Hot Mustard","Bs. 3"));
        mItemListArraySlE.add(new ItemList("Salsa Picante","Bs. 3"));

        pSubItemArrayListG = new ArrayList<SubCategoria>();
        pSubItemArrayListB = new ArrayList<SubCategoria>();
        pSubItemArrayListSl = new ArrayList<SubCategoria>();

        pSubItemArrayListG.add(new SubCategoria("Papas Fritas",mItemListArrayPF));
        pSubItemArrayListG.add(new SubCategoria("Arroz",mItemListArrayA));

        pSubItemArrayListB.add(new SubCategoria("Coca Cola",mItemListArrayS));
        pSubItemArrayListB.add(new SubCategoria("Fanta",mItemListArrayS));
        pSubItemArrayListB.add(new SubCategoria("Sprite",mItemListArrayS));

        pSubItemArrayListSl.add(new SubCategoria("Tradicional",mItemListArraySlT));
        pSubItemArrayListSl.add(new SubCategoria("Extravagante",mItemListArraySlE));


        pProductosArrayList = new ArrayList<Productos1>();
        pProductosArrayList.add(new Productos1("Guarniciones", pSubItemArrayListG));
        pProductosArrayList.add(new Productos1("Gaseosas", pSubItemArrayListB));
        pProductosArrayList.add(new Productos1("Salsas", pSubItemArrayListSl));




       // productosExtrasAdapter = new ProductosExtrasAdapter(context, pProductosArrayList);

        for (int i =0; i < pProductosArrayList.size(); i++){
            LayoutInflater inflater = null;
            inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mLinearView = inflater.inflate(R.layout.primera_fila,null);

            final TextView mProductoNombre = (TextView)mLinearView.findViewById(R.id.textViewNombre);
            final RelativeLayout mLinearFirstArrow = (RelativeLayout)mLinearView.findViewById(R.id.linearFirst);
            final ImageView mImageArrowFirst = (ImageView)mLinearView.findViewById(R.id.imageFirstArrow);
            final LinearLayout mLinearScrollSecond = (LinearLayout)mLinearView.findViewById(R.id.linear_scroll);

            if (!esPrimerClick){
                mLinearScrollSecond.setVisibility(View.GONE);
                mImageArrowFirst.setBackgroundResource(R.drawable.fle_costado);
            }else{
                mLinearScrollSecond.setVisibility(View.VISIBLE);
                mImageArrowFirst.setBackgroundResource(R.drawable.fle_abajo);
            }
            mLinearFirstArrow.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event){
                    if(!esPrimerClick){
                        esPrimerClick=true;
                        mImageArrowFirst.setBackgroundResource(R.drawable.fle_abajo);
                        mLinearScrollSecond.setVisibility(View.VISIBLE);
                    }else{
                        esPrimerClick = false;
                        mImageArrowFirst.setBackgroundResource(R.drawable.fle_costado);
                        mLinearScrollSecond.setVisibility(View.GONE);
                    }
                    return false;
                }

            });

            final String name = pProductosArrayList.get(i).getpNombre();
            mProductoNombre.setText(name);

            for(int j = 0 ; j < pProductosArrayList.get(i).getmSubCategoriaList().size();j++){
                LayoutInflater inflater2 = null;
                inflater2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mLinearView2 = inflater2.inflate(R.layout.segunda_fila,null);

                TextView mSubItemNombbre = (TextView) mLinearView2.findViewById(R.id.textViewTitle);
                final RelativeLayout mLinearSecondArrow = (RelativeLayout)mLinearView2.findViewById(R.id.linearSecond);
                final ImageView mImageArrowSecond = (ImageView) mLinearView2.findViewById(R.id.imageSecondArrow);
                final LinearLayout mLinearScrollThird = (LinearLayout) mLinearView2.findViewById(R.id.linear_scroll_third);

                if(!esSegundoClick){
                    mLinearScrollThird.setVisibility(View.GONE);
                    mImageArrowSecond.setBackgroundResource(R.drawable.fle_costado);
                }else{
                    mLinearScrollThird.setVisibility(View.VISIBLE);
                    mImageArrowSecond.setBackgroundResource(R.drawable.fle_abajo);
                }
                mLinearSecondArrow.setOnTouchListener(new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event){
                        if(!esSegundoClick){
                            esSegundoClick = true;
                            mImageArrowSecond.setBackgroundResource(R.drawable.fle_abajo);
                            mLinearScrollThird.setVisibility(View.VISIBLE);
                        }else {
                            esSegundoClick = false;
                            mImageArrowSecond.setBackgroundResource(R.drawable.fle_costado);
                            mLinearScrollThird.setVisibility(View.GONE);
                        }
                        return false;
                    }
                });

                final String catecoryName = pProductosArrayList.get(i).getmSubCategoriaList().get(j).getpSubCategoriaNombre();
                mSubItemNombbre.setText(catecoryName);

                for(int k = 0; k <pProductosArrayList.get(i).getmSubCategoriaList().get(j).getmItemListArray().size();k++){
                    final String nombreProd = pProductosArrayList.get(i).getmSubCategoriaList().get(j).getpSubCategoriaNombre();
                    LayoutInflater inflater3 = null;
                    inflater3 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mLinearView3 = inflater3.inflate(R.layout.tercera_fila,null);
                    LinearLayout lyhProductoExtra = (LinearLayout) mLinearView3.findViewById(R.id.lyhProductoExtra);
                    final ImageButton imgbtnProdExtra = (ImageButton) mLinearView3.findViewById(R.id.imgbtnChecke);
                    TextView mItemName = (TextView) mLinearView3.findViewById(R.id.textViewItemName);
                    TextView mItemPrecio = (TextView) mLinearView3.findViewById(R.id.textViewItemPrecio);
                    final String itemName = pProductosArrayList.get(i).getmSubCategoriaList().get(j).getmItemListArray().get(k).getItemNombre();
                    final String itemPrecio = pProductosArrayList.get(i).getmSubCategoriaList().get(j).getmItemListArray().get(k).getItemPrecio();
                    mItemName.setText(itemName);
                    mItemPrecio.setText(itemPrecio);
                    mLinearScrollThird.addView(mLinearView3);

                    final String precio = itemPrecio.substring(4);
                    final Productos p = new Productos();
                    p.setNombre(nombreProd);
                    p.setPrecio(Float.parseFloat(precio));
                    p.setDescripcion(nombreProd+" "+itemName);
                    lyhProductoExtra.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            ColorDrawable buttonColor = (ColorDrawable) imgbtnProdExtra.getBackground();
                            int buttonId = buttonColor.getColor();
                            Log.i("comparar", buttonId+"="+Color.GRAY);

                            Log.i("producto", p.getNombre()+" "+p.getDescripcion() + precio);
                            if (buttonId == Color.GRAY) {
                                imgbtnProdExtra.setBackgroundColor(Color.CYAN);
                                VerOrdenActivity.listaDePedidos.add(p);
                                precioTotalE += Double.parseDouble(precio);
                            } else {
                                imgbtnProdExtra.setBackgroundColor(Color.GRAY);
                                VerOrdenActivity.listaDePedidos.remove(p);
                                precioTotalE -= Double.parseDouble(precio);
                            }
                            lblPrecioTotalE.setText(Double.toString(precioTotalE));
                            return false;
                        }
                    });
                }
                mLinearScrollSecond.addView(mLinearView2);
            }
            mLinearListView.addView(mLinearView);
        }

        imgbtnAnadirPedidoE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MenuActivity.class);
                precioTotalE = Double.parseDouble(lblPrecioTotalE.getText().toString());
                MenuActivity.setPrecio(precioTotalE);
                lblPrecioTotalE.setText(Double.toString(MenuActivity.getPrecio())+"0");
                startActivity(intent);
            }
        });

        tlbVerOrdenE.setOnClickListener(new View.OnClickListener() {
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
