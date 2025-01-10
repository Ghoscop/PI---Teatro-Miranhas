package Teatro_projeto_teatro_parte1.Entities.Model.BO;

import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario2;

import java.io.*;
import java.util.List;

public class SalvarDados2 {

    private static final String RESOURCES_PATH = "arquivos/resources";

    public static void salvarDadosUsuarios(List<ModelUsuario2> listaUsuarios) {
        try {
            File pastaResources = new File(RESOURCES_PATH);
            if (!pastaResources.exists()) {
                if (!pastaResources.mkdirs()) {
                    throw new IOException("Não foi possível criar a pasta resources.");
                }
            }

            String caminhoTxt = RESOURCES_PATH + "/out2.txt";
            String caminhoCsv = RESOURCES_PATH + "/out2.csv";

            salvarUsuariosEmTxt(listaUsuarios, caminhoTxt);
            salvarUsuariosEmCsv(listaUsuarios, caminhoCsv);

        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void salvarUsuariosEmTxt(List<ModelUsuario2> listaUsuarios, String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (ModelUsuario2 usuario : listaUsuarios) {
                // Escreve CPF no formato "CPF: <valor>"
                writer.write(String.format("CPF: %s", usuario.getCpf()));
                writer.newLine();
            }
        }
    }

    private static void salvarUsuariosEmCsv(List<ModelUsuario2> listaUsuarios, String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("CPF");
            writer.newLine();

            for (ModelUsuario2 usuario : listaUsuarios) {
                writer.write(String.format("\"%s\"", usuario.getCpf()));
                writer.newLine();
            }
        }
    }
}