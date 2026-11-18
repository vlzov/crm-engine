package com.example.crm.task; import java.time.LocalDate; import java.util.UUID; public record TaskDto(UUID id,String title,LocalDate dueDate,boolean completed,UUID customerId,UUID dealId) {}
