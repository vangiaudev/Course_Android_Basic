package vangiaurecca.example.mycontactapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.AcceptPendingException;

public class MainActivity extends AppCompatActivity {
    EditText txtPhone, txtTinNhan;
    Button btnQuaySo, btnGoiLuon, btnNhanTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        btnQuaySo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyQuaySo();
            }
        });
        btnGoiLuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyGoiLuon();
            }
        });
        btnNhanTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNhanTinVaQuanLyKetQua();
            }
        });
    }

    private void xuLyNhanTinVaQuanLyKetQua()
    {
       final SmsManager sms = SmsManager.getDefault();
       Intent msgSent = new Intent("ACTION_MSG_SENT");
       final PendingIntent pendingMsgSent = PendingIntent.getBroadcast(this,0,msgSent,0);
       registerReceiver(new BroadcastReceiver(){
           public void onReceive(Context context, Intent intent){
               int result = getResultCode();
               String msg = "Gửi thành công";
               if(result != Activity.RESULT_OK){
                   msg = "Gửi thất bại";
               }
               Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
           }
       }, new IntentFilter("ACTION_MSG_SENT"));
       sms.sendTextMessage(txtPhone.getText().toString(), null, txtTinNhan.getText()+"", pendingMsgSent, null);
    }
    private void xuLyGoiLuon() {
        //Đây là cú pháp bắt buộc gõ chính xác từng khoảng trắng
        Uri uri = Uri.parse("tel:"+txtPhone.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    private void xuLyQuaySo() {
        //Đây là cú pháp bắt buộc gõ chính xác từng khoảng trắng
        Uri uri = Uri.parse("tel:"+txtPhone.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    private void addControls() {
        txtPhone = this.<EditText>findViewById(R.id.txtPhone);
        txtTinNhan = this.<EditText>findViewById(R.id.txtTinNhan);
        btnGoiLuon = this.<Button>findViewById(R.id.btnGoiLuon);
        btnNhanTin = this.<Button>findViewById(R.id.btnNhanTin);
        btnQuaySo = this.<Button>findViewById(R.id.btnQuaySo);
    }
}