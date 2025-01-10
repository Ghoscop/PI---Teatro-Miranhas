package Teatro_projeto_teatro_parte1.Entities.Model.BO;

import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalvarDados {

    private static final String RESOURCES_PATH = "arquivos/resources";

    public static void salvarDadosUsuarios(List<ModelUsuario> listaUsuarios) {
        try {
            File pastaResources = new File(RESOURCES_PATH);
            if (!pastaResources.exists()) {
                if (!pastaResources.mkdirs()) {
                    throw new IOException("Não foi possível criar a pasta resources.");
                }
            }

            String caminhoTxt = RESOURCES_PATH + "/out.txt";
            String caminhoCsv = RESOURCES_PATH + "/out.csv";

            salvarUsuariosEmTxt(listaUsuarios, caminhoTxt);
            salvarUsuariosEmCsv(listaUsuarios, caminhoCsv);

        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void salvarUsuariosEmTxt(List<ModelUsuario> listaUsuarios, String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (ModelUsuario usuario : listaUsuarios) {
                writer.write(String.format(
                        "Nome: %s, CPF: %s, Telefone: %s %s, Endereço: %s, Complemento: %s, Senha: %s, Data de Nascimento: %s",
                        usuario.getNome(),
                        usuario.getCpf(),
                        usuario.getDdd(),
                        usuario.getNumero(),
                        usuario.getEndereco(),
                        usuario.getComplemento(),
                        usuario.getSenha(),
                        usuario.getDataDeNascimento()));
                writer.newLine();
            }
        }
    }

    private static void salvarUsuariosEmCsv(List<ModelUsuario> listaUsuarios, String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("Nome,CPF,Telefone,Endereço,Complemento,Senha,Data de Nascimento");
            writer.newLine();

            for (ModelUsuario usuario : listaUsuarios) {
                writer.write(String.format("\"%s\",\"%s\",\"%s %s\",\"%s\",\"%s\",\"%s\",\"%s\"",
                        usuario.getNome(),
                        usuario.getCpf(),
                        usuario.getDdd(),
                        usuario.getNumero(),
                        usuario.getEndereco(),
                        usuario.getComplemento(),
                        usuario.getSenha(),
                        usuario.getDataDeNascimento()));
                writer.newLine();
            }
        }
    }

    public static void salvarAssentosA(List<String> assentosSelecionados) {
        String caminhoArquivo = RESOURCES_PATH + "/assentos_selecionadosA.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            for (String assento : assentosSelecionados) {
                writer.write(assento);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os assentos selecionados: " + e.getMessage());
        }
    }

    public static List<String> carregarAssentosA() {
        String caminhoArquivo = RESOURCES_PATH + "/assentos_selecionadosA.txt";
        List<String> assentosSelecionados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                assentosSelecionados.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Nenhum assento salvo encontrado.");
        }
        return assentosSelecionados;
    }
    public static void salvarAssentosB(List<String> assentosSelecionados2) {
        String caminhoArquivo = RESOURCES_PATH + "/assentos_selecionadosB.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            for (String assento : assentosSelecionados2) {
                writer.write(assento);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os assentos selecionados: " + e.getMessage());
        }
    }

    public static List<String> carregarAssentosB() {
        String caminhoArquivo = RESOURCES_PATH + "/assentos_selecionadosB.txt";
        List<String> assentosSelecionados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                assentosSelecionados.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Nenhum assento salvo encontrado.");
        }
        return assentosSelecionados;
    }
    public static void salvarAssentosC(List<String> assentosSelecionados3) {
        String caminhoArquivo = RESOURCES_PATH + "/assentos_selecionadosC.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            for (String assento : assentosSelecionados3) {
                writer.write(assento);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os assentos selecionados: " + e.getMessage());
        }
    }

    public static List<String> carregarAssentosC() {
        String caminhoArquivo = RESOURCES_PATH + "/assentos_selecionadosC.txt";
        List<String> assentosSelecionados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                assentosSelecionados.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Nenhum assento salvo encontrado.");
        }
        return assentosSelecionados;
    }
}
