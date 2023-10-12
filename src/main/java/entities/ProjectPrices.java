package entities;

public class ProjectPrices {
    private int projectId;
    private int price;

    public ProjectPrices(int projectId, int price) {
        this.projectId = projectId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "projectId=" + projectId +
                ", price=" + price +
                '}';
    }
}
