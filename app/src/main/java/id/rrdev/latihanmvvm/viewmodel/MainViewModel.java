package id.rrdev.latihanmvvm.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.rrdev.latihanmvvm.model.Segitiga;
import static id.rrdev.latihanmvvm.utils.View.toast;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> etAlas = new MutableLiveData<>();
    public MutableLiveData<String> etTinggi = new MutableLiveData<>();
    private MutableLiveData<Segitiga> segitigaMutableLiveData;

    public void btnLuasSegitiga(Context context){
        if (etAlas.getValue() == null || etAlas.getValue().length() == 0 || etTinggi.getValue() == null || etTinggi.getValue().length() == 0){
            toast(context,"harus terisi semua");
            return;
        }

        Double alas = Double.parseDouble(etAlas.getValue());
        Double tinggi = Double.parseDouble(etTinggi.getValue());
        Double hasilHitungLuas = (alas*tinggi)/2;

        Segitiga segitiga = new Segitiga(alas,tinggi,hasilHitungLuas);
        segitigaMutableLiveData.setValue(segitiga);
    }

    public LiveData<Segitiga> getSegitiga(){
        if (segitigaMutableLiveData == null){
            segitigaMutableLiveData = new MutableLiveData<>();
        }
        return segitigaMutableLiveData;
    }
}
