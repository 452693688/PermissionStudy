package com.permission.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.permission.ui.utile.Permission;

import activity.ui.com.permissionstudy.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_examine_btn).setOnClickListener(this);
        findViewById(R.id.main_apply_btn).setOnClickListener(this);
        findViewById(R.id.main_manager_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_examine_btn:
                boolean isExist = Permission.getInstance().checkSelfPermission(
                        this, Permission.permission_record);

                break;
            case R.id.main_apply_btn:
                Permission.getInstance().requestPermissions(this, Permission.permission_record);
                break;
            case R.id.main_manager_btn:
                Permission.getInstance().startAccredit(this);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Permission.getInstance().onRequestPermissionsResult(this,requestCode, permissions, grantResults);
    }
}
