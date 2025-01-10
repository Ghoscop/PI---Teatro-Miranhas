package Teatro_projeto_teatro_parte1.Entities.Exceptions;

public class ErroDeValidacao extends IllegalArgumentException {
    public ErroDeValidacao(String message) {
        super(message);
    }
}
