 package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

 public class ContactenosActivity extends AppCompatActivity {
     private static final int opcion1= 1;
     private static final int opcion2 = 2;
     private static final int opcion3 = 3;
     private static final int opcion4 = 4;
     private static final int opcion5 = 5;

     private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactenos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
