package co.com.kqm.orders;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import co.com.kqm.orders.model.Products;
import co.com.kqm.orders.utilities.AdapterProducts;
import co.com.kqm.orders.utilities.Constants;

import static co.com.kqm.orders.utilities.Constants.GRID;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerProduct;
    ArrayList<Products> listProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildRecycler();

    }

    public void fillProducts() {
        listProducts.add(new Products("Xiaomi 8 pro","Caracteristicas Principales\n" +
                "\n" +
                "Pantalla 6.21 Pulgadas \n" +
                "Procesador Snapdragon 845 Octa-core\n" +
                "Android One 8.1 (Oreo) \n" +
                "Memoria Interna 128Gb \n" +
                "Memoria Ram 8Gb \n" +
                "Cámara Principal 12 mpx + 12 mpx Con Flash\n" +
                "Cámara Frontal 20 mpx \n" +
                "Batería 3400\n" +
                "Carga Rápida Si \n" +
                "Sensores Huella digital (montado en la parte posterior), acelerómetro, giroscopio, proximidad, brújula\n" +
                "Bluetooth Si", R.drawable.mi_8_pro));
        listProducts.add(new Products("Xiaomi 9 se","Xiaomi Mi 9 SE \n" +
                "\n" +
                "Pantalla 5.97 pulgadas\n" +
                "Snapdragon 712 Octa Core\n" +
                "Android 9.0 (Pie) MIUI 10\n" +
                "Cámaras Principales de 48Mpx, 13Mpx y 8Mpx\n" +
                "Cámara Frontal 20 Mpx \n" +
                "Memoria Interna 64 GB \n" +
                "Memoria Ram 6 GB \n" +
                "Batería 3070 mAh \n" +
                "Carga Rápida Si\n" +
                "USB Tipo C\n" +
                "- Sensor acelerómetro para auto rotación\n" +
                "- Sensor de proximidad para auto apagado\n" +
                "- Sensor giroscópico\n" +
                "- Sensor de luz ambiente\n" +
                "- Barómetro\n" +
                "- Lector de huellas dactilares", R.drawable.mi_9_se));
        listProducts.add(new Products("Xiaomi 9","Pantalla 6.39 pulgadas\n" +
                "Snapdragon 855 Octa Core\n" +
                "Android 9.0 (Pie) MIUI 10\n" +
                "Cámaras Principales de 48Mpx, 16Mpx y 12Mpx\n" +
                "Cámara Frontal 20 Mpx \n" +
                "Memoria Interna 128 GB \n" +
                "Memoria Ram 6 GB \n" +
                "Batería 3300 mAh \n" +
                "Carga Rápida Si\n" +
                "USB Tipo C\n" +
                "- Sensor acelerómetro para auto rotación\n" +
                "- Sensor de proximidad para auto apagado\n" +
                "- Sensor giroscópico\n" +
                "- Sensor de luz ambiente\n" +
                "- Barómetro\n" +
                "- Lector de huellas dactilares", R.drawable.mi_9));
        listProducts.add(new Products("Xiaomi Mix 3 5g","Pantalla: AMOLED de 6,39 pulgadas con resolución de 1080 x 2340 píxeles y ratio 19,5:9\n" +
                "Procesador: Qualcomm Snapdragon 855 de ocho núcleos\n" +
                "RAM: 6/8/10 GB\n" +
                "Almacenamiento Interno: 64/128 GB/256/512 GB\n" +
                "Gráfica: Adreno 630\n" +
                "Cámara trasera: 12 Mp + 12 Mp con Apertura f/1.8 + f/2.4.\n" +
                "Cámara delantera: 24 + 2 MP\n" +
                "Conectividad: 5G, Dual SIM, Bluetooth 5.0, WiFi 802.11a/b/g/n/ac, USB Tipo-C\n" +
                "Otros: Sensor de huellas trasero, sensor facial 3D, NFC\n" +
                "Batería: 3.800 mAh con carga rápida y carga inalámbrica\n" +
                "\n", R.drawable.mix3_5g));

    }

    public void onClick(View view){

        switch (view.getId()) {
            case R.id.btn_list:
                Constants.visualizacion = Constants.LIST;
                break;
            case R.id.btn_grid:
                Constants.visualizacion = GRID;
                break;
        }

        buildRecycler();
    }

    private void buildRecycler() {

        listProducts = new ArrayList<>();
        recyclerProduct=findViewById(R.id.Re_firstList);

        if (Constants.visualizacion == Constants.LIST){
            recyclerProduct.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerProduct.setLayoutManager(new GridLayoutManager(this,2));
        }

        fillProducts();

        AdapterProducts adapterProducts = new AdapterProducts(listProducts);
        recyclerProduct.setAdapter(adapterProducts);

    }

}