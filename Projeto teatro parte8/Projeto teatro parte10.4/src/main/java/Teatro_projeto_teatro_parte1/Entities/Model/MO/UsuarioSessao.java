package Teatro_projeto_teatro_parte1.Entities.Model.MO;

import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario;
import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario2;

public class UsuarioSessao {
    private static ModelUsuario usuario;
    private static ModelUsuario2 usuario2;

    public static ModelUsuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(ModelUsuario usuario) {
        UsuarioSessao.usuario = usuario;
    }

    public static ModelUsuario2 getUsuario2() {
        return usuario2;
    }
    public static void setUsuario2(ModelUsuario2 usuario) {
        UsuarioSessao.usuario2 = usuario;
    }

    }
