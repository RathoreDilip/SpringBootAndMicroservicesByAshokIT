package com.example.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

// Load data into Vector Store DB.
@Configuration
public class DataLoader {

    @Autowired
    private VectorStore vectorStore;

    @PostConstruct
    public void init(){
        TokenTextSplitter tokenTextSplitter=
                new TokenTextSplitter(100,100,5,1000,true);

        ClassPathResource resource1=new ClassPathResource("spring-notes.txt");
        TextReader notesReader=new TextReader(resource1);
        List<Document> documents=tokenTextSplitter.split(notesReader.get());
        vectorStore.add(documents);

        ClassPathResource resource2=new ClassPathResource("products-data.txt");
        TextReader notesReader2=new TextReader(resource2);
        documents=tokenTextSplitter.split(notesReader2.get());
        vectorStore.add(documents);
    }


}
