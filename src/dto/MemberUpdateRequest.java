package dto;

public record MemberUpdateRequest(int id, String username, int tell, String address, String email) {
}
