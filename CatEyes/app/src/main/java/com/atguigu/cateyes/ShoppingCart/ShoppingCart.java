package com.atguigu.cateyes.ShoppingCart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.atguigu.cateyes.R;
import com.atguigu.cateyes.Untils.CartProvider;
import com.atguigu.cateyes.bean.ShoppingCartBean;
import com.atguigu.cateyes.recycler_view_adapter.ShoppingTrolleyRecyclerAdapter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class ShoppingCart extends Activity{
    // 商户PID
    public static final String PARTNER = "2088911876712776";
    // 商户收款账号
    public static final String SELLER = "chenlei@atguigu.com";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANNGsUxqtQu6mA/d\n" +
            "dOv6KvbyefjFNzrMosPdYgu7K/r9srU4xpYSWJFMTIWNHi1LKfePjOFN816SV7Xa\n" +
            "mePLcIr6fSACT8sf+283mowVfs5oe+vhLbvsaSbCmFOaiD9QW4xPk4mczGYEKq99\n" +
            "fXq0+Htdvydey83GRCGOU5luDW5zAgMBAAECgYBuCXKMH0Nd8XgDQ08DHE9GQLGg\n" +
            "DG8gc7YOFv5ap8hXN8zcr85WGQYB3uA36nCeHHimFCDGs4eeaM+/yjO+PZXGCfCu\n" +
            "YXzYOMf0ApLB2lpHPZrjqrclzlA/DIRwsALA9AWr8CnY6t6vwea98chP/qcnuzkF\n" +
            "t98YFpzxK33ddV4ogQJBAPS6oGFm3/kOOLgLiZkb+l9eUSDXCD65uyHZclKjaL/q\n" +
            "lUAsddvjEZFtpx6oq+NJmsCMd2bS9trq78EKL2lXMrMCQQDdAad9fDy32WY1tQgp\n" +
            "oRbkYwXsPtkEkrzHzWYLMzL9QzzINqvMExP89/B+Z5fvDWIIUN48xYgl9CmlZMRs\n" +
            "K7VBAkBDXnCx/3jefby9ZWeuf1YwFK2upaM+aTCLg+mFuDgoxLHrZZHYQyzd5Nqh\n" +
            "hPs0aVmxcbmY07Bi2VPAx0X/8KIjAkEAnb1ohi/+RlpskTi8srm/VRM4Tv4sdw8k\n" +
            "npcDlkrcwdcTsvMSe33CbnOouw/FaWHr7nOJq2ZxXmV+tAXQDETGAQJBANI1MeCp\n" +
            "Z4f1qCLvBKlPSkfZ55IJ2K/7OKyMj/cn+b1FtMnZxcTWDvMJFK3mdE7xlwKbu5E4\n" +
            "MVwK3wohrYAxT4I=";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDTRrFMarULupgP3XTr+ir28nn4\n" +
            "xTc6zKLD3WILuyv6/bK1OMaWEliRTEyFjR4tSyn3j4zhTfNekle12pnjy3CK+n0g\n" +
            "Ak/LH/tvN5qMFX7OaHvr4S277GkmwphTmog/UFuMT5OJnMxmBCqvfX16tPh7Xb8n\n" +
            "XsvNxkQhjlOZbg1ucwIDAQAB";

    private static final int SDK_PAY_FLAG = 1;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(ShoppingCart.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(ShoppingCart.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(ShoppingCart.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };


















    private RecyclerView rv_shopping_trolley_recyclerview;
    private Button button_bianji;
    private CheckBox checkbox_total_price;
    private TextView tv_total_price;
    private TextView tv_jiesuan;
    /**
     * 编辑状态
     */
    private static final int ACTION_EDIT = 1;
    /**
     * 完成状态
     */
    private static final int ACITON_COMPLETE = 2;
    private ShoppingTrolleyRecyclerAdapter adapter;
    private TextView btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_trolley);
        initView();
        initData();
    }

    private CartProvider cartProvider;

    private void initData() {
        /*从本地得到数据*/
        cartProvider=new CartProvider(this);
        List<ShoppingCartBean> data = cartProvider.getAllData();

        adapter= new ShoppingTrolleyRecyclerAdapter(this, data, checkbox_total_price, tv_total_price);
        rv_shopping_trolley_recyclerview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_shopping_trolley_recyclerview.setLayoutManager(linearLayoutManager);
        button_bianji.setTag(ACTION_EDIT);
        /*设置编辑的点击事件*/
        button_bianji.setOnClickListener(new MyOnClickListener());
        //设置删除按钮的点击事件
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.deleteData();
            }
        });

        //设置去结算的点击事件
        tv_jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay(v);
            }
        });

    }


    private void initView() {

         rv_shopping_trolley_recyclerview= (RecyclerView) findViewById(R.id.rv_shopping_trolley_RecyclerView);
        /*编辑*/
         button_bianji= (Button) findViewById(R.id.button_bianji);
        /*全选*/
          checkbox_total_price= (CheckBox) findViewById(R.id.checkbox_total_price);
        /*总价格*/
          tv_total_price= (TextView) findViewById(R.id.tv_total_price);
        /*取结算*/
          tv_jiesuan= (TextView) findViewById(R.id.tv_jiesuan);
         btn_delete= (TextView) findViewById(R.id.btn_delete);
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //得到状态
            int action = (int) button_bianji.getTag();

            if (action == ACTION_EDIT) {
                //显示删除按钮
                showDeleteButton();
            } else if (action == ACITON_COMPLETE) {
                //隐藏删除按钮
                hideDeleteButton();
            }
        }
    }

    private void hideDeleteButton() {
        //1.设置文本为完成
        button_bianji.setText("编辑");
        //2.设置全部为非勾选和全选按钮为非勾选
        adapter.all_none(true);
        checkbox_total_price.setChecked(true);
        //3.显示价格
        tv_total_price.setVisibility(View.VISIBLE);
        //4.隐藏删除按钮
        btn_delete.setVisibility(View.GONE);
        //5.显示结算按钮
        tv_jiesuan.setVisibility(View.VISIBLE);
        //6.设置状态 ACTION_EDIT
        button_bianji.setTag(ACTION_EDIT);


    }

    private void showDeleteButton() {
        //1.设置文本为完成
        button_bianji.setText("完成");
        //2.设置全部为非勾选和全选按钮为非勾选
        adapter.all_none(false);
        checkbox_total_price.setChecked(false);
        //3.隐藏价格
        tv_total_price.setVisibility(View.GONE);
        //4.显示删除按钮
        btn_delete.setVisibility(View.VISIBLE);
        //5.隐藏结算按钮
        tv_jiesuan.setVisibility(View.GONE);
        //6.设置状态 ACTION_COMPLETE
        button_bianji.setTag(ACITON_COMPLETE);
    }






    /**
     * call alipay sdk pay. 调用SDK支付
     *
     */
    public void pay(View v) {
        if (TextUtils.isEmpty(PARTNER) || TextUtils.isEmpty(RSA_PRIVATE) || TextUtils.isEmpty(SELLER)) {
            new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置PARTNER | RSA_PRIVATE| SELLER")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            finish();
                        }
                    }).show();
            return;
        }

        String orderInfo = getOrderInfo("尚硅谷商城-Android培训", "尚硅谷商城-Android培训-牛", adapter.getTotalPrice()+"");

        /**
         * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
         */
        String sign = sign(orderInfo);
        try {
            /**
             * 仅需对sign 做URL编码
             */
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 完整的符合支付宝参数规范的订单信息
         */
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(ShoppingCart.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }












    /**
     * create the order info. 创建订单信息
     *
     */
    private String getOrderInfo(String subject, String body, String price) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;

    }
    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     *
     */
    private String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content
     *            待签名订单信息
     */
    private String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     *
     */
    private String getSignType() {
        return "sign_type=\"RSA\"";
    }


    }



