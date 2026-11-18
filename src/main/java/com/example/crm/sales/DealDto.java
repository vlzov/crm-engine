package com.example.crm.sales; import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
public record DealDto(UUID id,String title,BigDecimal amount,Deal.Stage stage,UUID customerId,Instant createdAt) {}
