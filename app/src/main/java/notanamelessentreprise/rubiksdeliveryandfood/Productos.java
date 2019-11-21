package notanamelessentreprise.rubiksdeliveryandfood;

public class Productos {

    private String nombre;
    private float precio;
    private String descripcion;
    private String fotoUrl;
    private boolean checked = false;

    public Productos() {
        // Firebase necesita este contructor
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public boolean getChecked() {return checked;}

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
   }
