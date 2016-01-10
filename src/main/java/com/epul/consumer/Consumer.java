package com.epul.consumer;

import com.epul.metier.*;
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
    private static String urlActivite = "http://localhost:8080/Activites/Sejour/";
    private static String urlActiviteDelete = "http://localhost:8080/Activites/";
    private static String urlSport = "http://localhost:8080/Sport/";
    private static String urlFacture = "http://localhost:8080/Facture/";
    private static String urlEmplacement = "http://localhost:8080/Emplacement/";


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

            return listSejour;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Sport> getAllSport(){
        try {
            List<Sport> listSport;
            Gson gson = new Gson();
            URL url = new URL(urlSport);

            Type listType = new TypeToken<List<Sport>>() {}.getType();
            String string = getResultFromURL(url, "GET");
            listSport = gson.fromJson(string, listType);

            return listSport;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Activite> getAllActiviteForSejour(int numSejour) {
        try {
            List<Activite> listActivite;
            Gson gson = new Gson();
            URL url = new URL(urlActivite + numSejour);

            Type listType = new TypeToken<List<Activite>>() {}.getType();
            String string = getResultFromURL(url, "GET");
            listActivite = gson.fromJson(string, listType);

            return listActivite;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
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

    public static Facture getTarifForSejour(int numSej){
        try {
            Facture facture;
            Gson gson = new Gson();
            URL url = new URL(urlFacture + numSej);
            String string = getResultFromURL(url, "GET");
            facture = gson.fromJson(string, Facture.class);

            return facture;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static Boolean deleteActivite(int idSejour, int idSport,String date) {
        URL url = null;
        try {
            url = new URL(urlActiviteDelete + idSejour + "/" + idSport + "/" + date);
            return deleteRequest(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<EmplacementTypeEmplacement> getAllEmplacement(){
        try {
            List<EmplacementTypeEmplacement> emplacements;
            Gson gson = new Gson();
            URL url = new URL(urlEmplacement );

            Type listType = new TypeToken<List<EmplacementTypeEmplacement>>() {}.getType();
            String string = getResultFromURL(url, "GET");
            emplacements = gson.fromJson(string, listType);

            return emplacements;
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

}
