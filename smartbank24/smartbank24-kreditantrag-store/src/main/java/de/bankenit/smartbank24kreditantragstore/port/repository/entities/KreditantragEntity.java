package de.bankenit.smartbank24kreditantragstore.port.repository.entities;

import lombok.*;
import org.hibernate.Hibernate;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tbl_kredit_antraege")
public class KreditantragEntity implements Serializable {

    @Id
    @Column(length = 36)
    private String creditApplicationId;
    @Column(length = 51)
    private String firstName;
    @Column(length = 51)
    private String lastName;
    @Column(length = 51)
    private String city;
    private LocalDateTime applicationDate;
    private double monthlyIncome;
    private double monthlyExpenditure;
    private double creditSum;

    @Version
    private long version;

    @Column(length = 30, nullable = false)
    private String kreditantragState;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        KreditantragEntity that = (KreditantragEntity) o;
        return creditApplicationId != null && Objects.equals(creditApplicationId, that.creditApplicationId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
