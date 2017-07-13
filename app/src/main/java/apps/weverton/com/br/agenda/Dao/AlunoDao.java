package apps.weverton.com.br.agenda.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;


import java.util.ArrayList;
import java.util.List;

import apps.weverton.com.br.agenda.Model.AlunoModel;

/**
 * Created by re034850 on 19/06/2017.
 */

public class AlunoDao extends SQLiteOpenHelper {

    public AlunoDao(Context context) {
        super(context, "Agenda", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "endereco TEXT, " +
                "telefone TEXT, " +
                "site TEXT, " +
                "nota REAL, " +
                "caminhoFoto TEXT);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "";
        switch (oldVersion){
            case 1:
                sql = "ALTER TABLE Alunos ADD COLUMN caminhoFoto TEXT";
                db.execSQL(sql);
        }
    }

    public void inserir(AlunoModel aluno) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDoAluno(aluno);
        db.insert("Alunos", null, dados);

    }

    public void alterar(AlunoModel aluno) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosDoAluno(aluno);
        String[] parametros = {aluno.getId().toString()};
        db.update("Alunos", dados, "id = ?", parametros);

    }

    public void deletar(AlunoModel aluno) {

        SQLiteDatabase db = getWritableDatabase();
        String[] parametros = {aluno.getId().toString()};
        db.delete("Alunos", "id = ?", parametros);

    }


    public List<AlunoModel> buscaAlunos() {
        String sql = "SELECT * FROM Alunos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<AlunoModel> alunos = new ArrayList<>();
        while (c.moveToNext()) {
            AlunoModel aluno = new AlunoModel();
            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setEndereco(c.getString(c.getColumnIndex("endereco")));
            aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
            aluno.setSite(c.getString(c.getColumnIndex("site")));
            aluno.setNota(c.getDouble(c.getColumnIndex("nota")));
            aluno.setCaminhoFoto(c.getString(c.getColumnIndex("caminhoFoto")));
            alunos.add(aluno);
        }
        c.close();
        return alunos;
    }


    @NonNull
    private ContentValues pegaDadosDoAluno(AlunoModel aluno) {
        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("endereco", aluno.getEndereco());
        dados.put("telefone", aluno.getTelefone());
        dados.put("site", aluno.getSite());
        dados.put("nota", aluno.getNota());
        dados.put("caminhoFoto", aluno.getCaminhoFoto());
        return dados;
    }




}
