package com.thientvse.icommerce.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;


    /*@Column(name = "product_id")
    private Integer productId;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

   /* @Column(name = "user_id")
    private Integer userId;*/

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private String amount;


    @Column(name = "date")
    @UpdateTimestamp
    private LocalDateTime date;


   /* @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;*/

}
