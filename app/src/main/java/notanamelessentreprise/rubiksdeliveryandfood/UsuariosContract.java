package notanamelessentreprise.rubiksdeliveryandfood;

import android.provider.BaseColumns;

/**
 * Created by DTIC-123 on 23/03/2017.
 */

public class UsuariosContract {


    //invoice = factura u.u

    public static abstract class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME ="usuarios";

        public static final String NAME = "nombre";
        public static final String USERNAME = "usuario";
        public static final String PHONE_NUMBER = "celulartelefono";
        public static final String ADDRESS = "domicilio";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "contrasenia";
        public static final String NIT = "nit";
        public static final String INVOICENAME = "nombrefactura";
    }
}
