package apps.weverton.com.br.agenda;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import apps.weverton.com.br.agenda.Model.AlunoModel;

/**
 * Created by re034850 on 19/06/2017.
 */

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    private final RatingBar campoNota;
    private final ImageView campoFoto;

    private AlunoModel aluno;


    public FormularioHelper(FormularioActivity activity) {

        campoNome = (EditText) activity.findViewById(R.id.formularioEdtNome);
        campoEndereco = (EditText) activity.findViewById(R.id.formularioEdtEndereco);
        campoTelefone = (EditText) activity.findViewById(R.id.formularioEdtTelefone);
        campoSite = (EditText) activity.findViewById(R.id.formularioEdtSite);
        campoNota = (RatingBar) activity.findViewById(R.id.formularioRtbNota);
        campoFoto = (ImageView) activity.findViewById(R.id.formularioImgFoto);
        aluno = new AlunoModel();

    }

    public AlunoModel pegaAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));
        aluno.setCaminhoFoto((String) campoFoto.getTag());
        return aluno;

    }

    public void preencherFormulario(AlunoModel aluno) {
        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());
        campoSite.setText(aluno.getSite());
        campoNota.setProgress(aluno.getNota().intValue());
        carregaImagem(aluno.getCaminhoFoto());
        this.aluno = aluno;

    }

    public void carregaImagem(String caminhoFoto) {
        if (caminhoFoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            campoFoto.setTag(caminhoFoto);
        }
    }
}
