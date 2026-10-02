package repository;

import entity.Member;

public interface MemberRepository extends BaseRepository<Member> {

    int count();

    Member findByUsername(String username);
}
