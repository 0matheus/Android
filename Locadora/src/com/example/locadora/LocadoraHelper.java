package com.example.locadora;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LocadoraHelper extends SQLiteOpenHelper {
	
	static final String NOME_BANCO = "locadora.db";
	static final String NOME_TABELA = "filme";
	static final String ID = "_id";
	static final String NOME = "nome";
	static final String ANO = "ano";
	static final String GENERO = "genero";
	static final String PAIS = "pais";
	static final int VERSAO = 1;
	
	public LocadoraHelper (Context context){
		super(context, NOME_BANCO, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE " + NOME_TABELA);
		sql.append("(" + ID);
		sql.append(" integer primary key autoincrement,");
		sql.append(NOME    + " text,");
		sql.append(ANO     + " integer,");
		sql.append(GENERO  + " text,");
		sql.append(PAIS    + " text)");
		
		try{
			db.execSQL(sql.toString());
		}catch(SQLException e){
			Log.e("CRIAR BANCO", e.getMessage());
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Verficando se a tabela existe
		db.execSQL("DROP TABLE IF EXISTS "+NOME_TABELA);
		onCreate(db);
		
	}

}
