package jpql;



import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //애플리케이션 처음 실행 될때

        EntityManager em = emf.createEntityManager(); // 사용자 요청시

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            //jpql 기본문법
//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.id = 10", Member.class);
//            List<Member> resultList = query.getResultList();      //리스트 반환, 데이터 없을때 빈 리스트 반환
//            Member singleResult = query.getSingleResult();  // 싱글 반환  //경과가 정확히 하나만 있어야함, 2개 이상 , 없으면 예외 발생

//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query.setParameter("username", "member1");
//            Member singleResult = query.getSingleResult();
            //  이름 기반 파라미터 권장
//            Member singleResult = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("singleResult.getUsername() = " + singleResult.getUsername());

            //프로젝션
            em.flush();
            em.clear();

            //엔티티 프로젝션 1
//            List<Member> resultList = em.createQuery("select m.team from Member m", Member.class)
//                    .getResultList();
//            Member findMember = resultList.get(0);
//            findMember.setAge(20);

            //엔티티 프로젝션 2
//            List<Team> resultList = em.createQuery("select m.team from Member m", Team.class)
//                    .getResultList();
            //조인을 해서 sql 과 비슷하게 하는걸 권장(튜닝을 위해 위에 것 같이 작성하면 예측하기가 힘듬)
//            List<Team> resultList = em.createQuery("select t from Member m join m.team t", Team.class)
//                    .getResultList();

            //임베디드 타입 프로젝션
//            em.createQuery("select o.address from Order o", Address.class)
//                    .getResultList();

            //스칼라 타입 프로젝션
//            List resultList = em.createQuery("select distinct m.username, m.age from Member m")
//                    .getResultList();
//            1. Object[] 타입으로 조회
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("result[0] = " + result[0]);
//            System.out.println("result[0] = " + result[1]);

//            2. 제너릭 타입으로 조회
//            List<Object[]> resultList = em.createQuery("select distinct m.username, m.age from Member m")
//                    .getResultList();
//            Object[] result = resultList.get(0);
//            System.out.println("result[0] = " + result[0]);
//            System.out.println("result[0] = " + result[1]);

            //3. new 명령어로 조회
            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();
            MemberDTO memberDTO = resultList.get(0);
            System.out.println("result[0] = " + memberDTO.getUsername());
            System.out.println("result[0] = " + memberDTO.getAge());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
