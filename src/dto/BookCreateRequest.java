package dto;

public record BookCreateRequest(String author, String title, boolean available) {
}
