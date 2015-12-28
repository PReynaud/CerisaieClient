package com.epul.consumer;

import com.epul.metier.Client;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 13/10/2015.
 */
public class Consumer {
    private String uri;

    public Consumer(String uri) {
        this.uri = uri;
    }

    public Client getOneClient(int id){
        try {
            Gson gson = new Gson();
            URL url = new URL(uri + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            InputStream json = connection.getInputStream();
            String string = getStringFromInputStream(json);
            Client customer = gson.fromJson(string, Client.class);

            connection.disconnect();

            return customer;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Client> getAllClient(){
        try {
            List<Client> listClient;
            Gson gson = new Gson();
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            Type listType = new TypeToken<List<Client>>() {}.getType();
            InputStream json = connection.getInputStream();
            String string = getStringFromInputStream(json);
            listClient = gson.fromJson(string, listType);

            connection.disconnect();

            return listClient;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

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
}
