package com.ai.SpringAiDemo.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.Embedding;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.openai.OpenAiEmbeddingModel;
import org.springframework.ai.openai.OpenAiEmbeddingOptions;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenAiServiceImpl {
//
//    private final EmbeddingModel embeddingModel;
//    // OpenAiEmbeddingClient = EmbeddingModel
//    private final VectorStore vectorStore;
//
//    public List<float[]> embeddingExample() {
//        EmbeddingResponse embeddingResponse = embeddingModel.call(
//                new EmbeddingRequest(List.of("Hello World", "World is big and salvation is near"),
//                        OpenAiEmbeddingOptions.builder()
//                                .model("text-embedding-ada-002")
//                                .build()));
//        List<Embedding> results = embeddingResponse.getResults();
//        List<float[]> embeddings = results.stream()
//                .map(Embedding::getOutput)
//                .collect(Collectors.toList());
//
//        log.info("Embedding example results: {}", embeddings);
//        return embeddings;
//    }
//    public void saveEmbedding() {
//        List<Document> documents = List.of(
//                new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("meta1", "meta1")),
//                new Document("The World is Big and Salvation Lurks Around the Corner"),
//                new Document("You walk forward facing the past and you turn back toward the future.", Map.of("meta2", "meta2")));
//        // Add the documents to PGVector
//        vectorStore.add(documents);
//
//// Retrieve documents similar to a query
//        List<Document> results = this.vectorStore.similaritySearch(SearchRequest.builder().query("Spring").topK(5).build());
//    }
}
