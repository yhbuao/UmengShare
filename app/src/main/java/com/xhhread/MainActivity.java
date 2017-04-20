package com.xhhread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final UMWeb  web = new UMWeb("https://xhhread.com");
        web.setTitle("This is music title");//标题
        web.setThumb(new UMImage(MainActivity.this,"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png"));  //缩略图
        web.setDescription("my description");//描述

        findViewById(R.id.bt_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(MainActivity.this).withText("hello")
                       .withMedia(web)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.ALIPAY,SHARE_MEDIA.DOUBAN)
                        .setCallback(umShareListener).open();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);

            Toast.makeText(MainActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
}
