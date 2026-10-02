package entity;


public abstract class BaseEntity<I> {

    private I id;

    public BaseEntity() {
    }

    public BaseEntity(I id) {
        this.id = id;
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
