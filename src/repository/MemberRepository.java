package repository;

import entity.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);

    Member findById(int id);

    void update(Member member);

    List<Member> findAll();

    void delete(Member member);

    int count();

    Member findByUsername(String username);
}
