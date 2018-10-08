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
@Table(name = "read_ok")
public class ReadOk extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 952196873615785379L;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Integer number;

    @Column(name = "repeated")
    private Integer repeat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
