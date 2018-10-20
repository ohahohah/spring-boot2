package examples.boot.myshop;

import examples.boot.myshop.entity.Board;
import examples.boot.myshop.entity.Category;
import examples.boot.myshop.repository.BoardRepository;
import examples.boot.myshop.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // test에서 @Transactional을 사용하면 자동 rollback이 됨 - 상식적으로 테스트값이 DB 에 영향을 미치면 안되니까
public class MyshopApplicationTests {
	@Autowired
	CategoryRepository categoryRepository; //test 할 대상을 주입받음

    @Autowired
    BoardRepository boardRepository;

	@Test
	public void contextLoads() {
	}

	@Test
    public void test1(){
        Category category = categoryRepository.getOne(1L);
        System.out.println(category.getId());
        System.out.println(category.getName());
        Category category2 = categoryRepository.getOne(1L);
        // 1차 캐시 사용하는지 확인해봅시다
        if (category == category2){ // 같은 참조자인지 비교
            System.out.println("category == category2");
        }
    }

    @Test
    public void test2() {
        System.out.println("------------------");

        System.out.println(categoryRepository.getClass().getName());
	    Category category = categoryRepository.getOne(1L);

	    List<Board> boards = category.getBoards();
	    // proxy객체로 overriding 해준거라니까

        System.out.println("------------------");
        System.out.println("say name:"+ boards.getClass().getName()); // say name:org.hibernate.collection.internal.PersistentBag

        // 아래 for문이 없을때는 board조회하는 select쿼리를 실행하지 않음
        for(Board board : boards){
            // 실제로 불러왔을때만 하는 lazy loading 실행
            System.out.println(board.getTitle());
        }

        System.out.println("------------------");
    }

    @Test
    public void test3() {
        List<Board> list = boardRepository.findAllByName("kim");
        for (Board board : list){
            System.out.println(board.getTitle());
        }
    }

    @Test
    public void test4() { //1+N 문제
	    List<Board> list = boardRepository.findAll();
	    for (Board board : list){
	        // 쿼리가 몇 번 실행될까? 1+N 문제(JPA 쓰고 빠르게 욕먹는 방법)
            System.out.println(board.getTitle());
        }
    }

    @Test
    public void test5() { // 1+N 문제 해결
        List<Board> list = boardRepository.getBoards();
        for (Board board : list){
            System.out.println(board.getTitle());
        }

    }
}
