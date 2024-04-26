package com.jardel;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<HttpClient> consultas = new ArrayList<>();


        System.out.println("Digite o cep: ");
        busca = leitura.nextLine();


        //String endereco = "https://viacep.com.br/ws/31035490/json/";
        String endereco = "https://viacep.com.br/ws/" + busca + "/json/";

        String consultaCep = URLEncoder.encode(busca, "UTF-8");

        // consumo da API
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting() // melhor formatação em json.
                .create()
                ;

        consultas.add(client);

        // criação de arquivo em json
        FileWriter writerJson = new FileWriter("cep.json");
        writerJson.write(json);
        writerJson.close();
    }
}
