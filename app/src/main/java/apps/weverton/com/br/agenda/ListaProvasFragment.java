package apps.weverton.com.br.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import apps.weverton.com.br.agenda.Model.ProvaModel;

/**
 * Created by re034850 on 28/06/2017.
 */

public class ListaProvasFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_provas, container, false);

        List<String> topicosPort = Arrays.asList("Sujeito", "Objeto Direto", "Objeto Indireto");
        ProvaModel provaPortugues = new ProvaModel("Portugues", "25/05/2016", topicosPort);

        List<String> topicosMat = Arrays.asList("Segundo Grau", "Trigonometria");
        ProvaModel provaMatematica = new ProvaModel("Matematica", "27/05/2016", topicosMat);

        List<ProvaModel> provas = Arrays.asList(provaPortugues, provaMatematica);

        ArrayAdapter<ProvaModel> adapter = new ArrayAdapter<ProvaModel>(getContext(), android.R.layout.simple_list_item_1, provas);

        ListView lista = (ListView) view.findViewById(R.id.provas_lista);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProvaModel prova = (ProvaModel) parent.getItemAtPosition(position);
                Toast.makeText(getContext(), "Clicou na Prova de " + prova, Toast.LENGTH_SHORT).show();


                ProvasActivity provasActivity = (ProvasActivity) getActivity();
                provasActivity.selecionaProva(prova);

            }
        });


        return view;
    }
}
