package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");

            /* 조회
            Member findMember = em.find(Member.class, 1L);
            */
            /* 삭제
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);
            */
            /* 등록
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");

            em.persist(member);
            */
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();;
        }

        emf.close();
    }

}
