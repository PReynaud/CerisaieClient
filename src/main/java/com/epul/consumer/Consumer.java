package com.epul.consumer;

import com.epul.metier.Client;
import com.epul.metier.Sejour;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Pierre on 02/01/2016.
 */
public class Consumer {
    private static String urlClient = "http://localhost:8080/Clients/";
    private static String urlSejour = "http://localhost:8080/Sejours/";

    public static Client getOneClient(int id){
        try {
            Gson gson = new Gson();
            URL url = new URL(urlClient + id);
            String string = getResultFromURL(url,"GET");
            Client client = gson.fromJson(string, Client.class);

            return client;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Client> getAllClient(){
        try {
            List<Client> listClient;
            Gson gson = new Gson();
            URL url = new URL(urlClient);

            Type listType = new TypeToken<List<Client>>() {}.getType();
            String string = getResultFromURL(url, "GET");
            listClient = gson.fromJson(string, listType);

            return listClient;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Sejour getOneSejour(int id) {
        try {
            Gson gson = new Gson();
            URL url = new URL(urlSejour + id);
            String string = getResultFromURL(url, "GET");
            Sejour sejour = gson.fromJson(string, Sejour.class);

            return sejour;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Sejour> getAllSejour(){
        try {
            List<Sejour> listSejour;
            Gson gson = new Gson();
            URL url = new URL(urlSejour);

            Type listType = new TypeToken<List<Sejour>>() {}.getType();
            String string = getResultFromURL(url, "GET");
            listSejour = gson.fromJson(string, listType);
            //TODO: faire qqch ici pour parser correctement

            return listSejour;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String getResultFromURL(URL url, String requestMethod) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setRequestProperty("Accept", "application/json");
            InputStream json = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(json));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

    private static int getResponseCodeFromURL(URL url, String requestMethod) {
        int responseCode = 0;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setRequestProperty("Accept", "application/json");
            responseCode = connection.getResponseCode();
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseCode;

    }

    private static Boolean deleteRequest(URL url){
        int result = getResponseCodeFromURL(url, "DELETE");
        return result == 204;
    }

    public static Boolean deleteClient(int id) {
        URL url = null;
        try {
            url = new URL(urlClient + id);
            return deleteRequest(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean deleteSejour(int id) {
        URL url = null;
        try {
            url = new URL(urlSejour + id);
            return deleteRequest(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
