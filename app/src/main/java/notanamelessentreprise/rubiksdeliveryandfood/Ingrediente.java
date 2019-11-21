package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.ContentValues;
import android.media.Image;

/**
 * Created by DTIC-123 on 24/03/2017.
 */

public class Ingrediente {
    private String nombre;
    private double precio;
    private Image imagen;

    public Ingrediente(String nombre, double precio, Image imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

/*    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(IngredienteContract.IngredienteEntry.NAME, nombre);
        values.put(IngredienteContract.IngredienteEntry.PRECIO, precio);
        values.put(IngredienteContract.IngredienteEntry.IMAGEN, imagen);
        return values;
    }*/
}
