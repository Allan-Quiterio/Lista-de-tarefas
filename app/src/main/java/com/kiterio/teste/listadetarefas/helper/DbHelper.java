package com.kiterio.teste.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    //Classe para criação do Banco de Dados

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";

    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //Serve para criar a primeira vez o Banco de Dados

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS +
                    " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " nome TEXT NOT NULL); ";

        try {
            sqLiteDatabase.execSQL(sql);
            Log.i("INFO DB","Sucesso ao criar a tabela");
        }catch (Exception e){
            Log.i("INFO DB","Erro ao criar a tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { //Serve para fazer uma atualização do Banco de Dados

        //String sql = "ALTER TABLE " + TABELA_TAREFAS+ " ADD COLUMN status VARCHAR(2)" ;  Alterando a tabela
        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;"; //Deletando a tabela

        try {
            sqLiteDatabase.execSQL(sql);
            onCreate(sqLiteDatabase);
            Log.i("INFO DB","Sucesso ao atualizar App");
        }catch (Exception e){
            Log.i("INFO DB","Erro ao atualizar App" + e.getMessage());
        }
    }




}
