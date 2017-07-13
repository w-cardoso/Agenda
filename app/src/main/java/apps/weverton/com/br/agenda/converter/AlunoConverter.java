package apps.weverton.com.br.agenda.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import apps.weverton.com.br.agenda.Model.AlunoModel;


/**
 * Created by renan on 15/01/16.
 */
public class AlunoConverter {
    public String converteParaJSON(List<AlunoModel> alunos) {
        JSONStringer js = new JSONStringer();

        try {
            js.object().key("list").array().object().key("aluno").array();
            for (AlunoModel aluno : alunos) {
                js.object();
                js.key("nome").value(aluno.getNome());
                js.key("nota").value(aluno.getNota());
                js.endObject();
            }
            js.endArray().endObject().endArray().endObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return js.toString();
    }
}
