package com.example.lab3.data;

import com.example.lab3.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */

public class LoginDataSource {

    String[] uzytkownicy = new String[]{"DARIA:daria", "DARIA1:daria1"};

    public Result<LoggedInUser> login(String username, String password) {

        try {
            for(int i =0; i < uzytkownicy.length ; i++){

                for (String credential : uzytkownicy) {
                    String[] pieces = credential.split(":");
                    if (pieces[0].equals(username)) {
                        if(pieces[1].equals(password)){
                            LoggedInUser nowyUzytkownik = new LoggedInUser(java.util.UUID.randomUUID().toString(),username);

                            return new Result.Success<>(nowyUzytkownik);
                        }
                        else{
                            return new Result.Pass();
                        }
                    }
                }


            }
            return new Result.Error(new IOException("Error logging in"));
            // TODO: handle loggedInUser authentication

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }


    public void logout() {
        // TODO: revoke authentication
    }
}
