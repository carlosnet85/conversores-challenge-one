package br.com.carlos.conversor.funcoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.github.cdimascio.dotenv.Dotenv;

public class ConversorMoedasAPI {

	Dotenv dotenv = Dotenv.load();

	private static final String API_URL = "https://api.invertexto.com/v1/currency/";
	private String API_TOKEN = dotenv.get("API_TOKEN");

	private static Map<String, Double> cacheConversoes = new HashMap<>();

	public void carregarToken() {
		API_TOKEN = dotenv.get("API_TOKEN");

		API_TOKEN = (String) JOptionPane.showInputDialog(null, API_TOKEN, "Insira uma token válida",
				JOptionPane.PLAIN_MESSAGE, null, null, "");

		if (API_TOKEN == null || API_TOKEN.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Token não fornecida.", null, JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			verificarToken();
		}
	}

	public boolean verificarToken() {
		Double resultado = null;

		try {
			String apiUrl = API_URL + "USD" + "_" + "BRL" + "?token=" + API_TOKEN;
			@SuppressWarnings("deprecation")
			URL url = new URL(apiUrl);
			HttpURLConnection GET = (HttpURLConnection) url.openConnection();
			GET.setRequestMethod("GET");

			if (GET.getResponseCode() == 200) {
				String conteudo = new BufferedReader(new InputStreamReader(GET.getInputStream())).readLine();
				JsonObject jsonObject = new Gson().fromJson(conteudo, JsonObject.class);

				JsonObject converterMoeda = jsonObject.get("USD" + "_" + "BRL").getAsJsonObject();
				resultado = converterMoeda.get("price").getAsDouble();

				GET.disconnect();
			}

			if (resultado != null) {
				JOptionPane.showMessageDialog(null, "Token válida.");
				salvarToken(API_TOKEN);
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
						"Falha na chamada à API. \nVerifique se sua token esta funcionando corretamente.", null,
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}

	private void salvarToken(String apiKey) {
		try {

			FileWriter fw = new FileWriter(".env");
			PrintWriter pw = new PrintWriter(fw);

			pw.println("API_TOKEN=" + apiKey);
			pw.close();
			fw.close();

			JOptionPane.showMessageDialog(null, "Token salva.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar a token.", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	public Double getConversaoMoedas(String moedaDe, String moedaPara, double quantidade) {
		String moedasConversao = moedaDe + "_" + moedaPara;

		if (moedaDe.equals(moedaPara)) {
			return quantidade;
		}

		if (cacheConversoes.containsKey(moedasConversao)) {
			double fatorConversao = cacheConversoes.get(moedasConversao);

			return quantidade * fatorConversao;
		} else {
			try {
				String apiUrl = API_URL + moedasConversao + "?token=" + API_TOKEN;

				@SuppressWarnings("deprecation")
				URL url = new URL(apiUrl);
				HttpURLConnection GET = (HttpURLConnection) url.openConnection();
				GET.setRequestMethod("GET");

				if (GET.getResponseCode() == 200) {
					String conteudo = new BufferedReader(new InputStreamReader(GET.getInputStream())).readLine();

					JsonObject jsonObject = new Gson().fromJson(conteudo, JsonObject.class);
					if (jsonObject.has(moedasConversao)) {
						JsonObject converterMoeda = jsonObject.get(moedasConversao).getAsJsonObject();
						double fatorConversao = converterMoeda.get("price").getAsDouble();

						cacheConversoes.put(moedasConversao, fatorConversao);

						return quantidade * fatorConversao;
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Parece que a sua token não esta funcionando.\nClique no botão 'Github' para ter instruções de como definir uma token.");
				}
				GET.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public String getToken() {
		return API_TOKEN;
	}
}