package by.en.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "murphy_unit")
public class MurphyUnit extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2620748789783766637L;

    @Column(name="number")
    private Integer number;

    @Column(name = "name")
    private String name;
}
