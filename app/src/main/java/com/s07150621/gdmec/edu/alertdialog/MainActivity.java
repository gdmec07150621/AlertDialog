package com.s07150621.gdmec.edu.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)this.findViewById(R.id.textView);

        Button bt1=(Button)findViewById(R.id.button1);
        Button bt2=(Button)findViewById(R.id.button2);
        Button bt3=(Button)findViewById(R.id.button3);
        Button bt4=(Button)findViewById(R.id.button4);
        Button bt5=(Button)findViewById(R.id.button5);
        Button bt6=(Button)findViewById(R.id.button6);
        Button bt7=(Button)findViewById(R.id.button7);
        View.OnClickListener listener=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;

                }
            }
        };
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
        bt6.setOnClickListener(listener);
        bt7.setOnClickListener(listener);
    }
    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("你确定要退出吗");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时一般";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时放松";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"非常忙",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"一般忙",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"不忙",listener);
        dialog.show();
    }
    public void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入：");
        dialog.setMessage("你平时忙吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText et=new EditText(this);
        dialog.setView(et);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是:"+et.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog4(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListener= new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListener);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog5(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListener);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for (int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog6(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:"+item[which];
                tv1.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,sListener);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"取消",listener);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.diydialog,null);
        final EditText et=(EditText)layout.findViewById(R.id.editText1);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是:"+et.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }


}
