package apps.weverton.com.br.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import apps.weverton.com.br.agenda.Model.ProvaModel;

public class DetalhesProvaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_prova);

        Intent intent = getIntent();
        ProvaModel prova = (ProvaModel) intent.getSerializableExtra("provas");

        TextView materia = (TextView) findViewById(R.id.detalhes_prova_materia);
        TextView data = (TextView) findViewById(R.id.detalhes_prova_data);
        ListView listaTopicos = (ListView) findViewById(R.id.detalhes_prova_topicos);

        materia.setText(prova.getMateria());
        data.setText(prova.getData());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prova.getTopicos());
        listaTopicos.setAdapter(adapter);



    }
}
