package com.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class UserService {

    static String usersFilePath = "users.txt";

    public static long addUser(User user) throws IOException {  // add
        File file = new File(usersFilePath);

        //write user to file as csv
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(user.getId() + "," + user.getName() + "," + user.getEmail() + "," + user.getPassword() + "\n");
        fileWriter.close();
        return user.getId();
    }

    public static User getUser(long id) throws Exception {   // get
        //read from file and return matching user id

        User user = null;

        BufferedReader bufferedReader =  new BufferedReader(
            new FileReader(
                new File(usersFilePath)
            )
        );

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] userString = line.split(",");
            if (Long.parseLong(userString[0]) == id) {
                user = new User(Long.parseLong(userString[0]), userString[1], userString[2], userString[3]);
                break;
            }
        }

        return user;
    }

      public static boolean deleteUser(long id) throws IOException {
        File file = new File(usersFilePath);
        File tempFile = new File("users_temp.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean userFound = false;

        while ((line = bufferedReader.readLine()) != null) {
            String[] userString = line.split(",");
            if (Long.parseLong(userString[0]) == id) {
                userFound = true;
                continue; // Skip the line with the user to be deleted
            }
            bufferedWriter.write(line + System.lineSeparator());
        }

        bufferedReader.close();
        bufferedWriter.close();

        // Replace the original file with the updated one
        if (!file.delete()) {
            throw new IOException("Failed to delete the original file");
        }
        if (!tempFile.renameTo(file)) {
            throw new IOException("Failed to rename the temp file to original file name");
        }

        return userFound;
    }
                                                                                                                   //modify                                      
    public static User modify(long id,String modifyfield,String value) throws FileNotFoundException, IOException ,EOFException
    {
        File file=new File(usersFilePath);
        File filetemp=new File("modify.txt");

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filetemp)))
            {
                User user=null;
                String line;
                while ((line=bufferedReader.readLine())!=null) {

                    String[] arr=line.split(",");
                    if(Long.parseLong(arr[0])==id)
                    {
                        switch (modifyfield) {
                            case "name":
                                arr[1]=value;
                                break;
                            case "email":
                                arr[2]=value;
                                break;
                            case "pass":
                                arr[3]=value;
                                break;
                            default:
                                throw new EOFException("Invalid field: " + modifyfield);
                        }
                       user=new User(Long.parseLong(arr[0]), arr[1], arr[2], arr[3]);
                    }
                    bufferedWriter.write(String.join(",", arr)+System.lineSeparator());
                }
                if (!file.delete()) {
                    throw new IOException("Failed to delete the original file");
                }
                if (!filetemp.renameTo(file)) {
                    throw new IOException("Failed to rename the temp file to original file name");
                }
                return user;
            }
    }
    
    public static void printUsers() throws Exception {
        File file = new File(usersFilePath);
        FileReader fileReader = new FileReader(file);
        int i;
        while ((i = fileReader.read()) != -1) {
            System.out.print((char) i);
        }
        fileReader.close();
    }

}
