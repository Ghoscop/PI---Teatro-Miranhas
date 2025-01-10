package Teatro_projeto_teatro_parte1.Entities.Model.BO;

import Teatro_projeto_teatro_parte1.Entities.Exceptions.ErroDeValidacao;

public class SalvarPeca {
    private static String pecaEscolhida;
    private static String horarioEscolhido;

    public SalvarPeca(String pecaEscolhida, String horarioEscolhido) throws ErroDeValidacao {
        setPecaEscolhida(pecaEscolhida);
        setHorarioEscolhido(horarioEscolhido);
    }

    public static String getPecaEscolhida() {
        return pecaEscolhida;
    }

    public static void setPecaEscolhida(String pecaEscolhida) throws ErroDeValidacao {
        if (pecaEscolhida == null || pecaEscolhida.isBlank()) {
            throw new ErroDeValidacao("A peça escolhida não pode ser vazia.");
        }
        SalvarPeca.pecaEscolhida = pecaEscolhida;
    }

    public static String getHorarioEscolhido() {
        return horarioEscolhido;
    }

    public static void setHorarioEscolhido(String horarioEscolhido) throws ErroDeValidacao {
        if (horarioEscolhido == null || horarioEscolhido.isBlank()) {
            throw new ErroDeValidacao("O horário escolhido não pode ser vazio.");
        }
        SalvarPeca.horarioEscolhido = horarioEscolhido;
    }
}
