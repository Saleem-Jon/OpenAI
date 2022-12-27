package com.example.gpt;

import android.os.Bundle;

import com.github.plexpt.chatgpt.Chatbot;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gpt.databinding.ActivityMainBinding;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.edit.EditRequest;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    String s;
    Chatbot chatbot;
    int SDK_INT = android.os.Build.VERSION.SDK_INT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String sessionToken = "eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..NRMK8rxeiadXuxhG.WqERfewq17o-vWvIij4yo4vR__-rME4Sbwh6OaGIzh1r38oN3ciZR4IZQpKnpX8Myk5Bo1TM3Zlf4R1hDfppOJcFfZoTPIVB9tGVhmRVd0cQwgWQP43SaWaB8KjoQO2ZQo-jKwyrqmNT5B8Jk8h22trSMwIBh1-aPLQGuSmZM3ro44zOtXPYTtm8XgU_Fapuomce-U28mCI1Jc4tTMw4qqLGRcHCtVG5wxZA-VSTW0yg8Bjb94p-KaHhIgbAmTMQuW9etrKEXWjOThCx6YJPgPvzc7I0X7mOgagkSkWXg02jue-_OapJsGbEPeSUOwxUiL45yn2q97iu0DoQsmCYhHpyq4RWs2ROXwb1fFgDHp3ld9TZSvsKeibiw0_a8yJgnfaj_WEk0z1PXLbjmjRvPkaCpyQoKcI7BWM5q6GUl_7q0hPloxB8CS2Xu97uAj1f5HwD0DOTo4-nIH6BmtZ04-2jSPhZmF0t4py3Vt3RGEUOZULydLEYsXGwRZIGltREfdjHvetda9SV-zs8gRIxryG2SmtgplkWDAus6FZVhnxjhfyUXlCglYN7SEMvZ6m39sapVERylyj0W6ccnEiY9S6ojR3Eiy5sNYL6HDa81K6vSZEuSlRG-naJPpyrDsjeNcSMYYL3mvG-C17CjcPY0YOMRBK0uFuU7aa-HcgiRsyZkdB06c1gASHvZJdSRxDNx-fnq-oogniYUQDDmZ6A6aurWrixeavHpo-nHLsNlUbfd3pfVw9mND8w-KJuryUjGCpuQrbPtMrSLSyweSNIXb8OvL55XCV8Fl8FXqs6oIBbLAz2GWw4LGr18YAKcHy82SPxJFpA5fPPmp08KZtn-95qGrmJr2_I-QmHav40SOD71-80uxRYdiQ7vvGFWO6V2UTgpaSXVZ4xihxHpoWuZH1kF2J2Yse9U2SjY4puBZgJl7BGIun8PbgzwlhRaTU1OStWOl73GFuLiCeZmPw-Z3Ow0_2QSN9lMxWVqtid_4Tlab0WKnZ-GaSwGrjn9sJQLJEf4m3lwGT6qvdufprC-bcnRZikrThSw77spjijZP-eKe8chd727fdfbrGTFdnDlhvDEPnj3ULiSMpnFMtUTt6cRem2AgHLSOEr-8Nue9t7OdhWl497lQ5UIJV_mzfxyeaG-bFdM-WW-RuYj8r-dpmAtB_sqZMphEUaYDgxn5Y8rnxze1XWp8wu8092S-TrXPZ4rf9Irv7DOK3CKYUoArZ_gsL_qXXv8NXtE6XcrEZTfF518A8lm6uOXh6g0dtLZHmXukUh9xeTkxJsOjP-yeQX0bvqQTBMJ0XhyGjcwT2dfDoYFCqOKvTjgpGk6GcmOltcl45WaCUDVfqGI9RPWAX1ILfdCwWpfdkTeFYTovbPTHBgvxxrXIgvyuZ6hwMk1t5Re5XHyzdgTrlnM4VWbyLiqAa2YTwP_YH0PpRGzTi7A4GLd0YC5gf7Q4DfUdL1PUaOP2zvL6IgF2eK87GMvF-Li9WSF66c_Zdi3Gcji3LUbWwuCuDESqumnpY5V9fvXffb00rMPK_K7STbjwGwsIfzFcoztjp8jMp2mCLsqtevKbbMAvUofA5QTzzr3ddPRFhppXwX9XL5YCswAXwXu8DkDrE1oSVpsytZXtlx9zarqQNPC5NrBSlKbqsuXOZR53aTtZRXkKJrzswdFCzqQldtPEFnxLfGZKPAVq_ME57QhopHJKFr8Vl6ORiEY8lEGm7FwKtGsxzf5OBAnZ09yz_-fmecpDxnfbxwGUUeAxlHGtj4RFW0NeisKMT1WZKpnvgybHW4owRNbmoR3u5crgebzXbY_SP_ibyA5BfNPpEIi3m-5RMb0dFpdKdaPzcsV9QrfFL-XKvC8TiiBBebi3QancEx4yOtQ4JD-8bHHifXAKJtTt4_Z8Xz8HGk8qZBJyl65kyiS3Oe2V1HEORec_FhwC8lg4R1XL6lDalgMrLTSU4CHsjCOpOaK7xG0oyFP6QOJMaDznTvhbLyXVoTHrLms3YBnzp-YI4F3j749cwA2A5D3vXIciqmgBy7J7adosUUGlzaxr_pB75yEiwbp7jvW9GzuXTXj1VhmAmE7BvxOHWPbc7cmCwfoY4vtecrJST6LJItQkIate3tl_YV0PLZUyN5cVdSgtqyCRF2Chq5eUi2EIYwBtZqM2lh-flY8gjThfg2xM2BEYt2wdiZzMoImyIPhLHx_7pXZgKP26EiQHZQVmY0GzqJDJa_8qBUav0-D30aWEqAwc2xjCPFgzO7UuQ_je3UhFA.Pv3kKhPCMkIdFn3Nky7SMQ";

        String cf_clearance = "4kY2QV.JDVr9eyJUdTEOnfJqLj2OtOLHvBuesYbSgmA-1671707556-0-1-4c8e7b15.769fa59b.57a8ac91-160";
        String user_agent  = "Mozilla/5.0 (Linux; Android 11; BE2025) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Mobile Safari/537.36";
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

       setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        TextView tv1 = (TextView)findViewById(R.id.textmain);
        EditText prompt =findViewById(R.id.prompt);
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            }
           binding.fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String query = prompt.getText().toString();
                    if (query != "") {


                    OpenAiService service = new OpenAiService("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");
                    CompletionRequest completionRequest = CompletionRequest.builder()
                            .prompt(query)
                            .model("text-davinci-003")
                            .echo(true)
                            .maxTokens(1080)
                            .build();

                   ;

                    tv1.setText(service.createCompletion(completionRequest).getChoices().get(0).getText());

                   // OpenAI.apiKey = "YOUR_API_KEY";
                        prompt.setText("");
                    }
                    else{ Toast.makeText(getApplicationContext(),"Enter a Query first",Toast.LENGTH_SHORT).show();}



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
