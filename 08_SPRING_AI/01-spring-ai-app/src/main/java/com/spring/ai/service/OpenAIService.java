package com.spring.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
//import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAIService {

    // spring ai interface (impl class will be provided by LLM provider)
    private ChatClient chatClient; // spring ai - recommended spring ai

    @Autowired
    private ImageModel imageModel;

    // private OpenAiChatModel openAiChatModel; // open ai

//    public OpenAIService(ChatClient.Builder builder){
//        this.chatClient=builder.build();           // stateless client
//        System.out.println("Class Name: "+this.chatClient.getClass().getName());   // org.springframework.ai.chat.client.DefaultChatClient
//    }

    // making chatClient stateful
    public OpenAIService(ChatClient.Builder builder, ChatMemory chatMemory){
        chatClient=builder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
    }

    public String askAnything(String question){
        return chatClient.prompt().user(question).call().content();
    }

    public String getTravelGuidence(String place,String month,String language,String budget){
        PromptTemplate promptTemplate = new PromptTemplate(
                "Welcome to the {place} travel guide!\n"
                        + "If you're visiting in {month}, here's what you can do:\n"
                        + "1. Must-visit attractions.\n"
                        + "2. Local cuisine you must try.\n"
                        + "3. Useful phrases in {language}.\n"
                        + "4. Tips for traveling on a {budget} budget.\n"
                        + "Enjoy your trip!"
        );

        Prompt prompt=promptTemplate.create(Map.of("place",place,"month",month,"language",language,"budget",budget));

        return chatClient.prompt(prompt).call().chatResponse().getResult().getOutput().getText();

    }

    public String generateImage(String prompt){

        ImageResponse imageResponse =
                imageModel.call(new ImagePrompt(prompt, ImageOptionsBuilder.builder().height(1024).width(1024).N(1).build()));

        return imageResponse.getResult().getOutput().getUrl();

    }


}
