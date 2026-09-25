package service;

import dto.MemberUpdateRequest;
import entity.Member;
import exception.LibraryFullException;
import exception.MemberNotFoundException;
import repository.MemberRepository;

public class MemberService {
    //    TODO: implement this class
    private final MemberRepository memberRepository;
    private static final int LIBRARY_CAPACITY = 100;
    private static final String USERNAME_REQUIRED_MESSAGE = "username cannot be empty";

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void register(String name, String tel, String address, String email) {
        if (memberRepository.count() >= LIBRARY_CAPACITY)
            throw new LibraryFullException("Library is full");


        validateNonNull(name, "name");
        validateNonNull(tel, "tel");
        validateNonNull(address, "address");
        validateNonNull(email, "email");

        var member = new Member();
        member.setUsername(name);
        member.setTel(tel);
        member.setAddress(address);
        member.setEmail(email);

        memberRepository.save(member);
    }

    private void validateNonNull(String value, String valueName) {
//TODO: implement this
    }

    public void deleteAccount(int id) {
        Member member = memberRepository.findById(id);

        if (member == null) {

            throw new MemberNotFoundException("member not available");
        }
        memberRepository.delete(member);
    }

    public void updateMember(MemberUpdateRequest request) {
        validateNonNull(request.username(), USERNAME_REQUIRED_MESSAGE);

        Member member = findMemberByUsernameOrThrow((request.username());


    }

    private Member findMemberByUsernameOrThrow(String username) {
        Member member = memberRepository.findByUsername(username);


    }
}
