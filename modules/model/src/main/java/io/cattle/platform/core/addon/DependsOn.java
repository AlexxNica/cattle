package io.cattle.platform.core.addon;

import io.github.ibuildthecloud.gdapi.annotation.Field;
import io.github.ibuildthecloud.gdapi.annotation.Type;
import org.apache.commons.lang3.StringUtils;

@Type(list = false)
public class DependsOn {

    public enum DependsOnCondition {
        running,
        healthy,
        healthylocal
    }

    String service;
    String container;
    DependsOnCondition condition;

    @Field(nullable = false)
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Field(defaultValue = "healthy")
    public DependsOnCondition getCondition() {
        return condition;
    }

    public void setCondition(DependsOnCondition condition) {
        this.condition = condition;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    @Field(include = false)
    public String getDisplayName() {
        return StringUtils.isNotBlank(getContainer()) ? getContainer() : getService();
    }

}
