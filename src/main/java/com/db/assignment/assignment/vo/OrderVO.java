package com.db.assignment.assignment.vo;

import com.db.assignment.assignment.entity.OrderEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderVO {
    @ApiModelProperty(notes = "Order No",name="orderNo",required=true,value="398481")
    private Long orderNo;
    private Integer level;
    private String code;
    private String parent;
    private String parentDesc;
    private String includes;
    private String alsoIncludes;
    private String excludes;
    private String rulings;
    private String referenceIsic;
    private String message;



    public static OrderVO  mapOrder(OrderEntity orderEntity){
        return OrderVO.builder()
                .orderNo(orderEntity.getOrderNo())
                .level(orderEntity.getLevel())
                .code(orderEntity.getCode())
                .parent(orderEntity.getParent())
                .parentDesc(orderEntity.getParentDesc())
                .includes(orderEntity.getIncludes())
                .alsoIncludes(orderEntity.getAlsoIncludes())
                .excludes(orderEntity.getExcludes())
                .rulings(orderEntity.getRulings())
                .referenceIsic(orderEntity.getReferenceIsic())
                .build();
    }

}
