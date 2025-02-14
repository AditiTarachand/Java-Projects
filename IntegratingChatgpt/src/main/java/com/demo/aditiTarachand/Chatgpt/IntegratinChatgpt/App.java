package com.demo.aditiTarachand.Chatgpt.IntegratinChatgpt;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.*;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * Hello world!
 *
 */
public class App
{
	private static final String API_URL="https://api.openai.com/v1/chat/completions";
	private static final  String API_KEY="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";
	
    public static void main( String[] args ) throws Exception
    {
    	String response= getChatgptResponse("How does AI work");
    	System.out.println("chatGpt"+ response);
        
    }

	public static String getChatgptResponse(String userMessage) throws Exception {
		
		// TODO Auto-generated method stub
		OkHttpClient client= new OkHttpClient();
		ObjectMapper objectMapper= new ObjectMapper();
		
		HashMap<String, Object> requestBody = new HashMap<>();
		requestBody.put("model", "gpt-4");
		requestBody.put("message", List.of(
				Map.of("role", "system", "content", "You are a helpful assistant."),
				Map.of("role", "user", "content", userMessage)
				
				));
		requestBody.put("temperature", 0.7);
		
		String jsonPayLoad = objectMapper.writeValueAsString(requestBody);
		
		Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(jsonPayLoad, MediaType.get("application/json")))
                .build();

        // Execute request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new Exception("Unexpected code " + response);
            Map<String, Object> responseMap = objectMapper.readValue(response.body().string(), Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) responseMap.get("choices");
            return choices.get(0).get("message").toString();
        }
		
	}

	
}
