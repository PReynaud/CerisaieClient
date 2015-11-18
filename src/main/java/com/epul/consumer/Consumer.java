package com.epul.consumer;

import com.epul.metier.Client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Pierre on 13/10/2015.
 */
public class Consumer {
    private String uri;

    public Consumer(String uri) {
        this.uri = uri;
    }

    public Client getRessourceClient(int id){
        try {
            URL url = new URL(uri + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            JAXBContext jc = JAXBContext.newInstance(Client.class);
            InputStream json = connection.getInputStream();
            Client customer = (Client) jc.createUnmarshaller().unmarshal(json);
            connection.disconnect();

            return customer;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
