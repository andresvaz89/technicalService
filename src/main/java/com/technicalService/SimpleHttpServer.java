package com.technicalService;

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

    private static List<Request> requests = new ArrayList<>(); // In-memory storage

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8080), 0);
        server.createContext("/api/requests", new RequestHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class RequestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response;
            int statusCode = 200;

            switch (exchange.getRequestMethod()) {
                case "POST":
                    // Create a new request
                    Request newRequest = readRequestFromRequest(exchange);
                    requests.add(newRequest);
                    response = "Request added successfully!";
                    break;

                case "GET":
                    // Get all requests
                    response = requests.toString();
                    break;

                case "PUT":
                    // Update a request
                    int idToUpdate = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[3]);
                    Request updatedRequest = readRequestFromRequest(exchange);
                    if (idToUpdate < requests.size()) {
                        requests.set(idToUpdate, updatedRequest);
                        response = "Request updated successfully!";
                    } else {
                        response = "Request not found.";
                        statusCode = 404;
                    }
                    break;

                case "DELETE":
                    // Delete a request
                    int idToDelete = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[3]);
                    if (idToDelete < requests.size()) {
                        requests.remove(idToDelete);
                        response = "Request deleted successfully!";
                    } else {
                        response = "Request not found.";
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

        private Request readRequestFromRequest(HttpExchange exchange) throws IOException {
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

            // Use requests.size() to assign a unique ID
            int id = requests.size();
            return new Request(id, name, age);
        }
    }
}



