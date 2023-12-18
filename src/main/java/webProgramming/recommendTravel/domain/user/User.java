package webProgramming.recommendTravel.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
//    @Column(nullable = false, length = 25, unique = true)
    @Column
    private String userid;
//    @Column(nullable = false, length = 25)
    @Column
    private String username;
//    @Column(nullable = false, length = 25)
    @Column
    private String password;
//    @Column(length = 100)
    @Column
    private String email;
//    @Column(length = 4)
    @Column
    private String mbti_type;
}
