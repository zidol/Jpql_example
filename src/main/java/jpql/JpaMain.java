package jpql;



import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //애플리케이션 처음 실행 될때

        EntityManager em = emf.createEntityManager(); // 사용자 요청시

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);


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
//            em.flush();
//            em.clear();

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
//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//            MemberDTO memberDTO = resultList.get(0);
//            System.out.println("result[0] = " + memberDTO.getUsername());
//            System.out.println("result[0] = " + memberDTO.getAge());

//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member" +i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//            em.flush();
//            em.clear();

//            List<Member> resultList = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//            System.out.println("resultList.size() = " + resultList.size());
//            for (Member member1 : resultList) {
//                System.out.println("member1.toString() = " + member1.toString());
//            }

            //조인
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);

//            Member member = new Member();
//            member.setUsername("관리자1");
//            member.setAge(10);
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//            member2.setAge(10);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();

//            List<Member> resultList = em.createQuery("select m from Member m left outer join m.team t", Member.class) // left(outer) 조인
//            List<Member> resultList = em.createQuery("select m from Member m, Team t where m.username = t.name", Member.class)//세타 조인
//            List<Member> resultList = em.createQuery("select m from Member m left join m.team t on t.name = 'teamA'", Member.class) //조인 대상 필터링
//            List<Member> resultList = em.createQuery("select m from Member m left join Team t on m.username = t.name", Member.class) //연관관계 없는 조인
//            String qlString = "select m.username, 'HELLO', TRUE from Member m " +
//                    "where m.type = :userType";     // ENUM은 풀 패키지 명
//            List<Object[]> resultList = em.createQuery(qlString)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();

//            for (Object[] objects : resultList) {
//                System.out.println("objects[0] = " + objects[0]);
//                System.out.println("objects[0] = " + objects[1]);
//                System.out.println("objects[0] = " + objects[2]);
//            }

            //조건식 - case 식
//            String query = "select " +
//                                    "case when m.age <= 10 then '학생요금' " +
//                                    "     when m.age >= 60 then '경로요금' " +
//                                    "     else '일반요금' " +
//                                    "end " +
//                    "from Member m";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            //username = null
//            String query = "select coalesce(m.username, '이름 없는 회원') as username from Member m ";
//            String query = "select nullif(m.username, '관리자') as username from Member m ";
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            //JPQL 기본 함수
//            String query = "select concat('a' , 'b') from Member m ";
//            String query = "select 'a' || 'b' from Member m ";  //하이버네이트 구현체에서 지원 -> 주로 concat 사용
//            String query = "select substring(m.username, 2, 3) from Member m ";
//            String query = "select locate('de','abcdefg') from Member m ";          //  Iteger 타입으로 반환
//            String query = "select size(t.members) from Team t";    //컬렉션 사이즈 반환
//            @OrderColumn  => index 함수 쓸때

//            String query = "select function('group_concat', m.username) from Member m";
//            String query = "select group_concat(m.username) from Member m";
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }


            //JPQL 경로 표현식

            Team team = new Team();
            em.persist(team);
            Member member = new Member();
            member.setUsername("관리자1");
            member.setAge(10);
            member.setTeam(team);
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setAge(10);
            member2.setTeam(team);
            em.persist(member2);



            em.flush();
            em.clear();

//            String query = "select m.team from Member m";       // 묵시적 내부조인 나감
//            List<Team> result = em.createQuery(query, Team.class)
//                    .getResultList();
//
//            for (Team s : result) {
//                System.out.println("s = " + s);
//            }

//            String query = "select t.members from Team t";       // 묵시적 내부조인 나감
//            Collection result = em.createQuery(query, Collection.class)
//                    .getResultList();
//            for (Object o : result) {
//                System.out.println(o);
//            }


//            String query = "select t.members.size from Team t";       // 묵시적 내부조인 나감
//            Integer result = em.createQuery(query, Integer.class)
//                    .getSingleResult();
//            String query = "select t.members from Team t";       // t.members.username 탐색 안됨
            String query = "select m from Team t join t.members m";    //명시적 조인을 해야함
            List<Member> resultList = em.createQuery(query, Member.class)
                    .getResultList();
            System.out.println("result = " + resultList);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
