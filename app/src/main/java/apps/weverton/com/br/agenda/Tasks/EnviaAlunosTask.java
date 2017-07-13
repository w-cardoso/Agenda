package apps.weverton.com.br.agenda.Tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import apps.weverton.com.br.agenda.Dao.AlunoDao;
import apps.weverton.com.br.agenda.Model.AlunoModel;
import apps.weverton.com.br.agenda.Web.WebClient;
import apps.weverton.com.br.agenda.converter.AlunoConverter;


/**
 * Created by renan on 20/01/16.
 */
public class EnviaAlunosTask extends AsyncTask<Void, Void, String> {
    private Context context;
    private ProgressDialog dialog;

    public EnviaAlunosTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Enviando alunos...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {
        AlunoDao dao = new AlunoDao(context);
        List<AlunoModel> alunos = dao.buscaAlunos();
        dao.close();

        AlunoConverter conversor = new AlunoConverter();
        String json = conversor.converteParaJSON(alunos);

        WebClient client = new WebClient();
        String resposta = client.post(json);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}
