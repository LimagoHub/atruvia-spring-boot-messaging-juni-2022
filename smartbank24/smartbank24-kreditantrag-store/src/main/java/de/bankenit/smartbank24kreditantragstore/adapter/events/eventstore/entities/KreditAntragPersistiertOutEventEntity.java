package de.bankenit.smartbank24kreditantragstore.adapter.events.eventstore.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("KreditantragPersistiertOut")
public class KreditAntragPersistiertOutEventEntity extends AbstractEventEntity{


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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KreditAntragPersistiertOutEventEntity{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", applicationDate=").append(applicationDate);
        sb.append(", monthlyIncome=").append(monthlyIncome);
        sb.append(", monthlyExpenditure=").append(monthlyExpenditure);
        sb.append(", creditSum=").append(creditSum);
        sb.append('}');
        return sb.toString();
    }
}