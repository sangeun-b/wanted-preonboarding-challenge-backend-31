package org.example.server.product.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_details")
public class ProductDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(precision = 10, scale = 2)
    private BigDecimal weight;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb", name = "dimensions")
    private Map<String,Object> dimension = new HashMap<>();

    @Column(name = "materials")
    private String material;

    @Column(name = "country_of_origin", length = 100)
    private String countryOfOrigin;

    @Column(name = "warranty_info")
    private String warrantyInfo;

    @Column(name = "care_instructions")
    private String careInstructions;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb", name = "additional_info")
    private Map<String,Object> additionalInfo;

    @Builder
    public ProductDetail(Long id, Product product, BigDecimal weight, Map<String, Object> dimension, String material, String countryOfOrigin, String warrantyInfo, String careInstructions, Map<String, Object> additionalInfo) {
        this.id = id;
        this.product = product;
        this.weight = weight;
        this.dimension = dimension;
        this.material = material;
        this.countryOfOrigin = countryOfOrigin;
        this.warrantyInfo = warrantyInfo;
        this.careInstructions = careInstructions;
    }
}
