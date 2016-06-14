package activity.dengwenbin.com.js_with_native;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private AssetManager assetManager;
    private InputStream inputStream;
    private Context context;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        boolean flag = fileExists("javascript.html");
        if(flag){
            webView = (WebView) findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(new JsInterface(), "JsInterface");
            webView.setWebChromeClient(new WebChromeClient() {
            });
            webView.loadUrl("file:///" + this.getFilesDir() + "/javascript.html");
        }

    }

    public boolean fileExists(String fileName)  {
        try{
            inputStream = context.getResources().getAssets().open("javascript.html");
            File file = new File(this.getFilesDir().getPath());
            if(!file.exists()){
                file.mkdirs();
            }
            File fileDir= new File(this.getFilesDir().getPath(),"javascript.html");
            if(!fileDir.exists()){
                fileDir.createNewFile();

            }
            FileOutputStream fos = new FileOutputStream(this.getFilesDir()+"/javascript.html");
            byte[] buffer = new byte[1024];
            int count =0;
            while ((count = inputStream.read(buffer))>0){
                fos.write(buffer,0,count);
            }
            fos.flush();
            fos.close();
            inputStream.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.toString());
            return false;
        }

    }

    public class JsInterface{
        @JavascriptInterface
        public void showDialog(final String str){
            AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("显示输入框的内容");
            if(str.equals("")||str.equals(null)){
                builder.setMessage("请输入内容");
            }else{
                builder.setMessage(str);
            }
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

}
