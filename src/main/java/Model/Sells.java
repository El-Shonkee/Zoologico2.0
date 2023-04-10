package Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Sells {
    int  billNumber, adults, children, price;
    Users user;
    Plans plan;
    Date date;

    public Sells(Plans plan, Users user, int adults, int children, int price,Date date) {
        this.plan = plan;
        this.billNumber = randomBillGenerator();
        this.user = user;
        this.adults = adults;
        this.children = children;
        this.price = price;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public int getBillNumber() {
        return billNumber;
    }
    public Plans getPlan() {
        return plan;
    }

    public void setPlan(Plans plan) {
        this.plan = plan;
    }

    private static Set<Integer> billGenerated = new HashSet<Integer>();
    private static Random randomGenerator = new Random();

    public Users getUser() {
        return user;
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
        return  "user=" + user +
                ", billNumber=" + billNumber +
                ", adults=" + adults +
                ", children=" + children +
                ", price=" + price +
                ", plan=" + plan+
                ", Date=" + date;
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
