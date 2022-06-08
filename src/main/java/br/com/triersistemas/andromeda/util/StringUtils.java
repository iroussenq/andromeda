package br.com.triersistemas.andromeda.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;
import br.com.triersistemas.andromeda.domain.Produto;

public class StringUtils {

    private StringUtils() { }

    public static String getRandomName() {
        List<String> nomes = new ArrayList<>();
        nomes.add("Bianca");
        nomes.add("Vitória");
        nomes.add("Caethana");
        nomes.add("Kay");
        nomes.add("Amanda");
        nomes.add("Carol");
        nomes.add("Davi");
        nomes.add("Igor");
        nomes.add("Antônio");
        nomes.add("Edymar");
        nomes.add("Edward");
        SplittableRandom r = new SplittableRandom();
        return nomes.get(r.nextInt(0, nomes.size()));
    }

    public static List<Produto> getRandomMeds() {
        List<Produto> listaRetorno = new ArrayList<>();
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("Dipirona", BigDecimal.valueOf(5.32)));
        lista.add(new Produto("Frauda Anjinho", BigDecimal.valueOf(11.22)));
        lista.add(new Produto("Dove my care", BigDecimal.valueOf(35.11)));
        lista.add(new Produto("Tridents", BigDecimal.valueOf(2.50)));
        lista.add(new Produto("Paracetamol", BigDecimal.valueOf(7.31)));
        lista.add(new Produto("Rivotril", BigDecimal.valueOf(15.12)));
        lista.add(new Produto("Cloridrato de paroxetina", BigDecimal.valueOf(2.68)));
        lista.add(new Produto("Valium", BigDecimal.valueOf(60.92)));
        lista.add(new Produto("Valeriana", BigDecimal.valueOf(52.82)));
        lista.add(new Produto("Dipirona", BigDecimal.valueOf(12.22)));
        lista.add(new Produto("Floral", BigDecimal.valueOf(43.35)));
        lista.add(new Produto("Dramin", BigDecimal.valueOf(9.12)));
        var r = new SplittableRandom();

        for (int i = 0; i < r.nextInt(2, lista.size()); i++) {
            var p = lista.get(r.nextInt(0, lista.size()));
            listaRetorno.add(p);
            lista.remove(p);
        }
        return listaRetorno;
    }

    public static String getRandomMed() {
        List<String> lista = new ArrayList<>();
        lista.add("Dipirona");
        lista.add("Frauda Anjinho");
        lista.add("Dove my care");
        lista.add("Trident");
        lista.add("Paracetamol");
        lista.add("Rivotril");
        lista.add("Cloridrato de paroxetina");
        lista.add("Valium");
        lista.add("Valeriana");
        lista.add("Floral");
        lista.add("Dramin");
        var r = new SplittableRandom();
        return lista.get(r.nextInt(0, lista.size()));
    }

    public static String extractNumbers(final String val) {
        if (Objects.nonNull(val)) {
            return val.replaceAll("\\D+", "");
        }
        return "";
    }

    public static List<Integer> extractNumbersToList(final String value) {
        List<Integer> digitos = new ArrayList<>();
        for (char item : extractNumbers(value).toCharArray()) {
            digitos.add(Integer.parseInt(String.valueOf(item)));
        }
        return digitos;
    }

    public static String listToString(final List<Integer> list) {
        return list.stream()
                .map(Object::toString)
                .reduce("", (p, e) -> p + e);
    }
    public static List<Produto> putItensInCart(ArrayList<Produto> produtos){
    	List<Produto> p = new ArrayList<>();
    	SplittableRandom r = new SplittableRandom();
    	for (int i = 0; i < 3; i++) {
		p.add(produtos.get(r.nextInt(0, produtos.size())));	
		}
    	return p;
    }
    
    }

