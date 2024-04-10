package AndrewWebServices;

public class StubRecSys extends RecSys {
    private String recom;

    public StubRecSys(String recom) {
        this.recom = recom;
    }

    @Override
    public String getRecommendation(String accountName) {
        return recom;
    }
}
