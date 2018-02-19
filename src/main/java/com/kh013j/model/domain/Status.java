package com.kh013j.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/*public enum Status {
  WAITING, COOKING, READY
}
*/
@Entity
@Table(name = "status", schema = "rh")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(3) @Max(50)
    private String name;
    @Transient
    public static final String PREPARING = "preparing";
    @Transient
    public static final String COOKING = "cooking";
    @Transient
    public static final String DELIVERY = "delivery";
}