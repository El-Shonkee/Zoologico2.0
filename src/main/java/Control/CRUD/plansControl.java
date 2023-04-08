package Control.CRUD;


import Model.*;

import java.util.ArrayList;

public class plansControl{

    public static ArrayList<Plans> plansArrayList;
    public static ArrayList<String> planNames;

    public plansControl() {
        plansArrayList = new ArrayList<>();
        planNames = new ArrayList<>();
    }

    public static void addPlan(Plans plan) {
        plansArrayList.add(plan);
        planNames.add(plan.getNamePlan());
    }

    public void deletePlan(Plans plan){
        plansArrayList.remove(plan);
    }

    public static Plans searchPlan(String name){
        for(Plans plan: plansArrayList){
            if(plan.getNamePlan().equals(name)){
                return plan;
            }
        }
        return null;
    }

    public boolean modifyPlan( String namePlan, String descriptionPlan, String days, String hours, int pricePlan, int accountingPeople,String souvenir){
        Plans planModified = searchPlan(namePlan);

        if(planModified != null){
            planModified.setNamePlan(namePlan);
            planModified.setDescriptionPlan(descriptionPlan);
            planModified.setDays(days);
            planModified.setHours(hours);
            planModified.setPricePlan(pricePlan);
            planModified.setAccountingPeople(accountingPeople);
            planModified.setSouvenir(souvenir);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "plansControl{" +
                "usersArrayList=" + plansArrayList +
                '}';
    }



}
