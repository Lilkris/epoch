package com.marshal.epoch.message.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auth: Marshal
 * @date: 2020/4/10
 * @desc:
 */
@ConfigurationProperties(
        prefix = "epoch.message"
)
public class MessageProperty {

    private boolean enabled;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
