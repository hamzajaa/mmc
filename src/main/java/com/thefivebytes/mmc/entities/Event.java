package com.thefivebytes.mmc.entities;

import com.thefivebytes.mmc.security.bean.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String address;
    private int nbOfPlace;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    private EventVille eventVille;
    @ManyToOne(fetch = FetchType.LAZY)
    private EventType eventType;
    @ManyToOne(fetch = FetchType.LAZY)
    private EventStatus eventStatus;
//    @OneToMany(mappedBy = "event")
//    private List<EventSocialMediaLink> eventSocialMediaLinks;
    //    @OneToMany(mappedBy = "speaker")
//    private List<Speaker> speakers;
//    @OneToMany(mappedBy = "user")
//    private List<User> users;
//    @OneToMany(mappedBy = "sponsor")
//    private List<Sponsor> sponsors;
//    @OneToMany(mappedBy = "partners")
//    private List<Partner> partners;


}
