package id.rrdev.latihanmvvm.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import id.rrdev.latihanmvvm.R;
import id.rrdev.latihanmvvm.databinding.ActivityMainBinding;
import id.rrdev.latihanmvvm.viewmodel.MainViewModel;

import static id.rrdev.latihanmvvm.utils.View.toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);
        binding.setLifecycleOwner(this);

        mainViewModel.getSegitiga().observe(this, segitiga -> {
            if (segitiga.getHasil() != null){
                toast(getApplicationContext(),segitiga.getHasil().toString());
            }
        });
    }
}