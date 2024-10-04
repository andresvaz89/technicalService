package com.factoriaf5;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class SimpleHttpServer {

    private static List<Person> persons = new ArrayList<>(); // In-memory storage

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8080), 0);
        server.createContext("/api/persons", new PersonHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class PersonHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response;
            int statusCode = 200;

            switch (exchange.getRequestMethod()) {
                case "POST":
                    // Create a new person
                    Person newPerson = readPersonFromRequest(exchange);
                    persons.add(newPerson);
                    response = "Person added successfully!";
                    break;

                case "GET":
                    // Get all persons
                    response = persons.toString();
                    break;

                case "PUT":
                    // Update a person
                    int idToUpdate = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[3]);
                    Person updatedPerson = readPersonFromRequest(exchange);
                    if (idToUpdate < persons.size()) {
                        persons.set(idToUpdate, updatedPerson);
                        response = "Person updated successfully!";
                    } else {
                        response = "Person not found.";
                        statusCode = 404;
                    }
                    break;

                case "DELETE":
                    // Delete a person
                    int idToDelete = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[3]);
                    if (idToDelete < persons.size()) {
                        persons.remove(idToDelete);
                        response = "Person deleted successfully!";
                    } else {
                        response = "Person not found.";
                        statusCode = 404;
                    }
                    break;

                default:
                    response = "Unsupported method";
                    statusCode = 405;
                    break;
            }

            exchange.sendResponseHeaders(statusCode, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private Person readPersonFromRequest(HttpExchange exchange) throws IOException {
            InputStream is = exchange.getRequestBody();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            // Parse JSON manually
            String[] data = sb.toString().replace("{", "").replace("}", "").split(",");
            String name = data[0].split(":")[1].replace("\"", "").trim();
            int age = Integer.parseInt(data[1].split(":")[1].trim());

            // Use persons.size() to assign a unique ID
            int id = persons.size();
            return new Person(id, name, age);
        }
    }
}



