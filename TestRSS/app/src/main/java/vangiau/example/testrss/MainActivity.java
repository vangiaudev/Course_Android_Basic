package vangiau.example.testrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ListView lvTieuDe;
    ArrayList<String> arrayTitle, arrayLink, arrayImage;
    ArrayAdapter adapter;

    CustomAdapter customAdapter;
    ArrayList<TinTuc> arrayTinTuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayTinTuc = new ArrayList<>();

        lvTieuDe = findViewById(R.id.lvTieuDe);
        arrayTitle = new ArrayList<>();
        arrayLink = new ArrayList<>();
        arrayImage = new ArrayList<>();
//        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayImage);
//        lvTieuDe.setAdapter(adapter);
        new ReadRSS().execute("https://vnexpress.net/rss/so-hoa.rss");

        lvTieuDe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                intent.putExtra("linkTinTuc", arrayLink.get(i));
                startActivity(intent);
            }
        });
    }
    private class ReadRSS extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLDOMParser parser =  new XMLDOMParser();
            Document document = parser.getDocument(s);

            NodeList nodeList = document.getElementsByTagName("item");

            NodeList nodeListDescription = document.getElementsByTagName("description");
            String hinhAnh = "";
            String tieuDe = "";
            String link = "";
            String pubDate = "";

            for (int i = 0; i<nodeList.getLength(); i++){
                String cdata = nodeListDescription.item(i + 1).getTextContent();
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = p.matcher(cdata);
                if(matcher.find()){
                    hinhAnh = matcher.group(1);
                    Log.d("hinhAnh", hinhAnh + "........." + i);
                }
                Element element = (Element) nodeList.item(i);
                tieuDe = parser.getValue(element, "title");
                link = parser.getValue(element, "link");
                pubDate = parser.getValue(element, "pubDate");
//                arrayTitle.add(tieuDe);
                    arrayLink.add(parser.getValue(element, "link"));
//                arrayImage.add(hinhAnh);
                arrayTinTuc.add(new TinTuc(tieuDe, link, hinhAnh, pubDate));

            }
//            adapter.notifyDataSetChanged();
//            Toast.makeText(MainActivity.this, tieuDe, Toast.LENGTH_LONG).show();
            customAdapter = new CustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayTinTuc);
            lvTieuDe.setAdapter(customAdapter);
            super.onPostExecute(s);
        }
    }
}