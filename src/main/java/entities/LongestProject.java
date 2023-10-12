package entities;

public class LongestProject {
    private int projectId;
    private int projectDuration;

    public LongestProject(int projectId, int projectDuration) {
        this.projectId = projectId;
        this.projectDuration = projectDuration;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "projectId=" + projectId +
                ", projectDuration=" + projectDuration +
                '}';
    }
}
