package Teatro_projeto_teatro_parte1.Entities.Model.DAO;

import Teatro_projeto_teatro_parte1.Entities.Exceptions.ErroDeValidacao;

import java.util.Set;

public class ModelUsuario {
    private String cpf = "";
    private String senha, nome, ddd, endereco, complemento, numero, dataDeNascimento;

    public ModelUsuario(String nome, String cpf, String ddd, String endereco, String complemento, String numero, String senha, String dataDeNascimento) throws ErroDeValidacao {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDDD(ddd);
        this.endereco = endereco;
        this.complemento = complemento;
        this.setNumero(numero);
        this.senha = senha;
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setNome(String nome) throws ErroDeValidacao {
        if (nome.isBlank())
            throw new ErroDeValidacao("Nome não pode ser vazio");

        boolean temCaracteresInvalidos = !nome.replaceAll("[a-zA-Zà-úÀ-ÚçÇ ]", "").isEmpty();
        if (temCaracteresInvalidos)
            throw new ErroDeValidacao("Nome não pode ter caracteres inválidos");

        this.nome = nome.replaceAll("\\s{2,}", " ").trim();
    }

    public void setCpf(String cpf) {
        if (!this.validarFormatoCPF(cpf))
            throw new ErroDeValidacao("O CPF deve ser inserido no formato: 000.000.000-00.");

        if (!this.validarCPF(cpf))
            throw new ErroDeValidacao("CPF inválido! Digite um CPF verdadeiro.");

        this.cpf = cpf;
    }

    public void setNumero(String numero) throws ErroDeValidacao {
        if (numero.isBlank()) {
            throw new ErroDeValidacao("Número não pode ser vazio.");
        }

        if (!numero.matches("\\d+")) {
            throw new ErroDeValidacao("Número deve conter apenas dígitos.");
        }

        if (!(numero.length() == 9)) {
            throw new ErroDeValidacao("Número deve ter 9 dígitos.");
        }

        if (numero.charAt(0) != '9') {
            throw new ErroDeValidacao("O primeiro dígito do número deve ser '9'.");
        }

        this.numero = numero;
    }

    public void setDDD(String ddd) throws ErroDeValidacao {
        final Set<String> dddsValidos = Set.of(
                "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "21", "22", "24", "27", "28",
                "31", "32", "33", "34", "35", "37", "38",
                "41", "42", "43", "44", "45", "46",
                "47", "48", "49",
                "51", "53", "54", "55",
                "61", "62", "63", "64", "65", "66", "67",
                "68", "69",
                "71", "73", "74", "75", "77",
                "79",
                "81", "82", "83", "84", "85", "86", "87", "88", "89",
                "91", "92", "93", "94", "95", "96", "97", "98", "99"
        );

        if (ddd.isBlank()) {
            throw new ErroDeValidacao("DDD não pode ser vazio.");
        }

        if (ddd.length() != 2) {
            throw new ErroDeValidacao("DDD deve conter exatamente 2 dígitos.");
        }

        if (!ddd.matches("\\d{2}")) {
            throw new ErroDeValidacao("DDD deve conter apenas dígitos.");
        }

        if (!dddsValidos.contains(ddd)) {
            throw new ErroDeValidacao("DDD inválido. Informe um DDD válido no Brasil.");
        }

        this.ddd = ddd;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDdd() {
        return ddd;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }

    private boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] numeros = new int[11];
        for (int i = 0; i < 11; i++) {
            numeros[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += numeros[i] * (10 - i);
        }
        int digito1 = 11 - (soma1 % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += numeros[i] * (11 - i);
        }
        int digito2 = 11 - (soma2 % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        return digito1 == numeros[9] && digito2 == numeros[10];
    }

    private boolean validarFormatoCPF(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }
}

