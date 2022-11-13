package drivers;

import io.qameta.allure.internal.shadowed.jackson.databind.ser.std.StdKeySerializers;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"

})
public interface MobileConfig extends Config {

    @Key("browserstack.user")
    public abstract String getBrowserstackUser();

    @Key("browserstack.key")
    public abstract String getBrowserstackKey();

    @Key("app")
    public abstract String getApp();

    @Key("URL")
    @DefaultValue("http://localhost:4723/wd/hub")
    public abstract String getURL();
    @Key("device")
    @DefaultValue("Pixel 4 API 30")
    public abstract String getDevice();

    @Key("os_version")
    @DefaultValue("11")
    public abstract String getOsVersion();
    @Key("platform_name")
    @DefaultValue("android")
    public abstract String getPlatformName();
    @Key("project")
    public abstract String getProject();

    @Key("build")
    public abstract String getBuild();

    @Key("name")
    public abstract String getName();


}

