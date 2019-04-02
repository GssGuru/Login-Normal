package gss.guru.loginnormal.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Auth extends Base {

    public Auth() { }

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("user")
    @Expose
    private int user;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

}
