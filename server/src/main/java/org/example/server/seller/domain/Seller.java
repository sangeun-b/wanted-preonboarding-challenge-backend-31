package org.example.server.seller.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.server.util.CreatedOnlyEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="sellers")
public class Seller extends CreatedOnlyEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private String description;

    @Column(name="logo_url")
    private String logoUrl;

    @Column(precision = 3, scale = 2)
    private BigDecimal rating;

    @Column(name="contact_email", length = 100)
    private String contactEmail;

    @Column(name="contact_phone", length = 20)
    private String contactPhone;


}
