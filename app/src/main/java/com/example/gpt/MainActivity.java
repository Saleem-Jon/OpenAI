package com.example.gpt;

import android.os.Bundle;

import com.github.plexpt.chatgpt.Chatbot;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gpt.databinding.ActivityMainBinding;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    String s;
    Chatbot chatbot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String sessionToken = "eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..hyKFBS9e9wJRdD3i.QH6aD1o8CxWAgNs-V2pxowvmMZxZ8KagktHV4b0hvvfsRPb6EHr-zKVJguXoBIZgnPaGHsCnHSPuO15i2xr2S9ckgZ3DdkOXNu39hQSi6-VqcmwT7jdvybugNsOLubWF_baxxquqO9v_3sAmIJsZIIdBo8HxyE4jGrPB7XJwB-6UqtjXLpsrNOUrwx51nepMNdseCfTktwKL1iD680lzagRrni8LZzUUXuhoIlWen4jenBntfjvlUQyR9KfOwZ9F_oUlE2oH6xBeBYQH6auVK_BnFbfOYIw8SI9T8R9hi1CPC7zX-3V5xvo-qgfzkuV800edQcxPhlKyf-QhA40v2DeW-MEzarAd4lI2SwVwS2CA1v3n3IA01e1ztzZeCz2jCEn05bhHqwY43Nqv0E9oUVAMLPt2TkIgdWtyriZChl4tMAbWRnqrByqxCunxCGlEnaH0omTp4QKUSFldwTXmmWsSQwzAblIYrgDTxFtUYIItRrYA2_Y7-iQ0vRetDbh7b9DW5bfszYmHJm9u1DGpq8UGKDwY-1IHcsNkY_gM-cuhTdLxu_zgW1AEqn3NwxSUZgFtJiTZL46LPgxGlhP7Oi8ET0QdwWWnkTM0DQ5_TMgiHANrZ6taJyAMUqVLiaOpPcQq3k1NYwhVx_LvWijXKES0P1ec-06Ht0CYv2ayG1-qI-RjbekO4rKnvqIiFfkWuK0mZDzeatYZVh87ApPJhmw1kD2SweJ5Py0Gvlo0MX4rf14wDXcaHA9irztFYHLNz7zOYpUTfya-1krPxbc4fw0tvlxsnk8kmnuFAO_BG9QRMFeR4bm67ygtIbpjByaqxKZKNwHGDZnJNjZr5jQXvaAtixs7k3SmNtM27QZ-s4ysJ-gvcXUij8DQ1fpDi7NCMYycEopb46u-N1dErOABUS73lvET0Bnq6eCxi1uJKBlO0Xcotcip8rB4iT-83QS18iSwiartQ0v52-JFlaOQGptG5Dcn4g7zA-JXxier0GI31EMvw5bW_BrnOaJVH2UxroyOhxh2Mw09PEkjgo_z6jHvoRCXcWKHXEA8hWqqbBLRQ_lS8hNq228HkGRhJf5hzgFlFnaYpLpcnkMu4kp5dxJmT1bOPCLmTxB7N_tuR7MUGZfcNeuYsneAXayhmmzFnN20uHLklj7idvQTWEs-xzPyjlUCrVUOgJNfl1nLBkgWJBWWUdbiQbvQPrwIU0HxIdAnUXibRSVeDhzoMZNaCGLVQIyB5id_6MzwvX290jJhs-10v98v9uTTOIAgONB4FkytPrgj3ZPTRW8Tn46dD5PiGSr0L67b3XQXVzA2U5rguFZ3-Ias3gWqNh_rkNgbQsK8Y1t1HkQB0YMbnwLg00WMUxwWEEfXoRw5K9cxR21Q-I8CDdJzyJkgI5t2tBZ6loiSN0xbGcBwOJTWXu4UcclkrtiAgPwBxVUrKBQDfW_ASHX-tkGWkN2xOXZjCHZyUVG0WRCr6Zm6wzF1Z7QjcevYIj1HolsPxjO6uYa2jlNy2VpR6eQrRDx0tomwQ_fON_ax7beb1EVdoyaLd674QPok4w7AaD0Zwhp4R6qqilIkBdGQfn5pKAZRPMGDb68HYJXCRukFv22rzqZlUho6x_3lAQvLQvnQ1WhSF1fdVbWJTxacwMaNfUMeYGy3KH9yi_pP-U_w2YpsK8WC5yOelzgo_VY_ayLhboqQMstABDvb30JCZSjSEoZIqf3xAt7L12aDztjZD2MLP94rCNSZY_pJi0yfMmBLxiOnoACXlGirRibf5I6x8gFBoIgfT9WdRwIxFDOuSSE5-UiZtMLM0OXmF9aBmarN5u1mWmULIerHYP4WxMk_wiDwkjhsX-hQe55nqVlqXNpco41HmaMDE6gYIFSRAn0ExmaJGINf8brpx6e8tc70n4U1DFz162sHB0uOc3Gelq9wVxgYeZpEbEFZajCG4CoOmJEOedSdetdBjg-3uF8fJSJK4e_UGQDH6WsJKbFwujP8GHMtUGKMOc0vdIPmQPdIDXEB7IRI-Ip5XTD4-8j5fackifcY8Uokz1dowfW1YcmY-c5NQVbUKzxzGYc7W4lrhvCmEUZwgkvrr8TXT1_avXcaBvvcGClLUqvq3u92i7KcfwUleB5wrNHIIf6cciNtG3KrEDKjLX7LSaI9trnvjsmwCQGA3scGSaKp7gpVCFeyTAQI8gl-xDRPNZDWFT_nKbTtqNaY1SYEM2xKGUTDqc9gbkiGC-Gwar9Y0h1LkxbSVGd8qvRmSWpzgxEXGwdJnew.klDt-nzOY9WkH31f63C7yw";
        String cf_clearance = "R8HJlOYfngwGaBhzB6cLYr.6kXRdEjpLHhC9TEuYgEI-1671699137-0-1-4c8e7b15.769fa59b.57a8ac91-160";
        String user_agent  = "Mozilla/5.0 (Linux; Android 11; BE2025) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Mobile Safari/537.36";
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    //your codes here
                    chatbot = new Chatbot(sessionToken, cf_clearance, user_agent);


                    if (s!= null) {
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

                    }else if (s== null){
                        Toast.makeText(getApplicationContext(), "NULL", Toast.LENGTH_SHORT).show();
                    }

                    //Map<String, Object> chatResponse = chatbot.getChatResponse("hello");

                    s = String.valueOf(chatbot.hashCode());



                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
