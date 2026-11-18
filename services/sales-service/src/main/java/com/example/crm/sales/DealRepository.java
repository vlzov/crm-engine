package com.example.crm.sales; import org.springframework.data.jpa.repository.JpaRepository; import java.util.UUID; public interface DealRepository extends JpaRepository<Deal,UUID>{}
