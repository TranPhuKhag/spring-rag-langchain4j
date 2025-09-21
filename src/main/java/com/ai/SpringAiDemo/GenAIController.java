package com.ai.SpringAiDemo;

import com.ai.SpringAiDemo.Services.ImageService;
import com.ai.SpringAiDemo.Services.RecipeService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GenAIController {
    private final ChatServive chatServive;
    private final ImageService imageService;
    private final RecipeService recipeService;

    public GenAIController(ChatServive chatServive, ImageService imageService, RecipeService recipeService) {
        this.chatServive = chatServive;
        this.imageService = imageService;
        this.recipeService = recipeService;
    }
    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt) {
        return chatServive.getReponse(prompt);
    }
    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt) {
        return chatServive.getReponseOptions(prompt);
    }
    // Image Controller
    @GetMapping("generate-image")
    public void generateImages(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse imageResponse = imageService.generateImage(prompt);
        String imageUrl = imageResponse.getResult().getOutput().getUrl();
        // Chuyển hướng người dùng đến URL ( = HttpSerletResponse)
        response.sendRedirect(imageUrl);
    }
    @GetMapping("generate-image-options")
    public List<String> generateImagesOptions(HttpServletResponse response,
                                              @RequestParam String prompt,
                                              @RequestParam(defaultValue = "hd") String quality,
                                              @RequestParam(defaultValue = "1") int n,
                                              @RequestParam(defaultValue = "1024") int width,
                                              @RequestParam(defaultValue = "1024") int height) {
        ImageResponse imageResponse = imageService.generateImageOptions(prompt,quality,n,width,height);
        // Streams to get urls from ImageReponse
        List<String> imageUrls = imageResponse.getResults().stream()
                                .map(result ->result.getOutput().getUrl())
                                .toList();
        return imageUrls ;
    }
    @GetMapping("recipe-creator")
    public String recipseCreator(@RequestParam String ingredients,
                                 @RequestParam(defaultValue = "any") String cuisine,
                                 @RequestParam(defaultValue = "") String dietaryRestriction){
        return recipeService.createRecipe(ingredients,cuisine,dietaryRestriction);

    }
}
