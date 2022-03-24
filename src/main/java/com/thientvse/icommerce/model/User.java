package com.thientvse.icommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class User {
    @Id
    @Column(name = "id")
    private Long userId;

    /*@Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;*/

    @Column(name = "email")
    private String email;

   /* @Column(name = "address")
    private String address;*/

    @Column(name = "phone_number")
    private String phoneNumber;

    /*@Column(name = "gender")
    private String gender;

    @Column(name = "user_name")
    private String userName;*/




}
