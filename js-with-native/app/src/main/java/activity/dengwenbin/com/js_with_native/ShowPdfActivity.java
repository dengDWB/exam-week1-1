package activity.dengwenbin.com.js_with_native;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnDrawListener;
import com.joanzapata.pdfview.listener.OnLoadCompleteListener;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import java.io.File;

/**
 * Created by 40284 on 2016/6/14.
 */
public class ShowPdfActivity extends AppCompatActivity implements OnPageChangeListener
        , OnLoadCompleteListener, OnDrawListener {
    private PDFView pdfView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        pdfView = (PDFView) findViewById( R.id.pdfView );
        //从assets目录读取pdf
        displayFromAssets("nationalSalesBrief.pdf");

        //从文件中读取pdf
//        displayFromFile(new File("fileName"));
    }

    private void displayFromAssets(String assetFileName ) {
        //设置pdf文件地址
        pdfView.fromAsset(assetFileName)
                //设置默认显示第1页
                .defaultPage(1)
                //设置翻页监听
                .onPageChange(this)
                //设置加载监听
                .onLoad(this)
                //绘图监听
                .onDraw(this)
                //pdf放大的时候，是否在屏幕的右上角生成小地图
                .showMinimap(false)
                //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .swipeVertical(false)
                //是否允许翻页，默认是允许翻页
                .enableSwipe(true)
                .load();
    }

    private void displayFromFile( File file ) {
        //设置pdf文件地址
        pdfView.fromFile(file)
                //设置默认显示第1页
                .defaultPage(1)
                //设置翻页监听
                .onPageChange(this)
                //设置加载监听
                .onLoad(this)
                //绘图监听
                .onDraw(this)
                //pdf放大的时候，是否在屏幕的右上角生成小地图
                .showMinimap(false)
                //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
                .swipeVertical(false)
                //是否允许翻页，默认是允许翻
                .enableSwipe(true)
                .load();
    }
    @Override
    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

    }

    @Override
    public void loadComplete(int nbPages) {
        Toast.makeText(ShowPdfActivity.this, "加载完成" + nbPages, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        Toast.makeText( ShowPdfActivity.this , "page= " + page +
                " pageCount= " + pageCount , Toast.LENGTH_SHORT).show();
    }

}
