package com.example.beans;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RagService {

    private ChatClient chatClient;

    private VectorStore vectorStore;

    public RagService(ChatClient.Builder chatBuilder,VectorStore vectorStore){
        this.chatClient=chatBuilder.build();
        this.vectorStore=vectorStore;
    }

    public String ask(String question){
        List<Document> documents = vectorStore.similaritySearch(SearchRequest.builder().topK(3).query(question).build());

        System.out.println("Documents Size : "+documents.size());

        System.out.println("--------------------------------------------");
        for (Document document:documents){
            System.out.println(document.getFormattedContent());
        }
        System.out.println("--------------------------------------------");

        if(documents.isEmpty())
            return "I Don't know What You are Asking";

        String context = documents.stream()
                                 //   .limit(3)
                                    .map(Document::getFormattedContent)
                                    .collect(Collectors.joining("\n"));

        System.out.println("Context : "+context);

        return chatClient.prompt()
                .system("""
                        You are a helpful AI Assistant.
                        Answer the question using only the provided context.
                        If the context does not contain the answer, say "I don't know"
                        """)
                .user("""
                        Questions: 
                        %s
                        
                        Context:
                        %s
                        
                        """.formatted(question,context))
                            .call()
                            .content();

    }

}
