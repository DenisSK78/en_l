package by.en.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@ToString

@Entity
@Table(name = "statistic")
public class Statistic extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1264949964397251990L;

    @Column(name = "learned")
    private Integer learned;

    @Column(name = "repeated")
    private Integer reread;

    @Column(name = "need_repeat")
    private Integer needRepeat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
