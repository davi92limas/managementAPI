package com.usermanagement.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Subscription type entity for managing different subscription plans.
 */
@Entity
@Table(name = "subscriptions_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class SubscriptionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    @ToString.Include
    private Long id;

    @ToString.Include
    private String name;

    @Column(name = "access_months")
    private Integer accessMonths;

    private BigDecimal price;

    @Column(name = "product_key", unique = true)
    private String productKey;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionType that = (SubscriptionType) o;
        return Objects.equals(id, that.id) && 
               Objects.equals(productKey, that.productKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
