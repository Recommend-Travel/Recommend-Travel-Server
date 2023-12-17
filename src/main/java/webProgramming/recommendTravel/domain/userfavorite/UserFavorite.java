package webProgramming.recommendTravel.domain.userfavorite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import webProgramming.recommendTravel.domain.user.User;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class UserFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;
    @ManyToOne
    @JoinColumn(name = "cid")
    private User user;
//    @Column(nullable = false)
    @Column
    private Date dateAdded;

}
