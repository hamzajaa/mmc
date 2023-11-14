package com.thefivebytes.mmc.entities;

import com.thefivebytes.mmc.security.bean.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

//    @OneToOne(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
//    private User user;
}
