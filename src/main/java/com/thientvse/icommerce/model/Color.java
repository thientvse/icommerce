package com.thientvse.icommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "color")
public class Color {
    @Id
    @Column(name = "color_id")
    private Integer colorId;

    @Column(name = "color_name")
    private String colorName;

    public Integer getColorId() {
        return this.colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return this.colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
