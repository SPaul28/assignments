package com.db.assignment.assignment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "NACE_REV2")
public class OrderEntity implements Serializable {
    @Id
    @Column(name = "order_No")
    private Long orderNo;
    @Column(name = "order_level")
    private Integer level;
    @Column(name = "code")
    private String code;
    @Column(name = "parent")
    private String parent;
    @Column(name = "parent_desc")
    private String parentDesc;
    @Column(name="includes")
    private String includes;
    @Column(name = "also_includes")
    private String alsoIncludes;
    @Column(name = "excludes")
    private String excludes;
    @Column(name = "rulings")
    private String rulings;
    @Column(name = "reference_Isic")
    private String referenceIsic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return orderNo.equals(that.orderNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo);
    }
}
