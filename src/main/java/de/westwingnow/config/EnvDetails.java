package de.westwingnow.config;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "userName",
        "password"
})
public class EnvDetails {

    @JsonProperty("url")
    private String url;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public EnvDetails() {
    }

    public EnvDetails(String url, String userName, String password, Map<String, Object> additionalProperties) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "EnvDetails{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}