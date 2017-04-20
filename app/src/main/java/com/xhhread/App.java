package com.xhhread;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * @author: yuhaibo
 * @time: 2017/4/20 15:45.
 * projectName: UmengShare.
 */

public class App extends Application {
    {
//        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");

        //微信 appid appsecret
        PlatformConfig.setWeixin("wxd90285114785d416", "573bcdad62f91904b38804f56197e731");
        // QQ和Qzone appid appkey
        PlatformConfig.setQQZone("1105509914", "VT8AgpOUFHlJgZRm");
        //新浪微博 appkey appsecret
        PlatformConfig.setSinaWeibo("3739064668", "5e5ceaa313a41b2ccdd6734273e9d392","http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }
}
