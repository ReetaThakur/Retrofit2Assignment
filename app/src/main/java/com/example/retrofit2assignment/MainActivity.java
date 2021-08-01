package com.example.retrofit2assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText category;
    private Button click;
    private RecyclerView recyclerView;
    private List<DataModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        category=findViewById(R.id.edttext);
        click=findViewById(R.id.btnclick);
        recyclerView=findViewById(R.id.recyclerView);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();

            }
        });
    }

    private void callApi() {
        ApiService apiService=Network.getInstance().create(ApiService.class);
        String cater=category.getText().toString();
        apiService.getPath(cater).enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if(response.body()!=null){
                    modelList=response.body();
                    setRecycler();
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

            }
        });
    }

    private void setRecycler() {
        ResponseAdaptor adaptor=new ResponseAdaptor(modelList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adaptor);
    }
}