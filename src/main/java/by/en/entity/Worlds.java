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
@ToString

@Entity
@Table(name = "worlds")
public class Worlds extends BaseEntity {

    @Column(name = "ru_world")
    private String ruWorld;

    @Column(name = "en_world")
    private String  enWorld;

    @Column(name = "ru_phrase")
    private String  ruPhrase;

    @Column(name = "en_phrase")
    private String  enPhrase;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
