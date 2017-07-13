package apps.weverton.com.br.agenda.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by re034850 on 28/06/2017.
 */

public class ProvaModel implements Serializable {
    private String materia;
    private String data;
    private List<String> topicos;

    public ProvaModel(String materia, String data, List<String> topicos) {
        this.materia = materia;
        this.data = data;
        this.topicos = topicos;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<String> topicos) {
        this.topicos = topicos;
    }

    @Override
    public String toString() {
        return this.materia;
    }
}
