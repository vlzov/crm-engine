package com.example.crm.customer;
import org.junit.jupiter.api.Test; import static org.assertj.core.api.Assertions.*;
class CustomerMapperTest { @Test void mapsEntityToDto(){var c=new Customer("Acme","a@b.test","123");var d=new CustomerMapper().toDto(c);assertThat(d.name()).isEqualTo("Acme");assertThat(d.email()).isEqualTo("a@b.test");} }
