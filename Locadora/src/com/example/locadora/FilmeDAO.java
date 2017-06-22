package com.example.locadora;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FilmeDAO {
	LocadoraHelper banco;
	SQLiteDatabase db;
	
	//Criar o banco no momento da criação do objeto helper
	public FilmeDAO(Context context){
		banco = new LocadoraHelper(context);
	}
	public String inserir(Filme filme){
		//Criar um map para receber os valores dos atributos
		ContentValues valores = new ContentValues();
		//Pasar os valores para o map
		valores.put(banco.NOME, filme.getNome());
		valores.put(banco.ANO, filme.getAno());
		valores.put(banco.GENERO, filme.getGenero());
		valores.put(banco.PAIS, filme.getPais());
		
		//Permitir escrita no banco 
		db = banco.getWritableDatabase();
		
		//Inserir o objeto no banco
		long resultado = db.insert(banco.NOME_TABELA, null, valores);
		db.close();
		//Verificando o resultado
		if(resultado > 0){
			return "Inserido com sucesso!";
		}else{
			return "Erro ao inserir";
		}
		
		
	}
	
	public Cursor listarTodos(){
		//Preparando o banco para leitura
		db = banco.getReadableDatabase();
		//Definindo os campos a serem buscados no banco
		String[] campos = {banco.ID, banco.NOME, banco.ANO, banco.GENERO, banco.PAIS};
		
		//Fazendo a consulta
		Cursor cursor  = db.query(banco.NOME_TABELA, campos, null, null, null, null, null);
		if(cursor != null){
			cursor.moveToFirst();
		}
		db.close();
		return cursor;
	}
	
	public Cursor consultarPeloId(long id){
		// Definir is campos a serem buscandos
		String[] campos = { banco.ID, banco.NOME, banco.ANO, banco.GENERO, banco.PAIS };
		// Tornar o readable
		db = banco.getReadableDatabase();
		// Definir a cláusula where
		String selection = banco.ID + "=" + id;
		Cursor cursor = db.query(banco.NOME_TABELA, campos, selection, null,
				null, null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}
		db.close();
		return cursor;
	}
	
	public void alterar(Filme filme){
		//Definir os campos 
		ContentValues valores = new ContentValues();
		
		valores.put(banco.NOME, filme.getNome());
		valores.put(banco.ANO, filme.getAno());
		valores.put(banco.GENERO, filme.getGenero());
		valores.put(banco.PAIS, filme.getPais());
		
		db = banco.getWritableDatabase();
		String whereClause = banco.ID + "=" + filme.getId();
		
		db.update(banco.NOME_TABELA, valores, whereClause, null);
		db.close();
	}
	
	public void excluir(long id){
		db = banco.getWritableDatabase();
		String whereClause = banco.ID + "=" + id;
		db.delete(banco.NOME_TABELA, whereClause, null);
		db.close();
	}

}
