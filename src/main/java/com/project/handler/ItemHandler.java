package com.project.handler;

import com.google.gson.Gson;
import com.project.model.Item;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ItemHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        List<Item> items = new ArrayList<>();

        items.add(new Item(1, "Laptop"));
        items.add(new Item(2, "Mobile"));

        Gson gson = new Gson();

        String response = gson.toJson(items);

        exchange.getResponseHeaders().add("Content-Type", "application/json");

        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();

        os.write(response.getBytes());

        os.close();
    }
}