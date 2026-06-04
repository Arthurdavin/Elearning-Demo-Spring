package co.istad.elearningcodejourney.feature.comment;

import co.istad.elearningcodejourney.feature.video.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment prentComment;
    private LocalDateTime createdAt;

    @ManyToOne
    private Video video;

}
