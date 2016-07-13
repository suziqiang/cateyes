package com.atguigu.cateyes.mine;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.ShoppingCart.ShoppingCart;
import com.atguigu.cateyes.sql.DBhelper;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/2 0002.
 */
public class LogIn extends Activity implements View.OnClickListener {
    private ImageView login__history_delete;
    private ImageView login__history_delete1;
    private  ImageView im_login_back;
    private EditText et_login_user;
    private EditText et_login_password;
    private Button login_login;
    private Editable userName;
    private Editable userPassword;

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    private ImageView lonin_fenxing_qq;
    private ImageView lonin_fenxing_sina;
    private ImageView lonin_fenxing_weixin;
    private ImageView lonin_fenxing_qqkongjian;
    private UMShareAPI mShareAPI;
    private DBhelper dBhelper;
    private TextView login_tv_zhuce;
    private String username;
    private String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_login);
         dBhelper = new DBhelper(this,1);
        /*删除输入的内容*/
         login__history_delete = (ImageView) findViewById(R.id.login_history_delete);
         login__history_delete1 =(ImageView) findViewById(R.id.login_history_delete1);
        /*返回*/
         im_login_back=(ImageView) findViewById(R.id.im_login_back);
        /*用户输入*/
        et_login_user= (EditText) findViewById(R.id.et_login_user);

        /*密码输入*/
        et_login_password= (EditText) findViewById(R.id.et_login_password);

        /*登录按键*/
         login_login= (Button) findViewById(R.id.login_login);
        /*注册*/
        login_tv_zhuce= (TextView) findViewById(R.id.login_tv_zhuce);
           /*qq*/
         lonin_fenxing_qq= (ImageView) findViewById(R.id.lonin_fenxing_qq);
        lonin_fenxing_sina= (ImageView) findViewById(R.id.lonin_fenxing_sina);
        lonin_fenxing_weixin= (ImageView) findViewById(R.id.lonin_fenxing_weixin);
        lonin_fenxing_qqkongjian= (ImageView) findViewById(R.id.lonin_fenxing_qqkongjian);

        login_tv_zhuce.setOnClickListener(this);
        login_login.setOnClickListener(this);
        lonin_fenxing_qq.setOnClickListener(this);
        lonin_fenxing_sina.setOnClickListener(this);

         im_login_back.setOnClickListener(this);
         login__history_delete.setOnClickListener(this);
          et_login_user.addTextChangedListener(new MyTextChangedListener());

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_history_delete:
                et_login_user.setText("");
                break;
            case R.id.im_login_back:
                finish();
                break;

            case R.id.lonin_fenxing_qq:
                SHARE_MEDIA platform = SHARE_MEDIA.QQ;
                mShareAPI = UMShareAPI.get(this);
                mShareAPI.doOauthVerify(this, platform, umAuthListener);
                mShareAPI.isInstall(this, SHARE_MEDIA.QQ);
            break;
            case R.id.lonin_fenxing_sina:
                SHARE_MEDIA platformsina = SHARE_MEDIA.SINA;
                mShareAPI = UMShareAPI.get(this);
                mShareAPI.doOauthVerify(this, platformsina, umAuthListener);
                mShareAPI.isInstall(this, SHARE_MEDIA.SINA);

                break;
            case R.id.lonin_fenxing_weixin:
                SHARE_MEDIA platformsinaweixin = SHARE_MEDIA.WEIXIN;
                mShareAPI = UMShareAPI.get(this);
                mShareAPI.doOauthVerify(this, platformsinaweixin, umAuthListener);
                mShareAPI.isInstall(this, SHARE_MEDIA.WEIXIN);

                break;
            case R.id.lonin_fenxing_qqkongjian:
                SHARE_MEDIA platformsinakongjian = SHARE_MEDIA.QZONE;
                mShareAPI = UMShareAPI.get(this);
                mShareAPI.doOauthVerify(this, platformsinakongjian, umAuthListener);
                mShareAPI.isInstall(this, SHARE_MEDIA.QZONE);
                break;
            case R.id.login_login:
                 username = et_login_user.getText().toString();
                 password = et_login_password.getText().toString();
                if(!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)){
                    querySQL(username,password);
                }else{
                    Toast.makeText(LogIn.this,"账号和密码不能为空",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.login_tv_zhuce:
                username = et_login_user.getText().toString();
                password = et_login_password.getText().toString();
                if(!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)){
                    insertSQL(username,password);
                }else{
                    Toast.makeText(LogIn.this,"请输入注册账号和密码",Toast.LENGTH_SHORT).show();
                }
                break;




        }
    }

    private void insertSQL(String username, String password) {
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        ContentValues value=new ContentValues();
        value.put("name",username);
        value.put("password",password);
        database.insert("users", null, value);
        database.close();
        Toast.makeText(LogIn.this,"注册成功请立即登录",Toast.LENGTH_SHORT).show();
    }
    private void querySQL(String username,String userpassword) {

        SQLiteDatabase database = dBhelper.getReadableDatabase();
        Cursor cursor = database.query("users", null, null, null, null, null, null, null);
        Log.e("qqq","=======q1");
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password=cursor.getString(cursor.getColumnIndex("password"));
            Log.e("qqq", "=======q2");

            if(username.equals(name)&&userpassword.equals(password)){
                Intent intent=new Intent(this, ShoppingCart.class);
                startActivity(intent);
            }else{
                Log.e("qqq","=======q3");
                Toast.makeText(LogIn.this,"账号或密码不正确或未注册",Toast.LENGTH_SHORT).show();
            }

            break;
        }
        cursor.close();
        database.close();

    }

    private class MyTextChangedListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(et_login_user.getText().toString()!=null&&!et_login_user.getText().toString().equals("")){
                login__history_delete.setVisibility(View.VISIBLE);
            }else{
                login__history_delete.setVisibility(View.INVISIBLE);
            }
        }
    }
}


