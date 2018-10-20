package examples.boot.myshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동으로 increment
    private Long id;  // mysql사용할때 id를 autoincrement되도록 long으로 해둔다?
    private String name;

    @OneToMany(mappedBy = "category") // board entity의 필드명
    private List<Board> boards;

    //test3 용
//    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER) // board entity의 필드명
//    // EAGER? join해서 함께 가져옴
//    // 언제나 좋나?
//    private List<Board> boards;


    public List<Board> getBoards(){
        System.out.println("Execute Me??");
        return boards;
    }
}
