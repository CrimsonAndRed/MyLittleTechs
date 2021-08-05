package my.little.model.admin;

public class RequestCount {

    public RequestCount(Long count) {
        this.count = count;
    }

    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
