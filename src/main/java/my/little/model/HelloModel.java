package my.little.model;

public class HelloModel {

    public HelloModel() {
    }

    public HelloModel(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
