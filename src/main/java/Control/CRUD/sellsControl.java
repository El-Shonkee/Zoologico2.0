package Control.CRUD;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class sellsControl {
    public static ArrayList<Sells> getSellsArrayList() {
        return sellsArrayList;
    }

    public static ArrayList<Sells> sellsArrayList;

    public sellsControl(){
        sellsArrayList=new ArrayList<>();
    }

    public static void addSell(Sells sell){
        sellsArrayList.add(sell);
    }

    @Override
    public String toString() {
        return "sellsControl{"+ sellsArrayList +"}";
    }

    public static double getTotalSales() {
        double totalSales = 0;
        for (Sells sell : sellsArrayList) {
            totalSales += sell.getPrice();
        }
        return totalSales;
    }

    public static HashMap<String, Integer> summarizeSellsByPlan(ArrayList<Sells> sellsList) {
        HashMap<String, Integer> summary = new HashMap<>();
        for (Sells sell : sellsList) {
            String planName = sell.getPlan().getNamePlan();
            if (summary.containsKey(planName)) {
                summary.put(planName, summary.get(planName) + 1);
            } else {
                summary.put(planName, 1);
            }
        }
        return summary;
    }

}
