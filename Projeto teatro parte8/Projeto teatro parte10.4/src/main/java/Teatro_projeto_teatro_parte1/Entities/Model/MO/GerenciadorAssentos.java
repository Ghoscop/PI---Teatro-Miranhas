package Teatro_projeto_teatro_parte1.Entities.Model.MO;

import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorAssentos {

    private final int PRECO_PLATEIA_A = 40;
    private final int PRECO_PLATEIA_B = 60;
    private final int PRECO_FRISA = 120;
    private final int PRECO_CAMAROTE = 80;
    private final int PRECO_BALCAO_NOBRE = 250;

    private List<RadioButton> plateiaA;
    private List<RadioButton> plateiaB;
    private List<RadioButton> frisa;
    private List<RadioButton> camarote;
    private List<RadioButton> balcaoNobre;

    private Map<String, Integer> ingressosVendidosPorPeca;
    private Map<String, Integer> receitaPorPeca;
    private Map<String, Map<String, Integer>> ocupacaoPorSessao;

    public GerenciadorAssentos(List<RadioButton> plateiaA, List<RadioButton> plateiaB, List<RadioButton> frisa, List<RadioButton> camarote, List<RadioButton> balcaoNobre) {
        this.plateiaA = plateiaA;
        this.plateiaB = plateiaB;
        this.frisa = frisa;
        this.camarote = camarote;
        this.balcaoNobre = balcaoNobre;

        ingressosVendidosPorPeca = new HashMap<>();
        receitaPorPeca = new HashMap<>();
        ocupacaoPorSessao = new HashMap<>();
    }

    // Método para obter todos os assentos
    public List<RadioButton> obterAssentos() {
        List<RadioButton> todosAssentos = new ArrayList<>();
        if (plateiaA != null) todosAssentos.addAll(plateiaA);
        if (plateiaB != null) todosAssentos.addAll(plateiaB);
        if (frisa != null) todosAssentos.addAll(frisa);
        if (camarote != null) todosAssentos.addAll(camarote);
        if (balcaoNobre != null) todosAssentos.addAll(balcaoNobre);
        return todosAssentos;
    }

    // Método para calcular o preço total de uma lista de assentos
    public int calcularPrecoTotal(List<RadioButton> assentosSelecionados) {
        int precoTotal = 0;

        for (RadioButton assento : assentosSelecionados) {
            if (plateiaA.contains(assento)) {
                precoTotal += PRECO_PLATEIA_A;
            } else if (plateiaB.contains(assento)) {
                precoTotal += PRECO_PLATEIA_B;
            } else if (frisa.contains(assento)) {
                precoTotal += PRECO_FRISA;
            } else if (camarote.contains(assento)) {
                precoTotal += PRECO_CAMAROTE;
            } else if (balcaoNobre.contains(assento)) {
                precoTotal += PRECO_BALCAO_NOBRE;
            }
        }

        return precoTotal;
    }

    public void registrarVenda(String peca, String sessao, List<String> assentosVendidos, int precoTotal) {
        ingressosVendidosPorPeca.put(peca, ingressosVendidosPorPeca.getOrDefault(peca, 0) + assentosVendidos.size());
        receitaPorPeca.put(peca, receitaPorPeca.getOrDefault(peca, 0) + precoTotal);

        ocupacaoPorSessao.putIfAbsent(peca, new HashMap<>());
        Map<String, Integer> sessoes = ocupacaoPorSessao.get(peca);
        sessoes.put(sessao, sessoes.getOrDefault(sessao, 0) + assentosVendidos.size());
    }

    public String obterPecaMaisEMenosOcupada() {
        String maisVendida = null, menosVendida = null;
        int maxVendas = Integer.MIN_VALUE, minVendas = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : ingressosVendidosPorPeca.entrySet()) {
            String peca = entry.getKey();
            int vendidos = entry.getValue();

            if (vendidos > maxVendas) {
                maxVendas = vendidos;
                maisVendida = peca;
            }

            if (vendidos < minVendas) {
                minVendas = vendidos;
                menosVendida = peca;
            }
        }

        return String.format("Peça mais vendida: %s (%d ingressos)\nPeça menos vendida: %s (%d ingressos)",
                maisVendida, maxVendas, menosVendida, minVendas);
    }

    public String calcularLucratividadePorPeca() {
        String maisLucrativa = null, menosLucrativa = null;
        int maxLucro = Integer.MIN_VALUE, minLucro = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : receitaPorPeca.entrySet()) {
            String peca = entry.getKey();
            int lucro = entry.getValue();

            if (lucro > maxLucro) {
                maxLucro = lucro;
                maisLucrativa = peca;
            }

            if (lucro < minLucro) {
                minLucro = lucro;
                menosLucrativa = peca;
            }
        }

        return String.format("Peça mais lucrativa: %s (R$ %d)\nPeça menos lucrativa: %s (R$ %d)",
                maisLucrativa, maxLucro, menosLucrativa, minLucro);
    }

    public double calcularMediaLucroPorPeca() {
        int totalLucro = receitaPorPeca.values().stream().mapToInt(Integer::intValue).sum();
        return receitaPorPeca.isEmpty() ? 0 : (double) totalLucro / receitaPorPeca.size();
    }

    public String calcularOcupacaoPorSessao() {
        String sessaoMaisOcupada = null, sessaoMenosOcupada = null;
        int maxOcupacao = Integer.MIN_VALUE, minOcupacao = Integer.MAX_VALUE;

        for (Map<String, Integer> sessoes : ocupacaoPorSessao.values()) {
            for (Map.Entry<String, Integer> entry : sessoes.entrySet()) {
                String sessao = entry.getKey();
                int ocupacao = entry.getValue();

                if (ocupacao > maxOcupacao) {
                    maxOcupacao = ocupacao;
                    sessaoMaisOcupada = sessao;
                }

                if (ocupacao < minOcupacao) {
                    minOcupacao = ocupacao;
                    sessaoMenosOcupada = sessao;
                }
            }
        }

        return String.format("Sessão mais ocupada: %s (%d assentos)\nSessão menos ocupada: %s (%d assentos)",
                sessaoMaisOcupada, maxOcupacao, sessaoMenosOcupada, minOcupacao);
    }
}
