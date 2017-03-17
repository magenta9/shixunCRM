package entity;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class PersonEntity {
    private String personid;
    private String persistedFaceId;
    private String faceid;
    private String confidence;
    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }
    public String getFaceid() {
        return faceid;
    }
    public void setFaceid(String faceid) {
        this.faceid = faceid;
    }
    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String psesonid) {
        this.personid = psesonid;
    }

    public String getPersistedFaceId() {
        return persistedFaceId;
    }

    public void setPersistedFaceId(String persistedFaceId) {
        this.persistedFaceId = persistedFaceId;
    }

    public PersonEntity() {
    }

    public PersonEntity(String psesonid , String persistedFaceId ) {
        this.personid = psesonid;
        this.persistedFaceId=persistedFaceId;
    }
}
