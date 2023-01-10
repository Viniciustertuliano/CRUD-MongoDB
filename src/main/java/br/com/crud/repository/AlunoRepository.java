package br.com.crud.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.LinkedList;
import java.util.List;

public class AlunoRepository {

    LinkedList listaAlunos = new LinkedList();
    public List getAlunos(MongoCollection collection){
        FindIterable<Document> alunos = collection.find();
        MongoCursor it = alunos.iterator();
        while(it.hasNext()){
            listaAlunos.add(it.next());
        }
        return listaAlunos;
    }

    public void addAluno(MongoCollection collection, String nome, String idade){
        Document novoAluno = new Document("nome", nome).append("idade", idade);
        collection.insertOne(novoAluno);
        System.out.println("Cadastrado com sucesso");
    }

    public void atualizaNomeAluno(MongoCollection collection, String nome, String novoNome){
        collection.updateOne(Filters.eq("nome", nome), Updates.set("nome", novoNome));
        List alunos = getAlunos(collection);
    }

    public void deletarAlunoPorNome(MongoCollection collection, String nome){
        collection.deleteOne(Filters.eq("nome", nome));
    }
}
