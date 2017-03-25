package io.fragmentationsalt.reversedictandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button bsend = (Button) findViewById(R.id.button);
        bsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }
    public void send()
    {
        Socket s = null;
        String host = "10.0.4.60";
        try {
            s = new Socket(host,4030);
            OutputStream out = s.getOutputStream();
            String h = "hello";
            out.write(Byte.valueOf(h));
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
