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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "user")

@Entity
@Table
public class Learned extends BaseEntity{

    @Column(name = "number")
    private Integer number;

    @Column(name = "repeated")
    private Integer reread;

    @Column(name = "need_repeat")
    private Integer needRepeat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
