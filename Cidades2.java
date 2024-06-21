import java.util.ArrayList;
import java.util.List;

class Cidade {
    String nome;
    int codigo;
    int quantidadeVeiculos;
    int numeroAcidentes;

    public Cidade(String nome, int codigo, int quantidadeVeiculos, int numeroAcidentes) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidadeVeiculos = quantidadeVeiculos;
        this.numeroAcidentes = numeroAcidentes;
    }

    public double calcularMediaAcidentes() {
        return (double) numeroAcidentes / quantidadeVeiculos;
    }

    @Override
    public String toString() {
        return nome + " (Código: " + codigo + ")";
    }
}

public class PesquisaCidades {

    public static void main(String[] args) {
        // Dados de exemplo
        List<Cidade> cidades = new ArrayList<>();
        cidades.add(new Cidade("Maringá", 1, 150000, 300));
        cidades.add(new Cidade("Londrina", 2, 200000, 400));
        cidades.add(new Cidade("Cascavel", 3, 100000, 200));
        cidades.add(new Cidade("Ponta Grossa", 4, 80000, 160));
        cidades.add(new Cidade("Foz do Iguaçu", 5, 120000, 240));

        // Calculando a cidade com o maior e menor número de acidentes
        Cidade cidadeMaiorNumeroAcidentes = cidades.get(0);
        Cidade cidadeMenorNumeroAcidentes = cidades.get(0);

        for (Cidade cidade : cidades) {
            if (cidade.numeroAcidentes > cidadeMaiorNumeroAcidentes.numeroAcidentes) {
                cidadeMaiorNumeroAcidentes = cidade;
            }
            if (cidade.numeroAcidentes < cidadeMenorNumeroAcidentes.numeroAcidentes) {
                cidadeMenorNumeroAcidentes = cidade;
            }
        }

        System.out.println("Cidade com maior número de acidentes: " + cidadeMaiorNumeroAcidentes);
        System.out.println("Cidade com menor número de acidentes: " + cidadeMenorNumeroAcidentes);

        // Calculando a média anual de acidentes de cada cidade por quantidade de veículos
        System.out.println("\nMédia anual de acidentes de cada cidade por quantidade de veículos:");
        for (Cidade cidade : cidades) {
            System.out.printf("%s: %.2f acidentes por veículo%n", cidade.nome, cidade.calcularMediaAcidentes());
        }

        // Calculando a média total de acidentes das cidades pesquisadas pela quantidade de veículos
        int totalVeiculos = 0;
        int totalAcidentes = 0;
        for (Cidade cidade : cidades) {
            totalVeiculos += cidade.quantidadeVeiculos;
            totalAcidentes += cidade.numeroAcidentes;
        }
        double mediaTotalAcidentes = (double) totalAcidentes / totalVeiculos;

        System.out.printf("\nMédia total de acidentes das cidades pesquisadas por quantidade de veículos: %.2f acidentes por veículo%n", mediaTotalAcidentes);
    }
}
