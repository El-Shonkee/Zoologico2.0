import Control.CRUD.plansControl;
import Control.CRUD.sellsControl;
import Control.CRUD.usersControl;
import View.Menu;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.*;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        plansControl plans = new plansControl();
        usersControl users = new usersControl();
        sellsControl sells = new sellsControl();

        ObjectMapper mapper = new ObjectMapper();
        Plans plan = mapper.readValue(new File("Plans.json"), Plans.class);
        plansControl.addPlan(plan);

        new Menu();
    }
}