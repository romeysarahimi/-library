package dto;

public record BookUpdateRequest(int id, String author, String title, boolean available) {
}
