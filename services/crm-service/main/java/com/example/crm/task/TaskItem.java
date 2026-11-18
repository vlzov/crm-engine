package com.example.crm.task;
import jakarta.persistence.*; import lombok.*; import java.time.*; import java.util.UUID;
@Entity @Getter @Setter @NoArgsConstructor public class TaskItem { @Id @GeneratedValue(strategy=GenerationType.UUID) UUID id; @Column(nullable=false) String title; LocalDate dueDate; boolean completed; UUID customerId; UUID dealId; public TaskItem(String title,LocalDate dueDate,UUID customerId,UUID dealId){this.title=title;this.dueDate=dueDate;this.customerId=customerId;this.dealId=dealId;} }
