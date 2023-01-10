package br.com.crud;

import br.com.crud.repository.AlunoRepository;
import com.mongodb.MongoCredential;
import com.mongodb.client.*;

import java.util.List;

import org.bson.Document;

public class Main {

    public static void main(String[] args) {

        AlunoRepository repository = new AlunoRepository();

        MongoClient mongoClient = MongoClients.create("mongodb://root:123@localhost:27017/?authSource=admin");

        MongoCredential credential = MongoCredential.createCredential("java", "escola","123".toCharArray());

        MongoDatabase escolaDB = mongoClient.getDatabase("escola");
        MongoCollection<Document> collection = escolaDB.getCollection("alunos");
        List listaAlunos = repository.getAlunos(collection);


        System.out.println(credential);
        System.out.println(escolaDB.getName());
        System.out.println(collection.getNamespace().getCollectionName());

        repository.addAluno(collection, "Cecilia", "7");
        repository.addAluno(collection, "Thayna", "23");
        listaAlunos.forEach(a -> System.out.println(a));

        repository.atualizaNomeAluno(collection,"Sueli", "vinicius");
        listaAlunos.forEach(a -> System.out.println(a));

        repository.deletarAlunoPorNome(collection, "vinicius");
        listaAlunos.forEach(a -> System.out.println(a));
    }
}