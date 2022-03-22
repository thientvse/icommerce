package com.thientvse.icommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "attribute_value")
@SecondaryTables({
        @SecondaryTable(name = "attribute_group", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")),

})
public class AttributeValue {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "attribute_group_id")
    private Integer attributeGroupId;

    @Column(name = "name", table = "attribute_group")
    private String name;

    @Column(name = "value")
    private String value;


}
