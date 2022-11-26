package vangiaurecca.example.nodejssocketio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {

    private Socket mSocket;
    ListView lvUser, lvChat;
    EditText edtContent;

    ImageButton btnAdd, btnSend;

    ArrayList <String> arrayUser, arrayChat;
    ArrayAdapter adapterUser, adapterChat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();

        try {
            mSocket = IO.socket("http://192.168.1.13:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

          mSocket.connect();
          mSocket.on("server-send-result", onRetrieveResult);
          mSocket.on("server-send-user", onListUser);
          mSocket.on("server-send-chat", onListChat);
//        mSocket.emit("client-send-data", "Lap trinh Android");

        arrayUser = new ArrayList<>();
        adapterUser = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayUser);
        lvUser.setAdapter(adapterUser);

        arrayChat = new ArrayList<>();
        adapterChat = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayChat);
        lvChat.setAdapter(adapterChat);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtContent.getText().toString().trim().length() > 0){
                    mSocket.emit("client-register-user", edtContent.getText().toString());
                }

            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtContent.getText().toString().trim().length() > 0){
                    mSocket.emit("client-send-chat", edtContent.getText().toString());
                }
            }
        });
    }

    private void addControls() {
        btnAdd     = findViewById(R.id.btnAdd);
        btnSend    = findViewById(R.id.btnSend);
        edtContent = findViewById(R.id.edtContent);
        lvChat     = findViewById(R.id.lvChat);
        lvUser     = findViewById(R.id.lvUser);
    }

    private Emitter.Listener onListChat = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        String noiDung = object.getString("chatContent");
                        arrayChat.add(noiDung);
                        adapterChat.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };

    private Emitter.Listener onListUser = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        JSONArray array = object.getJSONArray("danhsach");

                        arrayUser.clear();
                        for (int i = 0; i< array.length(); i++){
                            String username = array.getString(i);
                            arrayUser.add(username);
                            //Toast.makeText(MainActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        }
                        adapterUser.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    };

    private Emitter.Listener onRetrieveResult = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];

                    boolean exits = false;
                    try {
                        exits = object.getBoolean("ketqua");
                        if(exits){
                            Toast.makeText(MainActivity.this, "Tài khoản này đã tồn tại", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    };
}