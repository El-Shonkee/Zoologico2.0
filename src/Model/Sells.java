package Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Sells {

    Users user;

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    int  billNumber,quantitySell, adults, children, price;

    public Plans getPlan() {
        return plan;
    }

    public void setPlan(Plans plan) {
        this.plan = plan;
    }

    Plans plan;

    private static Set<Integer> billGenerated = new HashSet<Integer>();
    private static Random randomGenerator = new Random();

    public Sells(Plans plan, Users user, int quantitySell, int adults, int children, int price) {
        this.plan = plan;
        this.billNumber = randomBillGenerator();
        this.user = user;
        this.quantitySell = quantitySell;
        this.adults = adults;
        this.children = children;
        this.price = price;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getQuantitySell() {
        return quantitySell;
    }

    public void setQuantitySell(int quantitySell) {
        this.quantitySell = quantitySell;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sells{" +
                "user=" + user +
                ", billNumber=" + billNumber +
                ", quantitySell=" + quantitySell +
                ", adults=" + adults +
                ", children=" + children +
                ", price=" + price +
                ", plan=" + plan +
                '}';
    }

    private static int randomBillGenerator() {
        int newIdBillNumber;
        do {
            newIdBillNumber = randomGenerator.nextInt(1000000);
        } while (billGenerated.contains(newIdBillNumber));
        billGenerated.add(newIdBillNumber);
        return newIdBillNumber;
    }



}
