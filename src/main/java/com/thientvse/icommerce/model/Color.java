package com.thientvse.icommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "color")
public class Color {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


}
