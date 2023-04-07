package Control.CRUD;


import Model.*;

import java.util.ArrayList;

public class usersControl {

    public static ArrayList<Users> usersArrayList;

    public usersControl() {
        usersArrayList = new ArrayList<>();
    }

    public static void addUser(Users user) {
        usersArrayList.add(user);
    }

    public void deleteUser(Users user){
        usersArrayList.remove(user);
    }

    public Users searchUser(String ID){
        for(Users user: usersArrayList){
            if(user.getId().equals(ID)){
                return user;
            }
        }
        return null;
    }

    public boolean modifyUser(String name, String id, int age, String email, String phone){
        Users userModified = searchUser(id);

        if(userModified != null){
            userModified.setName(name);
            userModified.setId(id);
            userModified.setAge(age);
            userModified.setEmail(email);
            userModified.setPhone(phone);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "usersControl{ "+ usersArrayList +" }";
    }
}
