package com.example.hamzesarsourlocal.rotrofitlib;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by hamze sarsour local on 9/1/2016.
 */
public class ViewData extends AppCompatActivity implements ListView.OnItemClickListener{


    //Root URL of our web service
    public static final String ROOT_URL = "http://192.168.8.104/";

    //Strings to bind with intent will be used to send data to other activity
    public static final String KEY_BOOK_ID = "id";
    public static final String KEY_BOOK_NAME = "name";
    public static final String KEY_BOOK_PRICE = "publisher";
    public static final String KEY_BOOK_STOCK = "image";

    //List view to show data
    private ListView listView;

    //List of type books this list will store type Book which is our data model
    private List<Item> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_data);

        //Initializing the listview
        listView = (ListView) findViewById(R.id.listViewBooks);

        //Calling the method that will fetch data
        getBooks();

        //Setting onItemClickListener to listview
        listView.setOnItemClickListener(this);
    }

    private void getBooks(){
        //While the app fetched data we are displaying a progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);

        //Creating a rest adapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        //Creating an object of our api interface
        SelectAPI api = adapter.create(SelectAPI.class);

        //Defining the method
        api.getItems(new Callback<List<Item>>() {
            @Override
            public void success(List<Item> list, Response response) {
                //Dismissing the loading progressbar
                loading.dismiss();

                //Storing the data in our list
                books = list;

                //Calling a method to show the list
                showList();
            }

            @Override
            public void failure(RetrofitError error) {
                //you can handle the errors here
            }
        });
    }

    //Our method to show list
    private void showList(){
        //String array to store all the book names
        String[] items = new String[books.size()];

        //Traversing through the whole list to get all the names
        for(int i=0; i<books.size(); i++){
            //Storing names to string array
            items[i] = books.get(i).getName();
        }

        //Creating an array adapter for list view
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.simple_list,items);

        //Setting adapter to listview
        listView.setAdapter(adapter);
    }


    //This method will execute on listitem click
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Creating an intent
        Intent intent = new Intent(this, ShowItemDetails.class);

        //Getting the requested book from the list
        Item item = books.get(position);

        //Adding book details to intent
        intent.putExtra(KEY_BOOK_ID,item.getBookId());
        intent.putExtra(KEY_BOOK_NAME,item.getName());
        intent.putExtra(KEY_BOOK_PRICE,item.getPublisher());
        intent.putExtra(KEY_BOOK_STOCK,item.getImage());

        //Starting another activity to show book details
        startActivity(intent);
    }

}
