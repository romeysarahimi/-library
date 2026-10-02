package repository;

import entity.Member;

public interface MemberRepository extends BaseRepository<Member,Integer> {

    int count();

    Member findByUsername(String username);
}
