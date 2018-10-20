package examples.boot.myshop.repository;

import examples.boot.myshop.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    //Query method! method명을 보고 자동으로 이름이 지어짐
    public List<Board> findAllByName(String name);
    public List<Board> findAllByTitleContains(String title); // like  검색

    //test5(test4의 1:N 문제 해결)
    @Query("select distinct b from Board b join fetch b.category") // 괄호 안은 SQL이 아닌 객체지향 JPQL언어 임
    // 여기에 nativeSQL을 사용할 수도 있지만, 그럼 DB 벤더 종속적이 되어버리므로 크게 추천하지는 않음
    public List<Board> getBoards();

}
