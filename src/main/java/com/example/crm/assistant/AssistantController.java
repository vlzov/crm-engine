package com.example.crm.assistant;
import jakarta.validation.Valid; import jakarta.validation.constraints.NotBlank; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/assistant") public class AssistantController { record ChatRequest(@NotBlank String message){} record ChatResponse(String answer,String provider){} @PostMapping("/chat") public ChatResponse chat(@Valid @RequestBody ChatRequest r){return new ChatResponse("Mock assistant: запрос принят — подключение LLM будет добавлено позже.","mock");} }
