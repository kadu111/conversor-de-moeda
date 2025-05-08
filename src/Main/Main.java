package Main;

import Modules.CurrencyFetcher;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        String baseCurrency = "USD"; // Moeda base
        String apiKey = "sua-chave-api";
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

        // Requisição a API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        CurrencyFetcher currencyFetcher = gson.fromJson(response.body(), CurrencyFetcher.class);

        if (!"success".equalsIgnoreCase(currencyFetcher.result())) {
            System.out.println("Erro ao obter taxas de câmbio. Encerrando.");
            return;
        }

        Map<String, Double> taxas = currencyFetcher.conversionRates();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Taxas carregadas com sucesso para " + taxas.size() + " moedas.");
        System.out.println("Digite 'LISTAR' para ver todas as moedas disponíveis ou 'SAIR' para encerrar.\n");

        while (true) {
            System.out.print("Moeda de origem: ");
            String origem = scanner.nextLine().toUpperCase();

            if (origem.equals("SAIR")) break;
            if (origem.equals("LISTAR")) {
                System.out.println("Moedas disponíveis:");
                taxas.keySet().stream().sorted().forEach(System.out::println);
                continue;
            }
            if (!taxas.containsKey(origem)) {
                System.out.println("Moeda inválida.\n");
                continue;
            }

            System.out.print("Moeda de destino: ");
            String destino = scanner.nextLine().toUpperCase();

            if (!taxas.containsKey(destino)) {
                System.out.println("Moeda inválida.\n");
                continue;
            }

            System.out.print("Valor a converter: ");
            double valor;
            try {
                valor = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.\n");
                continue;
            }

            double taxaOrigem = taxas.get(origem);
            double taxaDestino = taxas.get(destino);
            double resultado = valor * (taxaDestino / taxaOrigem);

            System.out.printf("%.2f %s equivalem a %.2f %s\n\n", valor, origem, resultado, destino);
        }

        System.out.println("Programa encerrado.");
    }
}