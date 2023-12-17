package webProgramming.recommendTravel.domain.destination;

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
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destinationId;
//    @Column(nullable = false, length = 50)
    @Column
    private String name;
//    @Column(nullable = false, length = 150)
    @Column
    private String location;
//    @Column(length = 250)
    @Column
    private String description;
//    @Column(length = 150)
    @Column
    private String imageURL;
//    @Column(nullable = false, length = 4)
    @Column
    private String mbti_type;
//    @Column(length = 250)
    @Column
    private String otherAttributes;
}
