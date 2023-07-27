package br.com.carlos.conversor.elementos;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class JComboBoxUnidades extends JComboBox<String> {
	String[] listaCategorias = { "Área", "Ângulo", "Comprimento", "Massa", "Moeda", "Pressão", "Temperatura", "Volume",
			"Velocidade", };

	HashMap<String, String[]> listaSubCategorias = new HashMap<>();

	public JComboBoxUnidades(JComboBoxSubUnidadeDe listaUnidadeDe, JComboBoxSubUnidadePara listaUnidadePara) {
		listaSubCategorias.put("Massa",
				new String[] { "Miligrama", "Grama", "Quilograma", "Tonelada", "Decagrama", "Hectograma" });
		listaSubCategorias.put("Temperatura", new String[] { "Kelvin", "Celsius", "Fahrenheit" });
		listaSubCategorias.put("Comprimento",
				new String[] { "Quilômetro", "Metro", "Decímetro", "Centímetro", "Milímetro", "Nanômetro" });
		listaSubCategorias.put("Volume",
				new String[] { "Metro cúbico", "Litro", "Decilitro", "Centilitro", "Centímetro cúbico", "Mililitro" });
		listaSubCategorias.put("Área", new String[] { "Quilômetro quadrado", "Hectare", "Metro quadrado",
				"Decimetro quadrado", "Centímetro quadrado", "Milímetro quadrado" });
		listaSubCategorias.put("Velocidade", new String[] { "Km/s", "M/s", "Km/h", "Mm/s" });
		listaSubCategorias.put("Moeda", new String[] { "Real", "Dolar", "Libra esterlina", "Peso argentino",
				"Peso chileno", "Euro", "Iene Japonês", "Won Coreano" });
		listaSubCategorias.put("Pressão", new String[] { "Atmosfera", "Bar", "Quilopascal", "Pascal" });
		listaSubCategorias.put("Ângulo", new String[] { "Grau", "Radiano", "Gradiano" });

		setBounds(260, 100, 120, 40);
		setBackground(new Color(20, 20, 20));
		setForeground(new Color(0, 255, 255));
		setFont(new Font("Arial", Font.BOLD, 14));

		addActionListener(e -> {
			String categoriaSelecionada = getSelectedItem().toString();
			String[] subCategoriaSelecionada = listaSubCategorias.get(categoriaSelecionada);

			listaUnidadeDe.removeAllItems();
			listaUnidadePara.removeAllItems();
			for (String item : subCategoriaSelecionada) {
				listaUnidadeDe.addItem(item);
				listaUnidadePara.addItem(item);
			}

		});

		for (String categoria : listaCategorias) {
			addItem(categoria);
		}
	}

}
