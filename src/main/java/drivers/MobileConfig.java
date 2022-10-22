package drivers;

import io.qameta.allure.internal.shadowed.jackson.databind.ser.std.StdKeySerializers;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile.properties"
})
public interface MobileConfig extends Config {

    @Key("browserstack.user")
    public abstract String getBrowserstackUser();

    @Key("browserstack.key")
    public abstract String getBrowserstackKey();

    @Key("app")
    public abstract String getApp();

    @Key("device")
    public abstract String getDevice();

    @Key("os_version")
    public abstract String getOsVersion();

    @Key("project")
    public abstract String getProject();

    @Key("build")
    public abstract String getBuild();

    @Key("name")
    public abstract String getName();


}

