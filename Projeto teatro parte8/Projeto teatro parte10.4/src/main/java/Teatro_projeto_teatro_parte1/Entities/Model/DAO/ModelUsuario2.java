package Teatro_projeto_teatro_parte1.Entities.Model.DAO;

import Teatro_projeto_teatro_parte1.Entities.Exceptions.ErroDeValidacao;

public class ModelUsuario2 {
    private String cpf = "";


    public ModelUsuario2(String nome, String cpf, String ddd, String endereco, String complemento, String numero, String senha, String dataDeNascimento) throws ErroDeValidacao {
        this.setCpf(cpf);
    }

    public void setCpf(String cpf) {
        if (!this.validarFormatoCPF(cpf))
            throw new ErroDeValidacao("O CPF deve ser inserido no formato: 000.000.000-00.");

        if (!this.validarCPF(cpf))
            throw new ErroDeValidacao("CPF inválido! Digite um CPF verdadeiro.");

        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
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



