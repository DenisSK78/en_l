package by.en.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "user")

@Entity
@Table
public class Learned extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2330478816277450060L;

    @Column(name = "repeated")
    private Integer repeated;

    @Column(name = "need_repeat")
    private Integer needRepeat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "murphy_unit_id", nullable = false, unique = true)
    private  MurphyUnit murphyUnit;
}
