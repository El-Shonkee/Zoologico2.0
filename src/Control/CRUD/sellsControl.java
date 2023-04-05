package Control.CRUD;

import Model.*;

import java.util.ArrayList;

public class sellsControl {
    public static ArrayList<Sells> sellsArrayList;

    public sellsControl(){
        sellsArrayList=new ArrayList<>();
    }

    public static void addSell(Sells sell){
        sellsArrayList.add(sell);
    }

    public void deleteSell(Sells sell){
        sellsArrayList.remove(sell);
    }

    @Override
    public String toString() {
        return "sellsControl{"+ sellsArrayList +"}";
    }
}
