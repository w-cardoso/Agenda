package apps.weverton.com.br.agenda;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import apps.weverton.com.br.agenda.Model.ProvaModel;

public class ProvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction tx = fragmentManager.beginTransaction();

        tx.replace(R.id.frame_principal, new ListaProvasFragment());
        if (estaNomodoPaisagem()) {
            tx.replace(R.id.frame_secundario, new DetalhesProvaFragment());
        }


        tx.commit();


    }

    private boolean estaNomodoPaisagem() {
        return getResources().getBoolean(R.bool.modoPaisagem);
    }

    public void selecionaProva(ProvaModel prova) {
        FragmentManager manager = getSupportFragmentManager();
        if (!estaNomodoPaisagem()) {
            FragmentTransaction tx = manager.beginTransaction();

            DetalhesProvaFragment detalhesFragment = new DetalhesProvaFragment();
            Bundle parametros = new Bundle();
            parametros.putSerializable("prova", prova);
            detalhesFragment.setArguments(parametros);

            tx.replace(R.id.frame_principal, detalhesFragment);
            tx.addToBackStack(null);
            tx.commit();
        } else {
            DetalhesProvaFragment detalhesFragment =
                    (DetalhesProvaFragment) manager.findFragmentById(R.id.frame_secundario);
            detalhesFragment.populaCamposcom(prova);
        }
    }
}
