import Control.CRUD.plansControl;
import Control.CRUD.sellsControl;
import Control.CRUD.usersControl;
import View.Menu;


public class Main {
    public static void main(String[] args){
        plansControl plans = new plansControl();
        usersControl users = new usersControl();
        sellsControl sells = new sellsControl();
        new Menu();
    }
}