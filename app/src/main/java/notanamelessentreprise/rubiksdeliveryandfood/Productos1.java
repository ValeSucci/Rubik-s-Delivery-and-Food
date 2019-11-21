package notanamelessentreprise.rubiksdeliveryandfood;

import java.util.ArrayList;

public class Productos1 {
    private String pNombre;
    private ArrayList<SubCategoria> mSubCategoriaList;

    private boolean checked = false;
    private float precio = 0;

    public Productos1(String pNombre, ArrayList<SubCategoria> mSubCategoriaList){
        super();
        this.pNombre = pNombre;
        this.mSubCategoriaList = mSubCategoriaList;
    }

    public String getpNombre(){
        return pNombre;
    }
    public void setpNombre(String pNombre){
        this.pNombre = pNombre;
    }

    public ArrayList<SubCategoria>getmSubCategoriaList(){

        return mSubCategoriaList;
    }
    public void setmSubCategoriaList(ArrayList<SubCategoria> mSubCategoriaList){
        this.mSubCategoriaList = mSubCategoriaList;
    }


    public static class SubCategoria{
        private String pSubCategoriaNombre;
        private ArrayList<ItemList> mItemListArray;

        public SubCategoria(String pSubCategoriaNombre,ArrayList<ItemList> mItemListArray){
            super();
            this.pSubCategoriaNombre = pSubCategoriaNombre;
            this.mItemListArray = mItemListArray;
        }

        public String getpSubCategoriaNombre(){
            return pSubCategoriaNombre;
        }

        public  void setpSubCategoriaNombre (String pSubCategoriaNombre){
            this.pSubCategoriaNombre = pSubCategoriaNombre;
        }
        public ArrayList<ItemList> getmItemListArray(){
            return mItemListArray;
        }
        public void setmItemListArray(ArrayList<ItemList> mItemListArray){
            this.mItemListArray = mItemListArray;
        }


        public static class ItemList{
            private String itemNombre;
            public String itemPrecio;

            public ItemList(String itemNombre, String itemPrecio){
                super();
                this.itemNombre = itemNombre;
                this.itemPrecio = itemPrecio;
            }
            public String getItemNombre(){
                return itemNombre;
            }
            public void setItemNombre(String itemNombre){
                this.itemNombre = itemNombre;
            }
            public String getItemPrecio(){
                return itemPrecio;
            }
            public void setItemPrecio(String itemPrecio){
                this.itemPrecio = itemPrecio;
            }
        }
    }

    public boolean getChecked() {return checked;}
   /* public float getPrecio() {
    return precio;
}*/


}
