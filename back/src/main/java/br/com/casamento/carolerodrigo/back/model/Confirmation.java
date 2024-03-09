package br.com.casamento.carolerodrigo.back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CONFIRMATION")
public class Confirmation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String fullName;
    private boolean answer;
    private String email;
    private String phone;
    private String obs;
    private String type;
    private UUID parentId;

    // @SQLRestriction("type == 'A'")
    @OneToMany(mappedBy="parentId")
    private List<Confirmation> adultsNames;

    // @SQLRestriction("type == 'C'")
    @OneToMany(mappedBy="parentId")
    private List<Confirmation> childrenNames;
}
