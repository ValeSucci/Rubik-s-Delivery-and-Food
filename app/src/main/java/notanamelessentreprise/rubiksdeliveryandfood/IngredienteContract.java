package notanamelessentreprise.rubiksdeliveryandfood;

import android.provider.BaseColumns;

/**
 * Created by DTIC-123 on 24/03/2017.
 */

public class IngredienteContract {

    public static abstract class IngredienteEntry implements BaseColumns {
        public static final String TABLE_NAME ="ingredientes";

        public static final String NAME = "nombre";
        public static final String PRECIO = "precio";
        public static final String IMAGEN = "imagen";

    }
}
