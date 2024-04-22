package ai.aecode.aecode.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Interaction")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_interaction;
    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "id_ProfileDetail")
    private Profile_detail profile_detail;
    @Enumerated(EnumType.STRING)
    @Column(name = "interaction_type")
    private InteractionType interactionType;

    @Column(name = "interaction_comment_content", columnDefinition = "TEXT")
    private String interaction_comment_content;

    @Column(name = "interaction_date", nullable = false)
    private LocalDateTime interaction_date;
}

enum InteractionType {
    LIKE,
    COMMENT,
    SHARE
}
