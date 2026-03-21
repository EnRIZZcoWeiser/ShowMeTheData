package org.enrycoweiser.showmethedata.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.enrycoweiser.showmethedata.standard.StandardEntity;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "operator")
public class Operator extends StandardEntity {
    @Column(nullable = false)
    private String role;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private LocalDate from;
}
