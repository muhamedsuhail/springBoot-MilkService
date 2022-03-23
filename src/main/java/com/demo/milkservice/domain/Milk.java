package com.demo.milkservice.domain;

import com.demo.milkservice.web.model.MilkTypeEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Milk {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    public UUID id;

    @Version
    private long version;

    @CreationTimestamp()
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp modifiedDate;

    private String milkName;
    private MilkTypeEnum milkType;

    @Column(unique = true)
    private Long upc;

    private BigDecimal price;

    private Integer quantityOnHand;
}
