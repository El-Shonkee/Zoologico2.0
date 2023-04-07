/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author andrea.correaa1
 */
public class Plans {
    private int idPlan;
    String namePlan;
    String descriptionPlan;
    String days;
    String hours;
    int pricePlan;
    int accountingPeople;
    String souvenir;


    boolean children;
    private static Set<Integer> iDsGenerated = new HashSet<Integer>();
    private static Random randomGenerator = new Random();
    public Plans(String namePlan,
                 String descriptionPlan,
                 String days,
                 String hours,
                 int pricePlan,
                 int accountingPeople,
                 String souvenir,
                 boolean children) {
        this.idPlan = randomIdGenerator();
        this.namePlan = namePlan;
        this.descriptionPlan = descriptionPlan;
        this.days = days;
        this.hours = hours;
        this.pricePlan = pricePlan;
        this.accountingPeople = accountingPeople;
        this.souvenir = souvenir;
        this.children = children;
    }

    public Plans(){

    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public String getDescriptionPlan() {
        return descriptionPlan;
    }

    public void setDescriptionPlan(String descriptionPlan) {
        this.descriptionPlan = descriptionPlan;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

   public int getPricePlan() {
        return pricePlan;
    }

    public void setPricePlan(int pricePlan) {
        this.pricePlan = pricePlan;
    }

    public int getAccountingPeople() {
        return accountingPeople;
    }

    public void setAccountingPeople(int accountingPeople) {
        this.accountingPeople = accountingPeople;
    }

    public String getSouvenir() {
        return souvenir;
    }

    public void setSouvenir(String souvenir) {
        this.souvenir = souvenir;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return  "Plan ID=" + idPlan + "\'" +
                ", Plan Name=" + namePlan + "\'" +
                ", Description=" + descriptionPlan + "\'" +
                ", Days=" + days + "\'" +
                ", Hours=" + hours + "\'" +
                ", Price=" + pricePlan + "\'" +
                ", People=" + accountingPeople + "\'" +
                ", Souvenir=" + souvenir + "\'" +
                ", childrens=" + children;
    }

    private static int randomIdGenerator() {
        int newId;
        do {
            newId = randomGenerator.nextInt(1000000);
        } while (iDsGenerated.contains(newId));
        iDsGenerated.add(newId);
        return newId;
    }

}
