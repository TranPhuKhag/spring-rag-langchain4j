package com.ai.SpringAiDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;



@Service
public class ChatServive {
    private final ChatModel chatModel;

    public ChatServive(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getReponse(String prompt) {
        return chatModel.call(prompt);

    }

    public String getReponseOptions(String prompt) {
        ChatResponse response = chatModel.call(
                new Prompt(
                        prompt, // "Generate the names of 5 famous pirates.",
                        OpenAiChatOptions.builder()
                                .model("nvidia/llama-3.1-nemotron-nano-8b-v1")
                                .temperature(0.4)
                                .build()
                ));
        return response.getResult().getOutput().getText();
    }
}

